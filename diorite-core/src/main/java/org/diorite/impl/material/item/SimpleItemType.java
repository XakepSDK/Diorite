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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.material.item.ItemSubtype;
import org.diorite.material.item.ItemType;

public class SimpleItemType extends ItemTypeImpl implements ItemSubtype
{
    private String subtypeStringId;
    private int subtypeId      = 0;
    private int proxySubtypeId = 0;

    public SimpleItemType(final int id, final String minecraftId, final int maxStack)
    {
        super(id, minecraftId, maxStack);
        final int i = minecraftId.indexOf(':');
        this.subtypeStringId = (i == - 1) ? minecraftId : minecraftId.substring(i + 1, minecraftId.length());
    }

    public SimpleItemType(final int id, final String minecraftId)
    {
        this(id, minecraftId, DEFAULT_STACK_SIZE);
    }

    @Override
    public ItemSubtype asSubtype()
    {
        return this;
    }

    @Override
    public int getSubtypeId()
    {
        return this.subtypeId;
    }

    public void setSubtypeId(final int subtypeId)
    {
        this.subtypeId = subtypeId;
    }

    @Override
    public int getProxySubtypeId()
    {
        return this.proxySubtypeId;
    }

    public void setProxySubtypeId(final int proxySubtypeId)
    {
        this.proxySubtypeId = proxySubtypeId;
    }

    @Override
    public String getSubtypeStringId()
    {
        return this.subtypeStringId;
    }

    public void setSubtypeStringId(final String subtypeStringId)
    {
        this.subtypeStringId = subtypeStringId;
    }

    @Override
    public ItemType getFullType()
    {
        return this;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("subtypeStringId", this.subtypeStringId).toString();
    }
}
