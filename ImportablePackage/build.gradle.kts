plugins {
    kotlin("jvm") version "1.9.20"
    // id("pl.allegro.tech.build.axion-release") version "1.15.5"
    id("com.github.ben-manes.versions") version "0.49.0"
    `maven-publish`
}

group = "com.nguylinc"
// version = scmVersion.version
version = "0.1.0"

repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/rinkaaan/ImportablePackage")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
            artifactId = "importablepackage"
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(20)
}
