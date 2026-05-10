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

- `GET /brinquedos` – listagem completa
  <img width="624" height="462" alt="image" src="https://github.com/user-attachments/assets/28ab00c3-6c53-4fcf-9de4-87d969f95b0c" />

- `GET /brinquedos/{id}` – busca por ID
  > Em caso de sucesso
  <img width="588" height="320" alt="image" src="https://github.com/user-attachments/assets/e826ebed-078e-47a5-afe2-e41defca304f" />
  
  > Em caso de erro
  <img width="579" height="245" alt="image" src="https://github.com/user-attachments/assets/f532cb10-7f7b-44a7-8a86-a4e9688d2196" />

- `POST /brinquedos` – criação com JSON
  > Em caso de sucesso
  <img width="590" height="481" alt="image" src="https://github.com/user-attachments/assets/35aa60c3-5326-4e5b-b6a1-eacabd7c0a2e" />

  > Em caso de erro
  <img width="593" height="417" alt="image" src="https://github.com/user-attachments/assets/500e0456-985e-4bfa-9daf-8aaf2ca19780" />

- `PUT /brinquedos/{id}` – atualização
  > Em caso de sucesso
  <img width="590" height="484" alt="image" src="https://github.com/user-attachments/assets/66fea6eb-e3b1-498e-b58e-e44648e02307" />

  > Em caso de erro
  <img width="592" height="408" alt="image" src="https://github.com/user-attachments/assets/050934a6-98f4-476d-a5aa-af42c44648c1" />

- `DELETE /brinquedos/{id}`
  > Em caso de sucesso
  <img width="586" height="213" alt="image" src="https://github.com/user-attachments/assets/fe64a82f-2e6c-4965-8b49-b22de803e09c" />

  > Em caso de erro
  <img width="586" height="250" alt="image" src="https://github.com/user-attachments/assets/23231780-d0e6-4431-8fdc-9efffe631093" />

