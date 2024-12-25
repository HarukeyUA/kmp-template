package org.example.project

import com.arkivanov.decompose.ComponentContext

interface EmptyComponent

class DefaultEmptyComponent(
    componentContext: ComponentContext
): EmptyComponent, ComponentContext by componentContext