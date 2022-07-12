# SDA - Bootstrap

> Aplicação bootstrap para demais serviços da SDA. Seu objetivo é fornecer
> exemplos e melhores práticas, estabelecendo um padrão entre as aplicações
> deste contexto.

## Dependências
| Dependência  | Versão   |
|--------------|----------|
| Java         | 17       |
| Kotlin       | 1.7      |
| Spring Boot  | 2.7.1    |
| Spring Cloud | 2021.0.1 |

## Integrações
| Software   | Versão | Portas         | Observações                         |
|------------|--------|----------------|-------------------------------------|
| PostgreSQL | 11.3   | 5432           | **user/pass:** admin/root           |
| PGAdmin    | 4.7    | 5050           | **user/pass:** admin@admin.com/root |
| RabbitMQ   | 3.8.14 | 5672<br/>15672 | **user/pass:** admin/root           |
| Wiremock   | 2.32.0 | 8082           |                                     |

## Estrutura do projeto

Este projeto apresenta uma aplicação Bootstrap consumindo serviços externos,
mockados por uma aplicação em wiremock.

![C4L1][6]

Sendo um projeto multi-módulos que contempla duas aplicações de um mesmo 
contexto. Os módulos são:
 - **api**: aplicação que fornece os rescursos *rest*. 
 - **messaging**: aplicação para processamento assíncrono do domínio.
 
![C4L2][7]

Cada módulo tem seus pacotes representando a estrutura da arquitetura hexagonal:  

![Arquitetura Hexagonal][5]

## Configurando o ambiente

Após baixar o repositório, você pode configurar o ambiente utilizando o SDKMan!,
caso não tenha instalado basta seguir as instruções em [SDKMan Installation][1].

``` bash
$ sdk env install
```

> **Dica:** você também pode habilitar o `sdkman_auto_env=true` editando as configurações
> pelo comando `sdk config`. Isso fará com que o ambiente seja configurado automaticamente
> ao entrar em uma pasta que contenha o arquivo `.sdkmanrc`.

para saber mais sobre como utilizar o SDKMan! veja seu [guia de uso][2].

## Desenvolvendo a aplicação localmente
### Executando o ambiente localmente

Para execução do sistema em ambiente local, utilizamos containeres docker
estes contêineres podem ser iniciados pelo docker-compose, configurado na 
raiz deste projeto.
``` bash
# configurando ambiente docker e executando contêineres
$ docker-compose up -d

# iniciando contêineres (necessário ter configurado os contêineres anteriormente)
$ docker-compose start

# parando contêineres
$ docker-compose stop

# parando reiniciando
$ docker-compose restart

# removendo componentes configurados pelo compose
$ docker-compose down
```

### Configurando o PGAdmin
Para configurar o PGAdmin, primeiro você precisará obter o endereço ip que 
o postgres está sendo executado, para isso digite o comando:
``` bash
$ docker inspect $(docker ps -f name=sda-bootstrap_postgres -q) | grep IPAddress
```
Tendo como resultado algo similiar:

![resultado][3]

Com este endereço, basta ir para a página principal do PGAdmin, clicar em
*"Add New Server"* e configurar os dados da conexão utilizando o ip encontrado
pelo comando anterior:
![Configuração PGAdmin][4]

### Db Migration
A criação da estrutura do banco de dados é feita pelo Flyway Migrate. Para executar o migration dos scripts basta executar o comando:
``` bash
$ DB_URL=jdbc:postgresql://localhost:5432/postgres DB_USER=admin DB_PASSWORD=root ./gradlew flywayMigrate
```

[1]: https://sdkman.io/install
[2]: https://sdkman.io/usage
[3]: ./config/assets/images/pg-ipaddress.png
[4]: ./config/assets/images/pgadmin-config.png
[5]: ./config/assets/images/hexagonal-arch.png
[6]: ./config/assets/images/SDABootstrap-C4L1.png
[7]: ./config/assets/images/SDABoostrap-C4L2.png
