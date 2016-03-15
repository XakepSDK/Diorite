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

import org.diorite.material.block.BlockRegistry;
import org.diorite.material.block.BlockSubtype;

/**
 * {@link BlockSubtype} adapter for {@link com.google.gson.Gson} library.
 */
public class BlockSubtypeAdapter implements JsonDeserializer<BlockSubtype>, JsonSerializer<BlockSubtype>
{
    @Override
    public BlockSubtype deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
    {
        if (! jsonElement.isJsonObject())
        {
            throw new JsonParseException("Can't deserialize block subtype from: " + jsonElement);
        }
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        return BlockRegistry.getBlockSubtype(jsonObject.get("type").getAsString(), jsonObject.get("subtype").getAsString());
    }

    @Override
    public JsonElement serialize(final BlockSubtype type, final Type type2, final JsonSerializationContext jsonSerializationContext)
    {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("type", jsonSerializationContext.serialize(type.getMinecraftId()));
        jsonObject.add("subtype", jsonSerializationContext.serialize(type.getSubtypeStringId()));
        return jsonObject;
    }
}
