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

import java.util.Collection;
import java.util.Set;

import org.diorite.inventory.item.meta.ToolMeta;
import org.diorite.material.block.BlockType;

/**
 * Interface of builder of tool item meta data.
 *
 * @param <B> type of builder.
 * @param <M> type of item meta.
 */
public interface IToolMetaBuilder<B extends IToolMetaBuilder<B, M>, M extends ToolMeta> extends IRepairableMetaBuilder<B, M>
{
    /**
     * Set if this tool is using CanDestory tag,
     * when you set it to false, add saved blocks will be removed.
     *
     * @param useCanDestoryTag if this tool should use CanDestory tag.
     *
     * @return builder for method chains.
     */
    default B setUseCanDestoryTag(final boolean useCanDestoryTag)
    {
        this.meta().setUseCanDestoryTag(useCanDestoryTag);
        return this.getBuilder();
    }

    /**
     * Set if this tool is using CanDestory tag,
     * when you set it to false, add saved blocks will be removed.
     *
     * @param src source item meta to copy state from it.
     *
     * @return builder for method chains.
     */
    default B setUseCanDestoryTag(final ToolMeta src)
    {
        this.meta().setUseCanDestoryTag(src.useCanDestoryTag());
        return this.getBuilder();
    }

    /**
     * Set blocks that can be destroyed by this tool. <br>
     * Minecraft don't support subtypes here, but diorite will save subtypes in separate tag.
     * (Vanilla client can't see them)
     *
     * @param blocks new collection of blocks.
     *
     * @return builder for method chains.
     */
    default B setCanDestoryBlocks(final Collection<BlockType> blocks)
    {
        this.meta().setCanDestoryBlocks(blocks);
        return this.getBuilder();
    }

    /**
     * Set blocks that can be destroyed by this tool. <br>
     * Minecraft don't support subtypes here, but diorite will save subtypes in separate tag.
     * (Vanilla client can't see them)
     *
     * @param src source item meta to copy data from it.
     *
     * @return builder for method chains.
     */
    default B setCanDestoryBlocks(final ToolMeta src)
    {
        final Set<BlockType> data = src.getCanDestoryBlocks();
        if (data == null)
        {
            return this.getBuilder();
        }
        this.meta().setCanDestoryBlocks(data);
        return this.getBuilder();
    }

    /**
     * Add new block that can be destroyed by this tool,
     * this method will automatically enable CanDestory tag if needed. <br>
     * Minecraft don't support subtypes here.
     *
     * @param block block to add.
     *
     * @return builder for method chains.
     */
    default B addCanDestoryBlock(final BlockType block)
    {
        this.meta().addCanDestoryBlock(block);
        return this.getBuilder();
    }

    /**
     * Add new block that can be destroyed by this tool,
     * this method will automatically enable CanDestory tag if needed. <br>
     * Minecraft don't support subtypes here.
     *
     * @param src source item meta to copy data from it.
     *
     * @return builder for method chains.
     */
    default B addCanDestoryBlocks(final ToolMeta src)
    {
        final Set<BlockType> data = src.getCanDestoryBlocks();
        if ((data == null) || data.isEmpty())
        {
            return this.getBuilder();
        }
        final M meta = this.meta();
        data.forEach(meta::addCanDestoryBlock);
        return this.getBuilder();
    }

    /**
     * Remove block that can be destroyed by this tool,
     * this method will automatically enable CanDestory tag if needed. <br>
     * Minecraft don't support subtypes here.
     *
     * @param block block to add.
     *
     * @return builder for method chains.
     */
    default B removeCanDestoryBlock(final BlockType block)
    {
        this.meta().removeCanDestoryBlock(block);
        return this.getBuilder();
    }

    /**
     * Clear list of blocks that can be destroyed by this tool,
     * this method will automatically enable CanDestory tag if needed. <br>
     * Use {@link #setUseCanDestoryTag(boolean)} if you want disable CanDestory tag.
     *
     * @return builder for method chains.
     */
    default B removeCanDestoryBlocks()
    {
        this.meta().removeCanDestoryBlocks();
        return this.getBuilder();
    }
}
