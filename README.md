# imposto-poo-java

Sistema de cálculo de impostos utilizando Programação Orientada a Objetos (POO) em Java.

## Descrição
Este projeto é um exercício prático de POO, onde o usuário informa dados de contribuintes (pessoa física ou jurídica) e o sistema calcula o imposto devido para cada um, além do total de impostos pagos.

## Funcionalidades
- Cadastro de múltiplos contribuintes (pessoa física ou jurídica)
- Validação de entradas do usuário
- Cálculo de imposto individual conforme regras para cada tipo
- Exibição do total de impostos pagos

## Estrutura do Projeto
- `model/`  
  - `Pessoa.java` (classe abstrata)
  - `PessoaFisica.java` (herda de Pessoa)
  - `PessoaJuridica.java` (herda de Pessoa)
- `Controller/`
  - `PessoaController.java` (classe principal com lógica de entrada e saída)

## Como executar
1. Clone o repositório:

   git clone https://github.com/GuimaraesZ/imposto-poo-java.git
 
2. Compile o projeto:

   cd imposto-poo-java
   mvn compile
   
3. Execute a aplicação:

   mvn exec:java -Dexec.mainClass="com.exercicio.Controller.PessoaController"
   

## Exemplo de uso

Enter the number of tax payers: 2
Tax payer #1 data:
Individual or company (i/c)? i
Name: Alex
Anual income: 50000.00
Health expenditures: 2000.00
Tax payer #2 data:
Individual or company (i/c)? c
Name: SoftTech
Anual income: 400000.00
Number of employees: 25

TAXES PAID:
Alex: $ 11500.00
SoftTech: $ 56000.00

TOTAL TAXES: $ 67500.00


## Tecnologias
- Java 21
- Maven

## Autor
- [GuimaraesZ](https://github.com/GuimaraesZ)

## Conceitos de Programação Orientada a Objetos Utilizados

### Herança
O projeto utiliza herança ao definir a classe abstrata `Pessoa` como base para as classes `PessoaFisica` e `PessoaJuridica`. Ambas herdam atributos e métodos de `Pessoa`, permitindo o reaproveitamento de código e a especialização do comportamento para cada tipo de contribuinte.

### Polimorfismo
O polimorfismo está presente quando o método `imposto()` é sobrescrito (override) nas subclasses. O controller pode tratar todos os objetos como `Pessoa` e chamar `imposto()` sem se preocupar com o tipo específico, pois cada classe calcula o imposto de forma diferente.

### Abstração
A classe `Pessoa` é abstrata, ou seja, serve apenas como modelo e não pode ser instanciada diretamente. Ela define a estrutura comum para pessoas físicas e jurídicas, forçando as subclasses a implementarem (ou sobrescreverem) comportamentos específicos.

### Tratamento de Exceções
O código faz uso de tratamento de exceções (`try/catch`) para garantir que entradas inválidas do usuário (como letras ao invés de números) não quebrem o programa. Sempre que ocorre uma entrada inválida, o sistema exibe uma mensagem de erro e solicita o valor novamente, tornando a aplicação mais robusta e amigável.
