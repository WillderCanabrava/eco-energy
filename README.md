# ECO-ENERGY ⚡

Projeto desenvolvido como parte da disciplina de Desenvolvimento Web com foco em temas ESG (Environmental, Social and Governance).

## 🌱 Tema ESG
**Gestão de Consumo de Energia Elétrica**  
O sistema registra o consumo de energia de dispositivos, com foco em promover o uso consciente e monitoramento de recursos.

---

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security
- Oracle (banco de dados)
- Flyway (migração de schema)
- Docker + Docker Compose

---

## 🚀 Como executar o projeto

### 🔧 Pré-requisitos
- Docker instalado
- Java 17 (se quiser rodar localmente sem container)
- Maven

### ▶️ Rodando com Docker

1. Compile o projeto:
   ```bash
   ./mvnw clean package 
   ```

2. Suba os containers:
     ```bash
    docker-compose -f docker/docker-compose.yml up  --build
    ```

3. Acesse:
    ```
    http://localhost:8080
  
    ```

🔐 Segurança

Todos os endpoints /consumo/** exigem autenticação via HTTP Basic.

Credenciais padrão:
- Usuário: admin
- Senha: admin123
<br><br>

📦 Endpoints principais

- POST /consumo: registrar um novo consumo

- GET /consumo/usuario/{id}: listar consumo por usuário

- DELETE /consumo/{id}: excluir consumo

<br>

Exemplo de uso com curl:
```
curl -u admin:admin123 http://localhost:8080/consumo/usuario/1

```
<br><br>

📁 Migração de Banco

O projeto utiliza Flyway para migração de banco. O script de criação da tabela consumo está localizado em:

```
src/main/resources/db/migration/V1__criar_tabela_consumo.sql
```

📌 Observações
- Banco Oracle sobe automaticamente com Docker.

- A aplicação Spring Boot se conecta ao Oracle utilizando variáveis configuradas no application.properties.

👨‍🎓 Autores

* Joice Fernanda de Souza
* Wilder Canabrava
* Leandro Salazar