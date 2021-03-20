#!/usr/bin/env sh

## Generate docker image
docker build . -t rodneybarreto/minipets_products-api:1.0.0

## Push to docker hub
#docker push rodneybarreto/minipets_products-api:1.0.0

## Run container
#docker run --name products-api -p 8081:8081 rodneybarreto/minipets_products-api:1.0.0