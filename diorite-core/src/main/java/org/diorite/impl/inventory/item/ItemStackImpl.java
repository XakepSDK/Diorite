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

import static org.diorite.Diorite.getItemFactory;


import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.Diorite;
import org.diorite.ItemFactory;
import org.diorite.inventory.item.ItemStack;
import org.diorite.inventory.item.meta.ItemMeta;
import org.diorite.material.item.ItemSubtype;
import org.diorite.material.item.ItemType;

public class ItemStackImpl implements IItemStack
{
    protected ItemSubtype itemSubtype;
    protected int         amount;
    protected ItemMeta    itemMeta;
    private   boolean     dirty;

    public ItemStackImpl(final ItemStack toCpy)
    {
        this.itemSubtype = toCpy.getType();
        this.amount = toCpy.getAmount();
        this.itemMeta = toCpy.getItemMeta().clone();
        this.setDirty();
    }

    public ItemStackImpl(final ItemType itemSubtype)
    {
        this(itemSubtype, 1);
    }

    public ItemStackImpl(final ItemType itemSubtype, final int amount)
    {
        Validate.notNull(itemSubtype, "Material can't be null.");
        this.amount = (this.itemSubtype == null) ? 0 : amount;
        this.setDirty();
    }

    @Override
    public boolean isSimilar(final ItemStack b)
    {
        if (b == null)
        {
            return this.amount == 0;
        }
        if (! this.itemSubtype.equals(b.getType()))
        {
            return false;
        }
        if (this.itemMeta == null)
        {
            return b.getItemMeta().isEmpty();
        }
        return this.itemMeta.equals(b.getItemMeta());
    }

    @Override
    public boolean isEmpty()
    {
        return (this.amount == 0) || (this.itemSubtype == null);
    }

    @Override
    public boolean isValid()
    {
        return this.amount <= this.itemSubtype.getMaxStack();
    }

    @Override
    public int getAmount()
    {
        return this.amount;
    }

    @Override
    public ItemMeta getItemMeta()
    {
        final ItemFactory fac = getItemFactory();
        if (this.itemMeta == null)
        {
            fac.construct(this.itemSubtype).apply(this);
        }
        if (! this.itemMeta.getClass().equals(fac.construct(this.itemSubtype.getMetaType()).getClass()))
        {
            fac.construct(this.itemSubtype, this.itemMeta.getNbtData()).apply(this);
        }
        return this.itemMeta;
    }

    @Override
    public boolean hasItemMeta()
    {
        return this.itemMeta == null;
    }

    @Override
    public ItemSubtype getType()
    {
        return this.itemSubtype;
    }

    @Override
    public void setType(final ItemType type)
    {
        Validate.notNull(type, "Material can't be null.");
        this.itemSubtype = type.asSubtype();
        this.setDirty();
    }

    @Override
    public void setItemMeta(final ItemMeta itemMeta)
    {
        if (itemMeta != null)
        {
            final ItemFactory fac = Diorite.getItemFactory();
            if (! itemMeta.getClass().equals(fac.construct(this.itemSubtype.getMetaType()).getClass()))
            {
                fac.construct(this.itemSubtype, itemMeta.getNbtData()).apply(this);
            }
        }
        this.itemMeta = itemMeta;
        this.setDirty();
    }

    @Override
    public void setAmount(final int amount)
    {
        this.amount = amount;
        this.setDirty();
    }

    @Override
    public IItemStack combine(final ItemStack other)
    {
        if (! this.isSimilar(other))
        {
            throw new IllegalArgumentException("Items must be similar to combine them.");
        }
        this.setDirty();

        final int maxStack = this.itemSubtype.getMaxStack();
        if ((this.amount + other.getAmount()) > maxStack)
        {
            final int pendingItems = (this.amount + other.getAmount()) - maxStack;
            this.amount = maxStack;

            final IItemStack temp = new ItemStackImpl(this);
            temp.setAmount(pendingItems);
            return temp;
        }
        else
        {
            this.amount += other.getAmount();
            return null;
        }
    }

    @Override
    public IItemStack addFrom(final ItemStack other, final int amount)
    {
        this.setDirty();
        if (amount > other.getAmount())
        {
            throw new IllegalArgumentException("amount to conbine can't be bigger than amount of items in stack.");
        }
        if (! this.isSimilar(other))
        {
            throw new IllegalArgumentException("Items must be similar to combine them.");
        }

        final int maxStack = this.itemSubtype.getMaxStack();
        if ((this.amount + amount) > maxStack)
        {
            final int pendingItems = (this.amount + amount) - maxStack;
            this.amount = maxStack;

            final IItemStack temp = new ItemStackImpl(this);
            temp.setAmount(pendingItems);
            return temp;
        }
        else
        {
            this.amount += amount;

            other.setAmount(other.getAmount() - amount);
            return null;
        }
    }

    @Override
    public IItemStack split(final int size)
    {
        if (size > this.amount)
        {
            throw new IllegalArgumentException();
        }

        if (this.amount == 1)
        {
            return null;
        }

        final IItemStack temp = new ItemStackImpl(this);

        this.amount -= size;
        this.setDirty();
        temp.setAmount(size);

        return temp;
    }

    private boolean isMetaDirty()
    {
        return ((this.itemMeta != null) && this.itemMeta.isDirty());
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
        if (this.itemMeta != null)
        {
            this.itemMeta.setDirty(dirty);
        }
        return b;
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    public IItemStack clone()
    {
        return new ItemStackImpl(this);
    }

    @Override
    public int hashCode()
    {
        int result = (this.itemSubtype != null) ? this.itemSubtype.hashCode() : 0;
        result = (31 * result) + this.amount;
        result = (31 * result) + ((this.itemMeta != null) ? this.itemMeta.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof ItemStack))
        {
            return false;
        }

        if (o instanceof IItemStack)
        {
            final ItemStackImpl itemStack = (ItemStackImpl) o;

            return (this.amount == itemStack.amount) && ! ((this.itemSubtype != null) ? ! this.itemSubtype.equals(itemStack.itemSubtype) : (itemStack.itemSubtype != null)) && ((this.itemMeta == null) || this.itemMeta.equals(itemStack.itemMeta));
        }
        else
        {
            final ItemStack itemStack = (ItemStack) o;
            return (this.amount == itemStack.getAmount()) && ! ((this.itemSubtype != null) ? ! this.itemSubtype.equals(itemStack.getType()) : (itemStack.getType() != null)) && ((this.itemMeta == null) || this.itemMeta.equals(itemStack.getItemMeta()));
        }
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("itemSubtype", this.itemSubtype).append("amount", this.amount).append("itemMeta", this.itemMeta).toString();
    }

}
