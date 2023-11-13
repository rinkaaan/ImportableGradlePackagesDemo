plugins {
    kotlin("jvm") version "1.9.20"
    application
    id("com.github.ben-manes.versions") version "0.49.0"
}

group = "com.nguylinc"
version = "0.1.0"

repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/rinkaaan/ImportablePackage")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
        metadataSources {
            mavenPom()
            artifact()
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(files("../ImportablePackage/build/libs/importablepackage-0.1.0.jar"))
    // implementation("com.nguylinc:importablepackage:0.1.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(20)
}

application {
    mainClass.set("com.nguylinc.importingpackage.MainKt")
}
