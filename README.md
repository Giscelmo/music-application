🎧 Screen Sound Music Application

📌 Visão Geral

Sistema backend desenvolvido com Java + Spring Boot, projetado com arquitetura escalável e integração com OpenAI API, permitindo gerenciamento inteligente de artistas e músicas.

Este projeto demonstra competências em:

Arquitetura corporativa

Integração com IA

Persistência avançada

Design profissional

Clean Code

Boas práticas utilizadas em empresas FAANG

🎬 Demonstração

🧠 Integração com Inteligência Artificial

O sistema integra com a API da OpenAI para enriquecer dados de artistas automaticamente.

Fluxo:

Usuário digita artista

↓

Sistema consulta OpenAI

↓

Resposta enriquecida exibida


Classe responsável:

OpenAIService.java


Tecnologias:

OpenAI Java SDK

REST API

JSON Parsing

🏗 Arquitetura

Arquitetura baseada em princípios de separação de responsabilidades:

Principal Layer

↓

Service Layer

↓

Repository Layer

↓

Database Layer

📂 Estrutura
MusicApplication

model/

repository/

service/

principal/

docs/

🧱 Modelo de Dados
Artista
id
nome
tipo

Musica
id
nomeMusica
album
generoMusical
tempoMusica
artista_id


Relacionamento:

1:N

Artista → Musicas

⚙ Stack Tecnológica

Java 25

Spring Boot 4

Spring Data JPA

Hibernate

PostgreSQL

OpenAI API

Maven

🚀 Execução

Clone:

git clone https://github.com/Giscelmo/MusicApplication


Entre:

cd MusicApplication


Configure:

application.properties


Execute:

./mvnw spring-boot:run

🧪 Práticas de Engenharia Utilizadas

Separação em camadas

Injeção de dependência

ORM com JPA

Tratamento de exceções

Integração externa

Versionamento profissional com Git

🔒 Segurança

Credenciais protegidas via:

application.properties ignorado


Arquivo exemplo:

application-example.properties

📈 Escalabilidade

Preparado para:

Transformação em API REST

Deploy em Cloud

Dockerização

Microserviços

🧠 Conceitos aplicados

Domain Driven Design

Separation of Concerns

Dependency Injection

Clean Architecture

🎯 Objetivo

Projeto criado com foco em:

Portfólio profissional

Demonstração de habilidades avançadas

Preparação para mercado internacional

👨‍💻 Autor

Giscelmo Costa

GitHub

https://github.com/Giscelmo

LinkedIn

https://linkedin.com/in/giscelmo-costa

⭐ Destaques Técnicos

Integração com IA

Arquitetura profissional

Persistência relacional

Código limpo

Pronto para produção