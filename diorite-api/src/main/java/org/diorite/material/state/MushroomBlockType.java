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

package org.diorite.material.state;

/**
 * Enum with all usable mushroom block texture types.
 */
public enum MushroomBlockType
{
    /**
     * Pores on all sides.
     */
    PORES_FULL(0x0),

    /**
     * Cap texture on top, west and north
     */
    CAP_NORTH_WEST(0x1),

    /**
     * Cap texture on top and north
     */
    CAP_NORTH(0x2),

    /**
     * Cap texture on top, north and east
     */
    CAP_NORTH_EAST(0x3),

    /**
     * Cap texture on top and west
     */
    CAP_WEST(0x4),

    /**
     * Cap texture on top
     */
    CAP(0x5),

    /**
     * Cap texture on top and east
     */
    CAP_EAST(0x6),

    /**
     * Cap texture on top, south and west
     */
    CAP_SOUTH_WEST(0x7),

    /**
     * Cap texture on top and south
     */
    CAP_SOUTH(0x8),

    /**
     * Cap texture on top, east and south
     */
    CAP_SOUTH_EAST(0x9),

    /**
     * Stem texture on all four sides, pores on top and bottom
     */
    STEAM(0xA),

    /**
     * Cap texture on all six sides
     */
    CAP_FULL(0xE),

    /**
     * Stem texture on all six sides
     */
    STEAM_FULL(0xF);
    private final byte flag;

    MushroomBlockType(final int flag)
    {
        this.flag = (byte) flag;
    }

//    /**
//     * @return sub-id for mushroom based blocks of this type.
//     */
//    public byte getFlag()
//    {
//        return this.flag;
//    }
}
