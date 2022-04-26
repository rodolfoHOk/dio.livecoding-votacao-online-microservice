# Live Coding - Criando o sistema de VOTAÇÃO ONLINE do BBB - DIO

# Java Microservice com Kakfa (Consumer) e Mongo DB

> Projeto do Back-End MicroService Kafka Consumer realizado durante a live coding Criando o sistema de VOTAÇÃO ONLINE do BBB da DIO com Rodrigo Tavares (Avanade) e Juliana Mascarenhas (DIO)

## Tecnologias do back-end

- Java : Linguagem programação
- Spring : Framework Java
- MongoDB : Banco de Dados noSQL
- Kafka : Mensageria
- Docker : Container

## Docker-Compose

- MongoDB

		version: '3.1'
		services:
		  mongo:
		    image: mongo:4.4
		    restart: always
		    ports:
		      - 27017:27017
		    environment:
		      MONGO_INITDB_ROOT_USERNAME: root
		      MONGO_INITDB_ROOT_PASSWORD: root
		  mongo-express:
		    image: mongo-express
		    restart: always
		    ports:
		      - 8081:8081
		    environment:
		      ME_CONFIG_MONGODB_ADMINUSERNAME: root
		      ME_CONFIG_MONGODB_ADMINPASSWORD: root
		      ME_CONFIG_MONGODB_URL: mongodb://root:root@mongo:27017/
		      
- Kafka

		version: "3"
		services:
		  zookeeper:
		    image: 'bitnami/zookeeper:latest'
		    ports:
		      - '2181:2181'
		    environment:
		      - ALLOW_ANONYMOUS_LOGIN=yes
		  kafka:
		    image: 'bitnami/kafka:latest'
		    ports:
		      - '9092:9092'
		    environment:
		      - KAFKA_BROKER_ID=1
		      - KAFKA_CFG_LISTENERS=PLAINTEXT://:9092
		      - KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092
		      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
		      - ALLOW_PLAINTEXT_LISTENER=yes
		    depends_on:
		      - zookeeper
		      
## Ferramentas

Offset Explorer : Kafka tool

Mongo Express : Web-based MongoDB admin interface

Insomnia : The Collaborative API Client and Design Tool
