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

package org.diorite.material.item;

import java.util.Collection;

import org.diorite.material.AnyType;

/**
 * Represent item type.
 */
public interface ItemType extends AnyType
{
    ItemType STONE                    = Items.getItemType("minecraft:stone");
    ItemType GRASS                    = Items.getItemType("minecraft:grass");
    ItemType DIRT                     = Items.getItemType("minecraft:dirt");
    ItemType COBBLESTONE              = Items.getItemType("minecraft:cobblestone");
    ItemType PLANKS                   = Items.getItemType("minecraft:planks");
    ItemType SAPLING                  = Items.getItemType("minecraft:sapling");
    ItemType BEDROCK                  = Items.getItemType("minecraft:bedrock");
    ItemType SAND                     = Items.getItemType("minecraft:sand");
    ItemType GRAVEL                   = Items.getItemType("minecraft:gravel");
    ItemType GOLD_ORE                 = Items.getItemType("minecraft:gold_ore");
    ItemType IRON_ORE                 = Items.getItemType("minecraft:iron_ore");
    ItemType COAL_ORE                 = Items.getItemType("minecraft:coal_ore");
    ItemType LOG                      = Items.getItemType("minecraft:log");
    ItemType LEAVES                   = Items.getItemType("minecraft:leaves");
    ItemType SPONGE                   = Items.getItemType("minecraft:sponge");
    ItemType GLASS                    = Items.getItemType("minecraft:glass");
    ItemType LAPIS_ORE                = Items.getItemType("minecraft:lapis_ore");
    ItemType LAPIS_BLOCK              = Items.getItemType("minecraft:lapis_block");
    ItemType DISPENSER                = Items.getItemType("minecraft:dispenser");
    ItemType SANDSTONE                = Items.getItemType("minecraft:sandstone");
    ItemType NOTEBLOCK                = Items.getItemType("minecraft:noteblock");
    ItemType POWERED_RAIL             = Items.getItemType("minecraft:golden_rail");
    ItemType DETECTOR_RAIL            = Items.getItemType("minecraft:detector_rail");
    ItemType PISTON_STICKY            = Items.getItemType("minecraft:sticky_piston");
    ItemType COBWEB                   = Items.getItemType("minecraft:web");
    ItemType TALL_GRASS               = Items.getItemType("minecraft:tallgrass");
    ItemType DEAD_BUSH                = Items.getItemType("minecraft:deadbush");
    ItemType PISTON                   = Items.getItemType("minecraft:piston");
    ItemType WOOL                     = Items.getItemType("minecraft:wool");
    ItemType DANDELION                = Items.getItemType("minecraft:yellow_flower");
    ItemType FLOWERS                  = Items.getItemType("minecraft:red_flower");
    ItemType BROWN_MUSHROOM           = Items.getItemType("minecraft:brown_mushroom");
    ItemType RED_MUSHROOM             = Items.getItemType("minecraft:red_mushroom");
    ItemType GOLD_BLOCK               = Items.getItemType("minecraft:gold_block");
    ItemType IRON_BLOCK               = Items.getItemType("minecraft:iron_block");
    ItemType STONE_SLAB               = Items.getItemType("minecraft:stone_slab");
    ItemType BRICK_BLOCK              = Items.getItemType("minecraft:brick_block");
    ItemType TNT                      = Items.getItemType("minecraft:tnt");
    ItemType BOOKSHELF                = Items.getItemType("minecraft:bookshelf");
    ItemType MOSSY_COBBLESTONE        = Items.getItemType("minecraft:mossy_cobblestone");
    ItemType OBSIDIAN                 = Items.getItemType("minecraft:obsidian");
    ItemType MOB_SPAWNER              = Items.getItemType("minecraft:mob_spawner");
    ItemType OAK_STAIRS               = Items.getItemType("minecraft:oak_stairs");
    ItemType CHEST                    = Items.getItemType("minecraft:chest");
    ItemType DIAMOND_ORE              = Items.getItemType("minecraft:diamond_ore");
    ItemType DIAMOND_BLOCK            = Items.getItemType("minecraft:diamond_block");
    ItemType CRAFTING_TABLE           = Items.getItemType("minecraft:crafting_table");
    ItemType FARMLAND                 = Items.getItemType("minecraft:farmland");
    ItemType FURNACE                  = Items.getItemType("minecraft:furnace");
    ItemType BURNING_FURNACE          = Items.getItemType("minecraft:lit_furnace");
    ItemType LADDER                   = Items.getItemType("minecraft:ladder");
    ItemType RAIL                     = Items.getItemType("minecraft:rail");
    ItemType COBBLESTONE_STAIRS       = Items.getItemType("minecraft:stone_stairs");
    ItemType LEVER                    = Items.getItemType("minecraft:lever");
    ItemType STONE_PRESSURE_PLATE     = Items.getItemType("minecraft:stone_pressure_plate");
    ItemType WOODEN_PRESSURE_PLATE    = Items.getItemType("minecraft:wooden_pressure_plate");
    ItemType REDSTONE_ORE             = Items.getItemType("minecraft:redstone_ore");
    ItemType STONE_BUTTON             = Items.getItemType("minecraft:stone_button");
    ItemType SNOW_LAYER_1             = Items.getItemType("minecraft:snow_layer");
    ItemType ICE                      = Items.getItemType("minecraft:ice");
    ItemType SNOW_BLOCK               = Items.getItemType("minecraft:snow");
    ItemType CACTUS                   = Items.getItemType("minecraft:cactus");
    ItemType CLAY_BLOCK               = Items.getItemType("minecraft:clay");
    ItemType JUKEBOX                  = Items.getItemType("minecraft:jukebox");
    ItemType OAK_FENCE                = Items.getItemType("minecraft:fence");
    ItemType PUMPKIN                  = Items.getItemType("minecraft:pumpkin");
    ItemType NETHERRACK               = Items.getItemType("minecraft:netherrack");
    ItemType SOUL_SAND                = Items.getItemType("minecraft:soul_sand");
    ItemType GLOWSTONE                = Items.getItemType("minecraft:glowstone");
    ItemType NETHER_PORTAL            = Items.getItemType("minecraft:portal");
    ItemType PUMPKIN_LANTERN          = Items.getItemType("minecraft:lit_pumpkin");
    ItemType STAINED_GLASS            = Items.getItemType("minecraft:stained_glass");
    ItemType WOODEN_TRAPDOOR          = Items.getItemType("minecraft:trapdoor");
    ItemType MONSTER_EGG_TRAP         = Items.getItemType("minecraft:monster_egg");
    ItemType STONE_BRICK              = Items.getItemType("minecraft:stonebrick");
    ItemType BROWN_MUSHROOM_BLOCK     = Items.getItemType("minecraft:brown_mushroom_block");
    ItemType RED_MUSHROOM_BLOCK       = Items.getItemType("minecraft:red_mushroom_block");
    ItemType IRON_BARS                = Items.getItemType("minecraft:iron_bars");
    ItemType GLASS_PANE               = Items.getItemType("minecraft:glass_pane");
    ItemType MELON_BLOCK              = Items.getItemType("minecraft:melon_block");
    ItemType VINE                     = Items.getItemType("minecraft:vine");
    ItemType OAK_FENCE_GATE           = Items.getItemType("minecraft:fence_gate");
    ItemType BRICK_STAIRS             = Items.getItemType("minecraft:brick_stairs");
    ItemType STONE_BRICK_STAIRS       = Items.getItemType("minecraft:stone_brick_stairs");
    ItemType MYCELIUM                 = Items.getItemType("minecraft:mycelium");
    ItemType WATER_LILY               = Items.getItemType("minecraft:waterlily");
    ItemType NETHER_BRICK             = Items.getItemType("minecraft:nether_brick");
    ItemType NETHER_BRICK_FENCE       = Items.getItemType("minecraft:nether_brick_fence");
    ItemType NETHER_BRICK_STAIRS      = Items.getItemType("minecraft:nether_brick_stairs");
    ItemType ENCHANTING_TABLE         = Items.getItemType("minecraft:enchanting_table");
    ItemType END_PORTAL_FRAME         = Items.getItemType("minecraft:end_portal_frame");
    ItemType END_STONE                = Items.getItemType("minecraft:end_stone");
    ItemType DRAGON_EGG               = Items.getItemType("minecraft:dragon_egg");
    ItemType REDSTONE_LAMP_OFF        = Items.getItemType("minecraft:redstone_lamp");
    ItemType WOODEN_SLAB              = Items.getItemType("minecraft:wooden_slab");
    ItemType COCOA_NORTH_0            = Items.getItemType("minecraft:cocoa");
    ItemType SANDSTONE_STAIRS         = Items.getItemType("minecraft:sandstone_stairs");
    ItemType EMERALD_ORE              = Items.getItemType("minecraft:emerald_ore");
    ItemType ENDER_CHEST              = Items.getItemType("minecraft:ender_chest");
    ItemType TRIPWIRE_HOOK            = Items.getItemType("minecraft:tripwire_hook");
    ItemType EMERALD_BLOCK            = Items.getItemType("minecraft:emerald_block");
    ItemType SPRUCE_STAIRS            = Items.getItemType("minecraft:spruce_stairs");
    ItemType BIRCH_STAIRS             = Items.getItemType("minecraft:birch_stairs");
    ItemType JUNGLE_STAIRS            = Items.getItemType("minecraft:jungle_stairs");
    ItemType COMMAND_BLOCK            = Items.getItemType("minecraft:command_block");
    ItemType BEACON                   = Items.getItemType("minecraft:beacon");
    ItemType COBBLESTONE_WALL         = Items.getItemType("minecraft:cobblestone_wall");
    ItemType WOODEN_BUTTON            = Items.getItemType("minecraft:wooden_button");
    ItemType ANVIL                    = Items.getItemType("minecraft:anvil");
    ItemType TRAPPED_CHEST            = Items.getItemType("minecraft:trapped_chest");
    ItemType GOLDEN_PRESSURE_PLATE    = Items.getItemType("minecraft:light_weighted_pressure_plate");
    ItemType IRON_PRESSURE_PLATE      = Items.getItemType("minecraft:heavy_weighted_pressure_plate");
    ItemType DAYLIGHT_DETECTOR        = Items.getItemType("minecraft:daylight_detector");
    ItemType REDSTONE_BLOCK           = Items.getItemType("minecraft:redstone_block");
    ItemType QUARTZ_ORE               = Items.getItemType("minecraft:quartz_ore");
    ItemType HOPPER                   = Items.getItemType("minecraft:hopper");
    ItemType QUARTZ_BLOCK             = Items.getItemType("minecraft:quartz_block");
    ItemType QUARTZ_STAIRS            = Items.getItemType("minecraft:quartz_brick_stairs");
    ItemType ACTIVATOR_RAIL           = Items.getItemType("minecraft:activator_rail");
    ItemType DROPPER                  = Items.getItemType("minecraft:dropper");
    ItemType STAINED_HARDENED_CLAY    = Items.getItemType("minecraft:stained_hardened_clay");
    ItemType STAINED_GLASS_PANE       = Items.getItemType("minecraft:stained_glass_pane");
    ItemType LEAVES2                  = Items.getItemType("minecraft:leaves2");
    ItemType LOG2                     = Items.getItemType("minecraft:log2");
    ItemType ACACIA_STAIRS            = Items.getItemType("minecraft:acacia_stairs");
    ItemType DARK_OAK_STAIRS          = Items.getItemType("minecraft:dark_oak_stairs");
    ItemType SLIME_BLOCK              = Items.getItemType("minecraft:slime");
    ItemType BARRIER                  = Items.getItemType("minecraft:barrier");
    ItemType IRON_TRAPDOOR            = Items.getItemType("minecraft:iron_trapdoor");
    ItemType PRISMARINE               = Items.getItemType("minecraft:prismarine");
    ItemType SEA_LANTERN              = Items.getItemType("minecraft:sea_lantern");
    ItemType HAY_BLOCK                = Items.getItemType("minecraft:hay_block");
    ItemType CARPET                   = Items.getItemType("minecraft:carpet");
    ItemType HARDENED_CLAY            = Items.getItemType("minecraft:hardened_clay");
    ItemType COAL_BLOCK               = Items.getItemType("minecraft:coal_block");
    ItemType PACKED_ICE               = Items.getItemType("minecraft:packet_ice");
    ItemType DOUBLE_FLOWERS           = Items.getItemType("minecraft:double_plant");
    ItemType RED_SANDSTONE            = Items.getItemType("minecraft:red_sandstone");
    ItemType RED_SANDSTONE_STAIRS     = Items.getItemType("minecraft:red_sandstone_stairs");
    ItemType STONE_SLAB2              = Items.getItemType("minecraft:stone_slab2");
    ItemType SPRUCE_FENCE_GATE        = Items.getItemType("minecraft:spruce_fence_gate");
    ItemType BIRCH_FENCE_GATE         = Items.getItemType("minecraft:brich_fence_gate");
    ItemType JUNGLE_FENCE_GATE        = Items.getItemType("minecraft:jungle_fence_gate");
    ItemType DARK_OAK_FENCE_GATE      = Items.getItemType("minecraft:fark_oak_fence_gate");
    ItemType ACACIA_FENCE_GATE        = Items.getItemType("minecraft:acacia_fence_gate");
    ItemType SPRUCE_FENCE             = Items.getItemType("minecraft:spruce_fence");
    ItemType BIRCH_FENCE              = Items.getItemType("minecraft:birch_fence");
    ItemType JUNGLE_FENCE             = Items.getItemType("minecraft:jungle_fence");
    ItemType DARK_OAK_FENCE           = Items.getItemType("minecraft:dark_oak_fence");
    ItemType ACACIA_FENCE             = Items.getItemType("minecraft:acacia_fence");
    ItemType IRON_SHOVEL              = Items.getItemType("minecraft:iron_Shovel");
    ItemType IRON_PICKAXE             = Items.getItemType("minecraft:iron_Pickaxe");
    ItemType IRON_AXE                 = Items.getItemType("minecraft:iron_Axe");
    ItemType FLINT_AND_STEEL          = Items.getItemType("minecraft:flint_and_steel");
    ItemType APPLE                    = Items.getItemType("minecraft:apple");
    ItemType BOW                      = Items.getItemType("minecraft:bow");
    ItemType ARROW                    = Items.getItemType("minecraft:arrow");
    ItemType COAL                     = Items.getItemType("minecraft:coal");
    ItemType DIAMOND                  = Items.getItemType("minecraft:diamond");
    ItemType IRON_INGOT               = Items.getItemType("minecraft:iron_ingot");
    ItemType GOLD_INGOT               = Items.getItemType("minecraft:gold_ingot");
    ItemType IRON_SWORD               = Items.getItemType("minecraft:iron_Sword");
    ItemType WOODEN_SWORD             = Items.getItemType("minecraft:wooden_Sword");
    ItemType WOODEN_SHOVEL            = Items.getItemType("minecraft:wooden_Shovel");
    ItemType WOODEN_PICKAXE           = Items.getItemType("minecraft:wooden_Pickaxe");
    ItemType WOODEN_AXE               = Items.getItemType("minecraft:wooden_axe");
    ItemType STONE_SWORD              = Items.getItemType("minecraft:stone_Sword");
    ItemType STONE_SHOVEL             = Items.getItemType("minecraft:stone_Shovel");
    ItemType STONE_PICKAXE            = Items.getItemType("minecraft:stone_Pickaxe");
    ItemType STONE_AXE                = Items.getItemType("minecraft:stone_Axe");
    ItemType DIAMOND_SWORD            = Items.getItemType("minecraft:diamond_Sword");
    ItemType DIAMOND_SHOVEL           = Items.getItemType("minecraft:diamond_Shovel");
    ItemType DIAMOND_PICKAXE          = Items.getItemType("minecraft:diamond_Pickaxe");
    ItemType DIAMOND_AXE              = Items.getItemType("minecraft:diamond_Axe");
    ItemType STICK                    = Items.getItemType("minecraft:stick");
    ItemType BOWL                     = Items.getItemType("minecraft:bowl");
    ItemType MUSHROOM_STEW            = Items.getItemType("minecraft:mushroom_stew");
    ItemType GOLDEN_SWORD             = Items.getItemType("minecraft:golden_Sword");
    ItemType GOLDEN_SHOVEL            = Items.getItemType("minecraft:golden_Shovel");
    ItemType GOLDEN_PICKAXE           = Items.getItemType("minecraft:golden_Pickaxe");
    ItemType GOLDEN_AXE               = Items.getItemType("minecraft:golden_Axe");
    ItemType STRING                   = Items.getItemType("minecraft:string");
    ItemType FEATHER                  = Items.getItemType("minecraft:feather");
    ItemType GUNPOWDER                = Items.getItemType("minecraft:gunpowder");
    ItemType WOODEN_HOE               = Items.getItemType("minecraft:wooden_Hoe");
    ItemType STONE_HOE                = Items.getItemType("minecraft:stone_Hoe");
    ItemType IRON_HOE                 = Items.getItemType("minecraft:iron_Hoe");
    ItemType DIAMOND_HOE              = Items.getItemType("minecraft:diamond_Hoe");
    ItemType GOLDEN_HOE               = Items.getItemType("minecraft:golden_Hoe");
    ItemType WHEAT_SEEDS              = Items.getItemType("minecraft:wheat_seeds");
    ItemType WHEAT                    = Items.getItemType("minecraft:wheat");
    ItemType BREAD                    = Items.getItemType("minecraft:bread");
    ItemType LEATHER_HELMET           = Items.getItemType("minecraft:leather_helmet");
    ItemType LEATHER_CHESTPLATE       = Items.getItemType("minecraft:leather_chestplate");
    ItemType LEATHER_LEGGINGS         = Items.getItemType("minecraft:leather_leggings");
    ItemType LEATHER_BOOTS            = Items.getItemType("minecraft:leather_boots");
    ItemType CHAINMAIL_HELMET         = Items.getItemType("minecraft:chainmail_helmet");
    ItemType CHAINMAIL_CHESTPLATE     = Items.getItemType("minecraft:chainmail_chestplate");
    ItemType CHAINMAIL_LEGGINGS       = Items.getItemType("minecraft:chainmail_leggings");
    ItemType CHAINMAIL_BOOTS          = Items.getItemType("minecraft:chainmail_boots");
    ItemType IRON_HELMET              = Items.getItemType("minecraft:iron_helmet");
    ItemType IRON_CHESTPLATE          = Items.getItemType("minecraft:iron_chestplate");
    ItemType IRON_LEGGINGS            = Items.getItemType("minecraft:iron_leggings");
    ItemType IRON_BOOTS               = Items.getItemType("minecraft:iron_boots");
    ItemType DIAMOND_HELMET           = Items.getItemType("minecraft:diamond_helmet");
    ItemType DIAMOND_CHESTPLATE       = Items.getItemType("minecraft:diamond_chestplate");
    ItemType DIAMOND_LEGGINGS         = Items.getItemType("minecraft:diamond_leggings");
    ItemType DIAMOND_BOOTS            = Items.getItemType("minecraft:diamond_boots");
    ItemType GOLD_HELMET              = Items.getItemType("minecraft:gold_helmet");
    ItemType GOLD_CHESTPLATE          = Items.getItemType("minecraft:gold_chestplate");
    ItemType GOLD_LEGGINGS            = Items.getItemType("minecraft:gold_leggings");
    ItemType GOLD_BOOTS               = Items.getItemType("minecraft:gold_boots");
    ItemType FLINT                    = Items.getItemType("minecraft:flint");
    ItemType PORKCHOP                 = Items.getItemType("minecraft:porkchop");
    ItemType COOKED_PORKCHOP          = Items.getItemType("minecraft:cooked_porkchop");
    ItemType PAINTING                 = Items.getItemType("minecraft:painting");
    ItemType GOLDEN_APPLE             = Items.getItemType("minecraft:golden_apple");
    ItemType SIGN                     = Items.getItemType("minecraft:sign");
    ItemType OAK_DOOR_ITEM            = Items.getItemType("minecraft:wooden_door");
    ItemType BUCKET                   = Items.getItemType("minecraft:bucket");
    ItemType WATER_BUCKET             = Items.getItemType("minecraft:water_bucket");
    ItemType LAVA_BUCKET              = Items.getItemType("minecraft:lava_bucket");
    ItemType MINECART                 = Items.getItemType("minecraft:minecraft");
    ItemType SADDLE                   = Items.getItemType("minecraft:saddle");
    ItemType IRON_DOOR_ITEM           = Items.getItemType("minecraft:iron_door");
    ItemType REDSTONE                 = Items.getItemType("minecraft:redstone");
    ItemType SNOWBALL                 = Items.getItemType("minecraft:snowball");
    ItemType OAK_BOAT                 = Items.getItemType("minecraft:boat");
    ItemType LEATHER                  = Items.getItemType("minecraft:leather");
    ItemType MILK_BUCKET              = Items.getItemType("minecraft:milk_bucket");
    ItemType BRICK                    = Items.getItemType("minecraft:brick");
    ItemType CLAY_BALL                = Items.getItemType("minecraft:clay_ball");
    ItemType REEDS                    = Items.getItemType("minecraft:reeds");
    ItemType PAPER                    = Items.getItemType("minecraft:paper");
    ItemType BOOK                     = Items.getItemType("minecraft:book");
    ItemType SLIMEBALL                = Items.getItemType("minecraft:slime_ball");
    ItemType CHEST_MINECART           = Items.getItemType("minecraft:chest_minecart");
    ItemType FURNACE_MINECART         = Items.getItemType("minecraft:furnace_minecart");
    ItemType EGG                      = Items.getItemType("minecraft:egg");
    ItemType COMPASS                  = Items.getItemType("minecraft:compass");
    ItemType FISHING_ROD              = Items.getItemType("minecraft:fishing_rod");
    ItemType CLOCK                    = Items.getItemType("minecraft:clock");
    ItemType GLOWSTONE_DUST           = Items.getItemType("minecraft:glowstone_dust");
    ItemType FISH                     = Items.getItemType("minecraft:fish");
    ItemType COOKED_FISH              = Items.getItemType("minecraft:cooked_fish");
    ItemType DYE                      = Items.getItemType("minecraft:dye");
    ItemType BONE                     = Items.getItemType("minecraft:bone");
    ItemType SUGAR                    = Items.getItemType("minecraft:sugar");
    ItemType CAKE                     = Items.getItemType("minecraft:cake");
    ItemType BED                      = Items.getItemType("minecraft:bed");
    ItemType REDSTONE_REPEATER_ITEM   = Items.getItemType("minecraft:repeater");
    ItemType COOKIE                   = Items.getItemType("minecraft:cookie");
    ItemType FILLED_MAP               = Items.getItemType("minecraft:filled_map");
    ItemType SHEARS                   = Items.getItemType("minecraft:shears");
    ItemType MELON                    = Items.getItemType("minecraft:melon");
    ItemType PUMPKIN_SEEDS            = Items.getItemType("minecraft:pumpkin_seeds");
    ItemType MELON_SEEDS              = Items.getItemType("minecraft:melon_seeds");
    ItemType BEEF                     = Items.getItemType("minecraft:beef");
    ItemType COOKED_BEEF              = Items.getItemType("minecraft:cooked_beef");
    ItemType CHICKEN                  = Items.getItemType("minecraft:chicked");
    ItemType COOKED_CHICKEN           = Items.getItemType("minecraft:cooked_chicken");
    ItemType ROTTEN_FLESH             = Items.getItemType("minecraft:rotten_flesh");
    ItemType ENDER_PEARL              = Items.getItemType("minecraft:ender_pearl");
    ItemType BLAZE_ROD                = Items.getItemType("minecraft:blaze_rod");
    ItemType GHAST_TEAR               = Items.getItemType("minecraft:ghast_tear");
    ItemType GOLD_NUGGET              = Items.getItemType("minecraft:gold_nugget");
    ItemType NETHER_WART              = Items.getItemType("minecraft:nether_wart");
    ItemType POTION                   = Items.getItemType("minecraft:potion");
    ItemType GLASS_BOTTLE             = Items.getItemType("minecraft:glass_bottle");
    ItemType SPIDER_EYE               = Items.getItemType("minecraft:spider_eye");
    ItemType FERMENTED_SPIDER_EYE     = Items.getItemType("minecraft:fermented_spider_eye");
    ItemType BLAZE_POWDER             = Items.getItemType("minecraft:blaze_powder");
    ItemType MAGMA_CREAM              = Items.getItemType("minecraft:magma_cream");
    ItemType BREWING_STAND            = Items.getItemType("minecraft:brewing_stand");
    ItemType CAULDRON                 = Items.getItemType("minecraft:cauldron");
    ItemType ENDER_EYE                = Items.getItemType("minecraft:ender_eye");
    ItemType SPECKLED_MELON           = Items.getItemType("minecraft:speckled_melon");
    ItemType SPAWN_EGG_CREEPER        = Items.getItemType("minecraft:spawn_egg");
    ItemType EXPERIENCE_BOTTLE        = Items.getItemType("minecraft:experience_bottle");
    ItemType FIRE_CHARGE              = Items.getItemType("minecraft:fire_charge");
    ItemType WRITABLE_BOOK            = Items.getItemType("minecraft:writable_book");
    ItemType WRITTEN_BOOK             = Items.getItemType("minecraft:written_book");
    ItemType EMERALD                  = Items.getItemType("minecraft:emerald");
    ItemType ITEM_FRAME               = Items.getItemType("minecraft:item_frame");
    ItemType FLOWER_POT               = Items.getItemType("minecraft:flower_pot");
    ItemType CARROT                   = Items.getItemType("minecraft:carrot");
    ItemType POTATO                   = Items.getItemType("minecraft:potato");
    ItemType BAKED_POTATO             = Items.getItemType("minecraft:baked_potato");
    ItemType POISONOUS_POTATO         = Items.getItemType("minecraft:poisounous_potato");
    ItemType MAP                      = Items.getItemType("minecraft:map");
    ItemType GOLDEN_CARROT            = Items.getItemType("minecraft:golden_carrot");
    ItemType SKULL                    = Items.getItemType("minecraft:skull");
    ItemType CARROT_ON_A_STICK        = Items.getItemType("minecraft:carrot_on_a_stick");
    ItemType NETHER_STAR              = Items.getItemType("minecraft:nether_star");
    ItemType PUMPKIN_PIE              = Items.getItemType("minecraft:pumpkin_pie");
    ItemType FIREWORKS                = Items.getItemType("minecraft:fireworks");
    ItemType FIREWORK_CHARGE          = Items.getItemType("minecraft:firework_charge");
    ItemType ENCHANTED_BOOK           = Items.getItemType("minecraft:enchanted_book");
    ItemType REDSTONE_COMPARATOR_ITEM = Items.getItemType("minecraft:comparator");
    ItemType NETHER_BRICK_ITEM        = Items.getItemType("minecraft:netherbrick");
    ItemType QUARTZ                   = Items.getItemType("minecraft:quartz");
    ItemType TNT_MINECART             = Items.getItemType("minecraft:tnt_minecart");
    ItemType HOPPER_MINECART          = Items.getItemType("minecraft:hopper_minecart");
    ItemType PRISMARINE_SHARD         = Items.getItemType("minecraft:prismarine_shard");
    ItemType PRISMARINE_CRYSTALS      = Items.getItemType("minecraft:prismarine_crystals");
    ItemType RABBIT                   = Items.getItemType("minecraft:rabbit");
    ItemType COOKED_RABBIT            = Items.getItemType("minecraft:cooked_rabbit");
    ItemType RABBIT_STEW              = Items.getItemType("minecraft:rabbit_stew");
    ItemType RABBIT_FOOT              = Items.getItemType("minecraft:rabbit_foot");
    ItemType RABBIT_HIDE              = Items.getItemType("minecraft:rabbit_hide");
    ItemType ARMOR_STAND              = Items.getItemType("minecraft:armor_stand");
    ItemType IRON_HORSE_ARMOR         = Items.getItemType("minecraft:iron_horse_armor");
    ItemType GOLDEN_HORSE_ARMOR       = Items.getItemType("minecraft:golden_horse_armor");
    ItemType DIAMOND_HORSE_ARMOR      = Items.getItemType("minecraft:diamond_horse_armor");
    ItemType LEAD                     = Items.getItemType("minecraft:lead");
    ItemType NAME_TAG                 = Items.getItemType("minecraft:name_tag");
    ItemType COMMAND_BLOCK_MINECART   = Items.getItemType("minecraft:command_block_minecart");
    ItemType MUTTON                   = Items.getItemType("minecraft:mutton");
    ItemType COOKED_MUTTON            = Items.getItemType("minecraft:cooked_mutton");
    ItemType BANNER                   = Items.getItemType("minecraft:banner");
    ItemType SPRUCE_DOOR_ITEM         = Items.getItemType("minecraft:spruce_door");
    ItemType BIRCH_DOOR_ITEM          = Items.getItemType("minecraft:birch_door");
    ItemType JUNGLE_DOOR_ITEM         = Items.getItemType("minecraft:jungle_door");
    ItemType ACACIA_DOOR_ITEM         = Items.getItemType("minecraft:acacia_door");
    ItemType DARK_OAK_DOOR_ITEM       = Items.getItemType("minecraft:dark_oak_door");
    ItemType SPRUCE_BOAT              = Items.getItemType("minecraft:spruce_boat");
    ItemType BIRCH_BOAT               = Items.getItemType("minecraft:birch_boat");
    ItemType JUNGLE_BOAT              = Items.getItemType("minecraft:jungle_boat");
    ItemType ACACIA_BOAT              = Items.getItemType("minecraft:acacia_boat");
    ItemType DARK_OAK_BOAT            = Items.getItemType("minecraft:dark_oak_boat");
    ItemType RECORD_13                = Items.getItemType("minecraft:record_13");
    ItemType RECORD_CAT               = Items.getItemType("minecraft:record_cat");
    ItemType RECORD_BLOCKS            = Items.getItemType("minecraft:record_blocks");
    ItemType RECORD_CHRIP             = Items.getItemType("minecraft:record_chrip");
    ItemType RECORD_FAR               = Items.getItemType("minecraft:record_far");
    ItemType RECORD_MALL              = Items.getItemType("minecraft:record_mall");
    ItemType RECORD_MELLOHI           = Items.getItemType("minecraft:record_mellohi");
    ItemType RECORD_STAL              = Items.getItemType("minecraft:record_stal");
    ItemType RECORD_STRAD             = Items.getItemType("minecraft:record_strad");
    ItemType RECORD_WARD              = Items.getItemType("minecraft:record_ward");
    ItemType RECORD_11                = Items.getItemType("minecraft:record_11");
    ItemType RECORD_WAIT              = Items.getItemType("minecraft:record_wait");

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
     * Returns id used in packets, used for adding fake items.
     *
     * @return id used in packets, used for adding fake items.
     */
    @Override
    default int getProxyId()
    {
        return this.getId();
    }

    /**
     * Returns minecraft string id of item.
     *
     * @return minecraft string id of item.
     */
    @Override
    String getMinecraftId();

    /**
     * Returns minecraft string id of item used in packets, used for adding fake items.
     *
     * @return minecraft string id of item used in packets, used for adding fake items.
     */
    @Override
    default String getProxyMinecraftId()
    {
        return this.getMinecraftId();
    }

    /**
     * Returns max size of single itemstack of this item, vanilla clinets can handle values only in byte range.
     *
     * @return max size of single itemstack of this item, vanilla clinets can handle values only in byte range.
     */
    int getMaxStack();

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    ItemSubtype getSubtype(int id);

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    ItemSubtype getSubtype(String id);

    /**
     * Returns collection of subtypes for this item.
     *
     * @return collection of subtypes for this item.
     */
    @Override
    Collection<? extends ItemSubtype> getSubtypes();

    /**
     * Returns display name of item.
     *
     * @return display name of item.
     */
    @Override
    String getDisplayNameKey();

}
