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

package org.diorite.impl.world.generator;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.impl.world.chunk.ChunkBlockData;
import org.diorite.impl.world.chunk.ChunkImpl;
import org.diorite.impl.world.chunk.ChunkPartImpl;
import org.diorite.impl.world.chunk.palette.PaletteImpl;
import org.diorite.material.block.BlockRegistry;
import org.diorite.material.block.BlockSubtype;
import org.diorite.material.block.BlockType;
import org.diorite.material.block.Blocks;
import org.diorite.world.chunk.Chunk;
import org.diorite.world.generator.BiomeGrid;
import org.diorite.world.generator.ChunkBuilder;
import org.diorite.world.generator.maplayer.MapLayer;

public class ChunkBuilderImpl implements ChunkBuilder
{
    private final ChunkPartBuilder[] chunkParts = new ChunkPartBuilder[Chunk.CHUNK_PARTS]; // size of 16, parts can be null
    private MapLayer[] biomesInput;
    private BiomeGrid  biomeGrid;

    public ChunkBuilderImpl(final MapLayer[] biomesInput)
    {
        this.biomesInput = biomesInput;
    }

    @Override
    public MapLayer[] getBiomesInput()
    {
        return this.biomesInput;
    }

    @Override
    public void setBiomesInput(final MapLayer[] biomesInput)
    {
        this.biomesInput = biomesInput;
    }

    public ChunkPartBuilder[] getChunkParts()
    {
        return this.chunkParts;
    }

    @Override
    public BiomeGrid getBiomeGrid()
    {
        return this.biomeGrid;
    }

    @Override
    public void setBiomeGrid(final BiomeGrid biomeGrid)
    {
        this.biomeGrid = biomeGrid;
    }

    @Override
    public void setBlock(final int x, final int y, final int z, final BlockType materialData)
    {
        final byte chunkPosY = (byte) (y >> 4);
        ChunkPartBuilder chunkPart = this.chunkParts[chunkPosY];
        if (chunkPart == null)
        {
            chunkPart = new ChunkPartBuilder(this, chunkPosY);
            this.chunkParts[chunkPosY] = chunkPart;
        }
        chunkPart.setBlock(x, y % Chunk.CHUNK_PART_HEIGHT, z, materialData);
    }

//    @Override
//    public void setBlock(final int x, final int y, final int z, final int id, final int meta)
//    {
//        final byte chunkPosY = (byte) (y >> 4);
//        ChunkPartBuilder chunkPart = this.chunkParts[chunkPosY];
//        if (chunkPart == null)
//        {
//            chunkPart = new ChunkPartBuilder(this, chunkPosY);
//            this.chunkParts[chunkPosY] = chunkPart;
//        }
//        chunkPart.setBlock(x, y % Chunk.CHUNK_PART_HEIGHT, z, id, meta);
//    }

    @Override
    public BlockSubtype getBlockType(final int x, final int y, final int z)
    {
        final byte chunkPosY = (byte) (y >> 4);
        final ChunkPartBuilder chunkPart = this.chunkParts[chunkPosY];
        if (chunkPart == null)
        {
            return Blocks.AIR.asSubtype();
        }
        return chunkPart.getBlockType(x, y % Chunk.CHUNK_PART_HEIGHT, z);
    }

    @Override
    public void init(final Chunk bChunk)
    {
        final ChunkImpl chunk = (ChunkImpl) bChunk;
        final ChunkPartImpl[] chunkParts = new ChunkPartImpl[this.chunkParts.length];
        final ChunkPartBuilder[] chunkPartBuilders = this.chunkParts;
        for (int i = 0, buildersLength = chunkPartBuilders.length; i < buildersLength; i++)
        {
            final ChunkPartBuilder chunkPart = chunkPartBuilders[i];
            if (chunkPart == null)
            {
                continue;
            }
            chunkParts[i] = new ChunkPartImpl(chunkPart.blockData, chunkPart.blockDataProxy, chunkPart.palette, (byte) i, chunk.getWorld().getDimension().hasSkyLight(), chunkPart.nonEmptyBlockCount);
//            chunkParts[i].recalculateBlockCount();
        }
        chunk.setChunkParts(chunkParts);
        chunk.initHeightMap();
        chunk.setBiomes(this.biomeGrid.rawData().clone());
        chunk.init();
    }

