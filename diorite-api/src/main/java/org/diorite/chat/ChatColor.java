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

package org.diorite.chat;

import org.apache.commons.lang3.Validate;

import org.diorite.chat.component.BaseComponent;
import org.diorite.chat.component.TextComponent;

import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;

public enum ChatColor
{
    BLACK('0'),
    DARK_BLUE('1'),
    DARK_GREEN('2'),
    DARK_AQUA('3'),
    DARK_RED('4'),
    DARK_PURPLE('5'),
    GOLD('6'),
    GRAY('7'),
    DARK_GRAY('8'),
    BLUE('9'),
    GREEN('a'),
    AQUA('b'),
    RED('c'),
    LIGHT_PURPLE('d'),
    YELLOW('e'),
    WHITE('f'),
    OBFUSCATED('k', true),
    BOLD('l', true),
    STRIKETHROUGH('m', true),
    UNDERLINE('n', true),
    ITALIC('o', true),
    RESET('r');

    public static final char COLOR_CHAR                   = '\u00A7'; // to fix encoding problems on Intellij 14.1
    public static final char DEFAULT_ALTERNATE_COLOR_CHAR = '&';
    private static final Char2ObjectMap<ChatColor> BY_CHAR;
    private final        String                    name;
    private final        char                      code;
    private final        boolean                   isFormat;
    private final        String                    toString;

    ChatColor(final char code)
    {
        this(code, false);
    }

    ChatColor(final char code, final boolean isFormat)
    {
        this.name = this.name().toLowerCase();
        this.code = code;
        this.isFormat = isFormat;
        this.toString = new String(new char[]{COLOR_CHAR, code});
    }

    public String getName()
    {
        return this.name;
    }

    public char getChar()
    {
        return this.code;
    }

    @Override
    public String toString()
    {
        return this.toString;
    }

    public boolean isFormat()
    {
        return this.isFormat;
    }

    public boolean isColor()
    {
        return (! this.isFormat) && (this != RESET);
    }

    public static ChatColor getByChar(final char code)
    {
        return BY_CHAR.get(code);
    }

    public static ChatColor getByChar(final String code)
    {
        Validate.notNull(code, "Code cannot be null");
        Validate.isTrue(! code.isEmpty(), "Code must have at least one char");

        return BY_CHAR.get(code.charAt(0));
    }

    public static String stripColor(final String input)
    {
        if (input == null)
        {
            return null;
        }
        final StringBuilder sb = new StringBuilder(input.length());
        final char[] chars = input.toCharArray();
        boolean colorChar = false;
        for (final char aChar : chars)
        {
            if (colorChar)
            {
                colorChar = false;
                if ("0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(aChar) > - 1)
                {
                    continue;
                }
                else
                {
                    sb.append(COLOR_CHAR);
                }
            }
            if (aChar == COLOR_CHAR)
            {
                colorChar = true;
                continue;
            }
            sb.append(aChar);
        }
        if (colorChar)
        {
            sb.append(COLOR_CHAR);
        }
        return sb.toString();
    }

    public static BaseComponent translateAlternateColorCodes(final char altColorChar, final String textToTranslate)
    {
        return TextComponent.fromLegacyText(translateAlternateColorCodesInString(altColorChar, textToTranslate));
    }

    public static BaseComponent translateAlternateColorCodes(final String textToTranslate)
    {
        return TextComponent.fromLegacyText(translateAlternateColorCodesInString(DEFAULT_ALTERNATE_COLOR_CHAR, textToTranslate));
    }

    public static String translateAlternateColorCodesInString(final char altColorChar, final String textToTranslate)
    {
        final char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < (b.length - 1); i++)
        {
            if ((b[i] == altColorChar) && ("0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[(i + 1)]) > - 1))
            {
                b[i] = COLOR_CHAR;
                b[(i + 1)] = Character.toLowerCase(b[(i + 1)]);
            }
        }
        return new String(b);
    }

    public static String translateAlternateColorCodesInString(final String textToTranslate)
    {
        return translateAlternateColorCodesInString(DEFAULT_ALTERNATE_COLOR_CHAR, textToTranslate);
    }

    public static String removeColorCodesInString(final char altColorChar, final String textToTranslate)
    {
        final char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < (b.length - 1); i++)
        {
            if ((b[i] == COLOR_CHAR) && ("0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[(i + 1)]) > - 1))
            {
                b[i] = altColorChar;
                b[(i + 1)] = Character.toLowerCase(b[(i + 1)]);
            }
        }
        return new String(b);
    }

    public static String getLastColors(final CharSequence input)
    {
        String result = "";
        final int length = input.length();
        for (int index = length - 1; index > - 1; index--)
        {
            final char section = input.charAt(index);
            if ((section == COLOR_CHAR) && (index < (length - 1)))
            {
                final char c = input.charAt(index + 1);
                final ChatColor color = getByChar(c);
                if (color != null)
                {
                    result = color.toString() + result;
                    if ((color.isColor()) || (color.equals(RESET)))
                    {
                        break;
                    }
                }
            }
        }
        return result;
    }

    static
    {
        final ChatColor[] values = values();
        BY_CHAR = new Char2ObjectOpenHashMap<>(values.length);
        for (final ChatColor color : values)
        {
            BY_CHAR.put(color.code, color);
        }
    }
}
