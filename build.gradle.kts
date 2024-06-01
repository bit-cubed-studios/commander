plugins {
    id("java")
    id("maven-publish")
}

group = "com.github.bitcubed"
version = "SNAPSHOT-0.9.3"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")

}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
    implementation("org.jooq:joor:0.9.14")
    implementation("org.jetbrains:annotations:24.0.0")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.bitcubed"
            artifactId = "commander"
            version = "SNAPSHOT-0.9.3"

            from(components["java"])
        }
    }
}