import org.jetbrains.kotlin.gradle.dsl.JvmTarget

// TODO: Move duplicated config to convention plugins
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ktfmt)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.core.ktx)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.runtime.compose)
            api(libs.decompose)
            implementation(libs.decompose.compose)
            api(libs.essenty.lifecycle)
            api(libs.essenty.backhandler)
            api(libs.essenty.statekeeper)

            implementation(libs.kotlinx.serialization.json)

            api(libs.bundles.kotlinInject)
        }
    }
}

android {
    namespace = "org.example.project.core.common"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    debugImplementation(compose.uiTooling)

    ksp(libs.kotlininject.compiler)
    ksp(libs.kotlinInject.anvil.compiler)
}

ktfmt {
    kotlinLangStyle()
}
