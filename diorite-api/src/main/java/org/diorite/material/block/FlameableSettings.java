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

/**
 * Represent block parameters related to fire.
 */
public interface FlameableSettings
{
    /**
     * Returns true if this block can be set on fire. (by flint and steel etc)
     *
     * @return true if this block can be set on fire. (by flint and steel etc)
     */
    boolean canBeSetOnFire();

    /**
     * Returns true if this block can be naturally affected by fire.
     *
     * @return true if this block can be naturally affected by fire.
     */
    boolean isFlameable();

    /**
     * Returns chances that block will be set on fire when block is next to fire. (checked every block tick)
     *
     * @return chances that block will be set on fire when block is next to fire. (checked every block tick)
     */
    double getFlameChances();

    /**
     * Returns chances that block will be burned/destroyed when block is on fire. (checked every block tick)
     *
     * @return chances that block will be burned/destroyed when block is on fire. (checked every block tick)
     */
    double getBurnChances();

    /**
     * Returns true if this block can be destroyed by fire.
     *
     * @return true if this block can be destroyed by fire.
     */
    boolean isBurnable();
}
