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

import java.util.ArrayList;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.material.state.BaseVariant;
import org.diorite.material.state.State;
import org.diorite.material.state.StateEntry;
import org.diorite.material.state.States;

public class VariantEntry
{
    private final String name;
    private final ArrayList<StateEntry<?>> map = new ArrayList<>(3);

    public VariantEntry(final String name)
    {
        this.name = name;
    }

    public <T> VariantEntry addState(final State<T> state, final T data)
    {
        this.map.add(new StateEntry<>(state, data));
        return this;
    }

    public <T> VariantEntry setClassic()
    {
        this.map.add(new StateEntry<>(States.BASE_VARIANT, BaseVariant.CLASSIC));
        return this;
    }

    public static VariantEntry[] asAgeable(final String name, final int ages)
    {
        return generateIntStates(name, name, name, States.AGE, ages);
    }

    public static VariantEntry[] generateIntStates(final String name, final State<Integer> state, final int states)
    {
        return generateIntStates(name, name, name, state, states);
    }

    public static VariantEntry[] generateIntStates(final String startName, final String name, final String endName, final State<Integer> state, final int states)
    {
        final VariantEntry[] result = new VariantEntry[states];
        result[0] = new VariantEntry(startName).addState(States.AGE, 0);
        for (int i = 1; i < (states - 1); i++)
        {
            result[i] = new VariantEntry(name + "_" + i).addState(States.AGE, i);
        }
        result[states - 1] = new VariantEntry(endName).addState(States.AGE, states);
        return result;
    }

    public static VariantEntry[] generateIntStates(final String startName, final String name, final String endName, final State<Integer> state, int start, final int states)
    {
        final VariantEntry[] result = new VariantEntry[states];
        result[0] = new VariantEntry(startName).addState(States.AGE, 0);
        for (int i = 1; i < (states - 1); i++)
        {
            result[i] = new VariantEntry(name + "_" + (start++)).addState(States.AGE, i);
        }
        result[states - 1] = new VariantEntry(endName).addState(States.AGE, states);
        return result;
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<StateEntry<?>> getStates()
    {
        return this.map;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("name", this.name).append("map", this.map).toString();
    }
}
