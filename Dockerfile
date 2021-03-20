FROM openjdk:11
MAINTAINER rodneybarreto
WORKDIR /opt/minipets/products
ARG APP=build/libs/products-1.0.0.jar
COPY ${APP} products.jar
ENTRYPOINT ["java","-jar","products.jar"]