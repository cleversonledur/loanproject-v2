#!/bin/sh

docker-compose up -d

cd frontend/ui/
ng serve

