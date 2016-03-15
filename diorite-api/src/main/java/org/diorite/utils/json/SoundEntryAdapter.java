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

import org.diorite.Sound;
import org.diorite.material.block.BlockType;
import org.diorite.utils.SoundEntry;

/**
 * {@link BlockType} adapter for {@link com.google.gson.Gson} library.
 */
public class SoundEntryAdapter implements JsonDeserializer<SoundEntry>, JsonSerializer<SoundEntry>
{
    @Override
    public SoundEntry deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
    {
        if (! jsonElement.isJsonObject())
        {
            throw new JsonParseException("Can't deserialize sound entry from: " + jsonElement);
        }
        final JsonObject jsonObject = ((JsonObject) jsonElement);
        return new SoundEntry(Sound.getByName(jsonObject.get("SoundName").getAsString()), jsonObject.get("Pitch").getAsFloat(), jsonObject.get("Volume").getAsFloat());
    }

    @Override
    public JsonElement serialize(final SoundEntry type, final Type type2, final JsonSerializationContext jsonSerializationContext)
    {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("SoundName", jsonSerializationContext.serialize(type.getSound().getSoundName()));
        jsonObject.add("Pitch", jsonSerializationContext.serialize(type.getPitch()));
        jsonObject.add("Volume", jsonSerializationContext.serialize(type.getVolume()));
        return jsonObject;
    }
}
