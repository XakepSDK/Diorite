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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.BlockFace;
import org.diorite.DyeColor;

/**
 * Basic collection of block states used by vanilla blocks.
 */
public final class States
{
    private static final Map<StateKey, State<?>> states      = new HashMap<>(20);
    private static final Map<StateKey, State<?>> statesUnmod = Collections.unmodifiableMap(states);

    public static final State<StoneSlabVariant> STONE_SLAB_VARIANT = registerState("stone_slab_variant", StoneSlabVariant.class);
    public static final State<FlowerVariant>    FLOWER_VARIANT     = registerState("flower_variant", FlowerVariant.class);
    public static final State<PillarVariant>    PILLAR_TYPE        = registerState("pillar_variant", PillarVariant.class);
    public static final State<StoneVariant>     STONE_TYPE         = registerState("stone_variant", StoneVariant.class);
    public static final State<BaseVariant>      BASE_VARIANT       = registerState("variant", BaseVariant.class);
    public static final State<LiquidStage>      LIQUID_STAGE       = registerState("stage", LiquidStage.class);
    public static final State<DirtVariant>      DIRT_TYPE          = registerState("dirt_variant", DirtVariant.class);
    public static final State<SandVariant>      SAND_TYPE          = registerState("snad_variant", SandVariant.class);
    public static final State<RotateAxis>       ROTATE_AXIS        = registerState("axis", RotateAxis.class);
    public static final State<LiquidType>       LIQUID_TYPE        = registerState("liquid_type", LiquidType.class);
    public static final State<BlockFace>        FACE               = registerState("facing", BlockFace.class);
    public static final State<WoodType>         WOOD_TYPE          = registerState("wood", WoodType.class);
    public static final State<SlabType>         SLAB_TYPE          = registerState("slab_type", SlabType.class);
    public static final State<RailType>         RAIL_TYPE          = registerState("rail_type", RailType.class);
    public static final State<DyeColor>         COLOR              = registerState("color", DyeColor.class);
    public static final State<BedPart>          BED_PART           = registerState("bed_part", BedPart.class);
    public static final State<DoorPart>         DOOR_PART          = registerState("door_part", DoorPart.class);
    public static final State<Integer>          MOISTURE           = registerState("moisture", int.class);
    public static final State<Integer>          AGE                = registerState("age", int.class);
    public static final State<Integer>          SIZE               = registerState("size", int.class);
    public static final State<Integer>          POWER              = registerState("power", int.class);
    public static final State<Boolean>          CHECK_DECAY        = registerState("check_decay", boolean.class);
    public static final State<Boolean>          DECAYABLE          = registerState("decayable", boolean.class);
    public static final State<Boolean>          OLDER              = registerState("older", boolean.class);
    public static final State<Boolean>          WET                = registerState("wet", boolean.class);
    public static final State<Boolean>          ACTIVATED          = registerState("activated", boolean.class);
    public static final State<Boolean>          POWERED            = registerState("powered", boolean.class);
    public static final State<Boolean>          OPEN               = registerState("open", ACTIVATED);
    public static final State<Boolean>          TRIGGERED          = registerState("triggered", ACTIVATED);
    public static final State<Boolean>          EXTENDED           = registerState("extended", ACTIVATED);
    public static final State<Boolean>          STICKY             = registerState("sticky", boolean.class);
    public static final State<Boolean>          UPSIDE_DOWN        = registerState("upsideDown", boolean.class);
    public static final State<Boolean>          OCCUPIED           = registerState("occupied", boolean.class);

    private States()
    {
    }

    @SuppressWarnings("unchecked")
    public static <T> State<T> getState(final String name, final Class<T> type)
    {
        return (State<T>) states.get(new StateKey(name, type));
    }

//    @SuppressWarnings("unchecked")
//    public static <T> State<T> getState(final String name)
//    {
//        return (State<T>) states.values().stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
//    }


    /**
     * Returns all registred states.
     *
     * @return all registred states.
     */
    public static Map<StateKey, State<?>> getStates()
    {
        return statesUnmod;
    }

    public static <T> State<T> registerState(final String name, final State<T> state)
    {
        final State<T> createdState = new DelegatedSimpleState<>(name, state);
        registerState(createdState);
        return createdState;
    }

    public static <T> State<T> registerState(final String name, final Class<T> type)
    {
        final State<T> state = new SimpleState<>(name, type);
        registerState(state);
        return state;
    }

    public static void registerState(final State<?> state)
    {
        states.put(new StateKey(state.getName(), state.getType()), state);
    }

    public static final class StateKey
    {
        private final String   name;
        private final Class<?> type;

        public StateKey(final String name, final Class<?> type)
        {
            this.name = name;
            this.type = type;
        }

        public String getName()
        {
            return this.name;
        }

        public Class<?> getType()
        {
            return this.type;
        }

        @Override
        public boolean equals(final Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (! (o instanceof StateKey))
            {
                return false;
            }

            final StateKey stateKey = (StateKey) o;

            return this.name.equalsIgnoreCase(stateKey.name) && this.type.equals(stateKey.type);
        }

        @Override
        public int hashCode()
        {
            int result = this.name.toLowerCase().hashCode();
            result = (31 * result) + this.type.hashCode();
            return result;
        }

        @Override
        public String toString()
        {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("name", this.name).append("type", this.type).toString();
        }
    }

    private static final class DelegatedSimpleState<T> implements State<T>
    {
        private final String   name;
        private final State<T> delegated;

        private DelegatedSimpleState(final String name, final State<T> delegated)
        {
            this.name = name;
            this.delegated = delegated;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        @Override
        public Class<T> getType()
        {
            return this.delegated.getType();
        }

        @Override
        public String toString()
        {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("name", this.name).append("type", this.delegated.getType()).toString();
        }

        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        @Override
        public boolean equals(final Object o)
        {
            return this.delegated.equals(o);
        }

        @Override
        public int hashCode()
        {
            return this.delegated.hashCode();
        }
    }

    private static final class SimpleState<T> implements State<T>
    {
        private final String   name;
        private final Class<T> type;

        private SimpleState(final String name, final Class<T> type)
        {
            this.name = name;
            this.type = type;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        @Override
        public Class<T> getType()
        {
            return this.type;
        }

        @Override
        public String toString()
        {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("name", this.name).append("type", this.type).toString();
        }
    }
}