    private static class ChunkPartBuilder // part of chunk 16x16x16
    {
        public static final int CHUNK_DATA_SIZE = Chunk.CHUNK_SIZE * Chunk.CHUNK_PART_HEIGHT * Chunk.CHUNK_SIZE;
        private final ChunkBuilderImpl chunk;
        private final PaletteImpl      palette;
        private final ChunkBlockData   blockData;
        private       ChunkBlockData   blockDataProxy;
        private final byte             yPos; // from 0 to 15
        private       int              nonEmptyBlockCount;

        private ChunkPartBuilder(final ChunkBuilderImpl chunk, final byte yPos)
        {
            this.chunk = chunk;
            this.yPos = yPos;
            this.palette = new PaletteImpl();
            this.blockData = new ChunkBlockData(this.palette.bitsPerBlock(), CHUNK_DATA_SIZE);
        }

        @SuppressWarnings("ObjectEquality")
        private void setBlock(final int x, final int y, final int z, final BlockType type)
        {
            final BlockSubtype blockSubtype = type.asSubtype();
            final BlockSubtype proxySubtype = blockSubtype.getProxySubtype();
            final BlockSubtype old = this.getBlockType(x, y, z);
            final int realId = blockSubtype.getId();
            final int realMeta = blockSubtype.getSubtypeId();
            if ((realId == old.getId()) && (realMeta == old.getSubtypeId()))
            {
                return;
            }
            if ((old.getId() == 0) && (realId != 0))
            {
                this.nonEmptyBlockCount++;
            }
            else if ((old.getId() != 0) && (realId == 0))
            {
                this.nonEmptyBlockCount--;
            }
            final int realRawData = this.palette.put(realId, (byte) realMeta);
            this.blockData.set(toArrayIndex(x, y, z), realRawData);
            if (blockSubtype == proxySubtype)
            {
                return;
            }
            if (this.blockDataProxy == null)
            {
                this.blockDataProxy = this.blockData.clone();
            }
            final int proxyId = proxySubtype.getId();
            final int proxyMeta = proxySubtype.getSubtypeId();
            final int proxyRawData = this.palette.put(proxyId, (byte) proxyMeta);
            this.blockDataProxy.set(toArrayIndex(x, y, z), realRawData);
        }

        @SuppressWarnings("MagicNumber")
        private BlockSubtype getBlockType(final int x, final int y, final int z)
        {
            final int data = this.blockData.getAsInt(toArrayIndex(x, y, z), this.palette);
            final BlockSubtype blockSubtype = BlockRegistry.getBlockSubtype(data >> 4, data & 15);
            if (blockSubtype == null)
            {
                return Blocks.AIR.asSubtype();
            }
            return blockSubtype;
        }

        @SuppressWarnings("MagicNumber")
        private static int toArrayIndex(final int x, final int y, final int z)
        {
            return ((y & 0xf) << 8) | (z << 4) | x;
        }

        @Override
        public String toString()
        {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("chunk", this.chunk).append("yPos", this.yPos).toString();
        }

        public int recalculateBlockCount()
        {
            this.nonEmptyBlockCount = 0;

            for (int i = 0; i < CHUNK_DATA_SIZE; i++)
            {
                final BlockSubtype type = this.blockData.get(i, this.palette);
                if ((type != null) && ! type.isThisSameType(Blocks.AIR))
                {
                    this.nonEmptyBlockCount++;
                }
            }
            return this.nonEmptyBlockCount;
        }

        public int getBlocksCount()
        {
            return this.nonEmptyBlockCount;
        }
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).toString();
    }
}
