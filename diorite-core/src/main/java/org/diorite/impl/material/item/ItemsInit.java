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

package org.diorite.impl.material.item;

import org.diorite.material.block.BlockType;
import org.diorite.material.block.BlockRegistry;
import org.diorite.material.item.ItemType;
import org.diorite.material.item.ItemRegistry;

@SuppressWarnings("MagicNumber")
public class ItemsInit
{
    public static ItemType fromBlock(final BlockType type)
    {
        return new BlockItemTypeImpl(type);
    }

    public static void init()
    {
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stone")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:grass")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:dirt")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:cobblestone")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:planks")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:sapling")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:bedrock")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:sand")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:gravel")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:gold_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:iron_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:coal_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:log")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:leaves")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:sponge")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:glass")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:lapis_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:lapis_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:dispenser")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:sandstone")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:noteblock")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:golden_rail")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:detector_rail")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:sticky_piston")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:web")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:tallgrass")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:deadbush")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:piston")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:wool")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:yellow_flower")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:red_flower")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:brown_mushroom")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:red_mushroom")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:gold_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:iron_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stone_slab")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:brick_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:tnt")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:bookshelf")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:mossy_cobblestone")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:obsidian")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:mob_spawner")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:oak_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:chest")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:diamond_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:diamond_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:crafting_table")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:farmland")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:furnace")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:lit_furnace")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:ladder")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:rail")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stone_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:lever")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stone_pressure_plate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:wooden_pressure_plate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:redstone_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stone_button")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:snow_layer")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:ice")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:snow")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:cactus")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:clay")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:jukebox")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:fence")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:pumpkin")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:netherrack")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:soul_sand")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:glowstone")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:portal")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:lit_pumpkin")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stained_glass")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:trapdoor")));
//        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:monster_egg")));
//        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stonebrick")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:brown_mushroom_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:red_mushroom_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:iron_bars")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:glass_pane")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:melon_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:vine")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:fence_gate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:brick_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stone_brick_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:mycelium")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:waterlily")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:nether_brick")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:nether_brick_fence")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:nether_brick_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:enchanting_table")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:end_portal_frame")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:end_stone")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:dragon_egg")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:redstone_lamp")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:wooden_slab")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:cocoa")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:sandstone_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:emerald_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:ender_chest")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:tripwire_hook")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:emerald_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:spruce_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:birch_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:jungle_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:command_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:beacon")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:cobblestone_wall")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:wooden_button")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:anvil")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:trapped_chest")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:light_weighted_pressure_plate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:heavy_weighted_pressure_plate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:daylight_detector")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:redstone_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:quartz_ore")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:hopper")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:quartz_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:quartz_brick_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:activator_rail")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:dropper")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stained_hardened_clay")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stained_glass_pane")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:leaves2")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:log2")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:acacia_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:dark_oak_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:slime")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:barrier")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:iron_trapdoor")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:prismarine")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:sea_lantern")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:hay_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:carpet")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:hardened_clay")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:coal_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:packet_ice")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:double_plant")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:red_sandstone")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:red_sandstone_stairs")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:stone_slab2")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:spruce_fence_gate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:brich_fence_gate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:jungle_fence_gate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:dark_oak_fence_gate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:acacia_fence_gate")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:spruce_fence")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:birch_fence")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:jungle_fence")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:dark_oak_fence")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:acacia_fence")));

        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:repeating_command_block")));
        ItemRegistry.registerItem(fromBlock(BlockRegistry.getBlockType("minecraft:chain_command_block")));
        ItemRegistry.registerItem(new SimpleItemType(256, "minecraft:iron_Shovel", 1));
        ItemRegistry.registerItem(new SimpleItemType(257, "minecraft:iron_Pickaxe", 1));
        ItemRegistry.registerItem(new SimpleItemType(258, "minecraft:iron_Axe", 1));
        ItemRegistry.registerItem(new SimpleItemType(259, "minecraft:flint_and_steel", 1));
        ItemRegistry.registerItem(new SimpleItemType(260, "minecraft:apple"));
        ItemRegistry.registerItem(new SimpleItemType(261, "minecraft:bow", 1));
        ItemRegistry.registerItem(new SimpleItemType(262, "minecraft:arrow"));
        ItemRegistry.registerItem(new SimpleItemType(263, "minecraft:coal"));
        ItemRegistry.registerItem(new SimpleItemType(264, "minecraft:diamond"));
        ItemRegistry.registerItem(new SimpleItemType(265, "minecraft:iron_ingot"));
        ItemRegistry.registerItem(new SimpleItemType(266, "minecraft:gold_ingot"));
        ItemRegistry.registerItem(new SimpleItemType(267, "minecraft:iron_Sword", 1));
        ItemRegistry.registerItem(new SimpleItemType(268, "minecraft:wooden_Sword", 1));
        ItemRegistry.registerItem(new SimpleItemType(269, "minecraft:wooden_Shovel", 1));
        ItemRegistry.registerItem(new SimpleItemType(270, "minecraft:wooden_Pickaxe", 1));
        ItemRegistry.registerItem(new SimpleItemType(271, "minecraft:wooden_axe", 1));
        ItemRegistry.registerItem(new SimpleItemType(272, "minecraft:stone_Sword", 1));
        ItemRegistry.registerItem(new SimpleItemType(273, "minecraft:stone_Shovel", 1));
        ItemRegistry.registerItem(new SimpleItemType(274, "minecraft:stone_Pickaxe", 1));
        ItemRegistry.registerItem(new SimpleItemType(275, "minecraft:stone_Axe", 1));
        ItemRegistry.registerItem(new SimpleItemType(276, "minecraft:diamond_Sword", 1));
        ItemRegistry.registerItem(new SimpleItemType(277, "minecraft:diamond_Shovel", 1));
        ItemRegistry.registerItem(new SimpleItemType(278, "minecraft:diamond_Pickaxe", 1));
        ItemRegistry.registerItem(new SimpleItemType(279, "minecraft:diamond_Axe", 1));
        ItemRegistry.registerItem(new SimpleItemType(280, "minecraft:stick"));
        ItemRegistry.registerItem(new SimpleItemType(281, "minecraft:bowl"));
        ItemRegistry.registerItem(new SimpleItemType(282, "minecraft:mushroom_stew", 1));
        ItemRegistry.registerItem(new SimpleItemType(283, "minecraft:golden_Sword", 1));
        ItemRegistry.registerItem(new SimpleItemType(284, "minecraft:golden_Shovel", 1));
        ItemRegistry.registerItem(new SimpleItemType(285, "minecraft:golden_Pickaxe", 1));
        ItemRegistry.registerItem(new SimpleItemType(286, "minecraft:golden_Axe", 1));
        ItemRegistry.registerItem(new SimpleItemType(287, "minecraft:string"));
        ItemRegistry.registerItem(new SimpleItemType(288, "minecraft:feather"));
        ItemRegistry.registerItem(new SimpleItemType(289, "minecraft:gunpowder"));
        ItemRegistry.registerItem(new SimpleItemType(290, "minecraft:wooden_Hoe", 1));
        ItemRegistry.registerItem(new SimpleItemType(291, "minecraft:stone_Hoe", 1));
        ItemRegistry.registerItem(new SimpleItemType(292, "minecraft:iron_Hoe", 1));
        ItemRegistry.registerItem(new SimpleItemType(293, "minecraft:diamond_Hoe", 1));
        ItemRegistry.registerItem(new SimpleItemType(294, "minecraft:golden_Hoe", 1));
        ItemRegistry.registerItem(new SimpleItemType(295, "minecraft:wheat_seeds"));
        ItemRegistry.registerItem(new SimpleItemType(296, "minecraft:wheat"));
        ItemRegistry.registerItem(new SimpleItemType(297, "minecraft:bread"));
        ItemRegistry.registerItem(new SimpleItemType(298, "minecraft:leather_helmet", 1));
        ItemRegistry.registerItem(new SimpleItemType(299, "minecraft:leather_chestplate", 1));
        ItemRegistry.registerItem(new SimpleItemType(300, "minecraft:leather_leggings", 1));
        ItemRegistry.registerItem(new SimpleItemType(301, "minecraft:leather_boots", 1));
        ItemRegistry.registerItem(new SimpleItemType(302, "minecraft:chainmail_helmet", 1));
        ItemRegistry.registerItem(new SimpleItemType(303, "minecraft:chainmail_chestplate", 1));
        ItemRegistry.registerItem(new SimpleItemType(304, "minecraft:chainmail_leggings", 1));
        ItemRegistry.registerItem(new SimpleItemType(305, "minecraft:chainmail_boots", 1));
        ItemRegistry.registerItem(new SimpleItemType(306, "minecraft:iron_helmet", 1));
        ItemRegistry.registerItem(new SimpleItemType(307, "minecraft:iron_chestplate", 1));
        ItemRegistry.registerItem(new SimpleItemType(308, "minecraft:iron_leggings", 1));
        ItemRegistry.registerItem(new SimpleItemType(309, "minecraft:iron_boots", 1));
        ItemRegistry.registerItem(new SimpleItemType(310, "minecraft:diamond_helmet", 1));
        ItemRegistry.registerItem(new SimpleItemType(311, "minecraft:diamond_chestplate", 1));
        ItemRegistry.registerItem(new SimpleItemType(312, "minecraft:diamond_leggings", 1));
        ItemRegistry.registerItem(new SimpleItemType(313, "minecraft:diamond_boots", 1));
        ItemRegistry.registerItem(new SimpleItemType(314, "minecraft:gold_helmet", 1));
        ItemRegistry.registerItem(new SimpleItemType(315, "minecraft:gold_chestplate", 1));
        ItemRegistry.registerItem(new SimpleItemType(316, "minecraft:gold_leggings", 1));
        ItemRegistry.registerItem(new SimpleItemType(317, "minecraft:gold_boots", 1));
        ItemRegistry.registerItem(new SimpleItemType(318, "minecraft:flint"));
        ItemRegistry.registerItem(new SimpleItemType(319, "minecraft:porkchop"));
        ItemRegistry.registerItem(new SimpleItemType(320, "minecraft:cooked_porkchop"));
        ItemRegistry.registerItem(new SimpleItemType(321, "minecraft:painting"));
        ItemRegistry.registerItem(new SimpleItemType(322, "minecraft:golden_apple"));
        ItemRegistry.registerItem(new SimpleItemType(323, "minecraft:sign", 16));
        ItemRegistry.registerItem(new SimpleItemType(324, "minecraft:wooden_door"));
        ItemRegistry.registerItem(new SimpleItemType(325, "minecraft:bucket", 16));
        ItemRegistry.registerItem(new SimpleItemType(326, "minecraft:water_bucket", 1));
        ItemRegistry.registerItem(new SimpleItemType(327, "minecraft:lava_bucket", 1));
        ItemRegistry.registerItem(new SimpleItemType(328, "minecraft:minecraft", 1));
        ItemRegistry.registerItem(new SimpleItemType(329, "minecraft:saddle", 1));
        ItemRegistry.registerItem(new SimpleItemType(330, "minecraft:iron_door"));
        ItemRegistry.registerItem(new SimpleItemType(331, "minecraft:redstone"));
        ItemRegistry.registerItem(new SimpleItemType(332, "minecraft:snowball"));
        ItemRegistry.registerItem(new SimpleItemType(333, "minecraft:boat", 1));
        ItemRegistry.registerItem(new SimpleItemType(334, "minecraft:leather"));
        ItemRegistry.registerItem(new SimpleItemType(335, "minecraft:milk_bucket", 1));
        ItemRegistry.registerItem(new SimpleItemType(336, "minecraft:brick"));
        ItemRegistry.registerItem(new SimpleItemType(337, "minecraft:clay_ball"));
        ItemRegistry.registerItem(new SimpleItemType(338, "minecraft:reeds"));
        ItemRegistry.registerItem(new SimpleItemType(339, "minecraft:paper"));
        ItemRegistry.registerItem(new SimpleItemType(340, "minecraft:book"));
        ItemRegistry.registerItem(new SimpleItemType(341, "minecraft:slime_ball"));
        ItemRegistry.registerItem(new SimpleItemType(342, "minecraft:chest_minecart", 1));
        ItemRegistry.registerItem(new SimpleItemType(343, "minecraft:furnace_minecart", 1));
        ItemRegistry.registerItem(new SimpleItemType(344, "minecraft:egg", 16));
        ItemRegistry.registerItem(new SimpleItemType(345, "minecraft:compass"));
        ItemRegistry.registerItem(new SimpleItemType(346, "minecraft:fishing_rod", 1));
        ItemRegistry.registerItem(new SimpleItemType(347, "minecraft:clock"));
        ItemRegistry.registerItem(new SimpleItemType(348, "minecraft:glowstone_dust"));
        ItemRegistry.registerItem(new SimpleItemType(349, "minecraft:fish"));
        ItemRegistry.registerItem(new SimpleItemType(350, "minecraft:cooked_fish"));
        ItemRegistry.registerItem(new SimpleItemType(351, "minecraft:dye"));
        ItemRegistry.registerItem(new SimpleItemType(352, "minecraft:bone"));
        ItemRegistry.registerItem(new SimpleItemType(353, "minecraft:sugar"));
        ItemRegistry.registerItem(new SimpleItemType(354, "minecraft:cake", 1));
        ItemRegistry.registerItem(new SimpleItemType(355, "minecraft:bed", 1));
        ItemRegistry.registerItem(new SimpleItemType(356, "minecraft:repeater"));
        ItemRegistry.registerItem(new SimpleItemType(357, "minecraft:cookie"));
        ItemRegistry.registerItem(new SimpleItemType(358, "minecraft:filled_map"));
        ItemRegistry.registerItem(new SimpleItemType(359, "minecraft:shears", 1));
        ItemRegistry.registerItem(new SimpleItemType(360, "minecraft:melon"));
        ItemRegistry.registerItem(new SimpleItemType(361, "minecraft:pumpkin_seeds"));
        ItemRegistry.registerItem(new SimpleItemType(362, "minecraft:melon_seeds"));
        ItemRegistry.registerItem(new SimpleItemType(363, "minecraft:beef"));
        ItemRegistry.registerItem(new SimpleItemType(364, "minecraft:cooked_beef"));
        ItemRegistry.registerItem(new SimpleItemType(365, "minecraft:chicked"));
        ItemRegistry.registerItem(new SimpleItemType(366, "minecraft:cooked_chicken"));
        ItemRegistry.registerItem(new SimpleItemType(367, "minecraft:rotten_flesh"));
        ItemRegistry.registerItem(new SimpleItemType(368, "minecraft:ender_pearl", 16));
        ItemRegistry.registerItem(new SimpleItemType(369, "minecraft:blaze_rod"));
        ItemRegistry.registerItem(new SimpleItemType(370, "minecraft:ghast_tear"));
        ItemRegistry.registerItem(new SimpleItemType(371, "minecraft:gold_nugget"));
        ItemRegistry.registerItem(new SimpleItemType(372, "minecraft:nether_wart"));
        ItemRegistry.registerItem(new SimpleItemType(373, "minecraft:potion", 1));
        ItemRegistry.registerItem(new SimpleItemType(374, "minecraft:glass_bottle"));
        ItemRegistry.registerItem(new SimpleItemType(375, "minecraft:spider_eye"));
        ItemRegistry.registerItem(new SimpleItemType(376, "minecraft:fermented_spider_eye"));
        ItemRegistry.registerItem(new SimpleItemType(377, "minecraft:blaze_powder"));
        ItemRegistry.registerItem(new SimpleItemType(378, "minecraft:magma_cream"));
        ItemRegistry.registerItem(new SimpleItemType(379, "minecraft:brewing_stand"));
        ItemRegistry.registerItem(new SimpleItemType(380, "minecraft:cauldron"));
        ItemRegistry.registerItem(new SimpleItemType(381, "minecraft:ender_eye"));
        ItemRegistry.registerItem(new SimpleItemType(382, "minecraft:speckled_melon"));
        ItemRegistry.registerItem(new SimpleItemType(383, "minecraft:spawn_egg"));
        ItemRegistry.registerItem(new SimpleItemType(384, "minecraft:experience_bottle"));
        ItemRegistry.registerItem(new SimpleItemType(385, "minecraft:fire_charge"));
        ItemRegistry.registerItem(new SimpleItemType(386, "minecraft:writable_book", 1));
        ItemRegistry.registerItem(new SimpleItemType(387, "minecraft:written_book", 16));
        ItemRegistry.registerItem(new SimpleItemType(388, "minecraft:emerald"));
        ItemRegistry.registerItem(new SimpleItemType(389, "minecraft:item_frame"));
        ItemRegistry.registerItem(new SimpleItemType(390, "minecraft:flower_pot"));
        ItemRegistry.registerItem(new SimpleItemType(391, "minecraft:carrot"));
        ItemRegistry.registerItem(new SimpleItemType(392, "minecraft:potato"));
        ItemRegistry.registerItem(new SimpleItemType(393, "minecraft:baked_potato"));
        ItemRegistry.registerItem(new SimpleItemType(394, "minecraft:poisounous_potato"));
        ItemRegistry.registerItem(new SimpleItemType(395, "minecraft:map"));
        ItemRegistry.registerItem(new SimpleItemType(396, "minecraft:golden_carrot"));
        ItemRegistry.registerItem(new SimpleItemType(397, "minecraft:skull"));
        ItemRegistry.registerItem(new SimpleItemType(398, "minecraft:carrot_on_a_stick", 1));
        ItemRegistry.registerItem(new SimpleItemType(399, "minecraft:nether_star"));
        ItemRegistry.registerItem(new SimpleItemType(400, "minecraft:pumpkin_pie"));
        ItemRegistry.registerItem(new SimpleItemType(401, "minecraft:fireworks"));
        ItemRegistry.registerItem(new SimpleItemType(402, "minecraft:firework_charge"));
        ItemRegistry.registerItem(new SimpleItemType(403, "minecraft:enchanted_book", 1));
        ItemRegistry.registerItem(new SimpleItemType(404, "minecraft:comparator"));
        ItemRegistry.registerItem(new SimpleItemType(405, "minecraft:netherbrick"));
        ItemRegistry.registerItem(new SimpleItemType(406, "minecraft:quartz"));
        ItemRegistry.registerItem(new SimpleItemType(407, "minecraft:tnt_minecart", 1));
        ItemRegistry.registerItem(new SimpleItemType(408, "minecraft:hopper_minecart", 1));
        ItemRegistry.registerItem(new SimpleItemType(409, "minecraft:prismarine_shard"));
        ItemRegistry.registerItem(new SimpleItemType(410, "minecraft:prismarine_crystals"));
        ItemRegistry.registerItem(new SimpleItemType(411, "minecraft:rabbit"));
        ItemRegistry.registerItem(new SimpleItemType(412, "minecraft:cooked_rabbit"));
        ItemRegistry.registerItem(new SimpleItemType(413, "minecraft:rabbit_stew"));
        ItemRegistry.registerItem(new SimpleItemType(414, "minecraft:rabbit_foot"));
        ItemRegistry.registerItem(new SimpleItemType(415, "minecraft:rabbit_hide"));
        ItemRegistry.registerItem(new SimpleItemType(416, "minecraft:armor_stand", 16));
        ItemRegistry.registerItem(new SimpleItemType(417, "minecraft:iron_horse_armor", 1));
        ItemRegistry.registerItem(new SimpleItemType(418, "minecraft:golden_horse_armor", 1));
        ItemRegistry.registerItem(new SimpleItemType(419, "minecraft:diamond_horse_armor", 1));
        ItemRegistry.registerItem(new SimpleItemType(420, "minecraft:lead"));
        ItemRegistry.registerItem(new SimpleItemType(421, "minecraft:name_tag"));
        ItemRegistry.registerItem(new SimpleItemType(422, "minecraft:command_block_minecart", 1));
        ItemRegistry.registerItem(new SimpleItemType(423, "minecraft:mutton"));
        ItemRegistry.registerItem(new SimpleItemType(424, "minecraft:cooked_mutton"));
        ItemRegistry.registerItem(new SimpleItemType(425, "minecraft:banner", 16));
        ItemRegistry.registerItem(new SimpleItemType(427, "minecraft:spruce_door"));
        ItemRegistry.registerItem(new SimpleItemType(428, "minecraft:birch_door"));
        ItemRegistry.registerItem(new SimpleItemType(429, "minecraft:jungle_door"));
        ItemRegistry.registerItem(new SimpleItemType(430, "minecraft:acacia_door"));
        ItemRegistry.registerItem(new SimpleItemType(431, "minecraft:dark_oak_door"));
        ItemRegistry.registerItem(new SimpleItemType(444, "minecraft:spruce_boat", 1));
        ItemRegistry.registerItem(new SimpleItemType(445, "minecraft:birch_boat", 1));
        ItemRegistry.registerItem(new SimpleItemType(446, "minecraft:jungle_boat", 1));
        ItemRegistry.registerItem(new SimpleItemType(447, "minecraft:acacia_boat", 1));
        ItemRegistry.registerItem(new SimpleItemType(448, "minecraft:dark_oak_boat", 1));
        ItemRegistry.registerItem(new SimpleItemType(2256, "minecraft:record_13", 1));
        ItemRegistry.registerItem(new SimpleItemType(2257, "minecraft:record_cat", 1));
        ItemRegistry.registerItem(new SimpleItemType(2258, "minecraft:record_blocks", 1));
        ItemRegistry.registerItem(new SimpleItemType(2259, "minecraft:record_chrip", 1));
        ItemRegistry.registerItem(new SimpleItemType(2260, "minecraft:record_far", 1));
        ItemRegistry.registerItem(new SimpleItemType(2261, "minecraft:record_mall", 1));
        ItemRegistry.registerItem(new SimpleItemType(2262, "minecraft:record_mellohi", 1));
        ItemRegistry.registerItem(new SimpleItemType(2263, "minecraft:record_stal", 1));
        ItemRegistry.registerItem(new SimpleItemType(2264, "minecraft:record_strad", 1));
        ItemRegistry.registerItem(new SimpleItemType(2265, "minecraft:record_ward", 1));
        ItemRegistry.registerItem(new SimpleItemType(2266, "minecraft:record_11", 1));
        ItemRegistry.registerItem(new SimpleItemType(2267, "minecraft:record_wait", 1));
    }
}
