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

import java.util.Collection;

/**
 * Represent type of block or item
 */
public interface AnyType
{
    /**
     * Returns numeric id used (not always, sometimes {@link #getMinecraftId()} is used) in save files, packets, etc.
     *
     * @return numeric id used (not always, sometimes {@link #getMinecraftId()} is used) in save files, packets, etc.
     *
     * @see #getProxyId()
     */
    int getId();

    /**
     * Returns id used in packets, used for adding fake types.
     *
     * @return id used in packets, used for adding fake types.
     */
    default int getProxyId()
    {
        return this.getId();
    }

    /**
     * Returns minecraft string id of types.
     *
     * @return minecraft string id of types.
     */
    String getMinecraftId();

    /**
     * Returns minecraft string id of type used in packets, used for adding fake types.
     *
     * @return minecraft string id of type used in packets, used for adding fake types.
     */
    default String getProxyMinecraftId()
    {
        return this.getMinecraftId();
    }

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    AnySubtype getSubtype(int id);

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    AnySubtype getSubtype(String id);

    /**
     * Returns collection of subtypes for this type.
     *
     * @return collection of subtypes for this type.
     */
    Collection<? extends AnySubtype> getSubtypes();

    /**
     * Returns display name of type.
     *
     * @return display name of type.
     */
    String getDisplayNameKey();

    /**
     * Returns true if given type is this same type as this type. (this method ignore subtypes)
     *
     * @return true if given type is this same type as this type. (this method ignore subtypes)
     */
    default boolean isThisSameType(final AnyType type)
    {
        return this.getId() == type.getId();
    }
}
