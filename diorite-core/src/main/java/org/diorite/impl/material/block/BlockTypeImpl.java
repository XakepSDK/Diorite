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
import java.util.Collections;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.entity.Entity;
import org.diorite.material.block.BlockInteractHandler;
import org.diorite.material.block.BlockSounds;
import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.BlockType;
import org.diorite.material.block.FlameableSettings;
import org.diorite.material.block.LightSettings;
import org.diorite.material.block.LiquidSettings;
import org.diorite.material.data.drops.PossibleDrops;
import org.diorite.material.item.ItemType;

public abstract class BlockTypeImpl implements BlockType
{
    private int    id;
    private String minecraftId;
    private int    fakeId;
    private String fakeMinecraftId;
    private String displayNameKey;
    private float  hardness;
    private float  blastResistace;
    private BlockSounds sounds = BlockSounds.DEFAULTS;
    private PossibleDrops drops;
    private boolean       solid;

    private LiquidSettings    liquidSettings    = LiquidSettingsImpl.NOT_LIQUID;
    private LightSettings     lightSettings     = LightSettingsImpl.NO_LIGHT;
    private FlameableSettings flameableSettings = FlameableSettingsImpl.NOT_FLAMEABLE;

    public BlockTypeImpl(final int id, final String minecraftId)
    {
        this.id = id;
        this.minecraftId = minecraftId;
        this.fakeId = id;
        this.fakeMinecraftId = minecraftId;
        this.displayNameKey = minecraftId.substring(minecraftId.indexOf(':') + 1);
//        this.drops = BasicPossibleDrops.createEmpty();
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    public BlockTypeImpl setId(final int id)
    {
        this.id = id;
        return this;
    }

    @Override
    public String getMinecraftId()
    {
        return this.minecraftId;
    }

    public BlockTypeImpl setMinecraftId(final String minecraftId)
    {
        this.minecraftId = minecraftId;
        return this;
    }

    @Override
    public int getProxyId()
    {
        return this.fakeId;
    }

    public BlockTypeImpl setProxyId(final int id)
    {
        this.fakeId = id;
        return this;
    }

    @Override
    public String getProxyMinecraftId()
    {
        return this.fakeMinecraftId;
    }

    public BlockTypeImpl setProxyMinecraftId(final String id)
    {
        this.fakeMinecraftId = id;
        return this;
    }

    @Override
    public String getDisplayNameKey()
    {
        return this.displayNameKey;
    }

    public BlockTypeImpl setDisplayNameKey(final String displayNameKey)
    {
        this.displayNameKey = displayNameKey;
        return this;
    }

    @Override
    public boolean isSolid()
    {
        return this.solid;
    }

    public void setSolid(final boolean solid)
    {
        this.solid = solid;
    }

    @Override
    public PossibleDrops getDrops()
    {
        return this.drops;
    }

    public void setDrops(final PossibleDrops drops)
    {
        this.drops = drops;
    }

    @Override
    public BlockSubtype getSubtype(final int id)
    {
        return null;
    }

    @Override
    public BlockSubtype getSubtype(final String id)
    {
        return null;
    }

    @Override
    public Collection<BlockSubtype> getSubtypes()
    {
        return Collections.emptyList();
    }

    @Override
    public abstract BlockSubtype asSubtype();

    @Override
    public double getHardness()
    {
        return this.hardness;
    }

    public BlockTypeImpl setHardness(final double hardness)
    {
        this.hardness = (float) hardness;
        return this;
    }

    public BlockTypeImpl setHardnessAndResistance(final float hardness, final float blastResistace)
    {
        this.hardness = hardness;
        this.blastResistace = blastResistace;
        return this;
    }

    public BlockTypeImpl setHardnessAndResistance(final float hardness, final float blastResistace, final boolean solid)
    {
        this.hardness = hardness;
        this.blastResistace = blastResistace;
        this.solid = solid;
        return this;
    }

    @Override
    public double getBlastResistance()
    {
        return this.blastResistace;
    }

    public BlockTypeImpl setBlastResistace(final double blastResistace)
    {
        this.blastResistace = (float) blastResistace;
        return this;
    }

    @Override
    public BlockSounds getSounds()
    {
        return this.sounds;
    }

    public BlockTypeImpl setSounds(final BlockSounds sounds)
    {
        this.sounds = sounds;
        return this;
    }

    @Override
    public boolean isCollidingWith(final int x, final int y, final int z, final Entity entity)
    {
        return false;
    }

    @Override
    public boolean isTileEntity()
    {
        return false;
    }

    @Override
    public ItemType getItem()
    {
        return null;
    }

    @Override
    public LiquidSettings getLiquidSettings()
    {
        return this.liquidSettings;
    }

    @Override
    public void setLiquidSettings(final LiquidSettings settings)
    {
        this.liquidSettings = settings;
    }

    @Override
    public LightSettings getLightSettings()
    {
        return this.lightSettings;
    }

    @Override
    public void setLightSettings(final LightSettings lightSettings)
    {
        this.lightSettings = lightSettings;
    }

    @Override
    public FlameableSettings getFlameableSettings()
    {
        return this.flameableSettings;
    }

    @Override
    public void setFlameableSettings(final FlameableSettings flameableSettings)
    {
        this.flameableSettings = flameableSettings;
    }

    @Override
    public BlockInteractHandler getInteractHandler()
    {
        return null;
    }

    public BlockTypeImpl setSettings(final FlameableSettings flameableSettings)
    {
        this.flameableSettings = flameableSettings;
        return this;
    }

    public BlockTypeImpl setSettings(final LightSettings lightSettings)
    {
        this.lightSettings = lightSettings;
        return this;
    }

    public BlockTypeImpl setSettings(final LiquidSettings settings)
    {
        this.liquidSettings = settings;
        return this;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("minecraftId", this.minecraftId).toString();
    }
}
