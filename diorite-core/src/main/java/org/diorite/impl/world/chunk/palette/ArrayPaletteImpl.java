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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.impl.CoreMain;
import org.diorite.impl.connection.packets.PacketDataSerializer;
import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.BlockType;
import org.diorite.material.block.BlockRegistry;
import org.diorite.material.block.Blocks;
import org.diorite.utils.math.DioriteMathUtils;

public class ArrayPaletteImpl implements PaletteData
{
    private static final int SIZE = 16;

    protected final BlockSubtype[] pattern;
    protected int lastIndex = 1;

    public ArrayPaletteImpl()
    {
        this.pattern = new BlockSubtype[SIZE];
        this.pattern[0] = Blocks.AIR.asSubtype();
    }

    private ArrayPaletteImpl(final BlockSubtype[] pattern)
    {
        this.pattern = pattern;
    }

    protected static int getIdAndMeta(final BlockSubtype subtype)
    {
        return ((subtype.getId() << 4) | subtype.getSubtypeId());
    }

    @Override
    public int put(final BlockType d)
    {
        final BlockSubtype data = d.asSubtype();
        final BlockSubtype[] pattern = this.pattern;
        for (int i = 0; i < this.lastIndex; i++)
        {
            final BlockSubtype materialData = pattern[i];
            if (getIdAndMeta(materialData) == getIdAndMeta(data))
            {
                return i;
            }
        }
        if (this.lastIndex >= pattern.length)
        {
            return - 1;
        }
        final int index = this.lastIndex++;
        pattern[index] = data;
        return index;
    }

    @Override
    public int put(final int minecraftIDandData)
    {
        final BlockSubtype[] pattern = this.pattern;
        for (int i = 0; i < this.lastIndex; i++)
        {
            final BlockSubtype materialData = pattern[i];
            if (getIdAndMeta(materialData) == minecraftIDandData)
            {
                return i;
            }
        }
        if (this.lastIndex >= this.pattern.length)
        {
            return - 1;
        }
        BlockSubtype mat = BlockRegistry.getBlockSubtype(minecraftIDandData >> 4, minecraftIDandData & 15);
        if (mat == null)
        {
            mat = BlockRegistry.getBlockSubtype(minecraftIDandData >> 4);
            if (mat == null)
            {
                mat = Blocks.AIR.asSubtype();
//                throw new IllegalArgumentException("Unknown itemSubtype: " + minecraftIDandData + " (" + (minecraftIDandData >> 4) + ":" + (minecraftIDandData & 15) + ")");
            }
        }
        final int index = this.lastIndex++;
        pattern[index] = mat;
        return index;
    }

    @Override
    public int getAsInt(final int sectionID)
    {
        final BlockSubtype mat = this.pattern[sectionID];
        if (mat == null)
        {
            return 0;
        }
        return getIdAndMeta(mat);
    }

    @Override
    public BlockSubtype get(final int sectionID)
    {
        final BlockSubtype mat = this.pattern[sectionID];
        if (mat == null)
        {
            return Blocks.AIR.asSubtype();
        }
        return mat;
    }

    @Override
    public int size()
    {
        return this.lastIndex;
    }

    @Override
    public int bitsPerBlock()
    {
        return 4;
    }

    @Override
    public int byteSize()
    {
        int bytes = DioriteMathUtils.varintSize(this.lastIndex);
        for (int var2 = 0; var2 < this.lastIndex; ++ var2)
        {
            bytes += DioriteMathUtils.varintSize(getIdAndMeta(this.pattern[var2]));
        }
        return bytes;
    }

    @Override
    public void write(final PacketDataSerializer data)
    {
        if (CoreMain.isEnabledDebug()) // TODO: remove
        {
            int i = 0;
            data.writeVarInt(this.lastIndex);
            for (final BlockSubtype materialData : this.pattern)
            {
                if (materialData == null)
                {
                    break;
                }
                i++;
                data.writeVarInt(getIdAndMeta(materialData));
            }
            if (this.lastIndex != i)
            {
                throw new AssertionError("Fail");
            }
            return;
        }
        data.writeVarInt(this.lastIndex);
        for (final BlockSubtype materialData : this.pattern)
        {
            if (materialData == null)
            {
                break;
            }
            data.writeVarInt(getIdAndMeta(materialData));
        }
    }

    @Override
    public void read(final PacketDataSerializer data)
    {
        final int size = data.readVarInt();
        for (int i = 0; i < size; i++)
        {
            final int id = data.readVarInt();
            final BlockSubtype mat = BlockRegistry.getBlockSubtype(id >> 4, id & 15);
            if (mat == null)
            {
                throw new IllegalArgumentException("Unknown itemSubtype: " + id + " (" + (id >> 4) + ":" + (id & 15) + ")");
            }
            this.pattern[i] = mat;
        }
    }

    @Override
    public PaletteData getNext()
    {
        return new MapPaletteImpl(this);
    }

    @Override
    public ArrayPaletteImpl clone()
    {
        return new ArrayPaletteImpl(this.pattern.clone());
    }

//    @Override
//    public void clear()
//    {
//        Arrays.fill(this.pattern, - 1);
//    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("pattern", this.pattern).toString();
    }
}
