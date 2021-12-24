import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
}

group = "dev.erickvieira.ppcc.service"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    val springBootVersion = property("springBootVersion")
    val springCloudConfigVersion = "3.0.6"
    val kotlinPluginsVersion = "1.6.0"
    val eurekaServerVersion = "3.1.0"

    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinPluginsVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinPluginsVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-config:$springCloudConfigVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:$eurekaServerVersion")

    developmentOnly("org.springframework.boot:spring-boot-devtools:$springBootVersion")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
