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

import java.util.Map;

import org.diorite.utils.SimpleEnum;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/**
 * Blocks register class.
 */
public final class Blocks
{
    private static final Int2ObjectMap<BlockType> byId       = new Int2ObjectOpenHashMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);
    private static final Map<String, BlockType>   byStringId = new CaseInsensitiveMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);

    private static final Int2ObjectMap<BlockSubtype> sybtypeById = new Int2ObjectOpenHashMap<>(300, SimpleEnum.SMALL_LOAD_FACTOR);

    private Blocks()
    {
    }

    public static BlockSubtype getBlockSubtype(final int id, final int meta)
    {
        return sybtypeById.get((id << 4) | meta);
    }

    public static BlockSubtype getBlockSubtypeByIdAndMeta(final int id)
    {
        return sybtypeById.get(id);
    }

    public static BlockType getBlockType(final int id)
    {
        return byId.get(id);
    }

    public static BlockType getBlockType(final String id)
    {
        return byStringId.get(id);
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
}
