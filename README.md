![Assertiva](https://github.com/alexandretrieste/image_for_Readme/blob/main/assertiva.png)
# Teste Técnico Assertiva

Este é um teste técnico da Assertiva para a vaga de desenvolvedor Mid-Level Java.

## Objetivos

 - Desenvolver uma API para cadastro de Clientes (ID, CPF, Nome, Celulares (um ou mais), E-mails (um ou mais)).
 - Requisitos:
 - Spring boot ou NodeJs;
 - Mysql ou Postgres;
 - Usar queries nativas do SQL;
 - Criar a API para Realizar o CRUD seguindo o padrão REST;
 - Listagem com possibilidade de filtrar por DDD dos Celulares, trazendo todos os clientes que possuem celulares com aquele DDD;
 - Listagem com possibilidade de filtrar por uma parte do nome;
 - Disponibilizar collection do Postman ou Swagger para a API;
 - Criar Dockerfile do projeto.
 - Subir código em um repositório git
 - * Se preferir, pode usar também sqlite, h2 ou até colocar um docker compose subindo uma instância de docker de banco junto também.

## Descrição do Projeto

O projeto consiste em uma API REST que permite o cadastro, atualização, exclusão e consulta de clientes. Os dados dos clientes são armazenados em um banco de dados, que é executado em um container Docker. A API foi desenvolvida em Java com Spring Boot e a documentação dos endpoints foi feita no Postman.

## Requisitos

- Docker
- Docker Compose
- Java
- IDE da sua escolha
- Postman ou Insomnia
- SGBD da sua escolha

## Como executar o projeto

1. Faça um fork do repositório para sua máquina local
2. Utilizando o terminal faça `mvn clean package`
3. Caso queira rodar localmente ` ./mvnw spring-boot:run`
4. Caso prefira rodar via docker, navegue até a raiz do projeto e execute o seguinte comando: `docker-compose up --build`
5. A aplicação estará disponível em http://localhost:8080
6. A documentação dos endpoints da API pode ser encontrada em https://documenter.getpostman.com/view/18676163/2s93XyTNo8

## Resumo dos Endpoints da API

- `GET /clientes`: retorna a lista de todos os clientes cadastrados
- `GET /clientes/{id}`: retorna os dados de um cliente específico
- `GET /clientes/nome/{{nome}}`: retorna a parte do nome buscada
- `GET /clientes/ddd/{{ddd}}`: retorna os clientes que possuem o ddd buscado
- `POST /clientes`: cadastra um novo cliente
- `PUT /clientes/{id}`: atualiza os dados de um cliente específico
- `DELETE /clientes/{id}`: exclui um cliente específico

## licença
### - MIT

#### By Alexandre Trieste - Java Software Engineer
##### [Clique para entrar em contato.](https://www.linkedin.com/in/alexandretrieste/)
