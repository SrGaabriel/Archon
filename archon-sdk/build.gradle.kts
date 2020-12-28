plugins {
    kotlin("jvm")
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

group = "com.archon.project"
version = "1.0.0"

repositories {
    jcenter()
    mavenCentral()
    maven("http://nexus.devsrsouza.com.br/repository/maven-public/")
}

dependencies {
    implementation(project(":archon-api"))

    val changing = Action<ExternalModuleDependency> { isChanging = true }
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:core:0.2.0-SNAPSHOT", changing)
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:serialization:0.2.0-SNAPSHOT", changing)
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:plugins:0.2.0-SNAPSHOT", changing)
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:exposed:0.2.0-SNAPSHOT", changing)

    //plugins
    val transitive = Action<ExternalModuleDependency> { isTransitive = false }
}

bukkit {
    main = "com.archon.project.archon.ArchonPlugin"
    depend = listOf("KotlinBukkitAPI")
    description = ""
    author = "SrGaabriel"
    website = ""
}

tasks {
    shadowJar {
        classifier = null
    }
}