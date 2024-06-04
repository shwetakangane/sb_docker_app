FROM openjdk:17
COPY /target/sb_docker_app.jar /usr/target/
WORKDIR /usr/target/                        
ENTRYPOINT [ "java", "-jar", "sb_docker_app.jar"]
EXPOSE 8086