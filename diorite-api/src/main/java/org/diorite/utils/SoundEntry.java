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

package org.diorite.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.Sound;

/**
 * Represend single sound entry, that contains sound, volume and pitch.
 */
public class SoundEntry
{
    private final Sound sound;
    private final float volume;
    private final float pitch;

    /**
     * Construct new entry for given sound, volume and pitch.
     *
     * @param sound  sound of entry.
     * @param volume volume of entry.
     * @param pitch  pitch of entry.
     */
    public SoundEntry(final Sound sound, final float volume, final float pitch)
    {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    /**
     * Returns sound of entry.
     *
     * @return sound of entry.
     */
    public Sound getSound()
    {
        return this.sound;
    }

    /**
     * Returns volume of entry.
     *
     * @return volume of entry.
     */
    public float getVolume()
    {
        return this.volume;
    }

    /**
     * Returns pitch of entry.
     *
     * @return pitch of entry.
     */
    public float getPitch()
    {
        return this.pitch;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof SoundEntry))
        {
            return false;
        }

        final SoundEntry that = (SoundEntry) o;

        return (Float.compare(that.volume, this.volume) == 0) && (Float.compare(that.pitch, this.pitch) == 0) && this.sound.equals(that.sound);
    }

    @Override
    public int hashCode()
    {
        int result = this.sound.hashCode();
        result = (31 * result) + ((this.volume != + 0.0f) ? Float.floatToIntBits(this.volume) : 0);
        result = (31 * result) + ((this.pitch != + 0.0f) ? Float.floatToIntBits(this.pitch) : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("sound", this.sound).append("volume", this.volume).append("pitch", this.pitch).toString();
    }
}
