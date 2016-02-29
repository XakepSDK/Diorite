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

package org.diorite.impl.inventory.item;

import org.diorite.inventory.item.ItemStack;
import org.diorite.inventory.item.meta.ItemMeta;
import org.diorite.material.item.ItemType;
import org.diorite.utils.others.Dirtable;

public interface IItemStack extends Dirtable, ItemStack, Cloneable
{
    @Override
    boolean isSimilar(ItemStack b);

    @Override
    boolean isEmpty();

    @Override
    boolean isValid();

    @Override
    int getAmount();

    @Override
    ItemMeta getItemMeta();

    @Override
    boolean hasItemMeta();

    @Override
    ItemType getType();

    @Override
    void setType(ItemType material);

    @Override
    void setItemMeta(ItemMeta itemMeta);

    @Override
    void setAmount(int amount);

    @Override
    IItemStack combine(ItemStack other);

    @Override
    IItemStack addFrom(ItemStack other, int amount);

    @Override
    IItemStack split(int size);

    @Override
    boolean isDirty();

    @Override
    boolean setDirty(boolean dirty);

    IItemStack clone();

    static IItemStack wrap(final ItemStack item)
    {
        if (item == null)
        {
            return null;
        }
        if (item instanceof IItemStack)
        {
            return (IItemStack) item;
        }
        return new WrappedItemStack(item); // TODO make sure this isn't used by vanilla diorite code
    }

     static void validate(final ItemStack excepted)
    {
        if ((excepted != null) && ! (excepted instanceof IItemStack))
        {
            throw new IllegalArgumentException("ItemStack must be implementation type. (IItemStack)");
        }
    }
}
