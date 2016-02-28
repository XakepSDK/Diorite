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
 * Represent block data
 */
public interface Block
{
    /**
     * Returns numeric id used in save files, packets, etc.
     *
     * @return numeric id used in save files, packets, etc.
     */
    int getId();

    /**
     * Returns minecraft string id of block.
     *
     * @return minecraft string id of block.
     */
    String getMinecraftId();

    /**
     * Returns display name of block.
     *
     * @return display name of block.
     */
    String getDisplayName();

    /**
     * Returns hardness of block.
     *
     * @return hardness of block.
     */
    double getHardness();

    /**
     * Returns hardness of block.
     *
     * @return hardness of block.
     */
    double getBlastResistance();

    /**
     * Returns true if this block is tile entity.
     *
     * @return true if this block is tile entity.
     */
    boolean isTileEntity();

    /**
     * Retruns liquid related block parameters.
     *
     * @return liquid related block parameters.
     */
    LiquidSettings getLiquidSettings();

    /**
     * Override block {@link LiquidSettings}.
     *
     * @param settings new parameters to use.
     */
    void setLiquidSettings(LiquidSettings settings);

    /**
     * Retruns light related block parameters.
     *
     * @return light related block parameters.
     */
    LightSettings getLightSettings();

    /**
     * Override block {@link LightSettings}.
     *
     * @param settings new parameters to use.
     */
    void setLightSettings(LightSettings settings);

    /**
     * Retruns fire related block parameters.
     *
     * @return fire related block parameters.
     */
    FlameableSettings getFlameableSettings();

    /**
     * Override block {@link FlameableSettings}.
     *
     * @param settings new parameters to use.
     */
    void setFlameableSettings(FlameableSettings settings);
}
