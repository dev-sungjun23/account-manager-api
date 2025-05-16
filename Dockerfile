# 1. Java 17을 기반 이미지로 설정
FROM eclipse-temurin:17-jdk-alpine

# 2. 애플리케이션 JAR 복사
COPY build/libs/account-manager-api-*.jar app.jar

# 3. 컨테이너 실행 시 실행할 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]