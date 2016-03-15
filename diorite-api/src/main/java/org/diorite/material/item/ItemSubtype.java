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

package org.diorite.material.item;

import java.util.Collections;
import java.util.List;

import org.diorite.material.AnySubtype;
import org.diorite.utils.math.DioriteRandomUtils;

public interface ItemSubtype extends ItemType, AnySubtype
{
    /**
     * Returns sub-id of item, like 3 for stone:diorite.
     *
     * @return sub-id of item, like 3 for stone:diorite.
     *
     * @see #getProxySubtypeId()
     */
    @Override
    int getSubtypeId();

    /**
     * Returns display name of item.
     *
     * @return display name of item.
     */
    @Override
    String getDisplayNameKey();

    @Override
    default List<? extends ItemSubtype> getProxySubtypes()
    {
        return Collections.emptyList();
    }

    @Override
    default ItemSubtype getProxySubtype()
    {
        final List<? extends ItemSubtype> proxySubtypes = this.getProxySubtypes();
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
     * Returns normal/full type of this item subtype.
     *
     * @return normal/full type of this item subtype.
     */
    @Override
    ItemType getFullType();
}
