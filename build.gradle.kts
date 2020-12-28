plugins {
    java
    kotlin("jvm") version "1.4.0"
}

allprojects {
    group = "com.archon.project"
    version = "1.0.0"

    plugins.apply("java")

    repositories {
        jcenter()
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }

    dependencies {
        compileOnly(kotlin("stdlib-jdk8"))

        compileOnly("org.github.paperspigot:paperspigot-api:1.8.8-R0.1-SNAPSHOT")
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime,kotlin.ExperimentalStdlibApi"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime,kotlin.ExperimentalStdlibApi"
    }
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(120, "seconds")
}