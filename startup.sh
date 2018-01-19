#!/usr/bin/env bash

mvn clean package

docker build -t ancina/user-stat .

docker run -d -p 8087:8087 -t ancina/user-stat