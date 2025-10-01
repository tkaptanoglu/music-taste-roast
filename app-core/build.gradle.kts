plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // Explicit version to avoid BOM/aggregation confusion
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

tasks.test {
    useJUnitPlatform()
}
