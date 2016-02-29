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

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.diorite.utils.SimpleEnum;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;
import org.diorite.utils.math.DioriteMathUtils;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/**
 * Items register class
 */
public final class Items
{
    private static final Int2ObjectMap<ItemType> byId       = new Int2ObjectOpenHashMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);
    private static final Map<String, ItemType>   byStringId = new CaseInsensitiveMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);

    private Items()
    {
    }

    public static ItemSubtype getItemSubtype(final int id, final int meta)
    {
        final ItemType itemType = byId.get(id);
        return (itemType == null) ? null : itemType.getSubtype(meta);
    }

    public static ItemSubtype getItemSubtype(final int id, final String meta)
    {
        final ItemType itemType = byId.get(id);
        return (itemType == null) ? null : itemType.getSubtype(meta);
    }

    public static ItemType getItemType(final int id)
    {
        return byId.get(id);
    }

    public static ItemType getItemType(final String id)
    {
        return byStringId.get(id);
    }

    public static ItemSubtype getItemSubtype(final int id)
    {
        final ItemType itemType = byId.get(id);
        return (itemType == null) ? null : itemType.asSubtype();
    }

    public static ItemSubtype getItemSubtype(final String id)
    {
        final ItemType itemType = byStringId.get(id);
        return (itemType == null) ? null : itemType.asSubtype();
    }

    public static ItemSubtype getItemSubtype(final String id, final int meta)
    {
        final ItemType itemType = byStringId.get(id);
        return (itemType == null) ? null : itemType.getSubtype(meta);
    }

    public static ItemSubtype getItemSubtype(final String id, final String meta)
    {
        final ItemType itemType = byStringId.get(id);
        return (itemType == null) ? null : itemType.getSubtype(meta);
    }

    public static void registerItem(final ItemType itemType)
    {
        byId.put(itemType.getId(), itemType);
        byStringId.put(itemType.getMinecraftId(), itemType);
    }

    /**
     * Method will try to find itemType by given name, converting it to any possible type of id: <br>
     * <ul>
     * <li>{numericId} {@literal ->} like "1" for stone</li>
     * <li>{minecraftStringId} {@literal ->} like "minecraft:stone"</li>
     * <li>minecraft:{shortMinecraftStringId} {@literal ->} like "stone"</li>
     * <li>{numericId}:{numericMeta} {@literal ->} like "1:0"</li>
     * <li>{numericId}:{stringMeta} {@literal ->} like "1:diorite"</li>
     * <li>{minecraftStringId}:{numericMeta} {@literal ->} like "minecraft:stone:diorite"</li>
     * <li>minecraft:{shortMinecraftStringId}:{stringMeta} {@literal ->} like "stone:diorite"</li>
     * </ul>
     * With extended mode it will also scan all itemType and looks for sub-itemType with name equals to given string
     * multiple types may have this same sub-itemType name, so may not return valid itemType for types like that.
     *
     * @param string item type name/id to find.
     *
     * @return item type or null if it didn't find any.
     */
    public static ItemSubtype matchItemType(String string)
    {
        string = StringUtils.replace(string, " ", "_");

        // using simple id
        final Integer i = DioriteMathUtils.asInt(string);
        if (i != null)
        {
            return getItemSubtype(i);
        }

        // find in enum by whole string
        ItemSubtype result = getItemSubtype(string);
        if ((result != null) || (((result = getItemSubtype("minecraft:" + string))) != null))
        {
            return result;
        }

        // split to [id, meta], where meta can't contains any ":"
        final int index = string.lastIndexOf(':');
        if (index == - 1)
        {
            for (final ItemType m : byId.values())
            {
                result = m.getSubtype(string);
                if (result != null)
                {
                    return result;
                }
            }

            // :<
            return null;
        }
        final String idPart = string.substring(0, index);
        final String metaPart = string.substring(index + 1);
        final Integer id = DioriteMathUtils.asInt(idPart);
        final Integer meta = DioriteMathUtils.asInt(metaPart);

        // by numeric id, and numeric or text meta.
        if (id != null)
        {
            return (meta != null) ? getItemSubtype(id, meta) : getItemSubtype(id, metaPart);
        }

        if (meta != null)
        {
            result = getItemSubtype(idPart, meta);
            if ((result != null) || (((result = getItemSubtype("minecraft:" + idPart, meta))) != null))
            {
                return result;
            }
        }
        result = getItemSubtype(idPart, metaPart);
        if ((result != null) || (((result = getItemSubtype("minecraft:" + idPart, metaPart))) != null))
        {
            return result;
        }

        // :<
        return null;
    }
}
