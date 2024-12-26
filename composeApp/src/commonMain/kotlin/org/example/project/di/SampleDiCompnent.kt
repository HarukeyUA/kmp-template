package org.example.project.di

import com.arkivanov.decompose.ComponentContext
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Provides
import org.example.project.DefaultEmptyComponent
import org.example.project.DefaultRootComponent
import org.example.project.EmptyComponent
import org.example.project.RootComponent
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesTo

// TODO: Remove, when kotlin-inject-anvil supports assisted inject
@ContributesTo(AppScope::class)
interface SampleDiCompnent {
    @Provides
    fun provideRootComponent(
        @Assisted componentContext: ComponentContext,
        emptyComponentFactory: (componentContext: ComponentContext) -> EmptyComponent
    ): RootComponent = DefaultRootComponent(
        componentContext = componentContext,
        emptyComponentFactory = emptyComponentFactory
    )

    @Provides
    fun provideEmptyComponent(
        @Assisted componentContext: ComponentContext
    ): EmptyComponent = DefaultEmptyComponent(componentContext)
}