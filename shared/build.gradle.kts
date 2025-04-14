plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    compilerOptions {
        progressiveMode = true
        allWarningsAsErrors = false
    }

    macosArm64()
    linuxArm64()

    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlinx.coroutines.core)
                api(libs.kotlinx.datetime)
                api(libs.ktor.client.core)
                api(libs.ktor.client.cio)
                api(libs.ktor.client.content.negotiation)
                api(libs.ktor.client.encoding)
                api(libs.ktor.client.logging)
                api(libs.ktor.client.resources)
                api(libs.ktor.client.auth)
                api(libs.ktor.client.serialization)
                api(libs.ktor.client.websockets)
                api(libs.ktor.serialization.json)
            }
        }

        nativeMain {
            dependencies {
                api(libs.ktor.client.curl)
            }
        }
    }
}