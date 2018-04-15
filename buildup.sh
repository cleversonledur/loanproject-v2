#!/bin/sh

cd eureka-server ; ./mvnw clean install -U -Dmaven.test.skip=true; cd ..
cd gateway-server ; ./mvnw clean install -U -Dmaven.test.skip=true; cd ..

cd commons ; ./mvnw clean install -U -Dmaven.test.skip=true; cd ..
cd loan ; ./mvnw clean install -U -Dmaven.test.skip=true; cd ..
cd customer ; ./mvnw clean install -U -Dmaven.test.skip=true; cd ..

docker-compose build 
docker-compose up -d

cd frontend/ui/
ng build
ng serve

echo "Done! You can access this application in http://localhost:4200/"
