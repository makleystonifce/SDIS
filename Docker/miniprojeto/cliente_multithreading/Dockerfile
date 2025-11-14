FROM openjdk:26-ea-23-jdk
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp/client/src
RUN javac *.java
CMD ["java", "App"]