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

package org.diorite.inventory.item.meta;

import java.util.Collection;
import java.util.Set;

import org.diorite.material.block.BlockType;

/**
 * Represent {@link ItemMeta} used by tool items, like pickaxes.
 */
public interface ToolMeta extends RepairableMeta
{
    /**
     * Returns true if this tool is using CanDestory tag.
     *
     * @return true if this tool is using CanDestory tag.
     */
    boolean useCanDestoryTag();

    /**
     * Set if this tool is using CanDestory tag,
     * when you set it to false, add saved materials will be removed.
     *
     * @param useCanDestoryTag if this tool should use CanDestory tag.
     */
    void setUseCanDestoryTag(boolean useCanDestoryTag);

    /**
     * Returns set of {@link BlockType}, block types that can be destroyed by this tool. <br>
     * Minecraft don't support subtypes here. <br>
     * Will return null if tag isn't used.
     *
     * @return set of {@link BlockType}, block types that can be destroyed by this tool if CanDestory tag is used.
     */
    Set<BlockType> getCanDestoryBlocks();

    /**
     * Set blocks that can be destroyed by this tool. <br>
     * Minecraft don't support subtypes here, but diorite will save subtypes in separate tag.
     * (Vanilla client can't see them)
     *
     * @param blocks new collection of blocks.
     */
    void setCanDestoryBlocks(Collection<BlockType> blocks);

    /**
     * Add new block that can be destroyed by this tool,
     * this method will automatically enable CanDestory tag if needed. <br>
     * Minecraft don't support subtypes here.
     *
     * @param block block to add.
     */
    void addCanDestoryBlock(BlockType block);

    /**
     * Check if given block is already in CanDestory tag.
     *
     * @param block block to be checked.
     *
     * @return true if given block is in CanDestory tag.
     */
    boolean containsCanDestoryBlock(BlockType block);

    /**
     * Remove block that can be destroyed by this tool,
     * this method will automatically enable CanDestory tag if needed. <br>
     * Minecraft don't support subtypes here.
     *
     * @param block block to add.
     */
    void removeCanDestoryBlock(BlockType block);

    /**
     * Clear list of blcoks that can be destroyed by this tool,
     * this method will automatically enable CanDestory tag if needed. <br>
     * Use {@link #setUseCanDestoryTag(boolean)} if you want disable CanDestory tag.
     */
    void removeCanDestoryBlocks();

    @Override
    ToolMeta clone();
}
