FROM openjdk:8
EXPOSE 10009
ADD ./target/pranitproject-0.0.1-SNAPSHOT.jar pranit.jar
ENTRYPOINT [ "java", "-jar","/pranit.jar" ]