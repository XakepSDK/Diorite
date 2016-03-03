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

import java.util.Map.Entry;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Represent state pair, BlockState and value of it.
 *
 * @param <T> type of BlockState value.
 */
public class BlockStateEntry<T> implements Entry<BlockState<T>, T>
{
    private final BlockState<T> state;
    private       T             value;

    /**
     * Construct new entry for given state and value.
     *
     * @param state block state of entry.
     * @param value value of block state and entry.
     */
    public BlockStateEntry(final BlockState<T> state, final T value)
    {
        this.state = state;
        this.value = value;
    }

    @Override
    public BlockState<T> getKey()
    {
        return this.state;
    }

    @Override
    public T getValue()
    {
        return this.value;
    }

    @Override
    public T setValue(final T value)
    {
        final T cpy = this.value;
        this.value = value;
        return cpy;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof BlockStateEntry))
        {
            return false;
        }

        final BlockStateEntry<?> that = (BlockStateEntry<?>) o;
        return this.state.equals(that.state) && this.value.equals(that.value);
    }

    @Override
    public int hashCode()
    {
        int result = this.state.hashCode();
        result = (31 * result) + this.value.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("state", this.state).append("value", this.value).toString();
    }
}
