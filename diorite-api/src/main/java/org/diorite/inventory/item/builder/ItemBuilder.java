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

package org.diorite.inventory.item.builder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.Diorite;
import org.diorite.inventory.item.ItemStack;
import org.diorite.inventory.item.meta.ItemMeta;
import org.diorite.material.item.ItemType;

/**
 * Simple builder for item stack.
 */
public class ItemBuilder
{
    /**
     * Wrapped item stack used by builder.
     */
    protected ItemStack itemStack;

    /**
     * Construct new item builder for given type.
     *
     * @param type type of new item.
     */
    protected ItemBuilder(final ItemType type)
    {
        this.itemStack = Diorite.newItem(type);
    }

    /**
     * Construct new item builder for given item stack.
     *
     * @param itemStack source item stack to copy data to new builder.
     */
    protected ItemBuilder(final ItemStack itemStack)
    {
        this.itemStack = itemStack.clone();
    }

    /**
     * Set type of builder.
     *
     * @param type new type of item.
     *
     * @return builder for method chains.
     */
    public ItemBuilder type(final ItemType type)
    {
        this.itemStack.setType(type);
        return this;
    }

    /**
     * Set type of item.
     *
     * @param src source item to copy type from it.
     *
     * @return builder for method chains.
     */
    public ItemBuilder type(final ItemStack src)
    {
        this.itemStack.setType(src.getType());
        return this;
    }

    /**
     * Set amount of type of item.
     *
     * @param amount new amount of item.
     *
     * @return builder for method chains.
     */
    public ItemBuilder amount(final int amount)
    {
        this.itemStack.setAmount(amount);
        return this;
    }

    /**
     * Set amount of type of item.
     *
     * @param src source item to copy amount from it.
     *
     * @return builder for method chains.
     */
    public ItemBuilder amount(final ItemStack src)
    {
        this.itemStack.setAmount(src.getAmount());
        return this;
    }

    /**
     * Set meta data of this item.
     *
     * @param builder builder of meta data.
     *
     * @return builder for method chains.
     */
    public ItemBuilder meta(final IMetaBuilder<?, ?> builder)
    {
        this.itemStack.setItemMeta(builder.build());
        return this;
    }

    /**
     * Set meta data of this item.
     *
     * @param meta meta data to copy.
     *
     * @return builder for method chains.
     */
    public ItemBuilder meta(final ItemMeta meta)
    {
        this.itemStack.setItemMeta(meta.clone());
        return this;
    }

    /**
     * Returns created item stack from this builder.
     *
     * @return created item stack from this builder.
     */
    public ItemStack build()
    {
        return this.itemStack.clone();
    }

    /**
     * Start builder of itemstack of given type.
     *
     * @param type type of item stack to build.
     *
     * @return created item builder.
     */
    public static ItemBuilder start(final ItemType type)
    {
        return new ItemBuilder(type);
    }

    /**
     * Start builder based on given item stack
     *
     * @param itemStack basic item stack, builder will copy data from it.
     *
     * @return created item builder.
     */
    public static ItemBuilder start(final ItemStack itemStack)
    {
        return new ItemBuilder(itemStack);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("itemStack", this.itemStack).toString();
    }
}
