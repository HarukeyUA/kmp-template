package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.retainedComponent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root =
            retainedComponent { componentContext ->
                (this@MainActivity.application as ProjectApplication)
                    .appDiComponent
                    .rootComponentFacotry(componentContext)
            }

        setContent { App(root) }
    }
}
