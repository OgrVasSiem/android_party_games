package com.ogrvassiem.partygames.aplication.query.core

import arrow.core.Either
import com.foresko.gptChat.aplication.utils.rest.TechnicalError

typealias RemoteQuery<RESULT> = Query<@JvmSuppressWildcards Either<TechnicalError, RESULT>>

