/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016. Diorite (by Bartłomiej Mazur (aka GotoFinal))
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.diorite.impl.material.block;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.apache.commons.lang3.ClassUtils;

import org.diorite.impl.material.block.json.BlockTypeAdapter;
import org.diorite.impl.material.block.json.FlameableSettingsAdapter;
import org.diorite.impl.material.block.json.LightSettingsAdapter;
import org.diorite.impl.material.block.json.LiquidSettingsAdapter;
import org.diorite.material.block.BlockRegistry;
import org.diorite.material.block.BlockSounds;
import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.BlockType;
import org.diorite.material.block.FlameableSettings;
import org.diorite.material.block.LightSettings;
import org.diorite.material.block.LiquidSettings;
import org.diorite.material.state.StateEntry;
import org.diorite.utils.SoundEntry;
import org.diorite.utils.json.BlockSoundsAdapter;
import org.diorite.utils.json.BlockSubtypeAdapter;
import org.diorite.utils.json.DimensionAdapter;
import org.diorite.utils.json.SoundEntryAdapter;
import org.diorite.utils.json.StateEntryAdapter;
import org.diorite.world.Dimension;
import org.diorite.world.TileEntity;

@SuppressWarnings("MagicNumber")
public final class BlocksInit
{
    private BlocksInit()
    {
    }

