FROM openjdk:11
MAINTAINER rodneybarreto
WORKDIR /opt/minipets/products
ARG APP=build/libs/products-1.0.0.jar
COPY ${APP} products.jar
RUN mkdir /opt/minipets/products/img
COPY products-images/* /opt/minipets/products/img/
EXPOSE 8081
ENTRYPOINT ["java","-jar","products.jar"]