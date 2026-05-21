# 🚀 Raízes Backend API

Projeto desenvolvido como trabalho final da faculdade (ADS).

API REST completa para gerenciamento de usuários, produtos, pedidos e pagamentos, com autenticação via JWT.

---

## 🧠 Tecnologias utilizadas

- Kotlin
- Spring Boot
- Spring Security
- JWT (Json Web Token)
- JPA / Hibernate
- PostgreSQL
- Gradle
- Swagger (OpenAPI)

---

## 📦 Funcionalidades

### 🔐 Autenticação
- Login com JWT
- Proteção de rotas

### 👤 Usuários
- Criar usuário
- Listar usuários
- Senha criptografada com BCrypt

### 🍔 Produtos
- Criar produto
- Listar produtos

### 🛒 Pedidos
- Criar pedido com múltiplos itens
- Cálculo automático do valor total

### 💳 Pagamentos
- Simulação de pagamento mock
- Atualização automática do status do pedido

---

## 🔄 Fluxo do sistema

```text
Usuário
   ↓
Login JWT
   ↓
Recebe Token
   ↓
Cria Produtos
   ↓
Cria Pedido
   ↓
Pagamento Mock
   ↓
Pedido Atualizado para PAGO
```

---

## 🔐 Segurança

- JWT Bearer Token
- Spring Security
- Senhas criptografadas com BCrypt
- Rotas protegidas por autenticação

---

## 📄 Documentação Swagger

A documentação da API pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

---

## ▶️ Como executar

### Clonar repositório

```bash
git clone https://github.com/lukemtv/raizes.backend.git
```

### Entrar no projeto

```bash
cd raizes.backend
```

### Executar aplicação

```bash
./gradlew bootRun
```

---

## 🗄️ Banco de dados

O projeto utiliza PostgreSQL.

Configuração realizada no arquivo:

```text
src/main/resources/application.properties
```

---

## 🧪 Testes da API

A collection do Postman utilizada nos testes está disponível em:

```text
/postman/raizes.postman_collection.json
```

---

## 📌 Endpoints principais

### 🔐 Auth
- POST `/auth/login`

### 🍔 Produtos
- POST `/produtos`
- GET `/produtos`

### 🛒 Pedidos
- POST `/pedidos`

### 💳 Pagamentos
- POST `/pedidos/{id}/pagar`

---

## ⚠️ Tratamento de erros

O sistema possui tratamento padronizado para erros como:

- Token inválido ou ausente
- Produto inexistente
- Pedido inexistente
- Validação de campos obrigatórios
- Erros de autenticação e autorização

---

## 🧱 Arquitetura

O projeto foi estruturado em camadas:

- Controller
- Service
- Repository
- Entity
- DTO
- Security

Seguindo boas práticas de organização e separação de responsabilidades.

---

## 👨‍💻 Autor

Lucas