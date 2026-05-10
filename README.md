# Brinquedoteca – CP2 FIAP

API REST para gerenciamento de brinquedos, desenvolvida com Spring Boot 3, Java 21, Oracle FIAP e Spring Data JPA.

## Grupo

| Nome | RM |
|---|---|
| Ana Flávia Camelo | RM561489 |
| Gustavo Kenji Terada | RM562745 |
| João Guilherme Carvalho Novaes | RM566234 |
| Pedro Chasci Puga | RM565154 |
| Lucas Figueiredo Vieira | RM561342 |

## Tecnologias

| Tecnologia | Uso |
|---|---|
| **Java 21** | Linguagem principal do projeto, utilizando recursos modernos como records e inferência de tipos |
| **Spring Boot 3.4.5** | Framework base que auto-configura o servidor embutido (Tomcat), gerencia beans e simplifica a criação da API REST |
| **Maven** | Gerenciador de dependências e build do projeto; responsável por baixar bibliotecas e compilar o código |
| **Spring Data JPA** | Abstrai o acesso ao banco de dados, gerando automaticamente as queries SQL a partir de interfaces como `JpaRepository` |
| **Oracle Database (FIAP)** | Banco de dados relacional utilizado para persistir os registros de brinquedos; a tabela `TDS_TB_Brinquedos` é criada automaticamente via `ddl-auto=update` |
| **Lombok** | Elimina código repetitivo (boilerplate) gerando automaticamente getters, setters, construtores e `toString` via anotações como `@Data`, `@RequiredArgsConstructor` |
| **MapStruct** | Gera o código de conversão entre a entidade `Brinquedo`, o DTO de entrada `BrinquedoDto` e o DTO de saída `BrinquedoResponse`, sem precisar escrever mapeamentos manualmente |
| **Spring Validation** | Valida os dados recebidos nas requisições com anotações como `@NotBlank`, `@NotNull` e `@Positive`, retornando erros 400 automaticamente quando inválidos |

## Como executar

1. Configure o `application.properties` com suas credenciais Oracle (não versionado)
2. Execute: `mvn spring-boot:run`
3. API disponível em: `http://localhost:8080/brinquedos`

## Endpoints

| Método | Endpoint            | Descrição          |
|--------|---------------------|--------------------|
| GET    | /brinquedos         | Listar todos       |
| GET    | /brinquedos/{id}    | Buscar por ID      |
| POST   | /brinquedos         | Criar novo         |
| PUT    | /brinquedos/{id}    | Atualizar por ID   |
| DELETE | /brinquedos/{id}    | Deletar por ID     |

## Exemplos de JSON

### POST /brinquedos – Criar brinquedo

```json
{
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Veículo",
  "classificacao": "Livre",
  "tamanho": "Médio",
  "preco": 149.90
}
```

### PUT /brinquedos/{id} – Atualizar brinquedo

```json
{
  "nome": "Carrinho de Controle Remoto Pro",
  "tipo": "Veículo",
  "classificacao": "Livre",
  "tamanho": "Grande",
  "preco": 199.90
}
```

### Resposta (GET, POST, PUT)

```json
{
  "id": 1,
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Veículo",
  "classificacao": "Livre",
  "tamanho": "Médio",
  "preco": 149.90
}
```

### Resposta de erro – recurso não encontrado (404)

```json
{
  "erro": "Brinquedo não encontrado com id: 99"
}
```

### Resposta de erro – validação (400)

```json
{
  "nome": "Nome é obrigatório",
  "preco": "Preço deve ser positivo"
}
```

## Estrutura do Projeto

```
fiap.com.br.cp2brinquedos
├── model/          → Entidade Brinquedo (JPA)
├── dto/            → BrinquedoDto (entrada) + BrinquedoResponse (saída)
├── mapper/         → BrinquedoMapper (MapStruct)
├── repository/     → BrinquedoRepository (JpaRepository)
├── service/        → BrinquedoService (lógica de negócio)
├── controller/     → BrinquedoController (delegação)
└── exception/      → ResourceNotFoundException + GlobalExceptionHandler
```

## Prints das telas (Postman)

> Adicionar os prints das telas do Postman aqui após os testes.

- `GET /brinquedos` – listagem completa
- `GET /brinquedos/{id}` – busca por ID
- `POST /brinquedos` – criação com JSON
- `PUT /brinquedos/{id}` – atualização
- `DELETE /brinquedos/{id}` – exclusão (204 No Content)
