# Banking System

## Descrição

Este é um sistema bancário simples implementado em Java utilizando padrões de projeto. O sistema permite a criação de contas bancárias, depósitos, saques e transferências de fundos entre contas.

## Padrões de Projeto Utilizados

- **Singleton:** Para garantir que exista apenas uma instância do sistema bancário.
- **Strategy:** Para diferentes tipos de contas bancárias (Conta Corrente e Conta Poupança).
- **Facade:** Para simplificar a interface com o sistema bancário, fornecendo métodos para operações comuns.

## Funcionalidades

- Criar contas bancárias (Corrente e Poupança).
- Realizar depósitos e saques.
- Transferir fundos entre contas.
- Visualizar saldo da conta.
- Exibir todas as transações de uma conta.
- Encerrar conta.

## Regras de Validação

- O número da conta deve ter 6 dígitos.
- O valor máximo de saldo em conta é de R$ 1.000.000.
- Os valores de depósito e saque devem ser maiores que zero.

# Execução

Navegue até o diretório do projeto:

```shell
cd banking-system
Compile o projeto:

mvn clean compile
Execute o projeto:

mvn exec:java -Dexec.mainClass="com.banking.Main"
markdown
Copiar código

### Explicação:

- **Navegue até o diretório do projeto**: Muda para o diretório onde o projeto está localizado.
- **Compile o projeto**: Usa o Maven para compilar o código-fonte.
- **Execute o projeto**: Executa a aplicação Java principal especificada pela classe `Main` usando o plugin `exec` do Maven.

Essa seção deve ser incluída no arquivo `README.md` para fornecer instruções claras sobre como compilar e executar o projeto. Se precisar de mais detalhes ou ajustes, avise-me!


## Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── banking/
│   │           ├── facade/
│   │           │   └── BankFacade.java
│   │           ├── model/
│   │           │   ├── Account.java
│   │           │   ├── CheckingAccount.java
│   │           │   ├── SavingsAccount.java
│   │           │   └── TransactionStrategy.java
│   │           ├── service/
│   │           │   ├── BankService.java
│   │           │   └── TransactionStrategyImpl.java
│   │           └── Main.java
├── test/
│   └── java/
│       └── com/
│           └── banking/
└── pom.xml
└── .gitignore
└── README.md



