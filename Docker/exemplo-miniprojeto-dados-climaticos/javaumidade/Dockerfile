FROM tomcat:11.0.14-jdk25-temurin-noble
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp/umidade/src
RUN javac *.java
CMD ["java", "App"] 
