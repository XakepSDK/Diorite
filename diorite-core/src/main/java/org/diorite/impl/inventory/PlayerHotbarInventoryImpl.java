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

package org.diorite.impl.inventory;

import org.diorite.impl.inventory.item.IItemStack;
import org.diorite.impl.inventory.item.ItemStackImplArray;
import org.diorite.entity.Human;
import org.diorite.inventory.InventoryType;
import org.diorite.inventory.PlayerHotbarInventory;
import org.diorite.inventory.item.ItemStack;

public class PlayerHotbarInventoryImpl extends PlayerInventoryPartImpl implements PlayerHotbarInventory
{
    protected PlayerHotbarInventoryImpl(final PlayerInventoryImpl playerInventory)
    {
        //noinspection MagicNumber
        super(playerInventory, playerInventory.getArray().getSubArray(36, InventoryType.PLAYER_HOTBAR.getSize()));
    }

    public PlayerHotbarInventoryImpl(final PlayerInventoryImpl playerInventory, final ItemStackImplArray content)
    {
        super(playerInventory, content);
    }

    @Override
    public ItemStack getItemInHand()
    {
        final Human holder = this.getHolder();
        if (holder == null)
        {
            return null;
        }
        return this.content.get(holder.getHeldItemSlot());
    }

    @Override
    public ItemStack setItemInHand(final ItemStack stack)
    {
        final Human holder = this.getHolder();
        if (holder == null)
        {
            return null;
        }
        return this.content.getAndSet(holder.getHeldItemSlot(), IItemStack.wrap(stack));
    }

    @Override
    public boolean replaceItemInHand(final ItemStack excepted, final ItemStack stack) throws IllegalArgumentException
    {
        IItemStack.validate(excepted);
        final Human holder = this.getHolder();
        return (holder != null) && this.content.compareAndSet(holder.getHeldItemSlot(), (IItemStack) excepted, IItemStack.wrap(stack));
    }
}
