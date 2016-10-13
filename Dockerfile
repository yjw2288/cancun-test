FROM yjw2288/ubuntu

# Install Java.
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer


# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle


WORKDIR /root
RUN mkdir /root/app
COPY build.gradle /root/app/build.gradle
ADD gradle /root/app/gradle
COPY gradlew /root/app/gradlew
ADD src /root/app/src

WORKDIR /root/app
RUN ./gradlew build -x test

CMD java -jar -Dspring.profiles.active=product /root/app/build/libs/gs-spring-boot-0.1.0.jar
EXPOSE 8080
