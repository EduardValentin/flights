FROM openjdk:11-jre

EXPOSE 8080
WORKDIR /usr/share/@project.artifactId@

COPY lib /usr/share/@project.artifactId@/lib/
COPY @project.build.finalName@.jar /usr/share/@project.artifactId@


ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar @project.build.finalName@.jar" ]