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
import org.diorite.material.block.Blocks;
import org.diorite.material.item.ItemType;
import org.diorite.material.item.Items;

@SuppressWarnings("MagicNumber")
public class ItemsInit
{
    public static ItemType fromBlock(final BlockType type)
    {
        return new BlockItemTypeImpl(type);
    }

    public static void init()
    {
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stone")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:grass")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:dirt")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:cobblestone")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:planks")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:sapling")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:bedrock")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:sand")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:gravel")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:gold_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:iron_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:coal_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:log")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:leaves")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:sponge")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:glass")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:lapis_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:lapis_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:dispenser")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:sandstone")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:noteblock")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:golden_rail")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:detector_rail")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:sticky_piston")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:web")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:tallgrass")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:deadbush")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:piston")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:wool")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:yellow_flower")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:red_flower")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:brown_mushroom")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:red_mushroom")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:gold_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:iron_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stone_slab")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:brick_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:tnt")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:bookshelf")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:mossy_cobblestone")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:obsidian")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:mob_spawner")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:oak_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:chest")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:diamond_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:diamond_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:crafting_table")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:farmland")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:furnace")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:lit_furnace")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:ladder")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:rail")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stone_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:lever")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stone_pressure_plate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:wooden_pressure_plate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:redstone_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stone_button")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:snow_layer")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:ice")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:snow")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:cactus")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:clay")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:jukebox")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:fence")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:pumpkin")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:netherrack")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:soul_sand")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:glowstone")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:portal")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:lit_pumpkin")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stained_glass")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:trapdoor")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:monster_egg")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stonebrick")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:brown_mushroom_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:red_mushroom_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:iron_bars")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:glass_pane")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:melon_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:vine")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:fence_gate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:brick_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stone_brick_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:mycelium")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:waterlily")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:nether_brick")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:nether_brick_fence")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:nether_brick_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:enchanting_table")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:end_portal_frame")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:end_stone")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:dragon_egg")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:redstone_lamp")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:wooden_slab")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:cocoa")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:sandstone_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:emerald_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:ender_chest")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:tripwire_hook")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:emerald_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:spruce_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:birch_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:jungle_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:command_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:beacon")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:cobblestone_wall")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:wooden_button")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:anvil")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:trapped_chest")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:light_weighted_pressure_plate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:heavy_weighted_pressure_plate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:daylight_detector")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:redstone_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:quartz_ore")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:hopper")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:quartz_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:quartz_brick_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:activator_rail")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:dropper")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stained_hardened_clay")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stained_glass_pane")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:leaves2")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:log2")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:acacia_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:dark_oak_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:slime")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:barrier")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:iron_trapdoor")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:prismarine")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:sea_lantern")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:hay_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:carpet")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:hardened_clay")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:coal_block")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:packet_ice")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:double_plant")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:red_sandstone")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:red_sandstone_stairs")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:stone_slab2")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:spruce_fence_gate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:brich_fence_gate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:jungle_fence_gate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:fark_oak_fence_gate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:acacia_fence_gate")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:spruce_fence")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:birch_fence")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:jungle_fence")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:dark_oak_fence")));
        Items.registerItem(fromBlock(Blocks.getBlockType("minecraft:acacia_fence")));
        Items.registerItem(new SimpleItemType(256, "minecraft:iron_Shovel", 1));
        Items.registerItem(new SimpleItemType(257, "minecraft:iron_Pickaxe", 1));
        Items.registerItem(new SimpleItemType(258, "minecraft:iron_Axe", 1));
        Items.registerItem(new SimpleItemType(259, "minecraft:flint_and_steel", 1));
        Items.registerItem(new SimpleItemType(260, "minecraft:apple"));
        Items.registerItem(new SimpleItemType(261, "minecraft:bow", 1));
        Items.registerItem(new SimpleItemType(262, "minecraft:arrow"));
        Items.registerItem(new SimpleItemType(263, "minecraft:coal"));
        Items.registerItem(new SimpleItemType(264, "minecraft:diamond"));
        Items.registerItem(new SimpleItemType(265, "minecraft:iron_ingot"));
        Items.registerItem(new SimpleItemType(266, "minecraft:gold_ingot"));
        Items.registerItem(new SimpleItemType(267, "minecraft:iron_Sword", 1));
        Items.registerItem(new SimpleItemType(268, "minecraft:wooden_Sword", 1));
        Items.registerItem(new SimpleItemType(269, "minecraft:wooden_Shovel", 1));
        Items.registerItem(new SimpleItemType(270, "minecraft:wooden_Pickaxe", 1));
        Items.registerItem(new SimpleItemType(271, "minecraft:wooden_axe", 1));
        Items.registerItem(new SimpleItemType(272, "minecraft:stone_Sword", 1));
        Items.registerItem(new SimpleItemType(273, "minecraft:stone_Shovel", 1));
        Items.registerItem(new SimpleItemType(274, "minecraft:stone_Pickaxe", 1));
        Items.registerItem(new SimpleItemType(275, "minecraft:stone_Axe", 1));
        Items.registerItem(new SimpleItemType(276, "minecraft:diamond_Sword", 1));
        Items.registerItem(new SimpleItemType(277, "minecraft:diamond_Shovel", 1));
        Items.registerItem(new SimpleItemType(278, "minecraft:diamond_Pickaxe", 1));
        Items.registerItem(new SimpleItemType(279, "minecraft:diamond_Axe", 1));
        Items.registerItem(new SimpleItemType(280, "minecraft:stick"));
        Items.registerItem(new SimpleItemType(281, "minecraft:bowl"));
        Items.registerItem(new SimpleItemType(282, "minecraft:mushroom_stew", 1));
        Items.registerItem(new SimpleItemType(283, "minecraft:golden_Sword", 1));
        Items.registerItem(new SimpleItemType(284, "minecraft:golden_Shovel", 1));
        Items.registerItem(new SimpleItemType(285, "minecraft:golden_Pickaxe", 1));
        Items.registerItem(new SimpleItemType(286, "minecraft:golden_Axe", 1));
        Items.registerItem(new SimpleItemType(287, "minecraft:string"));
        Items.registerItem(new SimpleItemType(288, "minecraft:feather"));
        Items.registerItem(new SimpleItemType(289, "minecraft:gunpowder"));
        Items.registerItem(new SimpleItemType(290, "minecraft:wooden_Hoe", 1));
        Items.registerItem(new SimpleItemType(291, "minecraft:stone_Hoe", 1));
        Items.registerItem(new SimpleItemType(292, "minecraft:iron_Hoe", 1));
        Items.registerItem(new SimpleItemType(293, "minecraft:diamond_Hoe", 1));
        Items.registerItem(new SimpleItemType(294, "minecraft:golden_Hoe", 1));
        Items.registerItem(new SimpleItemType(295, "minecraft:wheat_seeds"));
        Items.registerItem(new SimpleItemType(296, "minecraft:wheat"));
        Items.registerItem(new SimpleItemType(297, "minecraft:bread"));
        Items.registerItem(new SimpleItemType(298, "minecraft:leather_helmet", 1));
        Items.registerItem(new SimpleItemType(299, "minecraft:leather_chestplate", 1));
        Items.registerItem(new SimpleItemType(300, "minecraft:leather_leggings", 1));
        Items.registerItem(new SimpleItemType(301, "minecraft:leather_boots", 1));
        Items.registerItem(new SimpleItemType(302, "minecraft:chainmail_helmet", 1));
        Items.registerItem(new SimpleItemType(303, "minecraft:chainmail_chestplate", 1));
        Items.registerItem(new SimpleItemType(304, "minecraft:chainmail_leggings", 1));
        Items.registerItem(new SimpleItemType(305, "minecraft:chainmail_boots", 1));
        Items.registerItem(new SimpleItemType(306, "minecraft:iron_helmet", 1));
        Items.registerItem(new SimpleItemType(307, "minecraft:iron_chestplate", 1));
        Items.registerItem(new SimpleItemType(308, "minecraft:iron_leggings", 1));
        Items.registerItem(new SimpleItemType(309, "minecraft:iron_boots", 1));
        Items.registerItem(new SimpleItemType(310, "minecraft:diamond_helmet", 1));
        Items.registerItem(new SimpleItemType(311, "minecraft:diamond_chestplate", 1));
        Items.registerItem(new SimpleItemType(312, "minecraft:diamond_leggings", 1));
        Items.registerItem(new SimpleItemType(313, "minecraft:diamond_boots", 1));
        Items.registerItem(new SimpleItemType(314, "minecraft:gold_helmet", 1));
        Items.registerItem(new SimpleItemType(315, "minecraft:gold_chestplate", 1));
        Items.registerItem(new SimpleItemType(316, "minecraft:gold_leggings", 1));
        Items.registerItem(new SimpleItemType(317, "minecraft:gold_boots", 1));
        Items.registerItem(new SimpleItemType(318, "minecraft:flint"));
        Items.registerItem(new SimpleItemType(319, "minecraft:porkchop"));
        Items.registerItem(new SimpleItemType(320, "minecraft:cooked_porkchop"));
        Items.registerItem(new SimpleItemType(321, "minecraft:painting"));
        Items.registerItem(new SimpleItemType(322, "minecraft:golden_apple"));
        Items.registerItem(new SimpleItemType(323, "minecraft:sign", 16));
        Items.registerItem(new SimpleItemType(324, "minecraft:wooden_door"));
        Items.registerItem(new SimpleItemType(325, "minecraft:bucket", 16));
        Items.registerItem(new SimpleItemType(326, "minecraft:water_bucket", 1));
        Items.registerItem(new SimpleItemType(327, "minecraft:lava_bucket", 1));
        Items.registerItem(new SimpleItemType(328, "minecraft:minecraft", 1));
        Items.registerItem(new SimpleItemType(329, "minecraft:saddle", 1));
        Items.registerItem(new SimpleItemType(330, "minecraft:iron_door"));
        Items.registerItem(new SimpleItemType(331, "minecraft:redstone"));
        Items.registerItem(new SimpleItemType(332, "minecraft:snowball"));
        Items.registerItem(new SimpleItemType(333, "minecraft:boat", 1));
        Items.registerItem(new SimpleItemType(334, "minecraft:leather"));
        Items.registerItem(new SimpleItemType(335, "minecraft:milk_bucket", 1));
        Items.registerItem(new SimpleItemType(336, "minecraft:brick"));
        Items.registerItem(new SimpleItemType(337, "minecraft:clay_ball"));
        Items.registerItem(new SimpleItemType(338, "minecraft:reeds"));
        Items.registerItem(new SimpleItemType(339, "minecraft:paper"));
        Items.registerItem(new SimpleItemType(340, "minecraft:book"));
        Items.registerItem(new SimpleItemType(341, "minecraft:slime_ball"));
        Items.registerItem(new SimpleItemType(342, "minecraft:chest_minecart", 1));
        Items.registerItem(new SimpleItemType(343, "minecraft:furnace_minecart", 1));
        Items.registerItem(new SimpleItemType(344, "minecraft:egg", 16));
        Items.registerItem(new SimpleItemType(345, "minecraft:compass"));
        Items.registerItem(new SimpleItemType(346, "minecraft:fishing_rod", 1));
        Items.registerItem(new SimpleItemType(347, "minecraft:clock"));
        Items.registerItem(new SimpleItemType(348, "minecraft:glowstone_dust"));
        Items.registerItem(new SimpleItemType(349, "minecraft:fish"));
        Items.registerItem(new SimpleItemType(350, "minecraft:cooked_fish"));
        Items.registerItem(new SimpleItemType(351, "minecraft:dye"));
        Items.registerItem(new SimpleItemType(352, "minecraft:bone"));
        Items.registerItem(new SimpleItemType(353, "minecraft:sugar"));
        Items.registerItem(new SimpleItemType(354, "minecraft:cake", 1));
        Items.registerItem(new SimpleItemType(355, "minecraft:bed", 1));
        Items.registerItem(new SimpleItemType(356, "minecraft:repeater"));
        Items.registerItem(new SimpleItemType(357, "minecraft:cookie"));
        Items.registerItem(new SimpleItemType(358, "minecraft:filled_map"));
        Items.registerItem(new SimpleItemType(359, "minecraft:shears", 1));
        Items.registerItem(new SimpleItemType(360, "minecraft:melon"));
        Items.registerItem(new SimpleItemType(361, "minecraft:pumpkin_seeds"));
        Items.registerItem(new SimpleItemType(362, "minecraft:melon_seeds"));
        Items.registerItem(new SimpleItemType(363, "minecraft:beef"));
        Items.registerItem(new SimpleItemType(364, "minecraft:cooked_beef"));
        Items.registerItem(new SimpleItemType(365, "minecraft:chicked"));
        Items.registerItem(new SimpleItemType(366, "minecraft:cooked_chicken"));
        Items.registerItem(new SimpleItemType(367, "minecraft:rotten_flesh"));
        Items.registerItem(new SimpleItemType(368, "minecraft:ender_pearl", 16));
        Items.registerItem(new SimpleItemType(369, "minecraft:blaze_rod"));
        Items.registerItem(new SimpleItemType(370, "minecraft:ghast_tear"));
        Items.registerItem(new SimpleItemType(371, "minecraft:gold_nugget"));
        Items.registerItem(new SimpleItemType(372, "minecraft:nether_wart"));
        Items.registerItem(new SimpleItemType(373, "minecraft:potion", 1));
        Items.registerItem(new SimpleItemType(374, "minecraft:glass_bottle"));
        Items.registerItem(new SimpleItemType(375, "minecraft:spider_eye"));
        Items.registerItem(new SimpleItemType(376, "minecraft:fermented_spider_eye"));
        Items.registerItem(new SimpleItemType(377, "minecraft:blaze_powder"));
        Items.registerItem(new SimpleItemType(378, "minecraft:magma_cream"));
        Items.registerItem(new SimpleItemType(379, "minecraft:brewing_stand"));
        Items.registerItem(new SimpleItemType(380, "minecraft:cauldron"));
        Items.registerItem(new SimpleItemType(381, "minecraft:ender_eye"));
        Items.registerItem(new SimpleItemType(382, "minecraft:speckled_melon"));
        Items.registerItem(new SimpleItemType(383, "minecraft:spawn_egg"));
        Items.registerItem(new SimpleItemType(384, "minecraft:experience_bottle"));
        Items.registerItem(new SimpleItemType(385, "minecraft:fire_charge"));
        Items.registerItem(new SimpleItemType(386, "minecraft:writable_book", 1));
        Items.registerItem(new SimpleItemType(387, "minecraft:written_book", 16));
        Items.registerItem(new SimpleItemType(388, "minecraft:emerald"));
        Items.registerItem(new SimpleItemType(389, "minecraft:item_frame"));
        Items.registerItem(new SimpleItemType(390, "minecraft:flower_pot"));
        Items.registerItem(new SimpleItemType(391, "minecraft:carrot"));
        Items.registerItem(new SimpleItemType(392, "minecraft:potato"));
        Items.registerItem(new SimpleItemType(393, "minecraft:baked_potato"));
        Items.registerItem(new SimpleItemType(394, "minecraft:poisounous_potato"));
        Items.registerItem(new SimpleItemType(395, "minecraft:map"));
        Items.registerItem(new SimpleItemType(396, "minecraft:golden_carrot"));
        Items.registerItem(new SimpleItemType(397, "minecraft:skull"));
        Items.registerItem(new SimpleItemType(398, "minecraft:carrot_on_a_stick", 1));
        Items.registerItem(new SimpleItemType(399, "minecraft:nether_star"));
        Items.registerItem(new SimpleItemType(400, "minecraft:pumpkin_pie"));
        Items.registerItem(new SimpleItemType(401, "minecraft:fireworks"));
        Items.registerItem(new SimpleItemType(402, "minecraft:firework_charge"));
        Items.registerItem(new SimpleItemType(403, "minecraft:enchanted_book", 1));
        Items.registerItem(new SimpleItemType(404, "minecraft:comparator"));
        Items.registerItem(new SimpleItemType(405, "minecraft:netherbrick"));
        Items.registerItem(new SimpleItemType(406, "minecraft:quartz"));
        Items.registerItem(new SimpleItemType(407, "minecraft:tnt_minecart", 1));
        Items.registerItem(new SimpleItemType(408, "minecraft:hopper_minecart", 1));
        Items.registerItem(new SimpleItemType(409, "minecraft:prismarine_shard"));
        Items.registerItem(new SimpleItemType(410, "minecraft:prismarine_crystals"));
        Items.registerItem(new SimpleItemType(411, "minecraft:rabbit"));
        Items.registerItem(new SimpleItemType(412, "minecraft:cooked_rabbit"));
        Items.registerItem(new SimpleItemType(413, "minecraft:rabbit_stew"));
        Items.registerItem(new SimpleItemType(414, "minecraft:rabbit_foot"));
        Items.registerItem(new SimpleItemType(415, "minecraft:rabbit_hide"));
        Items.registerItem(new SimpleItemType(416, "minecraft:armor_stand", 16));
        Items.registerItem(new SimpleItemType(417, "minecraft:iron_horse_armor", 1));
        Items.registerItem(new SimpleItemType(418, "minecraft:golden_horse_armor", 1));
        Items.registerItem(new SimpleItemType(419, "minecraft:diamond_horse_armor", 1));
        Items.registerItem(new SimpleItemType(420, "minecraft:lead"));
        Items.registerItem(new SimpleItemType(421, "minecraft:name_tag"));
        Items.registerItem(new SimpleItemType(422, "minecraft:command_block_minecart", 1));
        Items.registerItem(new SimpleItemType(423, "minecraft:mutton"));
        Items.registerItem(new SimpleItemType(424, "minecraft:cooked_mutton"));
        Items.registerItem(new SimpleItemType(425, "minecraft:banner", 16));
        Items.registerItem(new SimpleItemType(427, "minecraft:spruce_door"));
        Items.registerItem(new SimpleItemType(428, "minecraft:birch_door"));
        Items.registerItem(new SimpleItemType(429, "minecraft:jungle_door"));
        Items.registerItem(new SimpleItemType(430, "minecraft:acacia_door"));
        Items.registerItem(new SimpleItemType(431, "minecraft:dark_oak_door"));
        Items.registerItem(new SimpleItemType(444, "minecraft:spruce_boat", 1));
        Items.registerItem(new SimpleItemType(445, "minecraft:birch_boat", 1));
        Items.registerItem(new SimpleItemType(446, "minecraft:jungle_boat", 1));
        Items.registerItem(new SimpleItemType(447, "minecraft:acacia_boat", 1));
        Items.registerItem(new SimpleItemType(448, "minecraft:dark_oak_boat", 1));
        Items.registerItem(new SimpleItemType(2256, "minecraft:record_13", 1));
        Items.registerItem(new SimpleItemType(2257, "minecraft:record_cat", 1));
        Items.registerItem(new SimpleItemType(2258, "minecraft:record_blocks", 1));
        Items.registerItem(new SimpleItemType(2259, "minecraft:record_chrip", 1));
        Items.registerItem(new SimpleItemType(2260, "minecraft:record_far", 1));
        Items.registerItem(new SimpleItemType(2261, "minecraft:record_mall", 1));
        Items.registerItem(new SimpleItemType(2262, "minecraft:record_mellohi", 1));
        Items.registerItem(new SimpleItemType(2263, "minecraft:record_stal", 1));
        Items.registerItem(new SimpleItemType(2264, "minecraft:record_strad", 1));
        Items.registerItem(new SimpleItemType(2265, "minecraft:record_ward", 1));
        Items.registerItem(new SimpleItemType(2266, "minecraft:record_11", 1));
        Items.registerItem(new SimpleItemType(2267, "minecraft:record_wait", 1));
    }
}
