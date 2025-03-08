// nome: Ryan Ledo RA: 10352727

public class Main {
    public static String conversaoInfixaPosfixa(String expressaoNumerica) {
        PilhaStr pilhaCaracter = new PilhaStr();
        String saida = "";
        String operadores = "+-*/^";
        
        // Transformando a expressão em maiúsculas
        String expressaoNumericaUpperCase = expressaoNumerica.toUpperCase();

        // Percorrendo a expressão numérica
        for (int i = 0; i < expressaoNumericaUpperCase.length(); i++) {
            //usando ch para diminuir o tamanho das condicoes
            char ch = expressaoNumericaUpperCase.charAt(i);

            // Se for uma letra adiciona a saída
            if (Character.isLetter(ch)) {
                saida += ch;
                System.out.println("saida: " + saida);
            }
            // Se for um operador gerencia a pilha conforme a prioridade
            else if (operadores.indexOf(ch) >= 0) {
                // Desempilha enquanto a prioridade do topo da pilha for maior ou igual
                while (!pilhaCaracter.isEmpty() && prioridade(pilhaCaracter.topo()) >= prioridade(ch)) {
                    saida += pilhaCaracter.pop();
                }
                pilhaCaracter.push(ch);
            }
            // Se for um parêntese de abertura, coloca na pilha
            else if (ch == '(') {
                pilhaCaracter.push(ch);
            }
            // Se for um parêntese de fechamento, desempilha até encontrar o parêntese de abertura
            else if (ch == ')') {
                while (!pilhaCaracter.isEmpty() && pilhaCaracter.topo() != '(') {
                    saida += pilhaCaracter.pop();
                }
                pilhaCaracter.pop(); // tirando o parentese de abertura da pilha
            }
        }

        // Esvaziando a pilha restante
        while (!pilhaCaracter.isEmpty()) {
            saida += pilhaCaracter.pop();
        }
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
