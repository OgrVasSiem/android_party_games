package com.ogrvassiem.partygames.aplication.command.core

import arrow.core.Either
import com.ogrvassiem.partygames.aplication.utils.rest.TechnicalError

typealias RemoteCommandHandler<COMMAND, RESULT> = CommandHandler<COMMAND, @JvmSuppressWildcards Either<TechnicalError, RESULT>>