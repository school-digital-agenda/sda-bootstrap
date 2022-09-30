import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.7.10"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    id("org.springframework.boot") version "2.7.2"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
    id("org.flywaydb.flyway") version "9.4.0"
    id("jacoco")
}

group = "br.com.sda.bootstrap"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.bootJar {
    enabled = false
}
tasks.jar {
    enabled = false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}

dependencies {
    implementation("org.postgresql:postgresql")
}
