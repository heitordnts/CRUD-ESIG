# CRUD-ESIG
Processo seletivo para desenvolvimento JAVA - ESIG Software

# Descrição da aplicação
A aplicação consiste num simples controle de registros(CRUD).
Os registros são lembretes.
Foram feitas duas versões, a primeira usando JSF e a segunda usando Spring e Reactjs.

# Itens feitos

- [x] A. Criar uma aplicação java web utilizando JavaServer Faces (JSF)

- [x] B. Utilizar persistência em um banco de dados (qualquer banco desejado)

- [x] C. Utilizar Hibernate e JPA

- [x] D. Utilizar Spring Framework Boot 2.0

- [x] E. Utilizar Spring MVC

- [x] F. Utilizar Bootstrap 4

- [x] G. Utilizar Primefaces

- [ ] H. Utilizar testes de unidades

- [x] I. Criar single page app utilizando react

- [ ] J. Publicar projeto no heroku

- [ ] K. Criar aplicativo mobile utilizando Flutter


# Como Executar

## Requisitos
- Java SDK 8
- Maven  ```$ sudo apt install mvn```
- PostgreSQL     ```$ sudo apt install postgresql-all```
- Linux (Foi usado o Ubuntu 18.04)
- Netbeans 

```
$ wget https://downloads.apache.org/netbeans/netbeans/11.3/Apache-NetBeans-11.3-bin-linux-x64.sh         
$ chmod +x Apache-NetBeans-11.3-bin-linux-x64.sh 
$ ./Apache-NetBeans-11.3-bin-linux-x64.sh 
```
- [Glassfish 5.0.1](https://javaee.github.io/glassfish/download)
- Nodejs(v12.16.1)
- npm(v6.14.2)

===
## Aplicação JSF
```
mvn package
```

```
AS_JAVA="/usr/lib/jvm/java-8-openjdk-amd64"
```

Para dar deploy na aplicação, precisamos e na pasta de instalação do glassfish em ./bin, e depois executar

```
$ ./asadmin start-domain domain1
$ ./asadmin deploy --force /[pasta-do-projeto]/target/lembreteapp-1.0-SNAPSHOT.war```
```

O aplicativo vai estar disponível em: localhost:8080/lembreteapp


Para o undeploy fazemos,  

```
$ ./asadmin undeploy lembreteapp-1.0-SNAPSHOT.war
$ ./asadmin stop-domain domain1
```

## Spring + React

### API REST Spring

```
$ mvn clean package

$ java -jar ./[pasta-do-projeto]/target/lembreteappspring-0.0.1-SNAPSHOT.jar
```

### Client React

Vá na pasta da aplicação e execute 

```
$ npm start
```
a aplicação vai estar disponivel em http://localhost:3000/



