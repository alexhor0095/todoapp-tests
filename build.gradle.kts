
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.qameta.allure") version "2.9.6"
    application
    id("io.gitlab.arturbosch.detekt").version("1.22.0")
}

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0")
    }
}

apply(plugin = "io.gitlab.arturbosch.detekt")

group = "org.example"
version = "1.0-SNAPSHOT"

configurations {}

val cucumberRuntime by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.platform:junit-platform-suite:1.8.1")
    implementation("io.cucumber:cucumber-java:7.2.3")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.10.1")
    implementation("io.qameta.allure:allure-cucumber7-jvm:2.17.3")
    testImplementation("io.cucumber:cucumber-junit:7.2.3")
}

detekt {
    toolVersion = "1.22.0"
    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

task("cucumber"){
    dependsOn("assemble", "compileTestJava")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
            // Change glue for your project package where the step definitions are.
            // And where the feature files are.
            args = listOf("--plugin", "pretty",
                "--glue", "com.example.feature", "src/test/resources",
                "--plugin", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
        }
    }
}
//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
/* cucumber() {
    dependsOn assemble, testClasses
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = ['--plugin', 'html:results.html',
                '--plugin', 'pretty',
                '--plugin', 'io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm',
                '--glue', 'step_definitions',
                'src/test/resources']
        }
    }
}*/
