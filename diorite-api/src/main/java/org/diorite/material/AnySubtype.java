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

package org.diorite.material;

import java.util.Collections;
import java.util.List;

import org.diorite.utils.math.DioriteRandomUtils;

/**
 * Represent subtype of block or item.
 */
public interface AnySubtype extends AnyType
{
    /**
     * Returns sub-id of type, like 3 for stone:diorite.
     *
     * @return sub-id of type, like 3 for stone:diorite.
     *
     * @see #getProxySubtypeId()
     */
    int getSubtypeId();

    /**
     * Returns display name of type.
     *
     * @return display name of type.
     */
    String getDisplayNameKey();

    /**
     * Returns list of proxy subtypes.
     *
     * @return list of proxy subtypes.
     */
    default List<? extends AnySubtype> getProxySubtypes()
    {
        return Collections.emptyList();
    }

    /**
     * Return subtype that should be send in packet.
     *
     * @return subtype that should be send in packet.
     */
    default AnySubtype getProxySubtype()
    {
        final List<? extends AnySubtype> proxySubtypes = this.getProxySubtypes();
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
    String getSubtypeStringId();

    /**
     * Returns normal type of this subtype.
     *
     * @return normal type of this subtype.
     */
    AnyType getFullType();
}
