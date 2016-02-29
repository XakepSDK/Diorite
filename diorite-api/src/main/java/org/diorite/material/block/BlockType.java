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

package org.diorite.material.block;

import java.util.Collection;

import org.diorite.BlockLocation;
import org.diorite.entity.Entity;
import org.diorite.material.AnyType;
import org.diorite.material.data.drops.PossibleDrops;
import org.diorite.material.item.ItemType;

/**
 * Represent block data
 */
public interface BlockType extends AnyType
{
    BlockType AIR                        = Blocks.getBlockType("minecraft:air");
    BlockType STONE                      = Blocks.getBlockType("minecraft:stone");
    BlockType GRASS                      = Blocks.getBlockType("minecraft:grass");
    BlockType DIRT                       = Blocks.getBlockType("minecraft:dirt");
    BlockType COBBLESTONE                = Blocks.getBlockType("minecraft:cobblestone");
    BlockType PLANKS                     = Blocks.getBlockType("minecraft:planks");
    BlockType SAPLING                    = Blocks.getBlockType("minecraft:sapling");
    BlockType BEDROCK                    = Blocks.getBlockType("minecraft:bedrock");
    BlockType WATER                      = Blocks.getBlockType("minecraft:water");
    BlockType WATER_STILL                = Blocks.getBlockType("minecraft:flowing_water");
    BlockType LAVA                       = Blocks.getBlockType("minecraft:lava");
    BlockType LAVA_STILL                 = Blocks.getBlockType("minecraft:flowing_lava");
    BlockType SAND                       = Blocks.getBlockType("minecraft:sand");
    BlockType GRAVEL                     = Blocks.getBlockType("minecraft:gravel");
    BlockType GOLD_ORE                   = Blocks.getBlockType("minecraft:gold_ore");
    BlockType IRON_ORE                   = Blocks.getBlockType("minecraft:iron_ore");
    BlockType COAL_ORE                   = Blocks.getBlockType("minecraft:coal_ore");
    BlockType LOG                        = Blocks.getBlockType("minecraft:log");
    BlockType LEAVES                     = Blocks.getBlockType("minecraft:leaves");
    BlockType SPONGE                     = Blocks.getBlockType("minecraft:sponge");
    BlockType GLASS                      = Blocks.getBlockType("minecraft:glass");
    BlockType LAPIS_ORE                  = Blocks.getBlockType("minecraft:lapis_ore");
    BlockType LAPIS_BLOCK                = Blocks.getBlockType("minecraft:lapis_block");
    BlockType DISPENSER                  = Blocks.getBlockType("minecraft:dispenser");
    BlockType SANDSTONE                  = Blocks.getBlockType("minecraft:sandstone");
    BlockType NOTEBLOCK                  = Blocks.getBlockType("minecraft:noteblock");
    BlockType BED_BLOCK                  = Blocks.getBlockType("minecraft:bed");
    BlockType POWERED_RAIL               = Blocks.getBlockType("minecraft:golden_rail");
    BlockType DETECTOR_RAIL              = Blocks.getBlockType("minecraft:detector_rail");
    BlockType PISTON_STICKY              = Blocks.getBlockType("minecraft:sticky_piston");
    BlockType COBWEB                     = Blocks.getBlockType("minecraft:web");
    BlockType TALL_GRASS                 = Blocks.getBlockType("minecraft:tallgrass");
    BlockType DEAD_BUSH                  = Blocks.getBlockType("minecraft:deadbush");
    BlockType PISTON                     = Blocks.getBlockType("minecraft:piston");
    BlockType PISTON_HEAD                = Blocks.getBlockType("minecraft:piston_head");
    BlockType WOOL                       = Blocks.getBlockType("minecraft:wool");
    BlockType PISTON_EXTENSION           = Blocks.getBlockType("minecraft:piston_extension");
    BlockType DANDELION                  = Blocks.getBlockType("minecraft:yellow_flower");
    BlockType FLOWERS                    = Blocks.getBlockType("minecraft:red_flower");
    BlockType BROWN_MUSHROOM             = Blocks.getBlockType("minecraft:brown_mushroom");
    BlockType RED_MUSHROOM               = Blocks.getBlockType("minecraft:red_mushroom");
    BlockType GOLD_BLOCK                 = Blocks.getBlockType("minecraft:gold_block");
    BlockType IRON_BLOCK                 = Blocks.getBlockType("minecraft:iron_block");
    BlockType DOUBLE_STONE_SLAB          = Blocks.getBlockType("minecraft:double_stone_slab");
    BlockType STONE_SLAB                 = Blocks.getBlockType("minecraft:stone_slab");
    BlockType BRICK_BLOCK                = Blocks.getBlockType("minecraft:brick_block");
    BlockType TNT                        = Blocks.getBlockType("minecraft:tnt");
    BlockType BOOKSHELF                  = Blocks.getBlockType("minecraft:bookshelf");
    BlockType MOSSY_COBBLESTONE          = Blocks.getBlockType("minecraft:mossy_cobblestone");
    BlockType OBSIDIAN                   = Blocks.getBlockType("minecraft:obsidian");
    BlockType TORCH_EAST                 = Blocks.getBlockType("minecraft:torch");
    BlockType FIRE                       = Blocks.getBlockType("minecraft:fire");
    BlockType MOB_SPAWNER                = Blocks.getBlockType("minecraft:mob_spawner");
    BlockType OAK_STAIRS                 = Blocks.getBlockType("minecraft:oak_stairs");
    BlockType CHEST                      = Blocks.getBlockType("minecraft:chest");
    BlockType REDSTONE_WIRE              = Blocks.getBlockType("minecraft:redstone_wire");
    BlockType DIAMOND_ORE                = Blocks.getBlockType("minecraft:diamond_ore");
    BlockType DIAMOND_BLOCK              = Blocks.getBlockType("minecraft:diamond_block");
    BlockType CRAFTING_TABLE             = Blocks.getBlockType("minecraft:crafting_table");
    BlockType WHEAT_BLOCK                = Blocks.getBlockType("minecraft:wheat");
    BlockType FARMLAND                   = Blocks.getBlockType("minecraft:farmland");
    BlockType FURNACE                    = Blocks.getBlockType("minecraft:furnace");
    BlockType BURNING_FURNACE            = Blocks.getBlockType("minecraft:lit_furnace");
    BlockType STANDING_SIGN              = Blocks.getBlockType("minecraft:standing_sign");
    BlockType OAK_DOOR                   = Blocks.getBlockType("minecraft:wooden_door");
    BlockType LADDER                     = Blocks.getBlockType("minecraft:ladder");
    BlockType RAIL                       = Blocks.getBlockType("minecraft:rail");
    BlockType COBBLESTONE_STAIRS         = Blocks.getBlockType("minecraft:stone_stairs");
    BlockType WALL_SIGN                  = Blocks.getBlockType("minecraft:wall_sign");
    BlockType LEVER                      = Blocks.getBlockType("minecraft:lever");
    BlockType STONE_PRESSURE_PLATE       = Blocks.getBlockType("minecraft:stone_pressure_plate");
    BlockType IRON_DOOR                  = Blocks.getBlockType("minecraft:iron_door");
    BlockType WOODEN_PRESSURE_PLATE      = Blocks.getBlockType("minecraft:wooden_pressure_plate");
    BlockType REDSTONE_ORE               = Blocks.getBlockType("minecraft:redstone_ore");
    BlockType REDSTONE_ORE_GLOWING       = Blocks.getBlockType("minecraft:lit_redstone_ore");
    BlockType REDSTONE_TORCH_OFF         = Blocks.getBlockType("minecraft:unlit_redstone_torch");
    BlockType REDSTONE_TORCH_ON          = Blocks.getBlockType("minecraft:redstone_torch");
    BlockType STONE_BUTTON               = Blocks.getBlockType("minecraft:stone_button");
    BlockType SNOW_LAYER_1               = Blocks.getBlockType("minecraft:snow_layer");
    BlockType ICE                        = Blocks.getBlockType("minecraft:ice");
    BlockType SNOW_BLOCK                 = Blocks.getBlockType("minecraft:snow");
    BlockType CACTUS                     = Blocks.getBlockType("minecraft:cactus");
    BlockType CLAY_BLOCK                 = Blocks.getBlockType("minecraft:clay");
    BlockType REEDS_BLOCK                = Blocks.getBlockType("minecraft:reeds");
    BlockType JUKEBOX                    = Blocks.getBlockType("minecraft:jukebox");
    BlockType OAK_FENCE                  = Blocks.getBlockType("minecraft:fence");
    BlockType PUMPKIN                    = Blocks.getBlockType("minecraft:pumpkin");
    BlockType NETHERRACK                 = Blocks.getBlockType("minecraft:netherrack");
    BlockType SOUL_SAND                  = Blocks.getBlockType("minecraft:soul_sand");
    BlockType GLOWSTONE                  = Blocks.getBlockType("minecraft:glowstone");
    BlockType NETHER_PORTAL              = Blocks.getBlockType("minecraft:portal");
    BlockType PUMPKIN_LANTERN            = Blocks.getBlockType("minecraft:lit_pumpkin");
    BlockType CAKE_BLOCK                 = Blocks.getBlockType("minecraft:cake");
    BlockType REDSTONE_REPEATER_OFF      = Blocks.getBlockType("minecraft:unpowered_repeater");
    BlockType REDSTONE_REPEATER_ON       = Blocks.getBlockType("minecraft:powered_repeater");
    BlockType STAINED_GLASS              = Blocks.getBlockType("minecraft:stained_glass");
    BlockType WOODEN_TRAPDOOR            = Blocks.getBlockType("minecraft:trapdoor");
    BlockType MONSTER_EGG_TRAP           = Blocks.getBlockType("minecraft:monster_egg");
    BlockType STONE_BRICK                = Blocks.getBlockType("minecraft:stonebrick");
    BlockType BROWN_MUSHROOM_BLOCK       = Blocks.getBlockType("minecraft:brown_mushroom_block");
    BlockType RED_MUSHROOM_BLOCK         = Blocks.getBlockType("minecraft:red_mushroom_block");
    BlockType IRON_BARS                  = Blocks.getBlockType("minecraft:iron_bars");
    BlockType GLASS_PANE                 = Blocks.getBlockType("minecraft:glass_pane");
    BlockType MELON_BLOCK                = Blocks.getBlockType("minecraft:melon_block");
    BlockType PUMPKIN_STEM               = Blocks.getBlockType("minecraft:pumpkin_stem");
    BlockType MELON_STEM                 = Blocks.getBlockType("minecraft:melon_stem");
    BlockType VINE                       = Blocks.getBlockType("minecraft:vine");
    BlockType OAK_FENCE_GATE             = Blocks.getBlockType("minecraft:fence_gate");
    BlockType BRICK_STAIRS               = Blocks.getBlockType("minecraft:brick_stairs");
    BlockType STONE_BRICK_STAIRS         = Blocks.getBlockType("minecraft:stone_brick_stairs");
    BlockType MYCELIUM                   = Blocks.getBlockType("minecraft:mycelium");
    BlockType WATER_LILY                 = Blocks.getBlockType("minecraft:waterlily");
    BlockType NETHER_BRICK               = Blocks.getBlockType("minecraft:nether_brick");
    BlockType NETHER_BRICK_FENCE         = Blocks.getBlockType("minecraft:nether_brick_fence");
    BlockType NETHER_BRICK_STAIRS        = Blocks.getBlockType("minecraft:nether_brick_stairs");
    BlockType NETHER_WART_BLOCK          = Blocks.getBlockType("minecraft:nether_wart");
    BlockType ENCHANTING_TABLE           = Blocks.getBlockType("minecraft:enchanting_table");
    BlockType BREWING_STAND_BLOCK        = Blocks.getBlockType("minecraft:brewing_stand");
    BlockType CAULDRON_BLOCK             = Blocks.getBlockType("minecraft:cauldron");
    BlockType END_PORTAL                 = Blocks.getBlockType("minecraft:end_portal");
    BlockType END_PORTAL_FRAME           = Blocks.getBlockType("minecraft:end_portal_frame");
    BlockType END_STONE                  = Blocks.getBlockType("minecraft:end_stone");
    BlockType DRAGON_EGG                 = Blocks.getBlockType("minecraft:dragon_egg");
    BlockType REDSTONE_LAMP_OFF          = Blocks.getBlockType("minecraft:redstone_lamp");
    BlockType REDSTONE_LAMP_ON           = Blocks.getBlockType("minecraft:lit_redstone_lamp");
    BlockType DOUBLE_WOODEN_SLAB         = Blocks.getBlockType("minecraft:double_wooden_slab");
    BlockType WOODEN_SLAB                = Blocks.getBlockType("minecraft:wooden_slab");
    BlockType COCOA_NORTH_0              = Blocks.getBlockType("minecraft:cocoa");
    BlockType SANDSTONE_STAIRS           = Blocks.getBlockType("minecraft:sandstone_stairs");
    BlockType EMERALD_ORE                = Blocks.getBlockType("minecraft:emerald_ore");
    BlockType ENDER_CHEST                = Blocks.getBlockType("minecraft:ender_chest");
    BlockType TRIPWIRE_HOOK              = Blocks.getBlockType("minecraft:tripwire_hook");
    BlockType TRIPWIRE                   = Blocks.getBlockType("minecraft:tripwire");
    BlockType EMERALD_BLOCK              = Blocks.getBlockType("minecraft:emerald_block");
    BlockType SPRUCE_STAIRS              = Blocks.getBlockType("minecraft:spruce_stairs");
    BlockType BIRCH_STAIRS               = Blocks.getBlockType("minecraft:birch_stairs");
    BlockType JUNGLE_STAIRS              = Blocks.getBlockType("minecraft:jungle_stairs");
    BlockType COMMAND_BLOCK              = Blocks.getBlockType("minecraft:command_block");
    BlockType BEACON                     = Blocks.getBlockType("minecraft:beacon");
    BlockType COBBLESTONE_WALL           = Blocks.getBlockType("minecraft:cobblestone_wall");
    BlockType FLOWER_POT_BLOCK           = Blocks.getBlockType("minecraft:flower_pot");
    BlockType CARROTS_BLOCK              = Blocks.getBlockType("minecraft:carrots");
    BlockType POTATOES_BLOCK             = Blocks.getBlockType("minecraft:potatoes");
    BlockType WOODEN_BUTTON              = Blocks.getBlockType("minecraft:wooden_button");
    BlockType SKULL_BLOCK_FLOOR          = Blocks.getBlockType("minecraft:skull");
    BlockType ANVIL                      = Blocks.getBlockType("minecraft:anvil");
    BlockType TRAPPED_CHEST              = Blocks.getBlockType("minecraft:trapped_chest");
    BlockType GOLDEN_PRESSURE_PLATE      = Blocks.getBlockType("minecraft:light_weighted_pressure_plate");
    BlockType IRON_PRESSURE_PLATE        = Blocks.getBlockType("minecraft:heavy_weighted_pressure_plate");
    BlockType REDSTONE_COMPARATOR        = Blocks.getBlockType("minecraft:unpowered_comparator");
    BlockType DAYLIGHT_DETECTOR          = Blocks.getBlockType("minecraft:daylight_detector");
    BlockType REDSTONE_BLOCK             = Blocks.getBlockType("minecraft:redstone_block");
    BlockType QUARTZ_ORE                 = Blocks.getBlockType("minecraft:quartz_ore");
    BlockType HOPPER                     = Blocks.getBlockType("minecraft:hopper");
    BlockType QUARTZ_BLOCK               = Blocks.getBlockType("minecraft:quartz_block");
    BlockType QUARTZ_STAIRS              = Blocks.getBlockType("minecraft:quartz_brick_stairs");
    BlockType ACTIVATOR_RAIL             = Blocks.getBlockType("minecraft:activator_rail");
    BlockType DROPPER                    = Blocks.getBlockType("minecraft:dropper");
    BlockType STAINED_HARDENED_CLAY      = Blocks.getBlockType("minecraft:stained_hardened_clay");
    BlockType STAINED_GLASS_PANE         = Blocks.getBlockType("minecraft:stained_glass_pane");
    BlockType LEAVES2                    = Blocks.getBlockType("minecraft:leaves2");
    BlockType LOG2                       = Blocks.getBlockType("minecraft:log2");
    BlockType ACACIA_STAIRS              = Blocks.getBlockType("minecraft:acacia_stairs");
    BlockType DARK_OAK_STAIRS            = Blocks.getBlockType("minecraft:dark_oak_stairs");
    BlockType SLIME_BLOCK                = Blocks.getBlockType("minecraft:slime");
    BlockType BARRIER                    = Blocks.getBlockType("minecraft:barrier");
    BlockType IRON_TRAPDOOR              = Blocks.getBlockType("minecraft:iron_trapdoor");
    BlockType PRISMARINE                 = Blocks.getBlockType("minecraft:prismarine");
    BlockType SEA_LANTERN                = Blocks.getBlockType("minecraft:sea_lantern");
    BlockType HAY_BLOCK                  = Blocks.getBlockType("minecraft:hay_block");
    BlockType CARPET                     = Blocks.getBlockType("minecraft:carpet");
    BlockType HARDENED_CLAY              = Blocks.getBlockType("minecraft:hardened_clay");
    BlockType COAL_BLOCK                 = Blocks.getBlockType("minecraft:coal_block");
    BlockType PACKED_ICE                 = Blocks.getBlockType("minecraft:packet_ice");
    BlockType DOUBLE_FLOWERS             = Blocks.getBlockType("minecraft:double_plant");
    BlockType STANDING_BANNER_SOUTH      = Blocks.getBlockType("minecraft:standing_banner");
    BlockType WALL_BANNER                = Blocks.getBlockType("minecraft:wall_banner");
    BlockType DAYLIGHT_DETECTOR_INVERTED = Blocks.getBlockType("minecraft:daylight_detector_inverted");
    BlockType RED_SANDSTONE              = Blocks.getBlockType("minecraft:red_sandstone");
    BlockType RED_SANDSTONE_STAIRS       = Blocks.getBlockType("minecraft:red_sandstone_stairs");
    BlockType DOUBLE_STONE_SLAB2         = Blocks.getBlockType("minecraft:double_stone_slab2");
    BlockType STONE_SLAB2                = Blocks.getBlockType("minecraft:stone_slab2");
    BlockType SPRUCE_FENCE_GATE          = Blocks.getBlockType("minecraft:spruce_fence_gate");
    BlockType BIRCH_FENCE_GATE           = Blocks.getBlockType("minecraft:brich_fence_gate");
    BlockType JUNGLE_FENCE_GATE          = Blocks.getBlockType("minecraft:jungle_fence_gate");
    BlockType DARK_OAK_FENCE_GATE        = Blocks.getBlockType("minecraft:fark_oak_fence_gate");
    BlockType ACACIA_FENCE_GATE          = Blocks.getBlockType("minecraft:acacia_fence_gate");
    BlockType SPRUCE_FENCE               = Blocks.getBlockType("minecraft:spruce_fence");
    BlockType BIRCH_FENCE                = Blocks.getBlockType("minecraft:birch_fence");
    BlockType JUNGLE_FENCE               = Blocks.getBlockType("minecraft:jungle_fence");
    BlockType DARK_OAK_FENCE             = Blocks.getBlockType("minecraft:dark_oak_fence");
    BlockType ACACIA_FENCE               = Blocks.getBlockType("minecraft:acacia_fence");
    BlockType SPRUCE_DOOR                = Blocks.getBlockType("minecraft:spruce_door");
    BlockType BIRCH_DOOR                 = Blocks.getBlockType("minecraft:birch_door");
    BlockType JUNGLE_DOOR                = Blocks.getBlockType("minecraft:jungle_door");
    BlockType ACACIA_DOOR                = Blocks.getBlockType("minecraft:acacia_door");
    BlockType DARK_OAK_DOOR              = Blocks.getBlockType("minecraft:dark_oak_door");

