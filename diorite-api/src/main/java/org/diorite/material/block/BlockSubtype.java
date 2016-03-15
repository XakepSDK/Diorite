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

package org.diorite.material.block;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.diorite.material.AnySubtype;
import org.diorite.material.data.drops.PossibleDrops;
import org.diorite.material.item.ItemSubtype;
import org.diorite.material.state.StateEntry;
import org.diorite.utils.math.DioriteRandomUtils;
import org.diorite.world.TileEntity;

/**
 * Represent block subtype.
 */
public interface BlockSubtype extends BlockType, AnySubtype
{
    /**
     * Returns sub-id of block, like 3 for stone:diorite.
     *
     * @return sub-id of block, like 3 for stone:diorite.
     *
     * @see #getProxySubtypeId()
     */
    @Override
    int getSubtypeId();

    /**
     * Returns display name of block.
     *
     * @return display name of block.
     */
    @Override
    String getDisplayNameKey();

    @Override
    default List<? extends BlockSubtype> getProxySubtypes()
    {
        return Collections.emptyList();
    }

    @Override
    default BlockSubtype getProxySubtype()
    {
        final List<? extends BlockSubtype> proxySubtypes = this.getProxySubtypes();
        if (proxySubtypes.isEmpty())
        {
            return this;
        }
        final int size = proxySubtypes.size();
        return (size == 1) ? proxySubtypes.get(0) : proxySubtypes.get(DioriteRandomUtils.nextInt(size));
    }

    /**
     * Returns string id for this subtype, like "diorite" for "minecraft:stone:diorite" (not supported by vanilla clients, used by diorite commands etc.)
     *
     * @return string id for this subtype, like "diorite" for "minecraft:stone:diorite" (not supported by vanilla clients, used by diorite commands etc.)
     */
    @Override
    String getSubtypeStringId();

    /**
     * Returns id of type and subtype as one int.
     *
     * @return id of type and subtype as one int.
     */
    default int getTypeAndSubtypeId() // (id << 4) | subId
    {
        return (this.getId() << 4) | this.getSubtypeId();
    }

    /**
     * Returns state data of this subtype.
     *
     * @return state data of this subtype.
     */
    Collection<StateEntry<?>> getStates();

    /**
     * Returns item for this block if exists.
     *
     * @return item for this block if exists.
     */
    ItemSubtype getItem();

    /**
     * Returns possible drops of this block.
     *
     * @return possible drops of this block.
     */
    PossibleDrops getDrops();

    /**
     * Returns sounds pack for this block.
     *
     * @return sounds pack for this block.
     */
    BlockSounds getSounds();

    /**
     * Returns hardness of block.
     *
     * @return hardness of block.
     */
    double getHardness();

    /**
     * Returns hardness of block.
     *
     * @return hardness of block.
     */
    double getBlastResistance();

    /**
     * Returns true if this block is solid.
     *
     * @return true if this block is solid.
     */
    boolean isSolid();

    /**
     * Retruns liquid related block parameters.
     *
     * @return liquid related block parameters.
     */
    LiquidSettings getLiquidSettings();

//    /**
//     * Override block {@link LiquidSettings}.
//     *
//     * @param settings new parameters to use.
//     */
//    void setLiquidSettings(LiquidSettings settings);

    /**
     * Retruns light related block parameters.
     *
     * @return light related block parameters.
     */
    LightSettings getLightSettings();

//    /**
//     * Override block {@link LightSettings}.
//     *
//     * @param settings new parameters to use.
//     */
//    void setLightSettings(LightSettings settings);

    /**
     * Retruns fire related block parameters.
     *
     * @return fire related block parameters.
     */
    FlameableSettings getFlameableSettings();

//    /**
//     * Override block {@link FlameableSettings}.
//     *
//     * @param settings new parameters to use.
//     */
//    void setFlameableSettings(FlameableSettings settings);

    /**
     * Returns interact handler.
     *
     * @return interact handler.
     */
    BlockInteractHandler getInteractHandler();

    /**
     * Returns true if this block is tile entity.
     *
     * @return true if this block is tile entity.
     */
    boolean isTileEntity();

    /**
     * Returns normal/full type of this block subtype.
     *
     * @return normal/full type of this block subtype.
     */
    @Override
    BlockType getFullType();

    /**
     * Returns type of tile entity, returns null if block isn't tile entity.
     *
     * @return type of tile entity, returns null if block isn't tile entity.
     */
    Class<? extends TileEntity> getTileEntityClass();
}
