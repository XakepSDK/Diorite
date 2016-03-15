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

import org.diorite.BlockLocation;
import org.diorite.entity.Entity;
import org.diorite.material.AnyType;
import org.diorite.material.state.State;
import org.diorite.material.state.StateEntry;

/**
 * Represent block data
 */
public interface BlockType extends AnyType
{
    /**
     * Returns numeric id used (not always, sometimes {@link #getMinecraftId()} is used) in save files, packets, etc.
     *
     * @return numeric id used (not always, sometimes {@link #getMinecraftId()} is used) in save files, packets, etc.
     *
     * @see #getProxyId()
     */
    @Override
    int getId();

    /**
     * Returns minecraft string id of block.
     *
     * @return minecraft string id of block.
     */
    @Override
    String getMinecraftId();

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    BlockSubtype getSubtype(int id);

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    BlockSubtype getSubtype(String id);

    /**
     * Get subtype of block by BlockState and value of it. <br>
     * If state isn't supported by this object, or value isn't in valid range, current subtype or {@link #getDefaultSubtype()} will be returned.
     *
     * @param state state of block.
     * @param value value of block state.
     * @param <T>   type of BlockState value.
     *
     * @return some subtype of block.
     */
    default <T> BlockSubtype getSubtype(final State<T> state, final T value)
    {
        return this.getSubtype(this.getDefaultSubtype(), new StateEntry<>(state, value));
    }

    /**
     * Get subtype of block by BlockState and value of it. <br>
     * If state isn't supported by this object, or value isn't in valid range, current subtype or {@link #getDefaultSubtype()} will be returned.
     *
     * @param entires block states of subtype.
     * @param <T>     type of BlockState value.
     *
     * @return some subtype of block.
     */
    default BlockSubtype getSubtype(final StateEntry<?>... entires)
    {
        return this.getSubtype(this.getDefaultSubtype(), entires);
    }

    /**
     * Get subtype of block by BlockState and value of it. <br>
     * If state isn't supported by this object, or value isn't in valid range, default subtype will be returned.
     *
     * @param state state of block.
     * @param value value of block state.
     * @param def   default subtype to return.
     * @param <T>   type of BlockState value.
     *
     * @return some subtype of block.
     */
    default <T> BlockSubtype getSubtype(final State<T> state, final T value, final BlockSubtype def)
    {
        return this.getSubtype(new StateEntry<>(state, value));
    }

    /**
     * Get subtype of block by BlockState and value of it. <br>
     * If state isn't supported by this object, or value isn't in valid range, default subtype will be returned.
     *
     * @param def     default subtype to return.
     * @param entires block states of subtype.
     * @param <T>     type of BlockState value.
     *
     * @return some subtype of block.
     */
    BlockSubtype getSubtype(final BlockSubtype def, StateEntry<?>... entires);

    /**
     * Adds new subtype to this block.
     *
     * @param subtype new subtype of block.
     */
    void addSubtype(BlockSubtype subtype);

    /**
     * Returns collection of subtypes for this block.
     *
     * @return collection of subtypes for this block.
     */
    @Override
    Collection<? extends BlockSubtype> getSubtypes();

    /**
     * Returns default subtype of this block type.
     *
     * @return default subtype of this block type.
     */
    BlockSubtype getDefaultSubtype();

    /**
     * Set default subtype of this block type.
     *
     * @param defaultSubtype new default subtype of this block.
     */
    void setDefaultSubtype(BlockSubtype defaultSubtype);

    /**
     * Returns default subtype of block.
     *
     * @return default subtype of block.
     */
    @Override
    BlockSubtype asSubtype();

    /**
     * Returns true if given entity is colliding with block at given position.
     *
     * @param blockLocation location of block.
     * @param entity        entity to be checked.
     *
     * @return true if given entity is colliding with block at given position.
     */
    default boolean isCollidingWith(final BlockLocation blockLocation, final Entity entity)
    {
        return this.isCollidingWith(blockLocation.getX(), blockLocation.getY(), blockLocation.getZ(), entity);
    }

    /**
     * Returns true if given entity is colliding with block at given position.
     *
     * @param x      x coordinates of block.
     * @param y      y coordinates of block.
     * @param z      z coordinates of block.
     * @param entity entity to be checked.
     *
     * @return true if given entity is colliding with block at given position.
     */
    boolean isCollidingWith(int x, int y, int z, Entity entity);
}
