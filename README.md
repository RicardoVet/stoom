# Escopo e Objetivo

    Teste de Qualificação BackEnd Stoom

    O Projeto foi criado utilizando java 8 com Spring boot 2.4.5 
    Todos os testes utilizaram a versão Junit 4 "Júpter" a mais atual e compatível com o Spring framework 5
    Docker 20.10.2

# Iniciando

    baixar o projeto na sua máquina

    entrar na pasta do projeto (cd stoom)

# Pré Requisitos

    é preciso ter Docker, Maven, JDK 8.
 
# Utilizando o projeto

   para iniciar o projeto é preciso realizar uma limpeza para evitar possíveis erros
   após entrar no projeto com o comando cd stoom utilizar o ./mvnw.cmd clean ou ./mvnw clean em terminais Mac
   pode-se também optar por utilizar uma IDE como o Eclipse ao selecionar o projeto utilizar a opção run as e escolher o mvn clean
   após está operação selecionar run as novamente e escolher mvn install ou no terminal ./mvnw install os arquivos no target devem ser gerados e os testes devem
   ser realizados com sucesso.
   no terminal utilizar comando docker-compose up -d para inicializar os containers do mysql e do stoom-container.
   Os testes podem ser melhor visualizados utlizando o postman importando o arquivo Stoom.postman_collection.json e rodando os testes um a um ou mesmo a 
   coleção de uma vez.
   
   
