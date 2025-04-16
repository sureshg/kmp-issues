import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    macosArm64()
    linuxArm64()

    targets.withType<KotlinNativeTarget>().configureEach {
        binaries {
            executable(setOf(RELEASE)) {
                entryPoint = "main"
                if (target.konanTarget.family == Family.LINUX) {
                    linkerOpts("-Wl,--as-needed", "-Wl,-Bstatic", "-lz", "-Wl,-Bdynamic")
                    // freeCompilerArgs += "-Xoverride-konan-properties=linkerGccFlags.linux=-lgcc -lgcc_eh -lc"
                }
            }
        }
    }

    sourceSets {
        commonMain { dependencies { api(projects.shared) } }
    }
}