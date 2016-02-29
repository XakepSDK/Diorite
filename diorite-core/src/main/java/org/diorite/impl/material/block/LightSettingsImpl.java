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

import org.diorite.material.block.LightSettings;

public class LightSettingsImpl implements LightSettings
{
    public static final LightSettingsImpl NO_LIGHT     = new LightSettingsImpl(15, 0);
    public static final LightSettingsImpl TRANSPARENT  = new LightSettingsImpl(0, 0);
    public static final LightSettingsImpl LIGHT_SOURCE = new LightSettingsImpl(0, 15);

    private byte filterLight;
    private byte emitLight;

    public LightSettingsImpl(final byte filterLight, final byte emitLight)
    {
        this.filterLight = filterLight;
        this.emitLight = emitLight;
    }

    public LightSettingsImpl(final int filterLight, final int emitLight)
    {
        this.filterLight = (byte) filterLight;
        this.emitLight = (byte) emitLight;
    }

    @Override
    public int getFilterLight()
    {
        return this.filterLight;
    }

    public void setFilterLight(final byte filterLight)
    {
        this.filterLight = filterLight;
    }

    @Override
    public int getEmitLight()
    {
        return this.emitLight;
    }

    public void setEmitLight(final byte emitLight)
    {
        this.emitLight = emitLight;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof LightSettingsImpl))
        {
            return false;
        }

        final LightSettingsImpl that = (LightSettingsImpl) o;

        return (this.filterLight == that.filterLight) && (this.emitLight == that.emitLight);

    }

    @Override
    public int hashCode()
    {
        int result = (int) this.filterLight;
        result = (31 * result) + (int) this.emitLight;
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("filterLight", this.filterLight).append("emitLight", this.emitLight).toString();
    }
}
