package org.example.project

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import kotlinx.serialization.Serializable
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject
import org.example.project.RootComponent.Child.EmptyChild
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

interface RootComponent : BackHandlerOwner {
    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked()

    sealed class Child {
        class EmptyChild(val component: EmptyComponent) : Child()
    }
}

class DefaultRootComponent(
    componentContext: ComponentContext,
    private val emptyComponentFactory: (componentContext: ComponentContext) -> EmptyComponent
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialStack = { listOf(Config.DefaultScreen) },
            childFactory = ::child
        )
    override val stack: Value<ChildStack<*, RootComponent.Child>> = _stack

    override fun onBackClicked() {
        navigation.pop()
    }

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child = when (config) {
        Config.DefaultScreen -> EmptyChild(emptyComponentFactory(componentContext))
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object DefaultScreen : Config
    }
}
