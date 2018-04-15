FROM java:8-jre
MAINTAINER Cleverson Ledur <cleversonledur@gmail.com>

ADD ./target/customer.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/customer.jar"]

EXPOSE 9094
