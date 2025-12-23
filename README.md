👑 Clash Royale WhatsApp Bot

> Um bot automatizado que monitora notícias do Clash Royale e envia novidades em tempo real para grupos do WhatsApp.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)
![Status](https://img.shields.io/badge/Status-Active-success)

## Sobre o Projeto

Este projeto é um **Bot de Notícias** desenvolvido em Java. Ele realiza **Web Scraping** em um site oficial/fã de Clash Royale para detectar novas postagens. Assim que uma novidade é encontrada, ele a envia automaticamente para um grupo do WhatsApp utilizando a **Green API** uma vez ao dia.

O sistema possui inteligência para não enviar notícias repetidas, utilizando um banco de dados para armazenar o histórico de envios.

## Funcionalidades

-   🤖 **Monitoramento Automático:** Verifica novas notícias diariamente (configurável via Cron).
-   📢 **Envio para WhatsApp:** Integração via API REST para disparo de mensagens.
-   💾 **Persistência de Dados:** Evita duplicidade salvando o histórico em banco de dados (PostgreSQL/H2).
-   🐳 **Dockerizado:** Pronto para rodar em containers e nuvem.
-   🔒 **Segurança:** Credenciais gerenciadas via Variáveis de Ambiente.

## Tecnologias Utilizadas

-   **Linguagem:** Java 21 (LTS)
-   **Framework:** Spring Boot 3
-   **Web Scraping:** Jsoup
-   **Integração:** Green API (WhatsApp)
-   **Banco de Dados:** PostgreSQL (Produção) / H2 (Dev)
-   **DevOps:** Docker & Docker Compose



### Pré-requisitos
* Java 21 JDK
* Maven
* Conta na [Green API](https://green-api.com/) (para obter Token e Instance ID)