# Bootcamp Santander - Padrões de Projeto com Spring

[![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?style=flat-square&logo=spring)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)

> Uma aplicação educacional que demonstra a implementação de **padrões de projeto** (Facade, Strategy, Singleton) em uma API REST robusta com Spring Boot, integrando dados em tempo real via ViaCEP.

---

## 📋 Índice
- [Visão Geral](#visão-geral)
- [Características](#características)
- [Tecnologias](#tecnologias)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Requisitos](#requisitos)
- [Como Iniciar](#como-iniciar)
- [Endpoints](#endpoints)
- [Exemplos de Uso](#exemplos-de-uso)
- [Configuração](#configuração)
- [Documentação](#documentação)

---

## 🎯 Visão Geral

Este projeto demonstra a aplicação prática de **padrões de projeto** (Facade, Strategy, Singleton) em uma **API REST** construída com Spring Boot. A aplicação oferece endpoints CRUD completos para gerenciar clientes e suas informações de endereço, integrando-se automaticamente com a **API ViaCEP** (via OpenFeign) para enriquecer dados de endereços a partir do CEP. A persistência é realizada em um banco H2 em memória, ideal para fins educacionais e demonstrações.

---

## ✨ Características

- ✅ **Spring Boot Application** - Classe principal: `one.digitalinnovation.gof.Application`
- ✅ **Entidades Relacionais** - `Cliente` com relacionamento bidirecional a `Endereco`
- ✅ **Integração OpenFeign** - Consumo automático da API ViaCEP para busca de endereços
- ✅ **Repositórios JPA** - `ClienteRepository` e `EnderecoRepository` com operações CRUD
- ✅ **Banco H2 Em Memória** - Configurado em `src/main/resources/application.properties`
- ✅ **Documentação OpenAPI/Swagger** - Interface interativa para testar endpoints
- ✅ **Padrões de Projeto** - Implementação didática de Facade, Strategy e Singleton

## 🛠️ Tecnologias

| Tecnologia | Versão | Propósito |
|-----------|--------|----------|
| **Java** | 21 | Linguagem de programação |
| **Spring Boot** | 3.x | Framework web e aplicação |
| **Spring Web** | 3.x | APIs REST |
| **Spring Data JPA** | 3.x | Persistência e acesso a dados |
| **Spring Cloud OpenFeign** | 4.x | Cliente HTTP declarativo |
| **H2 Database** | 2.x | Banco de dados em memória |
| **SpringDoc OpenAPI** | 2.x | Documentação Swagger/OpenAPI |
| **Maven** | 3.8+ | Gerenciamento de dependências |

## 📁 Estrutura do Projeto

```
src/main/java/one/digitalinnovation/gof/
├── Application.java                      # Classe principal da aplicação
├── controller/
│   └── ClienteRestController.java        # Endpoints REST (base: /clientes)
├── model/
│   ├── Cliente.java                      # Entidade de Cliente
│   ├── ClienteRepository.java            # Repositório JPA para Cliente
│   ├── Endereco.java                     # Entidade de Endereço
│   └── EnderecoRepository.java           # Repositório JPA para Endereço
└── service/
    ├── ClienteService.java               # Interface de serviço
    ├── ViaCepService.java                # Feign Client para ViaCEP
    └── impl/
        └── ClienteServiceImpl.java        # Implementação com lógica CRUD
```

**Configurações:**
```
src/main/resources/
└── application.properties                # Configurações H2, JPA, porta (8080)
```

## 📋 Requisitos

| Requisito | Versão Mínima | Status |
|-----------|---------------|--------|
| **JDK** | 21 | ✅ Obrigatório |
| **Maven** | 3.8+ | ✅ Opcional (incluso via `mvnw`) |
| **Git** | 2.x | ✅ Para clonar repositório |

> 💡 O projeto inclui Maven Wrapper (`mvnw`), portanto Maven não precisa ser instalado globalmente.

---

## 🚀 Como Iniciar

### Clone o Repositório
```bash
git clone https://github.com/seu-usuario/padroes-pjt-spring.git
cd padroes-pjt-spring
```

### Build e Execução

#### 🐧 Linux / WSL (bash):
```bash
# Compilar
./mvnw clean package

# Executar a aplicação
./mvnw spring-boot:run

# Ou executar diretamente o JAR
java -jar target/lab-padroes-projeto-spring-0.0.1-SNAPSHOT.jar
```

#### 🪟 Windows (CMD / PowerShell):
```powershell
# Compilar
mvnw.cmd clean package

# Executar a aplicação
mvnw.cmd spring-boot:run

# Ou executar diretamente o JAR
java -jar target\lab-padroes-projeto-spring-0.0.1-SNAPSHOT.jar
```

### ✅ Verificar se está rodando

A aplicação iniciará em: **http://localhost:8080**

```bash
# Testar se o servidor está respondendo
curl http://localhost:8080/clientes
# Resposta esperada: [] (array vazio, pois não há clientes ainda)
```

---

## ⚙️ Configuração

### H2 Console (Banco de Dados)

Acesse a interface gráfica do H2 em: **http://localhost:8080/h2-console**

| Campo | Valor |
|-------|-------|
| **JDBC URL** | `jdbc:h2:mem:testdb` |
| **Usuário** | `sa` |
| **Senha** | (deixar em branco) |

### OpenAPI / Swagger UI

Documentação interativa dos endpoints:

- **Swagger UI:** http://localhost:8080/swagger-ui/index.html
- **OpenAPI JSON:** http://localhost:8080/v3/api-docs
- **OpenAPI YAML:** http://localhost:8080/v3/api-docs.yaml

---

## 📚 Documentação

## 🔌 Endpoints

Base URL: `http://localhost:8080/clientes`

| Método | Endpoint | Descrição | Parâmetros |
|--------|----------|-----------|-----------|
| **GET** | `/` | Lista todos os clientes | - |
| **GET** | `/{id}` | Retorna cliente por ID | `id` (Path) |
| **POST** | `/` | Cria um novo cliente | JSON (Body) |
| **PUT** | `/{id}` | Atualiza cliente existente | `id` (Path), JSON (Body) |
| **DELETE** | `/{id}` | Deleta um cliente | `id` (Path) |

### Modelo de Dados

**Cliente:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "endereco": {
    "id": 1,
    "cep": "01001000",
    "logradouro": "Avenida Paulista",
    "complemento": "",
    "bairro": "Bela Vista",
    "localidade": "São Paulo",
    "uf": "SP"
  }
}
```

---

## 📌 Exemplos de Uso

### 1️⃣ Criar um Cliente

```bash
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "endereco": {
      "cep": "01001000"
    }
  }'
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "endereco": {
    "id": 1,
    "cep": "01001000",
    "logradouro": "Avenida Paulista",
    "bairro": "Bela Vista",
    "localidade": "São Paulo",
    "uf": "SP"
  }
}
```

---

### 2️⃣ Listar Todos os Clientes

```bash
curl http://localhost:8080/clientes
```

**Resposta (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "endereco": { ... }
  }
]
```

---

### 3️⃣ Obter Cliente por ID

```bash
curl http://localhost:8080/clientes/1
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "endereco": { ... }
}
```

---

### 4️⃣ Atualizar um Cliente

```bash
curl -X PUT http://localhost:8080/clientes/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva Santos",
    "endereco": {
      "cep": "01310100"
    }
  }'
```

**Resposta (200 OK):** Cliente atualizado com dados do novo CEP

---

### 5️⃣ Deletar um Cliente

```bash
curl -X DELETE http://localhost:8080/clientes/1
```

**Resposta (204 No Content):** Cliente removido com sucesso

### Swagger UI Screenshot

![Swagger UI - OpenAPI](/docs/swagger-ui.png)

---

## 📝 Observações Importantes

### 🔄 Integração com ViaCEP

- ✅ A integração com a **API ViaCEP** acontece **automaticamente** ao criar/atualizar um cliente
- ✅ Se o `endereco.cep` for fornecido, o serviço consulta o ViaCEP via **OpenFeign**
- ✅ Os dados de endereço (logradouro, bairro, localidade, UF) são preenchidos automaticamente
- ✅ A lógica está implementada em `ClienteServiceImpl` - método `salvarClienteComCep`

### 💾 Banco de Dados H2

- ⚠️ O banco H2 é **em memória** (não persistente)
- ⚠️ Todos os dados são **perdidos ao reiniciar** a aplicação
- ✅ Ideal para **testes** e **demonstrações**
- 💡 Para usar banco persistente, altere `application.properties`

### 🎓 Padrões de Projeto Implementados

| Padrão | Classe | Descrição |
|--------|--------|-----------|
| **Facade** | `ClienteServiceImpl` | Simplifica a complexidade de múltiplas operações |
| **Strategy** | `ViaCepService` | Diferentes estratégias de busca de dados |
| **Singleton** | Spring Beans | Gerenciamento de instâncias únicas |

---

## 🐛 Troubleshooting

### Porta 8080 já em uso
```bash
# Linux/WSL - Encontrar processo usando porta 8080
lsof -i :8080

# Ou especificar outra porta
export SERVER_PORT=8081
./mvnw spring-boot:run
```

### Erro ao conectar ViaCEP
- ✅ Verifique sua conexão com a internet
- ✅ Teste um CEP válido (ex: `01001000`)
- ✅ Consulte https://viacep.com.br/

### Erro de build
```bash
./mvnw clean install -DskipTests
```

---

## 📖 Documentação (Swagger UI)


---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. **Fork** o repositório
2. **Crie uma branch** para sua feature (`git checkout -b feature/MinhaFeature`)
3. **Commit** suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. **Push** para a branch (`git push origin feature/MinhaFeature`)
5. **Abra um Pull Request**

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo `LICENSE` para mais detalhes.

---

## 👨‍💻 Autor

**Desenvolvido com ❤️ por [Osmair Coelho](mailto:osmair.coelho@gmail.com)**

<a href="https://www.linkedin.com/in/osmaircoelho" target="_blank" rel="noopener noreferrer">
  <img src="https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white&logoWidth=20" alt="LinkedIn">
</a>
<a href="https://github.com/osmaircoelho" target="_blank" rel="noopener noreferrer">
  <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github" alt="GitHub">
</a>

---

<div align="center">

**[⬆ Voltar ao Topo](#-bootcamp-santander---padrões-de-projeto-com-spring)**

Feito com 💚 para a comunidade Java/Spring

</div>
