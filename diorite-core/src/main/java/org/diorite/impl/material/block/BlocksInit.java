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

import org.diorite.material.block.BlockRegistry;

@SuppressWarnings("MagicNumber")
public final class BlocksInit
{
    private BlocksInit()
    {
    }

    public static void init()
    {
        BlockRegistry.registerBlock(new SimpleBlockType(0, "minecraft:air").setHardnessAndResistance(0F, 0F, false));
        BlockRegistry.registerBlock(new SimpleBlockType(1, "minecraft:stone").setHardnessAndResistance(1.5F, 30F).setVariants("stone", "granite", "polished_granite", "diorite", "polished_diorite", "andesite", "polished_andesite"));
        BlockRegistry.registerBlock(new SimpleBlockType(2, "minecraft:grass").setHardnessAndResistance(0.6F, 3F).setVariants("dirt", "coarse", "podzol"));
        BlockRegistry.registerBlock(new SimpleBlockType(3, "minecraft:dirt").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(4, "minecraft:cobblestone").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(5, "minecraft:planks").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(6, "minecraft:sapling").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(7, "minecraft:bedrock").setHardnessAndResistance(- 1F, 18000000F));
        BlockRegistry.registerBlock(new SimpleBlockType(8, "minecraft:water").setHardnessAndResistance(100F, 500F));
        BlockRegistry.registerBlock(new SimpleBlockType(9, "minecraft:flowing_water").setHardnessAndResistance(100F, 500F));
        BlockRegistry.registerBlock(new SimpleBlockType(10, "minecraft:lava").setHardnessAndResistance(100F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(11, "minecraft:flowing_lava").setHardnessAndResistance(100F, 500F));
        BlockRegistry.registerBlock(new SimpleBlockType(12, "minecraft:sand").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(13, "minecraft:gravel").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(14, "minecraft:gold_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(15, "minecraft:iron_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(16, "minecraft:coal_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(17, "minecraft:log").setHardnessAndResistance(2F, 10F));
        BlockRegistry.registerBlock(new SimpleBlockType(18, "minecraft:leaves").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(19, "minecraft:sponge").setHardnessAndResistance(0.6F, 3F));
        BlockRegistry.registerBlock(new SimpleBlockType(20, "minecraft:glass").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(21, "minecraft:lapis_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(22, "minecraft:lapis_block").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(23, "minecraft:dispenser").setHardnessAndResistance(3.5F, 17.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(24, "minecraft:sandstone").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(25, "minecraft:noteblock").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(26, "minecraft:bed").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(27, "minecraft:golden_rail").setHardnessAndResistance(0.7F, 3.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(28, "minecraft:detector_rail").setHardnessAndResistance(0.7F, 3.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(29, "minecraft:sticky_piston").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(30, "minecraft:web").setHardnessAndResistance(4F, 20F));
        BlockRegistry.registerBlock(new SimpleBlockType(31, "minecraft:tallgrass").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(32, "minecraft:deadbush").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(33, "minecraft:piston").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(34, "minecraft:piston_head").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(35, "minecraft:wool").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(36, "minecraft:piston_extension").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(37, "minecraft:yellow_flower").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(38, "minecraft:red_flower").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(39, "minecraft:brown_mushroom").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(40, "minecraft:red_mushroom").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(41, "minecraft:gold_block").setHardnessAndResistance(3F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(42, "minecraft:iron_block").setHardnessAndResistance(5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(43, "minecraft:double_stone_slab").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(44, "minecraft:stone_slab").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(45, "minecraft:brick_block").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(46, "minecraft:tnt").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(47, "minecraft:bookshelf").setHardnessAndResistance(1.5F, 7.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(48, "minecraft:mossy_cobblestone").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(49, "minecraft:obsidian").setHardnessAndResistance(50F, 6000F));
        BlockRegistry.registerBlock(new SimpleBlockType(50, "minecraft:torch").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(51, "minecraft:fire").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(52, "minecraft:mob_spawner").setHardnessAndResistance(5F, 25F));
        BlockRegistry.registerBlock(new SimpleBlockType(53, "minecraft:oak_stairs").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(54, "minecraft:chest").setHardnessAndResistance(12.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(55, "minecraft:redstone_wire").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(56, "minecraft:diamond_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(57, "minecraft:diamond_block").setHardnessAndResistance(5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(58, "minecraft:crafting_table").setHardnessAndResistance(2.5F, 12.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(59, "minecraft:wheat").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(60, "minecraft:farmland").setHardnessAndResistance(0.6F, 3F));
        BlockRegistry.registerBlock(new SimpleBlockType(61, "minecraft:furnace").setHardnessAndResistance(3.5F, 17.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(62, "minecraft:lit_furnace").setHardnessAndResistance(3.5F, 17.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(63, "minecraft:standing_sign").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(64, "minecraft:wooden_door").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(65, "minecraft:ladder").setHardnessAndResistance(0.4F, 2F));
        BlockRegistry.registerBlock(new SimpleBlockType(66, "minecraft:rail").setHardnessAndResistance(0.7F, 3.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(67, "minecraft:stone_stairs").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(68, "minecraft:wall_sign").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(69, "minecraft:lever").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(70, "minecraft:stone_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(71, "minecraft:iron_door").setHardnessAndResistance(5F, 25F));
        BlockRegistry.registerBlock(new SimpleBlockType(72, "minecraft:wooden_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(73, "minecraft:redstone_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(74, "minecraft:lit_redstone_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(75, "minecraft:unlit_redstone_torch").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(76, "minecraft:redstone_torch").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(77, "minecraft:stone_button").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(78, "minecraft:snow_layer").setHardnessAndResistance(0.1F, 0.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(79, "minecraft:ice").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(80, "minecraft:snow").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(81, "minecraft:cactus").setHardnessAndResistance(0.4F, 2F));
        BlockRegistry.registerBlock(new SimpleBlockType(82, "minecraft:clay").setHardnessAndResistance(0.6F, 3F));
        BlockRegistry.registerBlock(new SimpleBlockType(83, "minecraft:reeds").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(84, "minecraft:jukebox").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(85, "minecraft:fence").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(86, "minecraft:pumpkin").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(87, "minecraft:netherrack").setHardnessAndResistance(0.4F, 2F));
        BlockRegistry.registerBlock(new SimpleBlockType(88, "minecraft:soul_sand").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(89, "minecraft:glowstone").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(90, "minecraft:portal").setHardnessAndResistance(- 1F, 18000000F));
        BlockRegistry.registerBlock(new SimpleBlockType(91, "minecraft:lit_pumpkin").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(92, "minecraft:cake").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(93, "minecraft:unpowered_repeater").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(94, "minecraft:powered_repeater").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(95, "minecraft:stained_glass").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(96, "minecraft:trapdoor").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(97, "minecraft:monster_egg").setHardnessAndResistance(0.75F, 3.75F));
        BlockRegistry.registerBlock(new SimpleBlockType(98, "minecraft:stonebrick").setHardnessAndResistance(1.5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(99, "minecraft:brown_mushroom_block").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(100, "minecraft:red_mushroom_block").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(101, "minecraft:iron_bars").setHardnessAndResistance(5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(102, "minecraft:glass_pane").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(103, "minecraft:melon_block").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(104, "minecraft:pumpkin_stem").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(105, "minecraft:melon_stem").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(106, "minecraft:vine").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(107, "minecraft:fence_gate").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(108, "minecraft:brick_stairs").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(109, "minecraft:stone_brick_stairs").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(110, "minecraft:mycelium").setHardnessAndResistance(0.6F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(111, "minecraft:waterlily").setHardnessAndResistance(0.6F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(112, "minecraft:nether_brick").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(113, "minecraft:nether_brick_fence").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(114, "minecraft:nether_brick_stairs").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(115, "minecraft:nether_wart").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(116, "minecraft:enchanting_table").setHardnessAndResistance(5F, 6000F));
        BlockRegistry.registerBlock(new SimpleBlockType(117, "minecraft:brewing_stand").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(118, "minecraft:cauldron").setHardnessAndResistance(2F, 10F));
        BlockRegistry.registerBlock(new SimpleBlockType(119, "minecraft:end_portal").setHardnessAndResistance(- 1F, 18000000F));
        BlockRegistry.registerBlock(new SimpleBlockType(120, "minecraft:end_portal_frame").setHardnessAndResistance(- 1F, 18000000F));
        BlockRegistry.registerBlock(new SimpleBlockType(121, "minecraft:end_stone").setHardnessAndResistance(3F, 45F));
        BlockRegistry.registerBlock(new SimpleBlockType(122, "minecraft:dragon_egg").setHardnessAndResistance(3F, 45F));
        BlockRegistry.registerBlock(new SimpleBlockType(123, "minecraft:redstone_lamp").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(124, "minecraft:lit_redstone_lamp").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(125, "minecraft:double_wooden_slab").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(126, "minecraft:wooden_slab").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(127, "minecraft:cocoa").setHardnessAndResistance(0.2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(128, "minecraft:sandstone_stairs").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(129, "minecraft:emerald_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(130, "minecraft:ender_chest").setHardnessAndResistance(22.5F, 3000F));
        BlockRegistry.registerBlock(new SimpleBlockType(131, "minecraft:tripwire_hook").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(132, "minecraft:tripwire").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(133, "minecraft:emerald_block").setHardnessAndResistance(5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(134, "minecraft:spruce_stairs").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(135, "minecraft:birch_stairs").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(136, "minecraft:jungle_stairs").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(137, "minecraft:command_block").setHardnessAndResistance(- 1F, 18000000F));
        BlockRegistry.registerBlock(new SimpleBlockType(138, "minecraft:beacon").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(139, "minecraft:cobblestone_wall").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(140, "minecraft:flower_pot").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(141, "minecraft:carrots").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(142, "minecraft:potatoes").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(143, "minecraft:wooden_button").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(144, "minecraft:skull").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(145, "minecraft:anvil").setHardnessAndResistance(5F, 6000F));
        BlockRegistry.registerBlock(new SimpleBlockType(146, "minecraft:trapped_chest").setHardnessAndResistance(2.5F, 12.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(147, "minecraft:light_weighted_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(148, "minecraft:heavy_weighted_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(149, "minecraft:unpowered_comparator").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(151, "minecraft:daylight_detector").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(152, "minecraft:redstone_block").setHardnessAndResistance(5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(153, "minecraft:quartz_ore").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(154, "minecraft:hopper").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(155, "minecraft:quartz_block").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(156, "minecraft:quartz_brick_stairs").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(157, "minecraft:activator_rail").setHardnessAndResistance(0.7F, 3.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(158, "minecraft:dropper").setHardnessAndResistance(3.5F, 17.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(159, "minecraft:stained_hardened_clay").setHardnessAndResistance(1.25F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(160, "minecraft:stained_glass_pane").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(161, "minecraft:leaves2").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(162, "minecraft:log2").setHardnessAndResistance(2F, 10F));
        BlockRegistry.registerBlock(new SimpleBlockType(163, "minecraft:acacia_stairs").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(164, "minecraft:dark_oak_stairs").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(165, "minecraft:slime").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(166, "minecraft:barrier").setHardnessAndResistance(- 1F, 18000004F));
        BlockRegistry.registerBlock(new SimpleBlockType(167, "minecraft:iron_trapdoor").setHardnessAndResistance(5F, 25F));
        BlockRegistry.registerBlock(new SimpleBlockType(168, "minecraft:prismarine").setHardnessAndResistance(1.5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(169, "minecraft:sea_lantern").setHardnessAndResistance(0.3F, 1.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(170, "minecraft:hay_block").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(171, "minecraft:carpet").setHardnessAndResistance(0.1F, 0.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(172, "minecraft:hardened_clay").setHardnessAndResistance(1.25F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(173, "minecraft:coal_block").setHardnessAndResistance(5F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(174, "minecraft:packet_ice").setHardnessAndResistance(0.5F, 2.5F));
        BlockRegistry.registerBlock(new SimpleBlockType(175, "minecraft:double_plant").setHardnessAndResistance(0F, 0F));
        BlockRegistry.registerBlock(new SimpleBlockType(176, "minecraft:standing_banner").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(177, "minecraft:wall_banner").setHardnessAndResistance(1F, 5F));
        BlockRegistry.registerBlock(new SimpleBlockType(178, "minecraft:daylight_detector_inverted").setHardnessAndResistance(0.2F, 1F));
        BlockRegistry.registerBlock(new SimpleBlockType(179, "minecraft:red_sandstone").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(180, "minecraft:red_sandstone_stairs").setHardnessAndResistance(0.8F, 4F));
        BlockRegistry.registerBlock(new SimpleBlockType(181, "minecraft:double_stone_slab2").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(182, "minecraft:stone_slab2").setHardnessAndResistance(2F, 30F));
        BlockRegistry.registerBlock(new SimpleBlockType(183, "minecraft:spruce_fence_gate").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(184, "minecraft:brich_fence_gate").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(185, "minecraft:jungle_fence_gate").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(186, "minecraft:fark_oak_fence_gate").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(187, "minecraft:acacia_fence_gate").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(188, "minecraft:spruce_fence").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(189, "minecraft:birch_fence").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(190, "minecraft:jungle_fence").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(191, "minecraft:dark_oak_fence").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(192, "minecraft:acacia_fence").setHardnessAndResistance(2F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(193, "minecraft:spruce_door").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(194, "minecraft:birch_door").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(195, "minecraft:jungle_door").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(196, "minecraft:acacia_door").setHardnessAndResistance(3F, 15F));
        BlockRegistry.registerBlock(new SimpleBlockType(197, "minecraft:dark_oak_door").setHardnessAndResistance(3F, 15F));
    }
}
