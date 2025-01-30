package com.ogrvassiem.partygames.aplication.command.core

fun interface CommandHandler<COMMAND : Command<RESULT>, RESULT> {

    suspend fun handle(command: COMMAND): RESULT
}