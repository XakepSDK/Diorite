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

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.inventory.item.ItemStack;
import org.diorite.inventory.item.meta.ItemMeta;
import org.diorite.material.item.ItemSubtype;
import org.diorite.material.item.ItemType;

public class WrappedItemStack implements IItemStack
{
    private final ItemStack wrapped;
    private       boolean   dirty;

    protected WrappedItemStack(final ItemStack wrapped)
    {
        Validate.isTrue(! (wrapped instanceof WrappedItemStack), "Can't wrap wrapper");
        this.wrapped = wrapped;
        this.setDirty();
    }

    public ItemStack getWrapped()
    {
        return this.wrapped;
    }

    @Override
    public boolean isSimilar(final ItemStack b)
    {
        return this.wrapped.isSimilar(b);
    }

    @Override
    public boolean isValid()
    {
        return this.wrapped.isValid();
    }

    @Override
    public boolean isEmpty()
    {
        return this.wrapped.getAmount() == 0;
    }

//    @Override
//    public void update()
//    {
//        this.wrapped.update();
//    }

    @Override
    public int getAmount()
    {
        return this.wrapped.getAmount();
    }

    @Override
    public ItemMeta getItemMeta()
    {
        return this.wrapped.getItemMeta();
    }

    @Override
    public boolean hasItemMeta()
    {
        return this.wrapped.hasItemMeta();
    }

    @Override
    public ItemSubtype getType()
    {
        return this.wrapped.getType();
    }

    @Override
    public void setType(final ItemType material)
    {
        this.wrapped.setType(material);
        this.setDirty();
    }

    @Override
    public void setItemMeta(final ItemMeta itemMeta)
    {
        this.wrapped.setItemMeta(itemMeta);
        this.setDirty();
    }

    @Override
    public void setAmount(final int amount)
    {
        this.wrapped.setAmount(amount);
        this.setDirty();
    }

    @Override
    public IItemStack combine(final ItemStack other)
    {
        this.setDirty();
        final ItemStack combined = this.wrapped.combine(other);
        return (combined == null) ? null : IItemStack.wrap(combined);
    }

    @Override
    public IItemStack addFrom(final ItemStack other, final int amount)
    {
        this.setDirty();
        return IItemStack.wrap(this.wrapped.addFrom(other, amount));
    }

    @Override
    public IItemStack split(final int size)
    {
        if (size > this.getAmount())
        {
            throw new IllegalArgumentException();
        }

        final ItemStackImpl temp = new ItemStackImpl(this);

        this.wrapped.setAmount(this.wrapped.getAmount() - size);
        if (this.getAmount() == 0)
        {
            this.wrapped.setItemMeta(null);
        }
        this.setDirty();
        temp.setAmount(size);

        return temp;
    }

    private boolean isMetaDirty()
    {
        return ((this.wrapped != null) && this.wrapped.hasItemMeta() && this.wrapped.getItemMeta().isDirty());
    }

    @Override
    public boolean isDirty()
    {
        return this.dirty || this.isMetaDirty();
    }

    @Override
    public boolean setDirty(final boolean dirty)
    {
        final boolean b = this.dirty || this.isMetaDirty();
        this.dirty = dirty;
        if ((this.wrapped != null) && this.wrapped.hasItemMeta())
        {
            this.wrapped.getItemMeta().setDirty(dirty);
        }
        return b;
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    public IItemStack clone()
    {
        return new WrappedItemStack(this.wrapped.clone());
    }

    public static void validate(final ItemStack excepted)
    {
        if ((excepted != null) && ! (excepted instanceof IItemStack))
        {
            throw new IllegalArgumentException("IItemStack must be a type of excepted item");
        }
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("wrapped", this.wrapped).append("dirty", this.dirty).toString();
    }
}
