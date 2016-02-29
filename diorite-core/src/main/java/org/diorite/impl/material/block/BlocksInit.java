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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.stream.Stream;

import org.diorite.material.block.Blocks;
import org.diorite.material_old.BlockMaterialData;
import org.diorite.material_old.Material;

@SuppressWarnings("MagicNumber")
public final class BlocksInit
{
    private BlocksInit()
    {
    }

    public static void main(String[] args)
    { DecimalFormat df = new DecimalFormat("############.##");
        final DecimalFormatSymbols symbols = df.getDecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(symbols);
        //  Blocks.registerBlock(new BlockTypeImpl(0, "minecraft:air"))
        Stream.of(Material.values()).filter(m -> m instanceof BlockMaterialData).sorted((a, b) -> Integer.compare(a.getId(), b.getId())).map(m -> (BlockMaterialData) m).forEach(material -> {

            System.out.println("Blocks.registerBlock(new BlockTypeImpl(" + material.getId() + ", \"" + material.getMinecraftId() + "\").setHardnessAndResistance(" + df.format(material.getHardness()) + "F, " + df.format(material.getBlastResistance()) + "F));");
        });
    }

    public static void init()
    {
        Blocks.registerBlock(new BlockTypeImpl(0, "minecraft:air").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(1, "minecraft:stone").setHardnessAndResistance(1.5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(2, "minecraft:grass").setHardnessAndResistance(0.6F, 3F));
        Blocks.registerBlock(new BlockTypeImpl(3, "minecraft:dirt").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(4, "minecraft:cobblestone").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(5, "minecraft:planks").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(6, "minecraft:sapling").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(7, "minecraft:bedrock").setHardnessAndResistance(-1F, 18000000F));
        Blocks.registerBlock(new BlockTypeImpl(8, "minecraft:water").setHardnessAndResistance(100F, 500F));
        Blocks.registerBlock(new BlockTypeImpl(9, "minecraft:flowing_water").setHardnessAndResistance(100F, 500F));
        Blocks.registerBlock(new BlockTypeImpl(10, "minecraft:lava").setHardnessAndResistance(100F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(11, "minecraft:flowing_lava").setHardnessAndResistance(100F, 500F));
        Blocks.registerBlock(new BlockTypeImpl(12, "minecraft:sand").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(13, "minecraft:gravel").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(14, "minecraft:gold_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(15, "minecraft:iron_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(16, "minecraft:coal_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(17, "minecraft:log").setHardnessAndResistance(2F, 10F));
        Blocks.registerBlock(new BlockTypeImpl(18, "minecraft:leaves").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(19, "minecraft:sponge").setHardnessAndResistance(0.6F, 3F));
        Blocks.registerBlock(new BlockTypeImpl(20, "minecraft:glass").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(21, "minecraft:lapis_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(22, "minecraft:lapis_block").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(23, "minecraft:dispenser").setHardnessAndResistance(3.5F, 17.5F));
        Blocks.registerBlock(new BlockTypeImpl(24, "minecraft:sandstone").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(25, "minecraft:noteblock").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(26, "minecraft:bed").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(27, "minecraft:golden_rail").setHardnessAndResistance(0.7F, 3.5F));
        Blocks.registerBlock(new BlockTypeImpl(28, "minecraft:detector_rail").setHardnessAndResistance(0.7F, 3.5F));
        Blocks.registerBlock(new BlockTypeImpl(29, "minecraft:sticky_piston").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(30, "minecraft:web").setHardnessAndResistance(4F, 20F));
        Blocks.registerBlock(new BlockTypeImpl(31, "minecraft:tallgrass").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(32, "minecraft:deadbush").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(33, "minecraft:piston").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(34, "minecraft:piston_head").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(35, "minecraft:wool").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(36, "minecraft:piston_extension").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(37, "minecraft:yellow_flower").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(38, "minecraft:red_flower").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(39, "minecraft:brown_mushroom").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(40, "minecraft:red_mushroom").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(41, "minecraft:gold_block").setHardnessAndResistance(3F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(42, "minecraft:iron_block").setHardnessAndResistance(5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(43, "minecraft:double_stone_slab").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(44, "minecraft:stone_slab").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(45, "minecraft:brick_block").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(46, "minecraft:tnt").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(47, "minecraft:bookshelf").setHardnessAndResistance(1.5F, 7.5F));
        Blocks.registerBlock(new BlockTypeImpl(48, "minecraft:mossy_cobblestone").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(49, "minecraft:obsidian").setHardnessAndResistance(50F, 6000F));
        Blocks.registerBlock(new BlockTypeImpl(50, "minecraft:torch").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(51, "minecraft:fire").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(52, "minecraft:mob_spawner").setHardnessAndResistance(5F, 25F));
        Blocks.registerBlock(new BlockTypeImpl(53, "minecraft:oak_stairs").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(54, "minecraft:chest").setHardnessAndResistance(12.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(55, "minecraft:redstone_wire").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(56, "minecraft:diamond_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(57, "minecraft:diamond_block").setHardnessAndResistance(5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(58, "minecraft:crafting_table").setHardnessAndResistance(2.5F, 12.5F));
        Blocks.registerBlock(new BlockTypeImpl(59, "minecraft:wheat").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(60, "minecraft:farmland").setHardnessAndResistance(0.6F, 3F));
        Blocks.registerBlock(new BlockTypeImpl(61, "minecraft:furnace").setHardnessAndResistance(3.5F, 17.5F));
        Blocks.registerBlock(new BlockTypeImpl(62, "minecraft:lit_furnace").setHardnessAndResistance(3.5F, 17.5F));
        Blocks.registerBlock(new BlockTypeImpl(63, "minecraft:standing_sign").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(64, "minecraft:wooden_door").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(65, "minecraft:ladder").setHardnessAndResistance(0.4F, 2F));
        Blocks.registerBlock(new BlockTypeImpl(66, "minecraft:rail").setHardnessAndResistance(0.7F, 3.5F));
        Blocks.registerBlock(new BlockTypeImpl(67, "minecraft:stone_stairs").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(68, "minecraft:wall_sign").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(69, "minecraft:lever").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(70, "minecraft:stone_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(71, "minecraft:iron_door").setHardnessAndResistance(5F, 25F));
        Blocks.registerBlock(new BlockTypeImpl(72, "minecraft:wooden_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(73, "minecraft:redstone_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(74, "minecraft:lit_redstone_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(75, "minecraft:unlit_redstone_torch").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(76, "minecraft:redstone_torch").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(77, "minecraft:stone_button").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(78, "minecraft:snow_layer").setHardnessAndResistance(0.1F, 0.5F));
        Blocks.registerBlock(new BlockTypeImpl(79, "minecraft:ice").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(80, "minecraft:snow").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(81, "minecraft:cactus").setHardnessAndResistance(0.4F, 2F));
        Blocks.registerBlock(new BlockTypeImpl(82, "minecraft:clay").setHardnessAndResistance(0.6F, 3F));
        Blocks.registerBlock(new BlockTypeImpl(83, "minecraft:reeds").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(84, "minecraft:jukebox").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(85, "minecraft:fence").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(86, "minecraft:pumpkin").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(87, "minecraft:netherrack").setHardnessAndResistance(0.4F, 2F));
        Blocks.registerBlock(new BlockTypeImpl(88, "minecraft:soul_sand").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(89, "minecraft:glowstone").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(90, "minecraft:portal").setHardnessAndResistance(-1F, 18000000F));
        Blocks.registerBlock(new BlockTypeImpl(91, "minecraft:lit_pumpkin").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(92, "minecraft:cake").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(93, "minecraft:unpowered_repeater").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(94, "minecraft:powered_repeater").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(95, "minecraft:stained_glass").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(96, "minecraft:trapdoor").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(97, "minecraft:monster_egg").setHardnessAndResistance(0.75F, 3.75F));
        Blocks.registerBlock(new BlockTypeImpl(98, "minecraft:stonebrick").setHardnessAndResistance(1.5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(99, "minecraft:brown_mushroom_block").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(100, "minecraft:red_mushroom_block").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(101, "minecraft:iron_bars").setHardnessAndResistance(5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(102, "minecraft:glass_pane").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(103, "minecraft:melon_block").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(104, "minecraft:pumpkin_stem").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(105, "minecraft:melon_stem").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(106, "minecraft:vine").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(107, "minecraft:fence_gate").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(108, "minecraft:brick_stairs").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(109, "minecraft:stone_brick_stairs").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(110, "minecraft:mycelium").setHardnessAndResistance(0.6F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(111, "minecraft:waterlily").setHardnessAndResistance(0.6F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(112, "minecraft:nether_brick").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(113, "minecraft:nether_brick_fence").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(114, "minecraft:nether_brick_stairs").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(115, "minecraft:nether_wart").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(116, "minecraft:enchanting_table").setHardnessAndResistance(5F, 6000F));
        Blocks.registerBlock(new BlockTypeImpl(117, "minecraft:brewing_stand").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(118, "minecraft:cauldron").setHardnessAndResistance(2F, 10F));
        Blocks.registerBlock(new BlockTypeImpl(119, "minecraft:end_portal").setHardnessAndResistance(-1F, 18000000F));
        Blocks.registerBlock(new BlockTypeImpl(120, "minecraft:end_portal_frame").setHardnessAndResistance(-1F, 18000000F));
        Blocks.registerBlock(new BlockTypeImpl(121, "minecraft:end_stone").setHardnessAndResistance(3F, 45F));
        Blocks.registerBlock(new BlockTypeImpl(122, "minecraft:dragon_egg").setHardnessAndResistance(3F, 45F));
        Blocks.registerBlock(new BlockTypeImpl(123, "minecraft:redstone_lamp").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(124, "minecraft:lit_redstone_lamp").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(125, "minecraft:double_wooden_slab").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(126, "minecraft:wooden_slab").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(127, "minecraft:cocoa").setHardnessAndResistance(0.2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(128, "minecraft:sandstone_stairs").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(129, "minecraft:emerald_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(130, "minecraft:ender_chest").setHardnessAndResistance(22.5F, 3000F));
        Blocks.registerBlock(new BlockTypeImpl(131, "minecraft:tripwire_hook").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(132, "minecraft:tripwire").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(133, "minecraft:emerald_block").setHardnessAndResistance(5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(134, "minecraft:spruce_stairs").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(135, "minecraft:birch_stairs").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(136, "minecraft:jungle_stairs").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(137, "minecraft:command_block").setHardnessAndResistance(-1F, 18000000F));
        Blocks.registerBlock(new BlockTypeImpl(138, "minecraft:beacon").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(139, "minecraft:cobblestone_wall").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(140, "minecraft:flower_pot").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(141, "minecraft:carrots").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(142, "minecraft:potatoes").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(143, "minecraft:wooden_button").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(144, "minecraft:skull").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(145, "minecraft:anvil").setHardnessAndResistance(5F, 6000F));
        Blocks.registerBlock(new BlockTypeImpl(146, "minecraft:trapped_chest").setHardnessAndResistance(2.5F, 12.5F));
        Blocks.registerBlock(new BlockTypeImpl(147, "minecraft:light_weighted_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(148, "minecraft:heavy_weighted_pressure_plate").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(149, "minecraft:unpowered_comparator").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(151, "minecraft:daylight_detector").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(152, "minecraft:redstone_block").setHardnessAndResistance(5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(153, "minecraft:quartz_ore").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(154, "minecraft:hopper").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(155, "minecraft:quartz_block").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(156, "minecraft:quartz_brick_stairs").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(157, "minecraft:activator_rail").setHardnessAndResistance(0.7F, 3.5F));
        Blocks.registerBlock(new BlockTypeImpl(158, "minecraft:dropper").setHardnessAndResistance(3.5F, 17.5F));
        Blocks.registerBlock(new BlockTypeImpl(159, "minecraft:stained_hardened_clay").setHardnessAndResistance(1.25F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(160, "minecraft:stained_glass_pane").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(161, "minecraft:leaves2").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(162, "minecraft:log2").setHardnessAndResistance(2F, 10F));
        Blocks.registerBlock(new BlockTypeImpl(163, "minecraft:acacia_stairs").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(164, "minecraft:dark_oak_stairs").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(165, "minecraft:slime").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(166, "minecraft:barrier").setHardnessAndResistance(-1F, 18000004F));
        Blocks.registerBlock(new BlockTypeImpl(167, "minecraft:iron_trapdoor").setHardnessAndResistance(5F, 25F));
        Blocks.registerBlock(new BlockTypeImpl(168, "minecraft:prismarine").setHardnessAndResistance(1.5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(169, "minecraft:sea_lantern").setHardnessAndResistance(0.3F, 1.5F));
        Blocks.registerBlock(new BlockTypeImpl(170, "minecraft:hay_block").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(171, "minecraft:carpet").setHardnessAndResistance(0.1F, 0.5F));
        Blocks.registerBlock(new BlockTypeImpl(172, "minecraft:hardened_clay").setHardnessAndResistance(1.25F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(173, "minecraft:coal_block").setHardnessAndResistance(5F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(174, "minecraft:packet_ice").setHardnessAndResistance(0.5F, 2.5F));
        Blocks.registerBlock(new BlockTypeImpl(175, "minecraft:double_plant").setHardnessAndResistance(0F, 0F));
        Blocks.registerBlock(new BlockTypeImpl(176, "minecraft:standing_banner").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(177, "minecraft:wall_banner").setHardnessAndResistance(1F, 5F));
        Blocks.registerBlock(new BlockTypeImpl(178, "minecraft:daylight_detector_inverted").setHardnessAndResistance(0.2F, 1F));
        Blocks.registerBlock(new BlockTypeImpl(179, "minecraft:red_sandstone").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(180, "minecraft:red_sandstone_stairs").setHardnessAndResistance(0.8F, 4F));
        Blocks.registerBlock(new BlockTypeImpl(181, "minecraft:double_stone_slab2").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(182, "minecraft:stone_slab2").setHardnessAndResistance(2F, 30F));
        Blocks.registerBlock(new BlockTypeImpl(183, "minecraft:spruce_fence_gate").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(184, "minecraft:brich_fence_gate").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(185, "minecraft:jungle_fence_gate").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(186, "minecraft:fark_oak_fence_gate").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(187, "minecraft:acacia_fence_gate").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(188, "minecraft:spruce_fence").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(189, "minecraft:birch_fence").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(190, "minecraft:jungle_fence").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(191, "minecraft:dark_oak_fence").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(192, "minecraft:acacia_fence").setHardnessAndResistance(2F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(193, "minecraft:spruce_door").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(194, "minecraft:birch_door").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(195, "minecraft:jungle_door").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(196, "minecraft:acacia_door").setHardnessAndResistance(3F, 15F));
        Blocks.registerBlock(new BlockTypeImpl(197, "minecraft:dark_oak_door").setHardnessAndResistance(3F, 15F));
    }
}
