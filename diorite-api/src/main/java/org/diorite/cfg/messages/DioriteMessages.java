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

package org.diorite.cfg.messages;

import java.io.File;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import org.diorite.Core;
import org.diorite.Diorite;
import org.diorite.cfg.messages.Message.MessageData;
import org.diorite.command.sender.CommandSender;
import org.diorite.plugin.BasePlugin;
import org.diorite.plugin.ChildPlugin;

/**
 * Static bindings for message methods related with Diorite.
 */
public final class DioriteMessages
{
    /**
     * Helper variable to prevent a typo.
     */
    public static final char   SEP             = '.';
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_COMMANDS    = "commands";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_PLAYER      = "player";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_ENTITY      = "entity";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_HELP        = "help";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_SAVE        = "save";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_PLUGIN      = "plugin";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_TIME        = "time";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String KEY_WORLDBORDER = "worldborder";


    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLAYER_JOIN = KEY_PLAYER + SEP + "join";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLAYER_QUIT = KEY_PLAYER + SEP + "quit";


    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_CMD_DISABLED                = KEY_COMMANDS + SEP + "disabled";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_ONLY_PLAYER                 = KEY_COMMANDS + SEP + "onlyplayer";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_ONLY_CONSOLE                = KEY_COMMANDS + SEP + "onlyconsole";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_NO_TARGET                   = KEY_COMMANDS + SEP + "no-target";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_NO_MATERIAL                 = KEY_COMMANDS + SEP + "no-material";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_NO_NUMBER                   = KEY_COMMANDS + SEP + "no-number";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_NUMBER_NOT_POSITIVE         = KEY_COMMANDS + SEP + "number-not-positive";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_NUMBER_NOT_POSITIVE_OR_ZERO = KEY_COMMANDS + SEP + "number-not-positive-or-zero";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_NO_WORLD                    = KEY_COMMANDS + SEP + "no-world";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_CONSOLE_NO_WORLD            = KEY_COMMANDS + SEP + "console-no-world";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_CORRECT                     = KEY_COMMANDS + SEP + "correct-usage";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_CMD_INVALID_ARGUMENTS           = KEY_COMMANDS + SEP + "invalid-arguments";


    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_HELP_HEADER = KEY_HELP + SEP + "header";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_HELP_NODESC = KEY_HELP + SEP + "nodesc";


    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_SAVE_START = KEY_SAVE + SEP + "start";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_SAVE_DONE  = KEY_SAVE + SEP + "done";


    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLUGIN_NOTFOUND               = KEY_PLUGIN + SEP + "notfound";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLUGIN_OVERVIEW_BASE          = KEY_PLUGIN + SEP + "overview" + SEP + "base";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLUGIN_OVERVIEW_DESCRIPTION   = KEY_PLUGIN + SEP + "overview" + SEP + "description";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLUGIN_OVERVIEW_WEBSITE       = KEY_PLUGIN + SEP + "overview" + SEP + "website";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLUGIN_OVERVIEW_NERDS_BASE    = KEY_PLUGIN + SEP + "overview" + SEP + "nerds" + SEP + "base";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLUGIN_OVERVIEW_NERDS_CHILD   = KEY_PLUGIN + SEP + "overview" + SEP + "nerds" + SEP + "child";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_PLUGIN_OVERVIEW_NERDS_REGULAR = KEY_PLUGIN + SEP + "overview" + SEP + "nerds" + SEP + "regular";


    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_TIME_CURRENT = KEY_TIME + SEP + "current";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_TIME_CHANGED = KEY_TIME + SEP + "changed";


    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_WORLDBORDER_INFO_BASE     = KEY_WORLDBORDER + SEP + "info" + SEP + "base";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_WORLDBORDER_INFO_RESIZING = KEY_WORLDBORDER + SEP + "info" + SEP + "resizing";
    /**
     * Helper variable to prevent a typo.
     */
    public static final String MSG_WORLDBORDER_INFO_COMMANDS = KEY_WORLDBORDER + SEP + "info" + SEP + "commands";


    private static Messages      msgs;
    private static MessageLoader loader;

    private DioriteMessages()
    {
    }

    /**
     * Returns message loader used by diorite, it change on messages reload so don't store it.
     *
     * @return message loader used by diorite, it change on messages reload so don't store it.
     */
    public static MessageLoader getLoader()
    {
        return loader;
    }

    /**
     * Returns main instance of {@link Messages} used to store all diorite and many diorite plugins messages.<br>
     * Note that returned value will be not updated after reload, so you should not cache it.
     *
     * @return main instance of {@link Messages}
     */
    public static Messages getMessages()
    {
        return msgs;
    }

    /**
     * Reloads diorite message files (including plugin ones)
     */
    public static void reload()
    {
        loader = new MessageLoader(Diorite.getConfig().getLanguages());
        final File langFolder = new File("lang");
        langFolder.mkdirs();
        msgs = loader.loadMessages("lang_", langFolder, Core.class, "/lang/");
        loader.saveMessages(msgs, langFolder, "lang_");
    }

