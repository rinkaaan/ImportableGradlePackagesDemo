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
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "importable-package"
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("https://nguylinc-542773719222.d.codeartifact.us-east-1.amazonaws.com/maven/maven-central-store/")
            credentials {
                username = "aws"
                password = project.property("codeartifact.auth_token").toString()
            }
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
