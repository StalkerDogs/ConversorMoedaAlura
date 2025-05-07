# Conversor de Moedas

Este é um programa Java que permite converter valores entre diferentes moedas utilizando a API Exchange Rate API.

## Funcionalidades

- Conversão entre as seguintes moedas:
  - USD (Dólar Americano)
  - BRL (Real Brasileiro)
  - ARS (Peso Argentino)
  - CLP (Peso Chileno)
  - COP (Peso Colombiano)
  - BOB (Boliviano)

## Requisitos

- Java 11 ou superior
- Maven
- Conexão com a internet

## Como executar

1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute o comando:
```bash
mvn clean package
```
4. Execute o programa:
```bash
java -cp target/conversor-moeda-1.0-SNAPSHOT.jar com.conversor.ConversorMoeda
```

## Como usar

1. Ao iniciar o programa, você verá um menu com as opções de conversão disponíveis
2. Digite o número da opção desejada
3. Digite o valor que deseja converter
4. O resultado será exibido na tela
5. Para sair do programa, digite 0

## Tecnologias utilizadas

- Java 11
- Maven
- Gson (para manipulação de JSON)
- HttpClient (para requisições HTTP)
- Exchange Rate API 
