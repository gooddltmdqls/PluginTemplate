import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import xyz.jpenilla.runpaper.task.RunServer

plugins {
    kotlin("jvm") version "1.9.22"
    id("xyz.jpenilla.run-paper") version "2.2.2"
    application
}

group = "xyz.icetang.plugin"
version = properties["version"]!!

val pluginName = properties["pluginName"]!!

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${properties["paperApiVersion"]!!}-R0.1-SNAPSHOT")
    implementation("xyz.icetang.lib:kommand-api:${properties["kommandVersion"]!!}")
}

tasks.withType<ProcessResources> {
    inputs.property("version", version)
    inputs.property("pluginName", pluginName)
    inputs.property("bukkitApiVersion", properties["bukkitApiVersion"]!!)
    inputs.property("kommandVersion", properties["kommandVersion"]!!)

    filesMatching("plugin.yml") {
        expand(mapOf(
            Pair("version", version),
            Pair("pluginName", pluginName),
            Pair("bukkitApiVersion", properties["bukkitApiVersion"]!!),
            Pair("kommandVersion", properties["kommandVersion"]!!)
        ))
    }
}

tasks.withType<RunServer> {
    minecraftVersion(properties["paperApiVersion"]!! as String)

    minHeapSize = "512M"
    maxHeapSize = "2G"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}