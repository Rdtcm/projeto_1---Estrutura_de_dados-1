// nome: Ryan Ledo RA: 10352727

public class Main {
    public static String conversaoInfixaPosfixa(String expressaoNumerica) {
        PilhaStr pilhaCaracter = new PilhaStr();
        String saida = "";
        String operadores = "+-*/^";
        // prioridade: ^, / ou *, + ou -

        // percorrendo expressao numerica
        for (int i=0; i < expressaoNumerica.length(); i++) {
            // se for uma letra, coloco na saida
            if (Character.isLetter(expressaoNumerica.charAt(i))) 
            {
                saida += expressaoNumerica.charAt(i);
            }
            // se for um caractere de operador
            else if (operadores.indexOf(expressaoNumerica.charAt(i)) >= 0 ) 
            {
                //enquanto a pilha nao for vazia e a prioridade do topo for maior do que a do caracte na posicao i
                while (! pilhaCaracter.isEmpty() && prioridade(pilhaCaracter.topo()) >= prioridade(expressaoNumerica.charAt(i))) {
                    saida += pilhaCaracter.pop();
                }

                pilhaCaracter.push(expressaoNumerica.charAt(i));
            }

            // se for um parentesis de abertura
            else if (expressaoNumerica.charAt(i) == '(') 
            {
                pilhaCaracter.push(expressaoNumerica.charAt(i));
            }
            // se for um parentesis de fechamento
            else if (expressaoNumerica.charAt(i) == ')')
            {
                // desempilhando ate achar um parentesis de abertura
                while (!pilhaCaracter.isEmpty() && pilhaCaracter.topo() != '(')
                {
                    saida += pilhaCaracter.pop();
                }
                // desempilhando o parentesis de abertura
                pilhaCaracter.pop();
            }
            //esvziando a pilha e movendo para saida
            while (! pilhaCaracter.isEmpty())
            {
                saida += pilhaCaracter.pop();
            }
            
        }
        // System.out.println("Expressao na forma posfixa: " + saida);
        return saida;
    }
    // metodo ou funcao para definir a prioridade
    public static int prioridade(char operador) {
        switch (operador) {
            // qunto maior a prioridade, maior o numero de retorno
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default: // para o caso de um operador ser invalido
                return -1;
        }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.exibirMenu();

    }
}
