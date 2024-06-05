FROM openjdk:17
#COPY /target/sb_docker_app.jar /usr/target/
COPY target/demo-*.jar /demo.jar
#WORKDIR /usr/target/                        
#ENTRYPOINT [ "java", "-jar", "sb_docker_app.jar"]
CMD [ "java", "-jar","-noverify", "/demo.jar"]
EXPOSE 8086