package com.ogrvassiem.partygames.aplication.query.core

import arrow.core.Either
import com.ogrvassiem.partygames.aplication.utils.rest.TechnicalError

typealias RemoteQuery<RESULT> = Query<@JvmSuppressWildcards Either<TechnicalError, RESULT>>

