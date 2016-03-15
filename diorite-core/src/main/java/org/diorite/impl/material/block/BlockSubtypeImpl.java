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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
import org.diorite.material.data.drops.BasicPossibleDrops;
import org.diorite.material.data.drops.PossibleDrops;
import org.diorite.material.item.ItemRegistry;
import org.diorite.material.item.ItemSubtype;
import org.diorite.material.state.StateEntry;
import org.diorite.world.TileEntity;

public class BlockSubtypeImpl implements BlockSubtype
{
    protected       int         subtypeId;
    protected       String      subtypeStringId;
    protected       String      displayNameKey;
    protected final BlockType   blockType;
    protected       String[]    itemTypeId;
    protected       ItemSubtype itemType;
    protected PossibleDrops drops = BasicPossibleDrops.createEmpty();

    protected List<BlockSubtype> proxyTypes = new ArrayList<>(1);

    private final Collection<StateEntry<?>> stateEntries;
    private final Collection<StateEntry<?>> stateEntriesUnmod;

    protected float                       hardness;
    protected float                       blastResistace;
    protected BlockSounds                 sounds;
    protected boolean                     solid;
    protected Class<? extends TileEntity> tileEntityClass;
    protected LiquidSettings              liquidSettings;
    protected LightSettings               lightSettings;
    protected FlameableSettings           flameableSettings;

    public BlockSubtypeImpl(final BlockTypeImpl blockType, final int id, final String stringId, final Collection<StateEntry<?>> stateEntries)
    {
        this.blockType = blockType;
        this.subtypeId = id;
        this.subtypeStringId = stringId;
        this.displayNameKey = this.blockType.getMinecraftId().substring(this.blockType.getMinecraftId().indexOf(':') + 1) + "." + stringId;
        this.stateEntries = new ArrayList<>(stateEntries);
        this.stateEntriesUnmod = Collections.unmodifiableCollection(this.stateEntries);

//        this.blastResistace = blockType.blastResistace;
//        this.hardness = blockType.hardness;
//        this.solid = blockType.solid;
//        this.tileEntityClass = blockType.tileEntityClass;
//        this.flameableSettings = blockType.flameableSettings;
//        this.lightSettings = blockType.lightSettings;
//        this.liquidSettings = blockType.liquidSettings;
//        this.sounds = blockType.sounds;
    }

    @Override
    public int getSubtypeId()
    {
        return this.subtypeId;
    }

    @Override
    public String getSubtypeStringId()
    {
        return this.subtypeStringId;
    }

    @Override
    public Collection<StateEntry<?>> getStates()
    {
        return this.stateEntriesUnmod;
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

    public void setSubtypeId(final int subtypeId)
    {
        this.subtypeId = subtypeId;
    }

    public void setSubtypeStringId(final String subtypeStringId)
    {
        this.subtypeStringId = subtypeStringId;
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
    public String getMinecraftId()
    {
        return this.blockType.getMinecraftId();
    }

    @Override
    public List<? extends BlockSubtype> getProxySubtypes()
    {
        return this.proxyTypes;
    }

    public void setProxySubtypes(final List<? extends BlockSubtype> list)
    {
        this.proxyTypes.clear();
        this.proxyTypes.addAll(list);
    }

    @Override
    public String getDisplayNameKey()
    {
        return this.displayNameKey;
    }

    public BlockSubtypeImpl setDisplayNameKey(final String displayNameKey)
    {
        this.displayNameKey = displayNameKey;
        return this;
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
    public BlockSubtype getSubtype(final BlockSubtype def, final StateEntry<?>... entires)
    {
        return null;
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
        return this.hardness;
    }

    public BlockSubtypeImpl setHardness(final double hardness)
    {
        this.hardness = (float) hardness;
        return this;
    }

    public BlockSubtypeImpl setHardnessAndResistance(final float hardness, final float blastResistace)
    {
        this.hardness = hardness;
        this.blastResistace = blastResistace;
        return this;
    }

    public BlockSubtypeImpl setHardnessAndResistance(final float hardness, final float blastResistace, final boolean solid)
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

    public BlockSubtypeImpl setBlastResistace(final double blastResistace)
    {
        this.blastResistace = (float) blastResistace;
        return this;
    }

    @Override
    public BlockSounds getSounds()
    {
        return this.sounds;
    }

    public void setSounds(final BlockSounds sounds)
    {
        this.sounds = sounds;
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
    public boolean isCollidingWith(final BlockLocation blockLocation, final Entity entity)
    {
        return this.blockType.isCollidingWith(blockLocation, entity);
    }

    @Override
    public boolean isTileEntity()
    {
        return this.tileEntityClass != null;
    }

    @Override
    public boolean isCollidingWith(final int x, final int y, final int z, final Entity entity)
    {
        return this.blockType.isCollidingWith(x, y, z, entity);
    }

    public void setItemSubtype(final ItemSubtype itemType)
    {
        this.itemType = itemType;
        this.itemTypeId = new String[]{itemType.getMinecraftId(), itemType.getSubtypeStringId()};
    }

    @Override
    public ItemSubtype getItem()
    {
        if ((this.itemTypeId == null) || (this.itemTypeId.length != 2))
        {
            return null;
        }
        if (this.itemType == null)
        {
            this.itemType = ItemRegistry.getItemSubtype(this.itemTypeId[0], this.itemTypeId[1]);
        }
        return this.itemType;
    }

    @Override
    public LightSettings getLightSettings()
    {
        return this.lightSettings;
    }

    public void setLightSettings(final LightSettings lightSettings)
    {
        this.lightSettings = lightSettings;
    }

    @Override
    public LiquidSettings getLiquidSettings()
    {
        return this.liquidSettings;
    }

    public void setLiquidSettings(final LiquidSettings liquidSettings)
    {
        this.liquidSettings = liquidSettings;
    }

    @Override
    public FlameableSettings getFlameableSettings()
    {
        return this.flameableSettings;
    }

    public void setFlameableSettings(final FlameableSettings flameableSettings)
    {
        this.flameableSettings = flameableSettings;
    }

    @Override
    public Class<? extends TileEntity> getTileEntityClass()
    {
        return this.tileEntityClass;
    }

    public void setTileEntityClass(final Class<? extends TileEntity> tileEntityClass)
    {
        this.tileEntityClass = tileEntityClass;
    }

    @Override
    public BlockInteractHandler getInteractHandler()
    {
        return null;
    }

    public BlockSubtypeImpl setSettings(final FlameableSettings flameableSettings)
    {
        this.flameableSettings = flameableSettings;
        return this;
    }

    public BlockSubtypeImpl setSettings(final LightSettings lightSettings)
    {
        this.lightSettings = lightSettings;
        return this;
    }

    public BlockSubtypeImpl setSettings(final LiquidSettings settings)
    {
        this.liquidSettings = settings;
        return this;
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
