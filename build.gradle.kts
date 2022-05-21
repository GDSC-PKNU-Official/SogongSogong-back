import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("plugin.jpa") version "1.6.10" //이거 없으면 Constructor 자동 생성 안됨
	id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10" //kotlin의 final class 억지로 open으로 열어줌
}

group = "sogong"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.projectlombok:lombok:1.18.22")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("mysql:mysql-connector-java")
	implementation("org.javassist:javassist:3.15.0-GA")
	implementation("org.projectlombok:lombok:1.18.22")// lombok 추가
	implementation("com.squareup.okhttp3:okhttp:4.9.3")
	implementation("org.springframework.boot:spring-boot-starter-security")
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


allOpen{
	annotation("javax.persistence.Entity") //@Entity로 선언된 class는... final이 아닌 open입니다이...
}
noArg{
	annotation("javax.persistence.Entity") //@Entity에 Consturctor 자동으로 만들어주세요이...
}