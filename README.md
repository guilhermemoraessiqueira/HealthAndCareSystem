# Health And Care System API

O Health And Care System é uma API inovadora e eficiente projetada para simplificar e agilizar o processo de agendamento de consultas médicas. Nosso objetivo é fornecer aos pacientes a capacidade de marcar consultas com médicos disponíveis, de acordo com sua especialidade e o momento que melhor lhes convier, tudo com facilidade e conveniência.

## Tecnologias Utilizadas

- Spring Boot 3.1.1
- Java 17
- PostgreSQL
- Spring Data JPA
- Spring Boot Validation
- Spring Boot Test
- ModelMapper
- Lombok
- Spring Security
- Java JWT
- Springdoc OpenAPI

## Princípios SOLID

Este projeto segue os princípios SOLID para promover a modularidade, flexibilidade e manutenibilidade do código:

1. **S** - Single Responsibility Principle (Princípio da Responsabilidade Única)
2. **O** - Open/Closed Principle (Princípio do Aberto/Fechado)
3. **L** - Liskov Substitution Principle (Princípio da Substituição de Liskov)
4. **I** - Interface Segregation Principle (Princípio da Segregação de Interfaces)
5. **D** - Dependency Inversion Principle (Princípio da Inversão de Dependência)

## Funcionalidades

### Cadastro de Médicos

- O sistema permite o cadastro detalhado de médicos, incluindo informações como nome, especialidade, horários de atendimento e informações de contato.

### Cadastro de Pacientes

- Os pacientes podem se registrar na plataforma, fornecendo informações pessoais, como nome, data de nascimento, informações de contato, entre outras.

### Agendamento de Consultas

- Pacientes podem agendar consultas com médicos disponíveis com base em critérios como especialidade e horários de atendimento.
- A API verifica a disponibilidade do médico e permite que os pacientes agendem a consulta no horário adequado.

### Gerenciamento de Permissões

- A API implementa um sistema de controle de acesso robusto com base em funções (ROLE) para garantir a segurança dos dados e funcionalidades.
- Os médicos e pacientes têm permissões específicas, garantindo que eles só acessem e modifiquem informações relevantes para cada ROLE.

## Pré-Requisitos

- JDK
- Maven
- PostgreSQL

## Configuração

- Baixe o projeto e abra na IDE de sua preferência;
- Crie no seu banco de dados uma database com o nome que deseja;
- Abra a pasta "src", "main" e "resources e abra o arquivo "application.properties" e configure as informações do seu banco de dados (lembrando que o nome da database que você criou tem que ser o mesmo nome que você colocará aqui)
- Após isso, rode o programa.

## Endpoints

A API "Health And Care System" oferece os seguintes endpoints para realizar várias operações:

### Médicos
--------------------------------------------------

#### Listar Todos os Médicos

- **URL**: `/medico`
- **Método HTTP**: GET
- **Descrição**: Retorna uma lista de todos os médicos cadastrados e ativos.

#### Mostrar Médico Por Id

- **URL**: `/medico/{"id"}`
- **Método HTTP**: GET
- **Descrição**: Retorna o médico com o id passado na URL.

#### Listar Médicos Disponíveis no Horarário

- **URL**: `medico/disponiveis`
- **Método HTTP**: GET
- **Descrição**: Retorna uma lista de todos os médicos da especialidade e na hora solicitada.

#### Destivar Médico por Id

- **URL**: `/medico/{"id"}`
- **Método HTTP**: DEL
- **Descrição**: Realiza uma exclusão lógica do médico com o Id fornecido na URL.

#### Cadastrar Médico

- **URL**: `/medico`
- **Método HTTP**: POST
- **Descrição**: Cadastra um novo médico no sistema. Os detalhes do médico devem ser fornecidos no corpo da solicitação em formato JSON.

### Pacientes
--------------------------------------------------

#### Cadastrar Paciente

- **URL**: `/paciente`
- **Método HTTP**: POST
- **Descrição**: Cadastra um novo paciente no sistema. Os detalhes do paciente devem ser fornecidos no corpo da solicitação em formato JSON.

#### Listar Todos os Pacientes

- **URL**: `/pacientes`
- **Método HTTP**: GET
- **Descrição**: Retorna uma lista de todos os pacientes cadastrados.

#### Mostrar Paciente Por Id

- **URL**: `/pacientes/{"id"}`
- **Método HTTP**: GET
- **Descrição**: Retorna o paciente que possui o id passado na URL.

#### Deletar Paciente por Id

- **URL**: `/paciente/{"id"}`
- **Método HTTP**: DEL
- **Descrição**: Realiza uma exclusão lógica do médico com o Id fornecido na URL.


### Consultas
---------------------------------------------------

#### Agendar Consulta

- **URL**: `/consulta`
- **Método HTTP**: POST
- **Descrição**: Permite que um paciente agende uma consulta com um médico disponível. Os detalhes da consulta, como médico, data e hora, devem ser fornecidos no corpo da solicitação em formato JSON.

#### Deletar Consulta

- **URL**: `/consulta`
- **Método HTTP**: DEL
- **Descrição**: Exclui a consulta, exige o id e o motivo do cancelamento em formato JSON.

## Estrutura do Projeto

O projeto é dividido nos seguintes diretórios:

#### - controllers
  
Onde todos os controllers estão.

#### - dtos
  
Onde todos os DTOs (Data Transfer Object) estão.

#### - enums
  
Onde todos os enums estão.

#### - infra
  
Onde está todo tratamento de exceptions, a parte de security do JWT e a parte de documentação com springdoc.

#### - models
  
Onde todas as entidades estão.

#### - repositories
  
Onde todos os repositories estão.

#### - services
  
Onde todos os services estão.

#### - validacao
  
Onde toda parte de validação para a consulta está.

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT) - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.


## Contato

Linkedin: https://www.linkedin.com/in/guilherme-moraes-siqueira/

Email: guimoraessiqueira@yahoo.com.br

---
