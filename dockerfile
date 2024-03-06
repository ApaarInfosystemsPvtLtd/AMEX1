FROM uatdockermsr.pmli.corp/infra/openjdk:8-jre-alpine
VOLUME /tmp
ARG JAR_FILE
ADD amex-0.0.1-SNAPSHOT.jar /amex-0.0.1-SNAPSHOT.jar
ENV TZ=Asia/Kolkata
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${spring_profiles_active}","-jar","/amex-0.0.1-SNAPSHOT.jar"]