package org.example.project.di

import android.content.Context
import com.arkivanov.decompose.ComponentContext
import me.tatarka.inject.annotations.Inject
import me.tatarka.inject.annotations.Provides
import org.example.project.RootComponent
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class AppComponent(
    @get:Provides val context: Context
) {
    abstract val rootComponentFacotry: (componentContext: ComponentContext) -> RootComponent
}