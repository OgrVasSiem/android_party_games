package com.ogrvassiem.partygames.aplication.command.operations

import com.ogrvassiem.partygames.aplication.command.core.Command
import com.ogrvassiem.partygames.aplication.command.core.CommandHandler
import com.ogrvassiem.partygames.data.dataStore.ShowOnboardingDataStore
import javax.inject.Inject

data object UpdateShowOnboardingCommand : Command<Unit>

class UpdateShowOnboardingCommandHandler @Inject constructor(
    private val showOnboardingDataStore: ShowOnboardingDataStore
) : CommandHandler<UpdateShowOnboardingCommand, Unit> {

    override suspend fun handle(command: UpdateShowOnboardingCommand) {
        showOnboardingDataStore.updateData { false }
    }
}