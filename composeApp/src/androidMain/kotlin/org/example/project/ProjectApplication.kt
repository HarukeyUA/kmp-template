package org.example.project

import android.app.Application
import org.example.project.di.AppComponent
import org.example.project.di.create

class ProjectApplication : Application() {
    val appDiComponent: AppComponent by lazy(LazyThreadSafetyMode.NONE) {
        AppComponent::class.create(applicationContext)
    }
}