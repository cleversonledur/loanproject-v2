# LoanProject

Este é um projeto de um sistema de emprestimo pessoal onde você pode cadastrar clientes e simular um empréstimo de acordo com o tipo de risco baseado no perfil do cliente.

Aqui utilizamos 3 tipos de riscos diferentes, utilizando para a escolha o valor dos rendimentos do cliente.

Para desenvolvimento deste projeto, utilizei as seguintes ferramentas:

## Arquitetura

### Backend

Utilizei uma arquitetura de microserviços, dividindo em um projeto **commons** onde ficam as classes que são compartilhadas entre os microserviços, um projeto **customer** que é basicamente o CRUD dos clientes e o projeto **loan** que realiza o cálculo do empréstimo. Fiz a divisão do cálculo do empréstimo e o projeto clientes (CRUD) para permitir (em um ambiente de produção) a escalabilidade e disponibilidade destas funcionalidades caso outra não esteja disponível.

Para desenvolver os microserviços utilizei as seguintes tecnologias:

* Spring Cloud 
* Netflix OSS (Ribbon, Zuul e Eureka)
* MySQL
* Spring Boot, Data, IoC
* JUnit (testes unitários)

### Frontend

Para desenvolver o frontend utilizei Angular 4 combinado com a biblioteca Materialize (http://materializecss.com/).

## Running

Para executar você deve possuir o docker e o docker-compose instalado no seu computador. Você pode instalar utilizando os procedimentos descritos neste site (https://docs.docker.com/compose/install/).

Na primeira execução, você precisa realizar o build do projeto. Para facilitar, já criei um script que vai fazer isto. Basta executar o seguinte comando:

./buildup.sh

Após a instalação, você pode utilizar o seguinte comando (neste mesmo diretório) para executar todo o projeto.

./up

O frontend estará executando no endereço http://localhost:4200.

A API estará executando no endereço localhost:8765.


## O que pode ser melhorado?

1 - Criação de um container para o Frontend.

2 - Criação de testes funcionais com Selenium.

3 - Utilização de BigDecimal.



