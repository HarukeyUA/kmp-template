package org.example.project.di

import com.arkivanov.decompose.ComponentContext
import org.example.project.RootComponent
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class AppDIComponent {
    abstract val rootComponentFacotry: (componentContext: ComponentContext) -> RootComponent
}

@MergeComponent.CreateComponent
expect fun create(): AppDIComponent

@Suppress("Unused") // Used in swift
fun createDi(): AppDIComponent {
    return create()
}