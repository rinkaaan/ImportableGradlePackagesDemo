plugins {
    kotlin("jvm") version "1.9.20"
    application
    id("com.github.ben-manes.versions") version "0.49.0"
}

group = "com.nguylinc"
version = "0.1.0"

repositories {
    maven {
        url = uri("https://nguylinc-542773719222.d.codeartifact.us-east-1.amazonaws.com/maven/maven-central-store/")
        credentials {
            username = "aws"
            password = project.property("codeartifact.auth_token").toString()
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
    // implementation("com.nguylinc:importable-package:0.1.0")
    implementation(files("../ImportablePackage/build/libs/importablepackage-0.1.0.jar"))
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
