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

package org.diorite.impl.material.block;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.material.block.LiquidSettings;
import org.diorite.world.World;

public abstract class LiquidSettingsImpl implements LiquidSettings
{
    public static final LiquidSettingsImpl NOT_LIQUID = new LiquidSettingsImpl(false)
    {
        @Override
        public int getSpillRadius(final World world)
        {
            return 0;
        }
    };

    private boolean liquid;

    public LiquidSettingsImpl(final boolean liquid)
    {
        this.liquid = liquid;
    }

    @Override
    public boolean isLiquid()
    {
        return this.liquid;
    }

    public void setLiquid(final boolean liquid)
    {
        this.liquid = liquid;
    }

    @Override
    public abstract int getSpillRadius(World world);

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof LiquidSettingsImpl))
        {
            return false;
        }

        final LiquidSettingsImpl that = (LiquidSettingsImpl) o;

        return this.liquid == that.liquid;
    }

    @Override
    public int hashCode()
    {
        return (this.liquid ? 1 : 0);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("liquid", this.liquid).toString();
    }
}