    /**
     * Returns numeric id used (not always, sometimes {@link #getMinecraftId()} is used) in save files, packets, etc.
     *
     * @return numeric id used (not always, sometimes {@link #getMinecraftId()} is used) in save files, packets, etc.
     *
     * @see #getProxyId()
     */
    @Override
    int getId();

    /**
     * Returns id used in packets, used for adding fake blocks.
     *
     * @return id used in packets, used for adding fake blocks.
     */
    @Override
    default int getProxyId()
    {
        return this.getId();
    }

    /**
     * Returns minecraft string id of block.
     *
     * @return minecraft string id of block.
     */
    @Override
    String getMinecraftId();

    /**
     * Returns minecraft string id of block used in packets, used for adding fake blocks.
     *
     * @return minecraft string id of block used in packets, used for adding fake blocks.
     */
    @Override
    default String getProxyMinecraftId()
    {
        return this.getMinecraftId();
    }

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    BlockSubtype getSubtype(int id);

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    BlockSubtype getSubtype(String id);

    /**
     * Returns collection of subtypes for this block.
     *
     * @return collection of subtypes for this block.
     */
    @Override
    Collection<? extends BlockSubtype> getSubtypes();

    /**
     * Returns display name of block.
     *
     * @return display name of block.
     */
    @Override
    String getDisplayNameKey();

