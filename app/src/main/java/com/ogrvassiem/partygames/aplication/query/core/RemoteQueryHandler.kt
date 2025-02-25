package com.ogrvassiem.partygames.aplication.query.core

import arrow.core.Either
import com.ogrvassiem.partygames.aplication.utils.rest.TechnicalError

typealias RemoteQueryHandler<COMMAND, RESULT> = QueryHandler<COMMAND, @JvmSuppressWildcards Either<TechnicalError, RESULT>>