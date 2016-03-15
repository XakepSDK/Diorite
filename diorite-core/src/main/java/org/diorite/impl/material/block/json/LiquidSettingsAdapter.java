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
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import org.diorite.impl.material.block.LiquidSettingsImpl;
import org.diorite.material.block.LiquidSettings;
import org.diorite.world.Dimension;

public class LiquidSettingsAdapter implements JsonDeserializer<LiquidSettings>, JsonSerializer<LiquidSettingsImpl>
{
    //@formatter:off
    private static final Type typeOfHashMap = new TypeToken<Map<Dimension, Byte>>() {}.getType();
    //@formatter:on

    @Override
    public LiquidSettings deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) throws JsonParseException
    {
        if (! jsonElement.isJsonObject())
        {
            throw new JsonParseException("Can't deserialize Liquid settings from: " + jsonElement);
        }
        final JsonObject jsonObject = ((JsonObject) jsonElement);
        return LiquidSettingsImpl.createLiquidSettings(jsonObject.get("IsLiquid").getAsBoolean(), context.deserialize(jsonObject.get("SpillRadius"), typeOfHashMap));
    }

    @Override
    public JsonElement serialize(final LiquidSettingsImpl type, final Type type2, final JsonSerializationContext context)
    {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("IsLiquid", context.serialize(type.isLiquid()));
        jsonObject.add("SpillRadius", context.serialize(type.getSpillRadius(), typeOfHashMap));
        return jsonObject;
    }
}
