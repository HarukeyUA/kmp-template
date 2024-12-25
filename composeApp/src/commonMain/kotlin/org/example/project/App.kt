package org.example.project

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        Children(
            stack = rootComponent.stack,
            animation = predictiveBackAnimation(
                backHandler = rootComponent.backHandler,
                fallbackAnimation = stackAnimation(fade() + scale()),
                onBack = rootComponent::onBackClicked,
            ),
        ) {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                when (val child = it.instance) {
                    is RootComponent.Child.EmptyChild -> {
                        Text(
                            modifier = Modifier.fillMaxSize(),
                            text = "Empty component",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}