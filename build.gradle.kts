plugins {
    kotlin("jvm") version "2.2.21"
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "9.2.1"
    }
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation("org.assertj:assertj-core:3.27.6")
}