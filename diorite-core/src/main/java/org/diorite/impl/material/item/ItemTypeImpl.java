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

import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.inventory.item.meta.ItemMeta;
import org.diorite.material.item.ItemSubtype;
import org.diorite.material.item.ItemType;

public abstract class ItemTypeImpl implements ItemType
{
    private int    id;
    private String minecraftId;
    private int                       maxStack = 64;
    private Class<? extends ItemMeta> metaType = ItemMeta.class;

    public ItemTypeImpl(final int id, final String minecraftId, final int maxStack)
    {
        this(id, minecraftId);
        this.maxStack = maxStack;
    }

    public ItemTypeImpl(final int id, final String minecraftId)
    {
        this.id = id;
        this.minecraftId = minecraftId;
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    public ItemTypeImpl setId(final int id)
    {
        this.id = id;
        return this;
    }

    @Override
    public String getMinecraftId()
    {
        return this.minecraftId;
    }

    public ItemTypeImpl setMinecraftId(final String minecraftId)
    {
        this.minecraftId = minecraftId;
        return this;
    }

    @Override
    public int getMaxStack()
    {
        return this.maxStack;
    }

    public void setMaxStack(final int maxStack)
    {
        this.maxStack = maxStack;
    }

    @Override
    public ItemSubtype getSubtype(final int id)
    {
        return null;
    }

    @Override
    public ItemSubtype getSubtype(final String id)
    {
        return null;
    }

    @Override
    public Collection<? extends ItemSubtype> getSubtypes()
    {
        return null;
    }

    @Override
    public Class<? extends ItemMeta> getMetaType()
    {
        return this.metaType;
    }

    /**
     * Set meta type of this itemSubtype, can be changed at runtime.
     *
     * @param metaType new meta type of this itemSubtype.
     */
    public void setMetaType(final Class<? extends ItemMeta> metaType)
    {
        this.metaType = metaType;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("minecraftId", this.minecraftId).toString();
    }
}
