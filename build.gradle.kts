import org.gradle.api.tasks.testing.Test
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
    jacoco
}

allprojects {
    group = "com.github.tkaptanoglu"
    version = "0.1.0"
}

subprojects {
    // Apply plugins to every subproject
    plugins.apply("java-library")
    plugins.apply("jacoco")

    repositories {
        mavenCentral()
    }

    // Configure the Java plugin via the typed extension (safe in Kotlin DSL)
    extensions.configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(24))
        }
        withJavadocJar()
        withSourcesJar()
    }

    // JUnit 5 for all Test tasks
    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
        // Make coverage run after tests
        finalizedBy(tasks.named("jacocoTestReport"))
    }

    // Configure the JaCoCo report task by type/name
    tasks.withType<JacocoReport>().configureEach {
        reports {
            xml.required.set(true)
        }
    }
}