// nome: Renan Horochk de Andrade RA: 
// nome: Ryan Ledo RA: 10352727

import java.util.Scanner;

public class Main {
    
        public static boolean validarAberturaParentesis(String expressaoNumerica) {
            boolean flagAberturaParentesis;
            PilhaStr pilhaParentesis = new PilhaStr();
            int tamanhoExpressao = expressaoNumerica.length();
            
            // validacao parentesis nao fechados
            //empilhando os caracteres de abertura
            for (int i=0; i < tamanhoExpressao; i++) {
                if (expressaoNumerica.charAt(i) == '(')
                {
                    pilhaParentesis.push(expressaoNumerica.charAt(i));
                }
            }
    
            //verificando se todas as aberturas sao fechadas, a flag deve ser true no final da execucao
            for (int i=0; i < expressaoNumerica.length(); i++) {
                if (expressaoNumerica.charAt(i) == ')')
                {
                    //verificando se o topo da pilha corresponde ao simbolo de fechamento
                    // (((A+b)*d
                    if (!pilhaParentesis.isEmpty() && expressaoNumerica.charAt(i) == ')' && pilhaParentesis.topo() == '(')
                    {
                        pilhaParentesis.pop(); // desempilha para verificar o proximo
                    }
                }
            }
            // se a pilha nao estiver vazia quer dizer que nao foram fechados todos os parentesis
            flagAberturaParentesis = pilhaParentesis.isEmpty();

            if (flagAberturaParentesis == false) {
                throw new IllegalArgumentException("Os parentesis nao foram fechados corretamente ");
            }
            return flagAberturaParentesis;
        }

        public static boolean validarOperadores(String expressaoNumerica) {
            boolean flagPeloMenosUmOperador = false;
            String operadores = "+-*/^";
            int tamanhoExpressao = expressaoNumerica.length();

            //VERIFICANDO SE A EXPRESSAO DE ENTRADA POSSUI PELO MENOS UM OPERADOR
            for (int i=0; i < tamanhoExpressao; i++) {
                if (operadores.indexOf(expressaoNumerica.charAt(i)) >= 0) 
                {
                    flagPeloMenosUmOperador = true;
                }
            }
            if (flagPeloMenosUmOperador == false) {
                throw new IllegalArgumentException("A expressao nao possui operadores! ");
            }
            return flagPeloMenosUmOperador;
        }
    
        public static String conversaoInfixaPosfixa(String expressaoNumerica) {
            PilhaStr pilhaCaracter = new PilhaStr();
            String saida = "";
            String operadores = "+-*/^";
            boolean flagAberturaParentesis;
            boolean flagOperadores;

            // ---------------------------------------------------------------------------------------------------------------------//
            //Comecando a Conversao somente se a entrada for valida
            flagAberturaParentesis = validarAberturaParentesis(expressaoNumerica);
            flagOperadores = validarOperadores(expressaoNumerica);

            try {

                try {
                    String expressaoNumericaUpperCase = expressaoNumerica.toUpperCase();

                // Percorrendo a expressão numérica
                for (int i = 0; i < expressaoNumericaUpperCase.length(); i++) {
                    //usando ch para diminuir o tamanho das condicoes
                    char ch = expressaoNumericaUpperCase.charAt(i);

                    // Se for uma letra adiciona a saída
                    if (Character.isLetter(ch)) {
                        saida += ch;
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
                while (!pilhaCaracter.isEmpty()) 
                {
                    saida += pilhaCaracter.pop();
                }
                    
                } catch (Exception e) {
                    System.out.println("A expressao no possui operadores! ");
                }
                
            } catch (Exception e) {
                System.out.println("Ha parentesis que nao foram fechados! ");
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

    public static void calcular(String expressaoPosFixa,  char caracteres[], int valor[]) {

        Scanner scan = new Scanner(System.in );
		
		
		Pilha pilha = new Pilha();

		OperaPilha pihla2 = new OperaPilha(pilha);
        
      // --------------------------------------------------------------------------//1
      

      // percorrendo a expressao pos fixa e colocando as letras em nome
        int tamanhoExpressao = expressaoPosFixa.length();

        for (int i = 0; i < tamanhoExpressao; i ++) {
            // simplicando as expressoes com  vriavel ch
            char ch = expressaoPosFixa.charAt(i);

        }
		
        char check = '0';
		String expre = expressaoPosFixa;
		
		for(int i = 0; i < expre.length() ; i++) {
			check = expre.charAt(i);
			if ((check >= 65 && check <= 90) || (check >= 97 && check <= 122)) {
			    for(int j=0; j< caracteres.length; j++) {
			    	if(check == caracteres[j] || check - 32 == caracteres[j]|| check + 32 == caracteres[j]) {
			    		
			    		pilha.push(valor[j]);
			    	}
			    }
			}if(check == '+') {
				pihla2.soma();
			}
			if(check == '-') {
				pihla2.sub();
			}
			if(check == '*') {
				pihla2.multi();
			}
			if(check == '/') {
				pihla2.div();
			}
			if(check == '^') {
				pihla2.expo();
			}
            
		}
        System.out.println("O resultado da expressão é :" + pilha.pop());
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.exibirMenu();

    }
}
