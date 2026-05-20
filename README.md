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
- PostgreSQL / H2
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
- Senha criptografada (BCrypt)

### 🍔 Produtos
- Criar produto
- Listar produtos

### 🛒 Pedidos
- Criar pedido com múltiplos itens
- Cálculo automático do valor total

### 💳 Pagamentos
- Simulação de pagamento
- Atualização de status do pedido

---

## 🔄 Fluxo do sistema

```text
Usuário → Login → Token JWT
→ Criar Produto
→ Criar Pedido
→ Pagar Pedido
