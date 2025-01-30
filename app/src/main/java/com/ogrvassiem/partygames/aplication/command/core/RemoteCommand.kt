package com.ogrvassiem.partygames.aplication.command.core

import arrow.core.Either
import com.ogrvassiem.partygames.aplication.utils.rest.TechnicalError

typealias RemoteCommand<RESULT> = Command<@JvmSuppressWildcards Either<TechnicalError, RESULT>>