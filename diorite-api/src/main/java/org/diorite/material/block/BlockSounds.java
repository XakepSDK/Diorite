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

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.Sound;
import org.diorite.utils.SoundEntry;

/**
 * Pack of sounds used by blocks
 */
public class BlockSounds
{
    /**
     * Contains default sounds - stone sounds.
     */
    public static final BlockSounds DEFAULTS = new BlockSounds(Sound.BLOCK_STONE_BREAK, Sound.BLOCK_STONE_FALL, Sound.BLOCK_STONE_HIT, Sound.BLOCK_STONE_PLACE, Sound.BLOCK_STONE_STEP, 1F, 1F);

    /**
     * BlockSounds object contains sounds of only one type: stone
     */
    public static final BlockSounds STONE  = DEFAULTS;
    /**
     * BlockSounds object contains sounds of only one type: wood
     */
    public static final BlockSounds WOOD   = new BlockSounds("wood", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: gravel
     */
    public static final BlockSounds GRAVEL = new BlockSounds("gravel", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: grass
     */
    public static final BlockSounds GRASS  = new BlockSounds("grass", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: cloth
     */
    public static final BlockSounds CLOTH  = new BlockSounds("cloth", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: sand
     */
    public static final BlockSounds SAND   = new BlockSounds("sand", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: snow
     */
    public static final BlockSounds SNOW   = new BlockSounds("snow", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: slime
     */
    public static final BlockSounds SLIME  = new BlockSounds("slime", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: metal
     */
    public static final BlockSounds METAL  = new BlockSounds("metal", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: ladder
     */
    public static final BlockSounds LADDER = new BlockSounds("ladder", 1F, 1F);
    /**
     * BlockSounds object contains sounds of only one type: anvil
     */
    public static final BlockSounds ANVIL  = new BlockSounds("anvil", 1F, 1F);

    private static final Set<BlockSounds> defs = new HashSet<>(30);

    static
    {
        defs.add(STONE);
        defs.add(WOOD);
        defs.add(GRAVEL);
        defs.add(GRASS);
        defs.add(CLOTH);
        defs.add(SAND);
        defs.add(SNOW);
        defs.add(SLIME);
        defs.add(METAL);
        defs.add(LADDER);
        defs.add(ANVIL);
    }

    /**
     * Represend sound played on block break.
     */
    protected final SoundEntry breakSound;
    /**
     * Represend sound played when entity fall on block.
     */
    protected final SoundEntry fallSound;
    /**
     * Represend sound played when someone hit block.
     */
    protected final SoundEntry hitSound;
    /**
     * Represend sound played on block place.
     */
    protected final SoundEntry placeSound;
    /**
     * Represend sound played when someone walk on block.
     */
    protected final SoundEntry stepSound;

    /**
     * Construct new block sounds by name of material, if one of sounds can't be found value from {@link #DEFAULTS} will be used.
     *
     * @param name   name of sound.
     * @param volume volume of all sounds.
     * @param pitch  pitch of all sounds.
     */
    private BlockSounds(String name, final float volume, final float pitch)
    {
        name = "block." + name + ".";
        this.breakSound = getSound(name + "break", volume, pitch, DEFAULTS.breakSound.getSound());
        this.fallSound = getSound(name + "fall", volume, pitch, DEFAULTS.fallSound.getSound());
        this.hitSound = getSound(name + "hit", volume, pitch, DEFAULTS.hitSound.getSound());
        this.placeSound = getSound(name + "place", volume, pitch, DEFAULTS.placeSound.getSound());
        this.stepSound = getSound(name + "step", volume, pitch, DEFAULTS.stepSound.getSound());
    }

    private static SoundEntry getSound(final String name, final float volume, final float pitch, final Sound def)
    {
        final Sound sound = Sound.getByName(name);
        return (sound == null) ? new SoundEntry(def, volume, pitch) : new SoundEntry(sound, volume, pitch);
    }

    /**
     * Full constructor of sounds, allows to mix sounds types.
     *
     * @param breakSound sound played on block break.
     * @param fallSound  sound played when entity fall on block.
     * @param hitSound   sound played when someone hit block.
     * @param placeSound sound played on block place.
     * @param stepSound  sound played when someone walk on block.
     * @param volume     volume of all sounds.
     * @param pitch      pitch of all sounds.
     */
    private BlockSounds(final Sound breakSound, final Sound fallSound, final Sound hitSound, final Sound placeSound, final Sound stepSound, final float volume, final float pitch)
    {
        this.breakSound = new SoundEntry(breakSound, volume, pitch);
        this.fallSound = new SoundEntry(fallSound, volume, pitch);
        this.hitSound = new SoundEntry(hitSound, volume, pitch);
        this.placeSound = new SoundEntry(placeSound, volume, pitch);
        this.stepSound = new SoundEntry(stepSound, volume, pitch);
    }

    /**
     * Full constructor of sounds, allows to mix sounds types and volume/pitch.
     *
     * @param breakSound sound played on block break.
     * @param fallSound  sound played when entity fall on block.
     * @param hitSound   sound played when someone hit block.
     * @param placeSound sound played on block place.
     * @param stepSound  sound played when someone walk on block.
     */
    private BlockSounds(final SoundEntry breakSound, final SoundEntry fallSound, final SoundEntry hitSound, final SoundEntry placeSound, final SoundEntry stepSound)
    {
        this.breakSound = breakSound;
        this.fallSound = fallSound;
        this.hitSound = hitSound;
        this.placeSound = placeSound;
        this.stepSound = stepSound;
    }

    /**
     * Returns sound played on block break.
     *
     * @return sound played on block break.
     */
    public SoundEntry getBreakSound()
    {
        return this.breakSound;
    }

    /**
     * Returns sound played when entity fall on block.
     *
     * @return sound played when entity fall on block.
     */
    public SoundEntry getFallSound()
    {
        return this.fallSound;
    }

    /**
     * Returns sound played when someone hit block.
     *
     * @return sound played when someone hit block.
     */
    public SoundEntry getHitSound()
    {
        return this.hitSound;
    }

    /**
     * Returns sound played on block place.
     *
     * @return sound played on block place.
     */
    public SoundEntry getPlaceSound()
    {
        return this.placeSound;
    }

    /**
     * Returns sound played when someone walk on block.
     *
     * @return sound played when someone walk on block.
     */
    public SoundEntry getStepSound()
    {
        return this.stepSound;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof BlockSounds))
        {
            return false;
        }

        final BlockSounds that = (BlockSounds) o;

        return (this.breakSound != null) ? this.breakSound.equals(that.breakSound) : ((that.breakSound == null) && ((this.fallSound != null) ? this.fallSound.equals(that.fallSound) : ((that.fallSound == null) && ((this.hitSound != null) ? this.hitSound.equals(that.hitSound) : ((that.hitSound == null) && ((this.placeSound != null) ? this.placeSound.equals(that.placeSound) : ((that.placeSound == null) && ((this.stepSound != null) ? this.stepSound.equals(that.stepSound) : (that.stepSound == null)))))))));
    }

    @Override
    public int hashCode()
    {
        int result = (this.breakSound != null) ? this.breakSound.hashCode() : 0;
        result = (31 * result) + ((this.fallSound != null) ? this.fallSound.hashCode() : 0);
        result = (31 * result) + ((this.hitSound != null) ? this.hitSound.hashCode() : 0);
        result = (31 * result) + ((this.placeSound != null) ? this.placeSound.hashCode() : 0);
        result = (31 * result) + ((this.stepSound != null) ? this.stepSound.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("breakSound", this.breakSound).append("fallSound", this.fallSound).append("hitSound", this.hitSound).append("placeSound", this.placeSound).append("stepSound", this.stepSound).toString();
    }

    /**
     * Full constructor of sounds, allows to mix sounds types and volume/pitch.
     *
     * @param breakSound sound played on block break.
     * @param fallSound  sound played when entity fall on block.
     * @param hitSound   sound played when someone hit block.
     * @param placeSound sound played on block place.
     * @param stepSound  sound played when someone walk on block.
     *
     * @return created (or cached) sound object.
     */
    public static BlockSounds createBlockSounds(final SoundEntry breakSound, final SoundEntry fallSound, final SoundEntry hitSound, final SoundEntry placeSound, final SoundEntry stepSound)
    {
        final BlockSounds sounds = new BlockSounds(breakSound, fallSound, hitSound, placeSound, stepSound);
        for (final BlockSounds def : defs)
        {
            if (def.equals(sounds))
            {
                return def;
            }
        }
        defs.add(sounds);
        return sounds;
    }

    /**
     * Full constructor of sounds, allows to mix sounds types.
     *
     * @param breakSound sound played on block break.
     * @param fallSound  sound played when entity fall on block.
     * @param hitSound   sound played when someone hit block.
     * @param placeSound sound played on block place.
     * @param stepSound  sound played when someone walk on block.
     * @param volume     volume of all sounds.
     * @param pitch      pitch of all sounds.
     * @return created (or cached) sound object.
     */
    public static BlockSounds createBlockSounds(final Sound breakSound, final Sound fallSound, final Sound hitSound, final Sound placeSound, final Sound stepSound, final float volume, final float pitch)
    {
        final BlockSounds sounds = new BlockSounds(breakSound, fallSound, hitSound, placeSound, stepSound, volume, pitch);
        for (final BlockSounds def : defs)
        {
            if (def.equals(sounds))
            {
                return def;
            }
        }
        defs.add(sounds);
        return sounds;
    }

    /**
     * Construct new block sounds by name of material, if one of sounds can't be found value from {@link #DEFAULTS} will be used.
     *
     * @param name   name of sound.
     * @param volume volume of all sounds.
     * @param pitch  pitch of all sounds.
     * @return created (or cached) sound object.
     */
    public static BlockSounds createBlockSounds(final String name, final float volume, final float pitch)
    {
        final BlockSounds sounds = new BlockSounds(name, volume, pitch);
        for (final BlockSounds def : defs)
        {
            if (def.equals(sounds))
            {
                return def;
            }
        }
        defs.add(sounds);
        return sounds;
    }
}
