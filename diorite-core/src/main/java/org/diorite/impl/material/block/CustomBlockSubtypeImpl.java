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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.BlockType;

public class CustomBlockSubtypeImpl extends BlockTypeImpl implements BlockSubtype
{
    private       int       subtypeId;
    private       String    subtypeStringId;
    private       int       proxySubtypeId;
    private final BlockType blockType;

    public CustomBlockSubtypeImpl(final BlockType blockType, final int id, final String stringId)
    {
        super(blockType.getId(), blockType.getMinecraftId());
        this.blockType = blockType;
        this.subtypeId = id;
        this.proxySubtypeId = id;
        this.subtypeStringId = stringId;
    }

    @Override
    public int getSubtypeId()
    {
        return this.subtypeId;
    }

    @Override
    public int getProxySubtypeId()
    {
        return this.proxySubtypeId;
    }

    @Override
    public String getSubtypeStringId()
    {
        return this.subtypeStringId;
    }

    public void setSubtypeId(final int subtypeId)
    {
        this.subtypeId = subtypeId;
    }

    public void setSubtypeStringId(final String subtypeStringId)
    {
        this.subtypeStringId = subtypeStringId;
    }

    public void setProxySubtypeId(final int proxySubtypeId)
    {
        this.proxySubtypeId = proxySubtypeId;
    }

    @Override
    public BlockSubtype asSubtype()
    {
        return this;
    }

    @Override
    public BlockType getFullType()
    {
        return this.blockType;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("blockType", this.blockType).append("subtypeStringId", this.subtypeStringId).toString();
    }
}
