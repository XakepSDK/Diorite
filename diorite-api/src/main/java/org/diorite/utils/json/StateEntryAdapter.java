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

package org.diorite.utils.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.apache.commons.lang3.ClassUtils;

import org.diorite.material.state.State;
import org.diorite.material.state.StateEntry;
import org.diorite.material.state.States;
import org.diorite.utils.SimpleEnum;

/**
 * {@link State} adapter for {@link com.google.gson.Gson} library.
 */
public class StateEntryAdapter implements JsonDeserializer<StateEntry<?>>, JsonSerializer<StateEntry<?>>
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public StateEntry<?> deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) throws JsonParseException
    {
        if (! jsonElement.isJsonObject())
        {
            throw new JsonParseException("Can't deserialize state entry from: " + jsonElement);
        }
        final JsonObject jsonObject = ((JsonObject) jsonElement);
        try
        {
            final Class<?> stateType = ClassUtils.getClass(jsonObject.get("Type").getAsString());
            final State<?> state = States.getState(jsonObject.get("Name").getAsString(), stateType);
            final Object value;
            if (SimpleEnum.class.isAssignableFrom(state.getType()))
            {
                value = SimpleEnum.getSimpleEnumValueSafe(jsonObject.get("Value").getAsString(), (Class) state.getType());
            }
            else
            {
                value = context.deserialize(jsonObject.get("Value"), state.getType());
            }
            return new StateEntry(state, value);
        } catch (final ClassNotFoundException e)
        {
            throw new JsonParseException("Can't find state type: ", e);
        }
    }

    @Override
    public JsonElement serialize(final StateEntry<?> stateEntry, final Type type, final JsonSerializationContext context)
    {
        final JsonObject jsonObject = new JsonObject();
        final State<?> state = stateEntry.getKey();
        jsonObject.add("Name", context.serialize(state.getName()));
        jsonObject.add("Type", context.serialize(state.getType().getName()));
        if (stateEntry.getValue() instanceof SimpleEnum)
        {
            jsonObject.add("Value", context.serialize(((SimpleEnum<?>) stateEntry.getValue()).name()));
        }
        else
        {
            jsonObject.add("Value", context.serialize(stateEntry.getValue()));
        }
        return jsonObject;
    }
}
