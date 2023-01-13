FROM adoptopenjdk/openjdk11
# Refer to Maven build -> finalName
ARG JAR_FILE=target/news-search.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/news-search.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]