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
 * Possible stages of liquid, liquid can be in two stages: normal and falling, each stage can have 7 levels and source level of liquid in it.
 */
public enum LiquidStage
{
    SOURCE,
    STAGE_1,
    STAGE_2,
    STAGE_3,
    STAGE_4,
    STAGE_5,
    STAGE_6,
    STAGE_7;

    public boolean isSource()
    {
        return this == SOURCE;
    }

    public LiquidStage getNextStage()
    {
        switch (this)
        {
            case SOURCE:
                return STAGE_1;
            case STAGE_1:
                return STAGE_2;
            case STAGE_2:
                return STAGE_3;
            case STAGE_3:
                return STAGE_4;
            case STAGE_4:
                return STAGE_5;
            case STAGE_5:
                return STAGE_6;
            case STAGE_6:
                return STAGE_7;
            case STAGE_7:
                return STAGE_7;
            default:
                return null;
        }
    }

    public LiquidStage getPreviousStage()
    {
        switch (this)
        {
            case SOURCE:
                return SOURCE;
            case STAGE_1:
                return SOURCE;
            case STAGE_2:
                return STAGE_1;
            case STAGE_3:
                return STAGE_2;
            case STAGE_4:
                return STAGE_3;
            case STAGE_5:
                return STAGE_4;
            case STAGE_6:
                return STAGE_5;
            case STAGE_7:
                return STAGE_6;
            default:
                return null;
        }
    }
}
