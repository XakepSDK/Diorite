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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.material.block.LiquidSettings;
import org.diorite.world.Dimension;
import org.diorite.world.World;

import it.unimi.dsi.fastutil.objects.Object2ByteMap;
import it.unimi.dsi.fastutil.objects.Object2ByteMaps;
import it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap;

public class LiquidSettingsImpl implements LiquidSettings
{
    public static final LiquidSettings NOT_LIQUID = new LiquidSettingsImpl(false, null);

    private static final Set<LiquidSettings> cache = new HashSet<>(10);

    static
    {
        cache.add(NOT_LIQUID);
    }

    protected final boolean liquid;
    protected final Object2ByteMap<Dimension> spillRadius = new Object2ByteOpenHashMap<>(5);

    private LiquidSettingsImpl(final boolean liquid, final Map<? extends Dimension, ? extends Byte> spillRadius)
    {
        this.liquid = liquid;
        this.spillRadius.defaultReturnValue((byte) 0);
        if (spillRadius != null)
        {
            this.spillRadius.putAll(spillRadius);
        }
    }

    @Override
    public boolean isLiquid()
    {
        return this.liquid;
    }

    @Override
    public int getSpillRadius(final World world)
    {
        return this.spillRadius.getByte(world.getDimension());
    }

    public Object2ByteMap<Dimension> getSpillRadius()
    {
        return Object2ByteMaps.unmodifiable(this.spillRadius);
    }

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

    public static LiquidSettings createLiquidSettings(final boolean liquid, final Map<? extends Dimension, ? extends Byte> spillRadius)
    {
        final LiquidSettings liquidSettings = new LiquidSettingsImpl(liquid, spillRadius);
        for (final LiquidSettings settings : cache)
        {
            if (settings.equals(liquidSettings))
            {
                return settings;
            }
        }
        cache.add(liquidSettings);
        return liquidSettings;
    }
}
