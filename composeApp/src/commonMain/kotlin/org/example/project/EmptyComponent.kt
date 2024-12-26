package org.example.project

import com.arkivanov.decompose.ComponentContext
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

interface EmptyComponent

class DefaultEmptyComponent(
    componentContext: ComponentContext
) : EmptyComponent, ComponentContext by componentContext