    public static void init()
    {
        Gson gsonInst = new GsonBuilder().registerTypeAdapter(StateEntry.class, new StateEntryAdapter()).registerTypeAdapter(Dimension.class, new DimensionAdapter()).registerTypeAdapter(SoundEntry.class, new SoundEntryAdapter()).registerTypeAdapter(BlockSubtype.class, new BlockSubtypeAdapter()).registerTypeAdapter(BlockSounds.class, new BlockSoundsAdapter()).registerTypeAdapter(FlameableSettingsImpl.class, new FlameableSettingsAdapter()).registerTypeAdapter(LightSettingsImpl.class, new LightSettingsAdapter()).registerTypeAdapter(LiquidSettingsImpl.class, new LiquidSettingsAdapter()).registerTypeAdapter(BlockTypeImpl.class, new BlockTypeAdapter()).registerTypeAdapter(BlockType.class, new org.diorite.utils.json.BlockTypeAdapter()).setPrettyPrinting().serializeNulls().create();

        try

        {
            final JsonParser gson = new JsonParser();
            final Iterable<? extends JsonObject> blocks = (Iterable) gson.parse(new FileReader(new File("D:/blocks.json"))).getAsJsonArray();
            for (final JsonObject block : blocks)
            {
                BlockTypeImpl blockType = new BlockTypeImpl(block.get("Id").getAsInt(), block.get("MinecraftId").getAsString());
                float hardness = block.get("Hardness").getAsFloat();
                float blastResistance = block.get("BlastResistance").getAsFloat();
                boolean isSolid = block.get("isSolid").getAsBoolean();
                Class<? extends TileEntity> tileEntityClass = block.get("TileEntityClass").getAsString().isEmpty() ? null : (Class<? extends TileEntity>) ClassUtils.getClass(block.get("TileEntityClass").getAsString());
                BlockSounds blockSounds = gsonInst.fromJson(block.get("Sounds"), BlockSounds.class);
                String defType = block.get("DefaultSubtype").getAsString();
                LiquidSettings LiquidSettings = gsonInst.fromJson(block.get("LiquidSettings"), LiquidSettingsImpl.class);
                LightSettings LightSettings = gsonInst.fromJson(block.get("LightSettings"), LightSettingsImpl.class);
                FlameableSettings FlameableSettings = gsonInst.fromJson(block.get("FlameableSettings"), FlameableSettingsImpl.class);
                Iterable<? extends JsonObject> subtypes = (Iterable) block.getAsJsonArray("Subtypes");
                for (final JsonObject subtype : subtypes)
                {
                    int id = subtype.get("Id").getAsInt();
                    String stringId = subtype.get("StringId").getAsString();
                    Iterable<? extends JsonObject> states = (Iterable) subtype.getAsJsonArray("States");
                    Collection<StateEntry<?>> stateEntries = new ArrayList<>(16);
                    if (states != null)
                    {
                        for (final JsonObject state : states)
                        {
                            StateEntry stateEntry = gsonInst.fromJson(state, StateEntry.class);
                            stateEntries.add(stateEntry);
                        }
                    }
                    BlockSubtypeImpl blockSubtype = new BlockSubtypeImpl(blockType, id, stringId, stateEntries);
                    blockSubtype.setLightSettings(LightSettings);
                    blockSubtype.setFlameableSettings(FlameableSettings);
                    blockSubtype.setLiquidSettings(LiquidSettings);
                    blockSubtype.setHardnessAndResistance(hardness, blastResistance, isSolid);
                    blockSubtype.setTileEntityClass(tileEntityClass);
                    blockSubtype.setSounds(blockSounds);
                    blockType.addSubtype(blockSubtype);
                }
                blockType.setDefaultSubtype(blockType.getSubtype(defType));
                BlockRegistry.registerBlock(blockType);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Blocks: " + BlockRegistry.getBlockTypes().size() + " Subtypes: " + BlockRegistry.getAllBlockSubtypes().size());
        delegateSubtypes("minecraft:water", "minecraft:flowing_water");
        delegateSubtypes("minecraft:log", "minecraft:log2");
        delegateSubtypes("minecraft:leaves", "minecraft:leaves2");
        delegateSubtypes("minecraft:stained_hardened_clay", "minecraft:hardened_clay");
        delegateSubtypes("minecraft:stained_glass_pane", "minecraft:glass_pane");
        delegateSubtypes("minecraft:sandstone", "minecraft:red_sandstone");
        delegateSubtypes("minecraft:piston", "minecraft:sticky_piston");
        delegateSubtypes("minecraft:red_flower", "minecraft:yellow_flower", "minecraft:tallgrass", "minecraft:deadbush", "minecraft:waterlily", "minecraft:red_mushroom", "minecraft:brown_mushroom");
        delegateSubtypes("minecraft:stone_slab", "minecraft:double_stone_slab", "minecraft:stone_slab2", "minecraft:double_stone_slab2");
        delegateSubtypes("minecraft:pumpkin", "minecraft:lit_pumpkin");
        delegateSubtypes("minecraft:dark_oak_stairs", "minecraft:acacia_stairs", "minecraft:jungle_stairs", "minecraft:birch_stairs", "minecraft:spruce_stairs", "minecraft:oak_stairs");

        final List<BlockType> collect = BlockRegistry.getBlockTypes().stream().sorted((a, b) -> Integer.compare(a.getId(), b.getId())).collect(Collectors.toList());
//        final String s = gsonInst.toJson(collect);
        try
        {
            JsonArray jsonArray = new JsonArray();
            for (final BlockType blockType : collect)
            {
                final String s = gsonInst.toJson(blockType);
                String name = blockType.getMinecraftId().replace(':', '.');
                final File file = new File("D:/blocksTest/" + blockType.getMinecraftId().replace(':', '.') + ".json");
                file.getParentFile().mkdirs();
                Files.write(file.toPath(), Arrays.asList(s.split("\n")), StandardOpenOption.CREATE);
                jsonArray.add(name);
            }
            final String s = gsonInst.toJson(jsonArray);
            final File file = new File("D:/blocksTest/blocks.json");
            Files.write(file.toPath(), Arrays.asList(s.split("\n")), StandardOpenOption.CREATE);
        } catch (final IOException e)
        {
            e.printStackTrace();
        }
    }

    public static class JsonBlockSerializer implements JsonSerializer<BlockSubtype>, JsonDeserializer<BlockSubtype>
    {

        @Override
        public BlockSubtype deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
        {
            return null;
        }

        @Override
        public JsonElement serialize(final BlockSubtype type, final Type type2, final JsonSerializationContext jsonSerializationContext)
        {
            final JsonObject jsonObject = new JsonObject();
            jsonObject.add("minecraftId", jsonSerializationContext.serialize(type.getMinecraftId()));
            jsonObject.add("subtypeName", jsonSerializationContext.serialize(type.getSubtypeId()));
            return jsonObject;
        }
    }

    private static void registerBlock(final BlockType blockType)
    {
        BlockRegistry.registerBlock(blockType);
    }

    private static void delegateSubtypes(final String... names)
    {
        final List<BlockTypeImpl> types = new ArrayList<>(names.length);
        for (final String name : names)
        {
            types.add((BlockTypeImpl) BlockRegistry.getBlockType(name));
        }
        final Set<BlockSubtype> subtypes = new HashSet<>(15);
        for (final BlockTypeImpl type : types)
        {
            subtypes.addAll(type.getSubtypes());
        }

        for (final BlockTypeImpl type : types)
        {
            final Collection<BlockSubtype> localSubtypes = new HashSet<>(subtypes);
            localSubtypes.removeAll(type.getSubtypes());

            for (final BlockSubtype subtype : localSubtypes)
            {
                type.addDelegatedSubtype(subtype);
            }
        }
    }

    private static void delegateSubtypes(final String nameA, final String nameB)
    {
        final BlockTypeImpl a = (BlockTypeImpl) BlockRegistry.getBlockType(nameA);
        final BlockTypeImpl b = (BlockTypeImpl) BlockRegistry.getBlockType(nameB);
        final Collection<BlockSubtype> subtypes = new ArrayList<>(a.getSubtypes());
        for (final BlockSubtype subtype : b.getSubtypes())
        {
            a.addDelegatedSubtype(subtype);
        }
        for (final BlockSubtype subtype : subtypes)
        {
            b.addDelegatedSubtype(subtype);
        }
    }
}
