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

package org.diorite.impl.material.block.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.apache.commons.lang3.ClassUtils;

import org.diorite.impl.material.block.BlockSubtypeImpl;
import org.diorite.impl.material.block.BlockTypeImpl;
import org.diorite.material.block.BlockSounds;
import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.FlameableSettings;
import org.diorite.material.block.LightSettings;
import org.diorite.material.block.LiquidSettings;
import org.diorite.material.state.StateEntry;
import org.diorite.world.TileEntity;

public class BlockTypeAdapter implements JsonDeserializer<BlockTypeImpl>, JsonSerializer<BlockTypeImpl>
{
    @SuppressWarnings("unchecked")
    @Override
    public BlockTypeImpl deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) throws JsonParseException
    {
        if (! jsonElement.isJsonObject())
        {
            throw new JsonParseException("Can't deserialize sound entry from: " + jsonElement);
        }
        final JsonObject jsonObject = ((JsonObject) jsonElement);
        final int id = jsonObject.get("Id").getAsInt();
        final String minecraftId = jsonObject.get("MinecraftId").getAsString();
        final JsonArray jsonSubtypes = jsonObject.getAsJsonArray("Subtypes");
        final BlockTypeImpl blockType = new BlockTypeImpl(id, minecraftId);
        for (final JsonElement jsonSubtypeTmp : jsonSubtypes)
        {
            final JsonObject jsonSubtype = ((JsonObject) jsonSubtypeTmp);
            blockType.addSubtype(this.deserialize(jsonSubtype, blockType, context));
        }
        blockType.setDefaultSubtype(blockType.getSubtype(jsonObject.get("DefaultSubtype").getAsString()));
        return blockType;
    }

    @SuppressWarnings("unchecked")
    public BlockSubtypeImpl deserialize(final JsonObject jsonObject, final BlockTypeImpl blockType, final JsonDeserializationContext context)
    {
        final int id = jsonObject.get("Id").getAsInt();
        final String stringId = jsonObject.get("StringId").getAsString();
        final float hardness = jsonObject.get("Hardness").getAsFloat();
        final float blastResistance = jsonObject.get("BlastResistance").getAsFloat();
        final boolean isSolid = jsonObject.get("isSolid").getAsBoolean();
        final Class<? extends TileEntity> tileEntityClass;
        try
        {
            final JsonElement tileEntityClassJsonEl = jsonObject.get("TileEntityClass");
            if (tileEntityClassJsonEl != null)
            {
                final String className = tileEntityClassJsonEl.getAsString();
                if (className != null)
                {
                    tileEntityClass = (Class<? extends TileEntity>) ClassUtils.getClass(className);
                }
                else
                {
                    tileEntityClass = null;
                }
            }
            else
            {
                tileEntityClass = null;
            }
        } catch (final ClassNotFoundException | ClassCastException e)
        {
            throw new JsonParseException("Can't deserialize BlockTypeImpl: " + jsonObject, e);
        }
        final BlockSounds sounds = context.deserialize(jsonObject.get("Sounds"), BlockSounds.class);
        final JsonArray jsonStates = jsonObject.getAsJsonArray("States");
        final Collection<StateEntry<?>> states = new ArrayList<>(jsonStates.size());
        for (final JsonElement jsonState : jsonStates)
        {
            states.add(context.deserialize(jsonState, StateEntry.class));
        }
        final LiquidSettings liquidSettings = context.deserialize(jsonObject.get("LiquidSettings"), LiquidSettings.class);
        final LightSettings lightSettings = context.deserialize(jsonObject.get("LightSettings"), LightSettings.class);
        final FlameableSettings flameableSettings = context.deserialize(jsonObject.get("FlameableSettings"), FlameableSettings.class);

        final BlockSubtypeImpl blockSubtype = new BlockSubtypeImpl(blockType, id, stringId, states);
        blockSubtype.setHardnessAndResistance(hardness, blastResistance, isSolid);
        blockSubtype.setTileEntityClass(tileEntityClass);
        blockSubtype.setSounds(sounds);
        blockSubtype.setDisplayNameKey(jsonObject.get("DisplayNameKey").getAsString());
        blockSubtype.setDefaultSubtype(blockSubtype.getSubtype(jsonObject.get("DefaultSubtype").getAsString()));
        blockSubtype.setLiquidSettings(liquidSettings);
        blockSubtype.setLightSettings(lightSettings);
        blockSubtype.setFlameableSettings(flameableSettings);
        return null;
    }

    @Override
    public JsonElement serialize(final BlockTypeImpl type, final Type type2, final JsonSerializationContext context)
    {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("Id", context.serialize(type.getId()));
        jsonObject.add("MinecraftId", context.serialize(type.getMinecraftId()));
        final JsonArray elements = new JsonArray();
        for (final BlockSubtype subtype : type.getSubtypes())
        {
            final JsonObject jsonSubtype = new JsonObject();
            jsonSubtype.add("Id", context.serialize(subtype.getSubtypeId()));
            jsonSubtype.add("StringId", context.serialize(subtype.getSubtypeStringId()));
            jsonSubtype.add("Hardness", context.serialize(subtype.getHardness()));
            jsonSubtype.add("BlastResistance", context.serialize(subtype.getBlastResistance()));
            jsonSubtype.add("isSolid", context.serialize(subtype.isSolid()));
            final Class<? extends TileEntity> tileEntityClass = subtype.getTileEntityClass();
            jsonSubtype.add("TileEntityClass", (tileEntityClass == null) ? null : context.serialize(tileEntityClass.getName()));
            jsonSubtype.add("LiquidSettings", context.serialize(subtype.getLiquidSettings()));
            jsonSubtype.add("LightSettings", context.serialize(subtype.getLightSettings()));
            jsonSubtype.add("FlameableSettings", context.serialize(subtype.getFlameableSettings()));
            jsonSubtype.add("DisplayNameKey", context.serialize(subtype.getDisplayNameKey()));
            jsonSubtype.add("States", context.serialize(subtype.getStates()));
            elements.add(jsonSubtype);
        }
        jsonObject.add("Subtypes", elements);
        jsonObject.add("DefaultSubtype", context.serialize(type.getDefaultSubtype().getSubtypeStringId()));
        return jsonObject;
    }
}
