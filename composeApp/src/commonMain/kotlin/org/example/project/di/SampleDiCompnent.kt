package org.example.project.di

import com.arkivanov.decompose.ComponentContext
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Provides
import org.example.project.*
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesTo

// TODO: Remove when kotlin-inject-anvil supports assisted inject. See: https://github.com/amzn/kotlin-inject-anvil/issues/92
@ContributesTo(AppScope::class)
interface SampleDiCompnent {
    @Provides
    fun provideRootComponent(
        @Assisted componentContext: ComponentContext,
        emptyComponentFactory: EmptyComponentFactory
    ): RootComponent = DefaultRootComponent(
        componentContext = componentContext,
        emptyComponentFactory = emptyComponentFactory
    )

    @Provides
    fun provideEmptyComponent(
        @Assisted componentContext: ComponentContext
    ): EmptyComponent = DefaultEmptyComponent(componentContext)
}