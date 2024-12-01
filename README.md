# Grupo 7
- Acad. Cirano Alves Belardony (ciranobelardony@gmail.com)
- Acad. Felipe Alves de Oliveira (prohazor.fa@gmail.com)
- Acad. João Ygor Vieira Ramalho (ygorvieira2002@gmail.com)

# Sobre o projeto
Este projeto foi desenvolvido como parte do Tech Challenge, um desafio técnico que engloba os conhecimentos adquiridos em diversas disciplinas do curso. O objetivo principal é a criação de um Sistema de Gerenciamento de Pedidos.

## Funcionalidades
este serviço cuidará de toda a logística
relacionada à entrega de pedidos, desde a atribuição de entregadores até
o rastreamento das entregas em tempo real. A função inclui calcular as
rotas mais eficientes, estimar tempos de entrega e fornecer atualizações
de status aos clientes.

## APIs associdas ao projeto
- Gerenciamento de Clientes (https://github.com/joaoygorr/Customer)
- Gestão de Pedidos (https://github.com/CiranoB/pedidos)
- Logística de Entrega (https://github.com/joaoygorr/delivery)

## Tecnologias utilizadas
- Java 21 LTS
- Spring Boot
- Docker
- Postgres
- Mockito
- Gatling
- Makefile
- Maven
- Lombok

# Requisitos para rodar o projeto:
* Docker (https://www.docker.com/)
* Git

Para clonar o projeto, rode o seguinte comando:
```
git clone https://github.com/Tatu-Armadillo/catalogo
```

# Variaveis de ambiente:
Obs.: Configuração padrão para rodar pelo docker com o banco e aplicação em comunicação pela da network restaurant-review-postgres-network 
```
PORT_APP, DB_SGDB, DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD
```

# Como executar a aplicação:
Rode o comando na pasta raíz da aplicação
```
docker-compose up -d
```

Para acessar o swagger:
```
http://localhost:8080/catalogo/swagger-ui/index.html
```
