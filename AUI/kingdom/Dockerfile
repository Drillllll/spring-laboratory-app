FROM eclipse-temurin:17.0.9_9-jre


ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8060

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:kingdom
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV SPECIES_URL=http://localhost:8070

EXPOSE 8060

COPY target/kingdom-${VERSION}.jar /opt/kingdom/kingdom.jar

CMD ["java", "-jar", "/opt/kingdom/kingdom.jar"]
