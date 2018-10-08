# Exemplo de Java RMI

O processo servidor registrou um objeto distribuído que atua como um contador e possui dois métodos:

- incrementa
- obtemValor



## Instruções para compilação

### Usando Netbeans

1. Abra o projeto no Netbeans e clique sobre "Clean & Build"
2. Pacotes `.jar` resultantes da compilação estarão no subdiretório `target`



### Usando o maven no terminal

1. Entre no diretório do projeto
2. Digite: `mvn package`
3. Pacotes `.jar` resultantes da compilação estarão no subdiretório `target`



## Instruções para execução dos exemplos no terminal

1. Executando o servidor

   `java -jar ContadorDistribuido-servidor.jar`

2. Executando o cliente

   `java -jar ContadorDistribuido-cliente.jar`

