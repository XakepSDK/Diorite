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

import java.util.Collection;

import org.diorite.inventory.item.meta.ItemMeta;
import org.diorite.material.AnyType;

/**
 * Represent item type.
 */
public interface ItemType extends AnyType
{
    /**
     * Default max stack size.
     */
    int DEFAULT_STACK_SIZE = 64;

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
     * Returns minecraft string id of item.
     *
     * @return minecraft string id of item.
     */
    @Override
    String getMinecraftId();

    /**
     * Returns max size of single itemstack of this item, vanilla clinets can handle values only in byte range.
     *
     * @return max size of single itemstack of this item, vanilla clinets can handle values only in byte range.
     */
    int getMaxStack();

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    ItemSubtype getSubtype(int id);

    /**
     * Returns subtype by given id.
     *
     * @param id id of subtype.
     *
     * @return subtype by given id.
     */
    @Override
    ItemSubtype getSubtype(String id);

    /**
     * Returns collection of subtypes for this item.
     *
     * @return collection of subtypes for this item.
     */
    @Override
    Collection<? extends ItemSubtype> getSubtypes();

    /**
     * Returns default subtype of item.
     *
     * @return default subtype of item.
     */
    ItemSubtype asSubtype();

    /**
     * Returns type of ItemMeta used by this material.
     *
     * @return type of ItemMeta used by this material.
     */
    Class<? extends ItemMeta> getMetaType();

}
