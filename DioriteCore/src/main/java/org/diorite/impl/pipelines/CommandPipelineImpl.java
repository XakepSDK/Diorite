package org.diorite.impl.pipelines;

import org.diorite.impl.ServerImpl;
import org.diorite.command.Command;
import org.diorite.command.sender.CommandSender;
import org.diorite.event.others.SenderCommandEvent;
import org.diorite.event.pipelines.CommandPipeline;
import org.diorite.utils.DioriteStringUtils;

public class CommandPipelineImpl extends EventPipelineImpl<SenderCommandEvent> implements CommandPipeline
{
    @Override
    public void reset_()
    {
        this.addFirst("Diorite|Cmd", (evt, pipeline) -> {
            if (evt.isCancelled() || (evt.getCommand() != null))
            {
                return;
            }
            evt.setCommand(this.server.getCommandMap().findCommand(evt.getMessage()));
        });
        this.addLast("Diorite|Exec", (evt, pipeline) -> {
            if (evt.isCancelled())
            {
                return;
            }
            final CommandSender sender = evt.getSender();
            if (evt.getCommand() == null)
            {
                sender.sendSimpleColoredMessage("&4No command: &c" + evt.getMessage());
                return;
            }
            final String[] args = DioriteStringUtils.splitArguments(evt.getMessage());
            if (args.length == 0)
            {
                return;
            }
            if (sender.isPlayer())
            {
                ServerImpl.getInstance().getConsoleSender().sendMessage(sender.getName() + ": " + Command.COMMAND_PREFIX + evt.getMessage());
            }
            //else if (sender.isCommandBlock()) TODO
            final String command = args[0];
            final String[] newArgs;
            if (args.length == 1)
            {
                newArgs = Command.EMPTY_ARGS;
            }
            else
            {
                newArgs = new String[args.length - 1];
                System.arraycopy(args, 1, newArgs, 0, args.length - 1);
            }
            evt.getCommand().tryDispatch(sender, command, newArgs);
        });
    }
}
