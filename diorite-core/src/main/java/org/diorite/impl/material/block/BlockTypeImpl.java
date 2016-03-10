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
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;

import com.google.common.collect.Sets;

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
import org.diorite.material.state.State;
import org.diorite.material.state.StateEntry;
import org.diorite.material.data.drops.PossibleDrops;
import org.diorite.material.item.ItemType;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class BlockTypeImpl implements BlockType
{
    protected int    id;
    protected String minecraftId;
    protected int    fakeId;
    protected String fakeMinecraftId;
    protected String displayNameKey;
    protected float  hardness;
    protected float  blastResistace;
    protected BlockSounds sounds = BlockSounds.DEFAULTS;
    protected PossibleDrops drops;
    protected boolean       solid;

    protected LiquidSettings    liquidSettings    = LiquidSettingsImpl.NOT_LIQUID;
    protected LightSettings     lightSettings     = LightSettingsImpl.NO_LIGHT;
    protected FlameableSettings flameableSettings = FlameableSettingsImpl.NOT_FLAMEABLE;

    protected BlockSubtype defaultSubtype;
    protected final Int2ObjectOpenHashMap<BlockSubtype> subtypesById   = new Int2ObjectOpenHashMap<>(1);
    protected final Map<String, BlockSubtype>           subtypesByName = new CaseInsensitiveMap<>(1);

    protected final Collection<State<?>>                         supportedStates = Collections.newSetFromMap(new IdentityHashMap<>(2));
    protected final Map<Collection<StateEntry<?>>, BlockSubtype> stateMap        = new HashMap<>(1);

    protected final Collection<BlockSubtype> allSubtypes            = new HashSet<>(1);
    private final   Collection<BlockSubtype> unmodifableAllSubtypes = Collections.unmodifiableCollection(this.allSubtypes);

    public BlockTypeImpl(final int id, final String minecraftId)
    {
        this.id = id;
        this.minecraftId = minecraftId;
        this.fakeId = id;
        this.fakeMinecraftId = minecraftId;
        this.displayNameKey = minecraftId.substring(minecraftId.indexOf(':') + 1);
        this.defaultSubtype = new DelegatedBlockSubtypeImpl(this, 0, this.displayNameKey);
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
        return this.subtypesById.get(id);
    }

    @Override
    public BlockSubtype getSubtype(final String id)
    {
        return this.subtypesByName.get(id);
    }

    @Override
    public BlockSubtype getSubtype(BlockSubtype def, final StateEntry<?>... states)
    {
        if (def == null)
        {
            def = this.defaultSubtype;
        }
        if ((states == null) || (states.length == 0))
        {
            return def;
        }
        final Collection<StateEntry<?>> statesSet = Sets.newHashSet(states);

        final Collection<StateEntry<?>> defStates = def.getStates();
        final Collection<StateEntry<?>> blockStates = new HashSet<>(defStates.size() + states.length);
        blockStates.addAll(defStates);
        Collections.addAll(blockStates, states);

        int defStateMatches = 0;
        for (final StateEntry<?> blockState : blockStates)
        {
            if (statesSet.isEmpty())
            {
                break;
            }
            if (statesSet.remove(blockState))
            {
                defStateMatches++;
            }
        }

        BlockSubtype selected = def;
        int selectedMatches = defStateMatches;

        for (final BlockSubtype subtype : this.subtypesByName.values())
        {
            final Collection<StateEntry<?>> subtypeStates = subtype.getStates();
            final int maxSize = subtypeStates.size();
            int stateMatches = 0;
            for (final StateEntry<?> blockState : blockStates)
            {
                if (stateMatches == maxSize)
                {
                    break;
                }
                if (subtypeStates.contains(blockState))
                {
                    stateMatches++;
                }
            }
            if (stateMatches > selectedMatches)
            {
                selected = subtype;
                selectedMatches = stateMatches;
            }
        }

        return selected;
    }

    public BlockType addVariants(int start, final String... names)
    {
        for (final String name : names)
        {
            this.addVariant(start++, name);
        }
        return this;
    }

    public BlockType setVariants(final VariantEntry... entries)
    {
        int id = - 1;
        for (final VariantEntry entry : entries)
        {
            ++ id;
            if (entry == null)
            {
                continue;
            }
            final ArrayList<StateEntry<?>> states = entry.getStates();
            states.trimToSize();
            final DelegatedBlockSubtypeImpl subtype = new DelegatedBlockSubtypeImpl(this, id, entry.getName());
            this.stateMap.put(states, subtype);
        }
        return this;
    }

    public BlockType setVariants(final String... names)
    {
        this.subtypesByName.clear();
        this.subtypesById.clear();
        int i = 0;
        for (final String name : names)
        {
            this.addVariant(i++, name);
        }
        return this;
    }

    public BlockSubtype addVariant(final int id, final String name)
    {
        final BlockSubtype subtype = new DelegatedBlockSubtypeImpl(this, id, name);
        this.addSubtype(subtype);
        return subtype;
    }

    public BlockTypeImpl addDelegatedSubtype(final BlockSubtype subtype)
    {
        this.allSubtypes.add(subtype);
        return this;
    }

    @Override
    public void addSubtype(final BlockSubtype subtype)
    {
        this.subtypesByName.put(subtype.getSubtypeStringId(), subtype);
        this.subtypesById.put(subtype.getSubtypeId(), subtype);
        this.allSubtypes.add(subtype);
    }

    @Override
    public Collection<BlockSubtype> getSubtypes()
    {
        return this.unmodifableAllSubtypes;
    }

    @Override
    public BlockSubtype getDefaultSubtype()
    {
        return this.defaultSubtype;
    }

    @Override
    public void setDefaultSubtype(final BlockSubtype defaultSubtype)
    {
        this.defaultSubtype = defaultSubtype;
    }

    @Override
    public BlockSubtype asSubtype()
    {
        return this.defaultSubtype;
    }

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
