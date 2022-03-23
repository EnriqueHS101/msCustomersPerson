FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
ADD target/msCustomersPerson-0.0.1-SNAPSHOT.jar customers-person.jar
RUN bash -c 'touch /customers-person.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /customers.person.jar"]