    /**
     * Returns hardness of block.
     *
     * @return hardness of block.
     */
    double getHardness();

    /**
     * Returns hardness of block.
     *
     * @return hardness of block.
     */
    double getBlastResistance();

    /**
     * Returns sounds pack for this block.
     *
     * @return sounds pack for this block.
     */
    BlockSounds getSounds();

    /**
     * Returns true if given entity is colliding with block at given position.
     *
     * @param blockLocation location of block.
     * @param entity        entity to be checked.
     *
     * @return true if given entity is colliding with block at given position.
     */
    default boolean isCollidingWith(final BlockLocation blockLocation, final Entity entity)
    {
        return this.isCollidingWith(blockLocation.getX(), blockLocation.getY(), blockLocation.getZ(), entity);
    }

    /**
     * Returns true if given entity is colliding with block at given position.
     *
     * @param x      x coordinates of block.
     * @param y      y coordinates of block.
     * @param z      z coordinates of block.
     * @param entity entity to be checked.
     *
     * @return true if given entity is colliding with block at given position.
     */
    boolean isCollidingWith(int x, int y, int z, Entity entity);

    /**
     * Returns true if this block is tile entity.
     *
     * @return true if this block is tile entity.
     */
    boolean isTileEntity();

    /**
     * Returns item for this block if exists.
     *
     * @return item for this block if exists.
     */
    ItemType getItem();

    /**
     * Returns possible drops of this block.
     *
     * @return possible drops of this block.
     */
    PossibleDrops getDrops();

    /**
     * Retruns liquid related block parameters.
     *
     * @return liquid related block parameters.
     */
    LiquidSettings getLiquidSettings();

    /**
     * Override block {@link LiquidSettings}.
     *
     * @param settings new parameters to use.
     */
    void setLiquidSettings(LiquidSettings settings);

    /**
     * Retruns light related block parameters.
     *
     * @return light related block parameters.
     */
    LightSettings getLightSettings();

    /**
     * Override block {@link LightSettings}.
     *
     * @param settings new parameters to use.
     */
    void setLightSettings(LightSettings settings);

    /**
     * Retruns fire related block parameters.
     *
     * @return fire related block parameters.
     */
    FlameableSettings getFlameableSettings();

    /**
     * Override block {@link FlameableSettings}.
     *
     * @param settings new parameters to use.
     */
    void setFlameableSettings(FlameableSettings settings);

    /**
     * Returns interact handler.
     *
     * @return interact handler.
     */
    BlockInteractHandler getInteractHandler();
}
