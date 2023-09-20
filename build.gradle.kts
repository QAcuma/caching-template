plugins {
    id("java")
    id("org.springframework.boot") version "3.1.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:3.1.3")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.3")

    implementation("org.springframework.boot:spring-boot-starter-cache:3.1.3")
    implementation("org.springframework.boot:spring-boot-starter-data-redis:3.1.3")

    implementation("javax.cache:cache-api:1.1.1")

    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
    implementation("com.github.ben-manes.caffeine:jcache:3.1.8")

    implementation("org.redisson:redisson:3.23.3")

    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}