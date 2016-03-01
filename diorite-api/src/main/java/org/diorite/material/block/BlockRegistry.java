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
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.diorite.utils.SimpleEnum;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;
import org.diorite.utils.math.DioriteMathUtils;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/**
 * Blocks register class.
 */
public final class BlockRegistry
{
    private static final Int2ObjectMap<BlockType> byId       = new Int2ObjectOpenHashMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);
    private static final Map<String, BlockType>   byStringId = new CaseInsensitiveMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);

    private static final Int2ObjectMap<BlockSubtype> sybtypeById = new Int2ObjectOpenHashMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);

    private BlockRegistry()
    {
    }

    public static BlockSubtype getBlockSubtypeByIdAndMeta(final int id)
    {
        return sybtypeById.get(id);
    }

    public static BlockSubtype getBlockSubtype(final int id, final int meta)
    {
        final BlockType blockType = byId.get(id);
        return (blockType == null) ? null : blockType.getSubtype(meta);
    }

    public static BlockSubtype getBlockSubtype(final int id, final String meta)
    {
        final BlockType blockType = byId.get(id);
        return (blockType == null) ? null : blockType.getSubtype(meta);
    }

    public static BlockType getBlockType(final int id)
    {
        return byId.get(id);
    }

    public static BlockType getBlockType(final String id)
    {
        return byStringId.get(id);
    }

    public static BlockSubtype getBlockSubtype(final int id)
    {
        final BlockType blockType = byId.get(id);
        return (blockType == null) ? null : blockType.asSubtype();
    }

    public static BlockSubtype getBlockSubtype(final String id)
    {
        final BlockType blockType = byStringId.get(id);
        return (blockType == null) ? null : blockType.asSubtype();
    }

    public static BlockSubtype getBlockSubtype(final String id, final int meta)
    {
        final BlockType blockType = byStringId.get(id);
        return (blockType == null) ? null : blockType.getSubtype(meta);
    }

    public static BlockSubtype getBlockSubtype(final String id, final String meta)
    {
        final BlockType blockType = byStringId.get(id);
        return (blockType == null) ? null : blockType.getSubtype(meta);
    }

    public static void registerBlock(final BlockType blockType)
    {
        byId.put(blockType.getId(), blockType);
        byStringId.put(blockType.getMinecraftId(), blockType);

        for (final BlockSubtype blockSubtype : blockType.getSubtypes())
        {
            sybtypeById.put(blockSubtype.getTypeAndSubtypeId(), blockSubtype);
        }
    }

    public static Collection<? extends BlockType> getBlockTypes()
    {
        return byId.values();
    }

    public static Collection<? extends BlockSubtype> getAllBlockSubtypes()
    {
        return sybtypeById.values();
    }

    /**
     * Method will try to find blockType by given name, converting it to any possible type of id: <br>
     * <ul>
     * <li>{numericId} {@literal ->} like "1" for stone</li>
     * <li>{minecraftStringId} {@literal ->} like "minecraft:stone"</li>
     * <li>minecraft:{shortMinecraftStringId} {@literal ->} like "stone"</li>
     * <li>{numericId}:{numericMeta} {@literal ->} like "1:0"</li>
     * <li>{numericId}:{stringMeta} {@literal ->} like "1:diorite"</li>
     * <li>{minecraftStringId}:{numericMeta} {@literal ->} like "minecraft:stone:diorite"</li>
     * <li>minecraft:{shortMinecraftStringId}:{stringMeta} {@literal ->} like "stone:diorite"</li>
     * </ul>
     * With extended mode it will also scan all blockType and looks for sub-blockType with name equals to given string
     * multiple types may have this same sub-blockType name, so may not return valid blockType for types like that.
     *
     * @param string blockType name/id to find.
     *
     * @return blockType or null if it didn't find any.
     */
    public static BlockSubtype matchBlockType(String string)
    {
        string = StringUtils.replace(string, " ", "_");

        // using simple id
        final Integer i = DioriteMathUtils.asInt(string);
        if (i != null)
        {
            return getBlockSubtype(i);
        }

        // find in enum by whole string
        BlockSubtype result = getBlockSubtype(string);
        if ((result != null) || (((result = getBlockSubtype("minecraft:" + string))) != null))
        {
            return result;
        }

        // split to [id, meta], where meta can't contains any ":"
        final int index = string.lastIndexOf(':');
        if (index == - 1)
        {
            for (final BlockType m : byId.values())
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
            return (meta != null) ? getBlockSubtype(id, meta) : getBlockSubtype(id, metaPart);
        }

        if (meta != null)
        {
            result = getBlockSubtype(idPart, meta);
            if ((result != null) || (((result = getBlockSubtype("minecraft:" + idPart, meta))) != null))
            {
                return result;
            }
        }
        result = getBlockSubtype(idPart, metaPart);
        if ((result != null) || (((result = getBlockSubtype("minecraft:" + idPart, metaPart))) != null))
        {
            return result;
        }

        // :<
        return null;
    }
}
