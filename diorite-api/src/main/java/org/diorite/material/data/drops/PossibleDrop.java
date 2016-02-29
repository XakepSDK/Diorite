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

package org.diorite.material.data.drops;

import java.util.Set;

import org.diorite.entity.Entity;
import org.diorite.inventory.item.ItemStack;
import org.diorite.utils.math.DioriteRandom;
import org.diorite.utils.math.IntRange;
import org.diorite.world.Block;

public interface PossibleDrop
{
    /**
     * Implementation of this method should simulate real drop from block. <br>
     * Method must handle case when block or usedTool is null.
     *
     * @param entity   may be null! Entity related to drop.
     * @param rand     random instance, should be used if random number is needed.
     * @param drops    drops list, now drops should be add here.
     * @param usedTool may be null! Used tool.
     * @param block    may be null! Block related to this drop simulation if exist.
     */
    void simulateDrop(Entity entity, DioriteRandom rand, Set<ItemStack> drops, ItemStack usedTool, Block block);

    /**
     * Implementation of this method should simulate real experience drop from block. <br>
     * Method must handle case when block or usedTool is null.
     *
     * @param entity   may be null! Entity related to drop.
     * @param rand     random instance, should be used if random number is needed.
     * @param usedTool may be null! Used tool.
     * @param block    may be null! Block related to this drop simulation if exist.
     *
     * @return simulated exp drop.
     */
    int simulateExperienceDrop(Entity entity, DioriteRandom rand, ItemStack usedTool, Block block);

    /**
     * Implementation of this method should return possible experience drop range from block. <br>
     * Method must handle case when block or usedTool is null.
     *
     * @param entity   may be null! Entity related to drop.
     * @param rand     random instance, should be used if random number is needed.
     * @param usedTool may be null! Used tool.
     * @param block    may be null! Block related to this drop simulation if exist.
     *
     * @return possible range of exp drop.
     */
    IntRange getExperienceDrop(Entity entity, DioriteRandom rand, ItemStack usedTool, Block block);
}
