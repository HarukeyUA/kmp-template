package org.example.project

import com.arkivanov.decompose.ComponentContext

typealias EmptyComponentFactory = (compoenentContext: ComponentContext) -> EmptyComponent

interface EmptyComponent

class DefaultEmptyComponent(
    componentContext: ComponentContext
) : EmptyComponent, ComponentContext by componentContext