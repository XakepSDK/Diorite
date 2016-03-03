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

package org.diorite.material.block.state;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.BlockFace;
import org.diorite.material.BaseVariant;
import org.diorite.material.FlowerVariant;
import org.diorite.material.LiquidStage;
import org.diorite.material.LiquidType;
import org.diorite.material.PillarVariant;
import org.diorite.material.RotateAxis;
import org.diorite.material.SlabType;
import org.diorite.material.StoneSlabVariant;
import org.diorite.material.StoneVariant;
import org.diorite.material.WoodType;

/**
 * Basic collection of block states used by vanilla blocks.
 */
public final class States
{
    public static final BlockState<StoneSlabVariant> STONE_SLAB_VARIANT = new SimpleBlockState<>(StoneSlabVariant.class);
    public static final BlockState<FlowerVariant>    FLOWER_VARIANT     = new SimpleBlockState<>(FlowerVariant.class);
    public static final BlockState<PillarVariant>    PILLAR_TYPE        = new SimpleBlockState<>(PillarVariant.class);
    public static final BlockState<StoneVariant>     STONE_TYPE         = new SimpleBlockState<>(StoneVariant.class);
    public static final BlockState<BaseVariant>      BASE_VARIANT       = new SimpleBlockState<>(BaseVariant.class);
    public static final BlockState<LiquidStage>      LIQUID_STAGE       = new SimpleBlockState<>(LiquidStage.class);
    public static final BlockState<RotateAxis>       ROTATE_AXIS        = new SimpleBlockState<>(RotateAxis.class);
    public static final BlockState<LiquidType>       LIQUID_TYPE        = new SimpleBlockState<>(LiquidType.class);
    public static final BlockState<BlockFace>        FACE               = new SimpleBlockState<>(BlockFace.class);
    public static final BlockState<WoodType>         WOOD_TYPE          = new SimpleBlockState<>(WoodType.class);
    public static final BlockState<SlabType>         SLAB_TYPE          = new SimpleBlockState<>(SlabType.class);
    public static final BlockState<Integer>          AGE                = new SimpleBlockState<>(int.class);

    private States()
    {
    }

    private static final class SimpleBlockState<T> implements BlockState<T>
    {
        private final Class<T> type;

        private SimpleBlockState(final Class<T> type)
        {
            this.type = type;
        }

        @Override
        public Class<T> getType()
        {
            return this.type;
        }

        @Override
        public String toString()
        {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("type", this.type).toString();
        }
    }
}
