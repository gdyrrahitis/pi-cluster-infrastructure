package com.codereform.socket.client.commands;

import mymessages.Command;

public interface ICommand {
    Command.ansibleCommand createCommand();
}
