package com.ogrvassiem.partygames.di

import com.ogrvassiem.partygames.aplication.command.core.Command
import com.ogrvassiem.partygames.aplication.command.core.CommandHandler
import com.ogrvassiem.partygames.aplication.command.operations.UpdateShowOnboardingCommand
import com.ogrvassiem.partygames.aplication.command.operations.UpdateShowOnboardingCommandHandler
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
@InstallIn(SingletonComponent::class)
abstract class CommandsModule {

    @MapKey
    annotation class CommandHandlerKey(val value: KClass<out Command<*>>)

    @Binds
    @IntoMap
    @CommandHandlerKey(UpdateShowOnboardingCommand::class)
    abstract fun bindUpdateShowOnboardingCommandHandler(
        handler: UpdateShowOnboardingCommandHandler
    ): CommandHandler<*, *>

}