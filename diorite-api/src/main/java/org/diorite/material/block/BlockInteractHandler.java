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

import org.diorite.BlockLocation;
import org.diorite.entity.Entity;

/**
 * Each block type contains own interact handler
 */
public interface BlockInteractHandler
{
    /**
     * Returns block type that owns this handler.
     *
     * @return block type that owns this handler.
     */
    BlockType getBlockType();

    /**
     * Invoked when entity walk on block.
     *
     * @param location location of block.
     * @param entity   entity that interacted with block.
     */
    void onStep(BlockLocation location, Entity entity); // TODO: maybe separate "InteractableEntity", Entity->Interactable->Living

    /**
     * Invoked when entity fall on block.
     *
     * @param location location of block.
     * @param entity   entity that interacted with block.
     */
    void onFall(BlockLocation location, Entity entity);

    /**
     * Invoked when entity hit this block. (player trying to break block etc)
     *
     * @param location location of block.
     * @param entity   entity that interacted with block.
     */
    void onHit(BlockLocation location, Entity entity);

    /**
     * Invoked when entity interact with block. (player clicking on block)
     *
     * @param location location of block.
     * @param entity   entity that interacted with block.
     */
    void onInteract(BlockLocation location, Entity entity);

    /**
     * Invoked when entity place this block on given location.
     *
     * @param location location of block.
     * @param entity   entity that interacted with block.
     */
    void onBlockPlace(BlockLocation location, Entity entity);

    /**
     * Invoked when entity break this block on given location.
     *
     * @param location location of block.
     * @param entity   entity that interacted with block.
     */
    void onBlockBreak(BlockLocation location, Entity entity);
}
