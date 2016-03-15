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

package org.diorite.impl.material.block.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.diorite.impl.material.block.FlameableSettingsImpl;
import org.diorite.material.block.FlameableSettings;

public class FlameableSettingsAdapter implements JsonDeserializer<FlameableSettings>, JsonSerializer<FlameableSettingsImpl>
{
    @Override
    public FlameableSettings deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) throws JsonParseException
    {
        if (! jsonElement.isJsonObject())
        {
            throw new JsonParseException("Can't deserialize Flameable Settings from: " + jsonElement);
        }
        final JsonObject jsonObject = ((JsonObject) jsonElement);
        return FlameableSettingsImpl.createFlameableSettings(jsonObject.get("canBeSetOnFire").getAsBoolean(), jsonObject.get("BurnChances").getAsFloat(), jsonObject.get("FlameChances").getAsFloat());
    }

    @Override
    public JsonElement serialize(final FlameableSettingsImpl type, final Type type2, final JsonSerializationContext context)
    {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("canBeSetOnFire", context.serialize(type.canBeSetOnFire()));
        jsonObject.add("BurnChances", context.serialize(type.getBurnChances()));
        jsonObject.add("FlameChances", context.serialize(type.getFlameChances()));
        return jsonObject;
    }
}
