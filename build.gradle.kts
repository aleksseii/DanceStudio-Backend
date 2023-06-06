@file:Suppress("VulnerableLibrariesLocal")

plugins {
    id("java")
}

group = "ru.aleksseii"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")

    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    implementation("org.springframework:spring-core:6.0.6")

    implementation("org.springframework.boot:spring-boot:3.1.0")
    implementation("org.springframework.boot:spring-boot-devtools:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("org.springframework.boot:spring-boot-configuration-processor:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.0")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")

    implementation("com.google.code.gson:gson:2.10.1")

//    -------------- database --------------
    implementation("org.liquibase:liquibase-core:4.22.0")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:3.1.0")
    implementation("org.postgresql:postgresql:42.6.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
