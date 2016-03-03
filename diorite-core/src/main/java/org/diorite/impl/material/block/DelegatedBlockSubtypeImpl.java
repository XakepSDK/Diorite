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

import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.BlockLocation;
import org.diorite.entity.Entity;
import org.diorite.material.AnyType;
import org.diorite.material.block.BlockInteractHandler;
import org.diorite.material.block.BlockSounds;
import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.BlockType;
import org.diorite.material.block.FlameableSettings;
import org.diorite.material.block.LightSettings;
import org.diorite.material.block.LiquidSettings;
import org.diorite.material.data.drops.PossibleDrops;
import org.diorite.material.item.ItemType;

public class DelegatedBlockSubtypeImpl implements BlockSubtype
{
    private       int       subtypeId;
    private       String    subtypeStringId;
    private       int       proxySubtypeId;
    private final BlockType blockType;

    public DelegatedBlockSubtypeImpl(final BlockType blockType, final int id, final String stringId)
    {
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
    public BlockType getFullType()
    {
        return this.blockType;
    }

    @Override
    public int getId()
    {
        return this.blockType.getId();
    }

    @Override
    public int getProxyId()
    {
        return this.blockType.getProxyId();
    }

    @Override
    public String getMinecraftId()
    {
        return this.blockType.getMinecraftId();
    }

    @Override
    public String getProxyMinecraftId()
    {
        return this.blockType.getProxyMinecraftId();
    }

    @Override
    public String getDisplayNameKey()
    {
        return this.blockType.getDisplayNameKey();
    }

    @Override
    public BlockSubtype getSubtype(final int id)
    {
        return this.blockType.getSubtype(id);
    }

    @Override
    public BlockSubtype getSubtype(final String id)
    {
        return this.blockType.getSubtype(id);
    }

    @Override
    public void addSubtype(final BlockSubtype subtype)
    {
        this.blockType.addSubtype(subtype);
    }

    @Override
    public Collection<? extends BlockSubtype> getSubtypes()
    {
        return this.blockType.getSubtypes();
    }

    @Override
    public BlockSubtype getDefaultSubtype()
    {
        return this.blockType.getDefaultSubtype();
    }

    @Override
    public void setDefaultSubtype(final BlockSubtype defaultSubtype)
    {
        this.blockType.setDefaultSubtype(defaultSubtype);
    }

    @Override
    public BlockSubtype asSubtype()
    {
        return this.blockType.asSubtype();
    }

    @Override
    public double getHardness()
    {
        return this.blockType.getHardness();
    }

    @Override
    public double getBlastResistance()
    {
        return this.blockType.getBlastResistance();
    }

    @Override
    public boolean isSolid()
    {
        return this.blockType.isSolid();
    }

    @Override
    public BlockSounds getSounds()
    {
        return this.blockType.getSounds();
    }

    @Override
    public boolean isCollidingWith(final BlockLocation blockLocation, final Entity entity)
    {
        return this.blockType.isCollidingWith(blockLocation, entity);
    }

    @Override
    public boolean isTileEntity()
    {
        return this.blockType.isTileEntity();
    }

    @Override
    public boolean isCollidingWith(final int x, final int y, final int z, final Entity entity)
    {
        return this.blockType.isCollidingWith(x, y, z, entity);
    }

    @Override
    public ItemType getItem()
    {
        return this.blockType.getItem();
    }

    @Override
    public PossibleDrops getDrops()
    {
        return this.blockType.getDrops();
    }

    @Override
    public void setLiquidSettings(final LiquidSettings settings)
    {
        this.blockType.setLiquidSettings(settings);
    }

    @Override
    public LiquidSettings getLiquidSettings()
    {
        return this.blockType.getLiquidSettings();
    }

    @Override
    public LightSettings getLightSettings()
    {
        return this.blockType.getLightSettings();
    }

    @Override
    public void setLightSettings(final LightSettings settings)
    {
        this.blockType.setLightSettings(settings);
    }

    @Override
    public FlameableSettings getFlameableSettings()
    {
        return this.blockType.getFlameableSettings();
    }

    @Override
    public void setFlameableSettings(final FlameableSettings settings)
    {
        this.blockType.setFlameableSettings(settings);
    }

    @Override
    public BlockInteractHandler getInteractHandler()
    {
        return this.blockType.getInteractHandler();
    }

    @Override
    public boolean isThisSameType(final AnyType type)
    {
        return this.blockType.isThisSameType(type);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("blockType", this.blockType).append("subtypeStringId", this.subtypeStringId).toString();
    }
}