    /**
     * Try send this message to given {@link CommandSender}, if message is disabled method will just return false.
     *
     * @param path   path to message.
     * @param target target of message.
     * @param lang   language to use if possible.
     * @param data   placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean sendMessage(final String path, final CommandSender target, final Locale lang, final MessageData... data)
    {
        return msgs.sendMessage(path, target, lang, data);
    }

    /**
     * Try send this message to given {@link CommandSender}, if message is disabled method will just return false.
     * Language will be automatically fetched from given {@link CommandSender}
     *
     * @param path   path to message.
     * @param target target of message.
     * @param data   placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean sendMessage(final String path, final CommandSender target, final MessageData... data)
    {
        return msgs.sendMessage(path, target, data);
    }

    /**
     * Try broadcast this message (to all players), if message is disabled method will just return false.
     *
     * @param path path to message.
     * @param lang language to use if possible.
     * @param data placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean broadcastStaticMessage(final String path, final Locale lang, final MessageData... data)
    {
        return msgs.broadcastStaticMessage(path, lang, data);
    }

    /**
     * Try broadcast this message to selected command senders, if message is disabled method will just return false.
     *
     * @param path    path to message.
     * @param targets targets of message.
     * @param lang    language to use if possible.
     * @param data    placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean broadcastStaticMessage(final String path, final Iterable<? extends CommandSender> targets, final Locale lang, final MessageData... data)
    {
        return msgs.broadcastStaticMessage(path, targets, lang, data);
    }

    /**
     * Try broadcast this message (to all players) in target player language if possible, if message is disabled method will just return false.
     *
     * @param path path to message.
     * @param lang default language to use if target don't have any.
     * @param data placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean broadcastMessage(final String path, final Locale lang, final MessageData... data)
    {
        return msgs.broadcastMessage(path, lang, data);
    }

    /**
     * Try broadcast this message to selected comamnd senders in target sender language if possible, if message is disabled method will just return false.
     *
     * @param path    path to message.
     * @param targets targets of message.
     * @param lang    default language to use if target don't have any.
     * @param data    placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean broadcastMessage(final String path, final Iterable<? extends CommandSender> targets, final Locale lang, final MessageData... data)
    {
        return msgs.broadcastMessage(path, targets, lang, data);
    }

    /**
     * Try broadcast this message (to all players) in target player language if possible, if message is disabled method will just return false.
     *
     * @param path path to message.
     * @param data placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean broadcastMessage(final String path, final MessageData... data)
    {
        return msgs.broadcastMessage(path, data);
    }

    /**
     * Try broadcast this message to selected comamnd senders in target sender language if possible, if message is disabled method will just return false.
     *
     * @param path    path to message.
     * @param targets targets of message.
     * @param data    placeholder objects to use.
     *
     * @return true if message was send.
     */
    public static boolean broadcastMessage(final String path, final Iterable<? extends CommandSender> targets, final MessageData... data)
    {
        return msgs.broadcastMessage(path, targets, data);
    }

    /**
     * Returns messages for given plugin, may return null if plugin don't use diorite message system. :(
     *
     * @param plugin plugin to get messages.
     *
     * @return messages for given plugin or null.
     */
    public static Messages getPluginMessages(final BasePlugin plugin)
    {
        return getMessages("plugins" + getNodeSeparator() + StringUtils.replaceEach(plugin.getName(), new String[]{Character.toString(getNodeSeparator()), ChildPlugin.CHILD_SEPARATOR}, new String[]{"_", getNodeSeparator() + "plugins" + getNodeSeparator()}));
    }

    /**
     * Returns node with messages on given path.
     *
     * @param path path to messages node, you may use '.' (by default) as path node separator. {@link #getNodeSeparator()}
     *
     * @return Another {@link Messages} node if exist.
     */
    public static Messages getMessages(final String path)
    {
        return msgs.getMessages(path);
    }

    /**
     * Returns node with messages on given path.
     *
     * @param path path to messages node, do not use any separator like dots here.
     *
     * @return Another {@link Messages} node if exist.
     */
    public static Messages getMessages(final String... path)
    {
        return msgs.getMessages(path);
    }

    /**
     * Returns message instance on given path.
     *
     * @param path path to messages node, you may use '.' (by default) as path node separator. {@link #getNodeSeparator()}
     *
     * @return message instance on given path.
     */
    public static Message getMessage(final String path)
    {
        return msgs.getMessage(path);
    }

    /**
     * Returns message instance on given path.
     *
     * @param path path to messages node, do not use any separator like dots here.
     *
     * @return message instance on given path.
     */
    public static Message getMessage(final String... path)
    {
        return msgs.getMessage(path);
    }

    /**
     * Add new message instance on given path.
     *
     * @param message message to add.
     * @param path    path to new messages node, do not use any separator like dots here.
     */
    public static void addMessage(final Message message, final String... path)
    {
        msgs.addMessage(message, path);
    }

    /**
     * Add new message instance on given path.
     *
     * @param message message to add.
     * @param path    path to new messages node, you may use '.' (by default) as path node separator. {@link #getNodeSeparator()}
     */
    public static void addMessage(final Message message, final String path)
    {
        msgs.addMessage(message, path);
    }

    /**
     * Returns node separator, '.' by default.
     *
     * @return node separator.
     */
    public static char getNodeSeparator()
    {
        return msgs.getNodeSeparator();
    }
}
