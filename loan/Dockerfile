FROM java:8-jre
MAINTAINER Cleverson Ledur <cleversonledur@gmail.com>

ADD ./target/loan.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/loan.jar"]

EXPOSE 9095
