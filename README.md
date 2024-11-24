
```markdown
# Monitoramento de Obras

Este projeto é uma aplicação JavaFX para o monitoramento de obras. A aplicação permite adicionar, atualizar, excluir e listar obras no banco de dados. As obras podem ser de dois tipos: **Comercial** ou **Residencial**, e a interface gráfica foi construída utilizando JavaFX. O projeto utiliza Hibernate para persistência de dados e Maven para gerenciamento de dependências.

## Funcionalidades

- **Adicionar Obra**: Permite ao usuário adicionar uma obra ao banco de dados, especificando o nome, descrição, endereço e tipo (Comercial ou Residencial).
- **Atualizar Obra**: Permite ao usuário atualizar os detalhes de uma obra já existente no banco de dados.
- **Excluir Obra**: Permite ao usuário excluir uma obra do banco de dados.
- **Listar Obras**: Exibe uma lista de todas as obras cadastradas na aplicação.
- **Tipo de Obra**: Permite escolher entre obra **Comercial** (com campo para empresa responsável) ou **Residencial** (com campo para número de apartamentos).

## Tecnologias Utilizadas

- **Java 17 (Amazon Corretto)**: Versão LTS do Java para desenvolvimento.
- **JavaFX**: Para a interface gráfica com o usuário.
- **Hibernate ORM**: Para mapeamento objeto-relacional e interação com o banco de dados.
- **JPA (Java Persistence API)**: Interface para gerenciamento de dados relacionais.
- **H2 Database**: Banco de dados embutido para armazenar as informações das obras.
- **Maven**: Para gerenciamento de dependências.

## Pré-requisitos

Antes de rodar a aplicação, certifique-se de ter o seguinte instalado em seu ambiente de desenvolvimento:

- **Java 17 ou superior**: Você pode fazer o download [aqui](https://adoptopenjdk.net/).
- **Maven**: Ferramenta de gerenciamento de dependências e build. Baixe [aqui](https://maven.apache.org/download.cgi).
- **JavaFX SDK 21**: Baixe [aqui](https://openjfx.io/).

## Como Rodar o Projeto

### 1. Clonar o repositório

Clone este repositório para o seu ambiente local:

```bash
git clone https://github.com/seu-usuario/monitoramento-de-obras.git
```

### 2. Instalar as dependências

O projeto utiliza o Maven para gerenciar as dependências. Execute o comando abaixo para baixar todas as dependências:

```bash
mvn clean install
```

### 3. Rodar a aplicação

Para rodar a aplicação, utilize o comando Maven abaixo:

```bash
mvn clean javafx:run
```

Isso compilará o código e iniciará a aplicação com a interface gráfica JavaFX.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte maneira:

```
monitoramento-de-obras/
├── pom.xml               # Arquivo de configuração do Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── obrasmonitoramento/
│   │   │           ├── Main.java            # Classe principal que inicia a aplicação
│   │   │           ├── gui/                 # Contém as classes da interface gráfica
│   │   │           │   └── ObraMonitorGUI.java
│   │   │           ├── entities/            # Contém as entidades JPA
│   │   │           │   ├── Obra.java
│   │   │           │   ├── ObraComercial.java
│   │   │           │   ├── ObraResidencial.java
│   │   │           │   ├── Engenheiro.java
│   │   │           │   └── Tarefa.java
│   │   │           └── services/            # Contém os serviços de persistência
│   │   │               └── ObrasIImplRepositorio.java
│   │   └── resources/         # Arquivos de configuração, se houver (por exemplo, fxml, imagens)
└── target/                  # Pasta gerada pelo Maven durante o build
```

## Como Contribuir

1. Faça um **fork** deste repositório.
2. Crie uma **branch** para sua funcionalidade (`git checkout -b minha-funcionalidade`).
3. Faça as modificações desejadas e commit suas alterações (`git commit -am 'Adicionando nova funcionalidade'`).
4. Envie para a sua branch no repositório remoto (`git push origin minha-funcionalidade`).
5. Abra um **Pull Request** para o repositório original.

## Licença

Distribuído sob a Licença MIT. Veja `LICENSE` para mais informações.

## Contato

Se você tiver alguma dúvida, não hesite em abrir uma **issue** ou entrar em contato!

- **Autor**: Pedro Gomes
- **Email**: pedrolkas15@gmail.com
- **GitHub**: https://github.com/pedrolucas201
```

Este arquivo `README.md` está completo com todos os detalhes necessários para a instalação, configuração e execução do projeto, bem como a estrutura das pastas e como contribuir com o repositório.
