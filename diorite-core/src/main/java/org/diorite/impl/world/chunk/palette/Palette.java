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

package org.diorite.impl.world.chunk.palette;

import org.diorite.impl.connection.packets.PacketDataSerializer;
import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.BlockType;
import org.diorite.material.block.BlockRegistry;
import org.diorite.material.block.Blocks;

public interface Palette
{
    Palette getNext();

//    void clear();

    int put(int minecraftIDandData); // returns -1 if id failed to add as pattern can't fit more ids

    default int put(final int minecraftID, final byte minecafrData)
    {
        return this.put(((minecraftID << 4) | minecafrData));
    }

    default int put(final BlockType data)
    {
        final BlockSubtype blockSubtype = data.asSubtype();
        return this.put(((blockSubtype.getId() << 4) | blockSubtype.getSubtypeId()));
    }

    int getAsInt(int sectionID);

    default BlockSubtype get(final int sectionID)
    {
        final int data = this.getAsInt(sectionID);
        final BlockSubtype mat = BlockRegistry.getBlockSubtype(data >> 4, data & 15);
        if (mat == null)
        {
            return Blocks.AIR.asSubtype();
        }
        return mat;
    }

    int size();

    int bitsPerBlock();

    int byteSize();

    void write(PacketDataSerializer data);
}
