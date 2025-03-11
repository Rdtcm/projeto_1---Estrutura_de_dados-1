
# PROJETO_1---Estrutura_de_Dados_1
Repositório para implementar o projeto 1 da matéria Estrutura de Dados 1.
GRUPO: ALEF,DERICK,RENAN,RYAN.
**************************************************************************

## ATIVIDADE 1: AVALIADOR DE EXPRESSÕES MATEMÁTICAS 

### OBJETIVO: DESENVOLVER UMA APLICAÇÃO EM JAVA QUE SOLUCIONE EXPRESSÕES MATEMÁTICAS ATRAVÉS DE NOTAÇÃO POLONESA (REVERSA) | POSFIXA, USANDO MANIPULAÇÃO DE PILHAS JAVA.

-O QUE É <ins>NOTAÇÃO POLONESA REVERSA OU POSFIXA (Reverse Polish Notation (RPN))</ins>:
  - Proposta pelo matemático polonês Jan Lukasiewicz é uma forma de escrever expressões aritméticas e lógicase sem a necessicade de prioridades através do uso de parênteses. Posteriomente, usada para       algumas calculadoras científicas e linguagens de programação.


-O programa deve:
  - Realizar a leitura de uma expressão matemática na notação infixa, sendo que as variáveis possuem uma única letra, por exemplo, (A + B) * A + B – C ;
  - Após inserida a expressão, deve-se realizar a leitura/atribuição dos valores numéricos de cada variável, exemplo as variáveis A = 5, B=7  e C=10);
  - Converter a expressão para notação polonesa reversa (notação posfixa), exemplo: infixa = (A + B) * A + B – C convertida para posfixa = A B + A * B + C -
  - Realizar o cálculo e apresentar o resultado da expressão.
  - Passo a passo do programa:
    - receber expressão infixa com variáveis: (A + B) * A + B – C;
    - receber atribuição de valores as variáveis A B e C => A=5, B=7, C=10;
    - expressão infixa após atribuição de valores: (5 + 7) * 5 + 7 - 10;
    - transformação da expressão infixa para notação polonesa reversa (notação posfixa) => A B + A * B + C -   com valores => 5 7 + 5 * 7 + 10 -;
    - calcular a expressão e apresentar resultado: 5 7 + 5 * 7 + 10 - = 57.

-RESTRIÇÕES :
- Na linguagem de programação Java:
  - A solução deve ser implementada em linguagem Java e deve usar uma versão adaptada da
  implementação do TAD Pilha estática/sequencial realizada durante as aulas.
  
  - Restringido o uso de estruturas de dados fornecidas pela linguagem Java (restrição inclui uso
  de Stack, Map, Hashtable, Vector, etc).

- Expressões matemáticas:
  - Devem conter somente variáveis e operadores (ver abaixo);
  - Podem conter espaços em branco, assim como não ter espaços em branco entre variáveis e operadores;
  - Devem estar em notação infixa;
  - Devem ser convertidas para a notação posfixa;
  - O cálculo da expressão deve ser realizado usando a expressão posfixa, somente se todas as variáveis presentes na expressão possuem valores definidos;
  - O programa deve validar as expressões matemáticas, isto é:
    - Aceitar somente as operações indicadas abaixo;
    - Aceitar somente variáveis como operandos, sendo que as variáveis possuem uma única letra, conforme indicado abaixo;
    - Considerar que uma expressão matemática na notação infixa pode conter parênteses que definem a prioridade das operações;
  - Caso a expressão inserida seja inválida (por exemplo, a expressão contém algum operador que não seja um dos cinco indicados ou possui uma quantidade incorreta de parênteses, como
    ((((A * (B – C)), o programa deve exibir uma mensagem informando o erro.
- Operações suportadas:
  - Binárias: + - * / ^ (adição, subtração, multiplicação, divisão e exponenciação, respectivamente).
  - Unária de negação (desafio opcional): -
  - Parênteses: ( )
- Variáveis:
  - A-Z, case insensitive.
 
REFERÊNCIAS:

  - https://panda.ime.usp.br/algoritmos/static/eps/ep6/parted/parted-polonesa.html
  - https://pt.wikipedia.org/wiki/Jan_%C5%81ukasiewicz
=======


