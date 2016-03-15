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

import org.diorite.material.block.BlockSounds;
import org.diorite.material.block.BlockType;
import org.diorite.utils.SoundEntry;

/**
 * {@link BlockType} adapter for {@link com.google.gson.Gson} library.
 */
public class BlockSoundsAdapter implements JsonDeserializer<BlockSounds>, JsonSerializer<BlockSounds>
{
    @Override
    public BlockSounds deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) throws JsonParseException
    {
        if (! jsonElement.isJsonObject())
        {
            throw new JsonParseException("Can't deserialize block sounds from: " + jsonElement);
        }
        final JsonObject jsonObject = ((JsonObject) jsonElement);
        return BlockSounds.createBlockSounds(this.deserialize(jsonObject.get("BreakSound"), context), this.deserialize(jsonObject.get("FallSound"), context), this.deserialize(jsonObject.get("HitSound"), context), this.deserialize(jsonObject.get("PlaceSound"), context), this.deserialize(jsonObject.get("StepSound"), context));
    }

    private SoundEntry deserialize(final JsonElement jsonElement, final JsonDeserializationContext context)
    {
        if (jsonElement == null)
        {
            return null;
        }
        return context.deserialize(jsonElement, SoundEntry.class);
    }

    private JsonElement serialize(final SoundEntry soundEntry, final JsonSerializationContext context)
    {
        if (soundEntry == null)
        {
            return null;
        }
        return context.serialize(soundEntry, SoundEntry.class);
    }

    @Override
    public JsonElement serialize(final BlockSounds type, final Type type2, final JsonSerializationContext context)
    {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("BreakSound", this.serialize(type.getBreakSound(), context));
        jsonObject.add("FallSound", this.serialize(type.getFallSound(), context));
        jsonObject.add("HitSound", this.serialize(type.getHitSound(), context));
        jsonObject.add("PlaceSound", this.serialize(type.getPlaceSound(), context));
        jsonObject.add("StepSound", this.serialize(type.getStepSound(), context));
        return jsonObject;
    }
}
