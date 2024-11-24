# Monitoramento de Obras

Este projeto é uma aplicação JavaFX para o monitoramento de obras. A aplicação permite adicionar, atualizar, excluir e listar obras no banco de dados. As obras podem ser de dois tipos: **Comercial** ou **Residencial**, e a interface gráfica foi construída utilizando JavaFX.

## Funcionalidades

- **Adicionar Obra**: Permite ao usuário adicionar uma obra ao banco de dados, especificando o nome, descrição, endereço e tipo (Comercial ou Residencial).
- **Atualizar Obra**: Permite ao usuário atualizar os detalhes de uma obra já existente no banco de dados.
- **Excluir Obra**: Permite ao usuário excluir uma obra do banco de dados.
- **Listar Obras**: Exibe uma lista de todas as obras cadastradas na aplicação.
- **Tipo de Obra**: Permite escolher entre obra **Comercial** (com campo para empresa responsável) ou **Residencial** (com campo para número de apartamentos).

## Tecnologias Utilizadas

- **Java 17 (Amazon Corretto)**: Versão LTS do Java para desenvolvimento.
- **JavaFX**: Para a interface gráfica com o usuário.
- **Hibernate ORM**: Para interação com o banco de dados.
- **H2 Database**: Banco de dados embutido para armazenar as informações das obras.
- **Maven**: Para gerenciamento de dependências.

## Pré-requisitos

- **Java 17** ou superior.
- **Maven** para gerenciamento de dependências.
- **Banco de Dados H2** configurado para armazenar os dados da aplicação.

## Como Rodar o Projeto

### 1. Clonar o repositório

Clone este repositório para o seu ambiente local:

```bash
git clone https://github.com/seu-usuario/monitoramento-de-obras.git
