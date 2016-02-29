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

import org.diorite.material.block.FlameableSettings;

public class FlameableSettingsImpl implements FlameableSettings
{
    public static final FlameableSettingsImpl NO_FIRE       = new FlameableSettingsImpl(false);
    public static final FlameableSettingsImpl NOT_FLAMEABLE = new FlameableSettingsImpl(0, 0);
    public static final FlameableSettingsImpl WOODEN        = new FlameableSettingsImpl(5, 20);
    public static final FlameableSettingsImpl STRONG        = new FlameableSettingsImpl(5, 5);
    public static final FlameableSettingsImpl PLANTS        = new FlameableSettingsImpl(60, 100);

    private boolean canBeSetOnFire;
    private float   flameChances;
    private float   burnChances;

    public FlameableSettingsImpl(final boolean canBeSetOnFire, final float flameChances, final float burnChances)
    {
        this.canBeSetOnFire = canBeSetOnFire;
//        this.flameable = flameable;
//        this.burnable = burnable;
        this.flameChances = flameChances;
        this.burnChances = burnChances;
    }

    public FlameableSettingsImpl(final boolean canBeSetOnFire)
    {
        this.canBeSetOnFire = canBeSetOnFire;
    }

    public FlameableSettingsImpl(final float flameChances, final float burnChances)
    {
        this.canBeSetOnFire = true;
//        this.flameable = true;
//        this.burnable = true;
        this.flameChances = flameChances;
        this.burnChances = burnChances;
    }

    public FlameableSettingsImpl(final float flameChances)
    {
        this.canBeSetOnFire = true;
//        this.flameable = true;
        this.flameChances = flameChances;
    }

    @Override
    public boolean canBeSetOnFire()
    {
        return this.canBeSetOnFire;
    }

    @Override
    public boolean isFlameable()
    {
        return this.flameChances > 0;
    }

    @Override
    public boolean isBurnable()
    {
        return this.burnChances > 0;
    }

    @Override
    public double getFlameChances()
    {
        return this.flameChances;
    }

    @Override
    public double getBurnChances()
    {
        return this.burnChances;
    }

    public void setCanBeSetOnFire(final boolean canBeSetOnFire)
    {
        this.canBeSetOnFire = canBeSetOnFire;
    }

    public void setFlameChances(final float flameChances)
    {
        this.flameChances = flameChances;
    }

    public void setBurnChances(final float burnChances)
    {
        this.burnChances = burnChances;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof FlameableSettingsImpl))
        {
            return false;
        }

        final FlameableSettingsImpl that = (FlameableSettingsImpl) o;

        return (this.canBeSetOnFire == that.canBeSetOnFire) && (Float.compare(that.flameChances, this.flameChances) == 0) && (Float.compare(that.burnChances, this.burnChances) == 0);
    }

    @Override
    public int hashCode()
    {
        int result = (this.canBeSetOnFire ? 1 : 0);
        result = (31 * result) + ((this.flameChances != + 0.0f) ? Float.floatToIntBits(this.flameChances) : 0);
        result = (31 * result) + ((this.burnChances != + 0.0f) ? Float.floatToIntBits(this.burnChances) : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("canBeSetOnFire", this.canBeSetOnFire).append("flameChances", this.flameChances).append("burnChances", this.burnChances).toString();
    }
}
