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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.entity.Entity;
import org.diorite.inventory.item.ItemStack;
import org.diorite.utils.math.DioriteRandom;
import org.diorite.utils.math.IntRange;
import org.diorite.world.Block;

// TODO: add more sublcasses for easier creating drops configs.

/**
 * Basic abstract implementation of {@link PossibleDrop}
 */
public abstract class AbstractPossibleDrop implements PossibleDrop
{
    protected final ItemStack itemStack;

    public AbstractPossibleDrop(final ItemStack itemStack)
    {
        this.itemStack = itemStack;
    }

    public AbstractPossibleDrop()
    {
        this.itemStack = null;
    }

    /**
     * Returns raw ItemStack of this possible drop. <br>
     * This item may be modified by different subclasses before real drop.
     *
     * @return raw ItemStack of this possible drop or null.
     *
     * @see #simulateDrop(Entity, DioriteRandom, Set, ItemStack, Block)
     */
    public ItemStack getItemStack()
    {
        return (this.itemStack == null) ? null : this.itemStack.clone();
    }

    @Override
    public int simulateExperienceDrop(final Entity entity, final DioriteRandom rand, final ItemStack usedTool, final Block block)
    {
        return 0;
    }

    @Override
    public IntRange getExperienceDrop(final Entity entity, final DioriteRandom rand, final ItemStack usedTool, final Block block)
    {
        return IntRange.EMPTY;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof AbstractPossibleDrop))
        {
            return false;
        }
        final AbstractPossibleDrop that = (AbstractPossibleDrop) o;

        return (this.itemStack != null) ? this.itemStack.equals(that.itemStack) : (that.itemStack == null);
    }

    @Override
    public int hashCode()
    {
        return (this.itemStack != null) ? this.itemStack.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("itemStack", this.itemStack).toString();
    }
}
