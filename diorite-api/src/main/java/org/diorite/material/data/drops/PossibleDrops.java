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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.diorite.entity.Entity;
import org.diorite.inventory.item.ItemStack;
import org.diorite.utils.math.DioriteRandom;
import org.diorite.world.Block;

/**
 * Represent possible drops by entity/block.
 * // TODO: implement vanilla drop tables using this interface.
 */
public interface PossibleDrops extends Iterable<PossibleDrop>
{
    /**
     * Returns copy of possible drops as normal ArrayList
     *
     * @return copy of possible drops.
     */
    List<PossibleDrop> getPossibleDrops();

    /**
     * Add new drop to possible drops.
     *
     * @param drop drop to add.
     *
     * @return true if drop was added.
     */
    boolean addDrop(PossibleDrop drop);

    /**
     * Remove drop from possible drops.
     *
     * @param drop drop to remove.
     *
     * @return true if drop was removed.
     */
    boolean removeDrop(PossibleDrop drop);

    /**
     * Check if possible drops contains this entry.
     *
     * @param drop drop to find/check.
     *
     * @return true if possible drops contains it.
     */
    boolean containsDrop(PossibleDrop drop);

    /**
     * Clear whole drop list.
     */
    void clear();

    /**
     * Implementation of this method should simulate real drop from block. <br>
     * Method must handle case when block or usedTool or entity is null.
     *
     * @param entity   may be null! Entity related to drop.
     * @param rand     random instance, should be used if random number is needed.
     * @param usedTool may be null! Used tool.
     * @param block    may be null! Block related to this drop simulation if exist.
     *
     * @return simulated drops for this block.
     */
    Set<ItemStack> simulateDrop(Entity entity, DioriteRandom rand, ItemStack usedTool, Block block);

    @Override
    Iterator<PossibleDrop> iterator();
}
