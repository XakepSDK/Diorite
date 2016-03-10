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

import org.diorite.material.AnySubtype;
import org.diorite.material.state.StateEntry;

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
     * Returns sub-id of block used in packets.
     *
     * @return sub-id of block used in packets.
     */
    @Override
    default int getProxySubtypeId()
    {
        return this.getSubtypeId();
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
     * @return state data of this subtype.
     */
    Collection<StateEntry<?>> getStates();

    /**
     * Returns normal/full type of this block subtype.
     *
     * @return normal/full type of this block subtype.
     */
    @Override
    BlockType getFullType();
}
