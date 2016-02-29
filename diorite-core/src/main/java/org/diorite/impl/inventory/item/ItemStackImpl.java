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

import org.diorite.entity.Item;
import org.diorite.inventory.item.ItemStack;
import org.diorite.inventory.item.meta.ItemMeta;
import org.diorite.material.item.ItemType;
import org.diorite.material_old.Material;
import org.diorite.utils.others.Dirtable;

public class ItemStackImpl implements Dirtable, ItemStack
{
    protected ItemType material;
    protected int      amount;
    protected ItemMeta itemMeta;
    private       boolean   dirty;

    public ItemStackImpl(final ItemType material, final int amount)
    {
        Validate.notNull(material, "Material can't be null.");
        this.amount = (this.material == null) ? 0 : amount;
        this.setDirty();
    }

    @Override
    public boolean isSimilar(final ItemStack b)
    {
        if (b == null)
        {
            return amount == 0;
        }
        if (! this.material.equals(b.getMaterial()))
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
    public boolean isAir()
    {
        return (this.material == null) || this.material.simpleEquals(Material.AIR);
    }

    @Override
    public boolean isValid()
    {
        return this.amount <= this.material.getMaxStack();
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
    public Material getMaterial()
    {
        return this.wrapped.getMaterial();
    }

    @Override
    public void setMaterial(final Material material)
    {
        this.wrapped.setMaterial(material);
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
    public ItemStackImpl combine(final ItemStack other)
    {
        this.setDirty();
        final ItemStack combined = this.wrapped.combine(other);
        return (combined == null) ? null : new ItemStackImpl(combined);
    }

    @Override
    public ItemStack addFrom(final ItemStack other, final int amount)
    {
        this.setDirty();
        return this.wrapped.addFrom(other, amount);
    }

    @Override
    public ItemStack split(final int size)
    {
        if (size > this.getAmount())
        {
            throw new IllegalArgumentException();
        }

        final ItemStack temp = new ItemStackImpl(this);

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
    public ItemStackImpl clone()
    {
        return new ItemStackImpl(this.wrapped.clone());
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("wrapped", this.wrapped).append("dirty", this.dirty).toString();
    }
}
