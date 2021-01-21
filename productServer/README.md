# Ecom-Product-Microservice

Projeti usando o mongodb.

# MongoDB

Para utilizar o mongo, use o projeto [dockerMongoDB](https://github.com/danielso2007/dockerMongoDB) para criar um container docker.

# HAL e o navegador HAL

[JSON Hypertext Application Language](http://stateless.co/hal_specification.html) , ou HAL, é um formato simples que oferece uma maneira consistente e fácil de criar um hiperlink entre recursos em nossa API . Incluir HAL em nossa API REST torna-o muito mais explorável para os usuários, além de ser essencialmente autodocumentado.
Ele funciona retornando dados no formato JSON, que descreve informações relevantes sobre a API.
O modelo HAL gira em torno de dois conceitos simples.

Recursos, que contêm:

* Links para URIs relevantes
* Recursos Embutidos
* Estado

Links:

* Um URI de destino
* Uma relação, ou rel, com o link
* Algumas outras propriedades opcionais para ajudar na depreciação, negociação de conteúdo, etc.

O navegador HAL foi criado pela mesma pessoa que desenvolveu o HAL e fornece uma GUI no navegador para atravessar sua API REST.

Veja mais exemplos aqui [spring-rest-hal](https://www.baeldung.com/spring-rest-hal).
