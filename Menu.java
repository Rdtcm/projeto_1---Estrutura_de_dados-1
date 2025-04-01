/*
Nome:Alef de souza Iima
RA:10431891
-------------------------------
Nome:Derick Sant’Ana Nascimento
RA:10443727
-------------------------------
Nome:Renan Horochk de Andrade
RA:10438120
-------------------------------
Nome:Ryan Vinicius Ledo
RA:10352727
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Menu {
    // ATRIBUTOS    
    public static boolean flagEntradaExpressaoNumerica;
    private boolean flagParentesis;
    private boolean flagOperadores;
    private String expressaoNumerica;
    public String expressao_PosFixa;
    private String e;
    private String armazem;
    String veri;
    private int count;
    private int[] valor; 
    private char[] carac;
    private boolean permiti = false;
    // Construtor da classe
    public Menu() {
        this.expressaoNumerica = "";
    }

    // fazendo um getter da expressao numerica
    public String getExpressaoNumerica() {
        return this.expressaoNumerica;
    }

    // getter da expressao pos fixa
    public String getExpressaoPosFixa() {
        return this.expressao_PosFixa;
    }
    

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int op;

        // Exibe o menu
        while (true) {
            //acrescentei codigos de escape ANSI apenas para deixar o print no terminal mais bonito e visivel
            System.out.println("\n");
            System.out.println("\033[1;34m*************************************\033[0m");
            System.out.println("\033[1;34m*               Menu                *\033[0m");
            System.out.println("\033[1;34m*************************************\033[0m");
            System.out.println("\033[1;32m1. Opção 1: Entrada da expressão aritmética na notação infixa X\033[0m");
            System.out.println("\033[1;32m2. Opção 2: Entrada dos valores numéricos associados às variáveis Y\033[0m");
            System.out.println("\033[1;32m3. Opção 3: Converter Expressao e Mostrar Y\033[0m");
            System.out.println("\033[1;32m4. Opção 4: Apresentar Resultados Y\033[0m");
            System.out.println("\033[1;32m5. Opção 5: Sair\033[0m");
            System.out.println("\033[1;34m*************************************\033[0m");

            System.out.println("\033[1;31mDigite a opção desejada: \033[0m");
            op = scanner.nextInt();

            scanner.nextLine();

            // scanner.close();
    
            switch (op) {
                case 1:
                    //validando a entrada do usuario
                    // para esta validacao utilizei o site https://www.devmedia.com.br/conceitos-basicos-sobre-expressoes-regulares-em-java/27539
                    // como uma fonte de pesquisa, pesquisei por expressoes regulares em java
                    String formatoPadraoParainput = "^[a-zA-Z()+\\-*/^]+$";
                    boolean flagP;
                    boolean flagOp;

                    // criando objeto pattern com o padrao estabelecido acima
                    Pattern pattern = Pattern.compile(formatoPadraoParainput);

                    //solicitando a entrada do usuario
                    try {
                        System.out.println("Digite a expressão: ");
                        expressaoNumerica = scanner.nextLine();  // Recebe a expressão
                        System.out.println("\nVocê digitou a expressão: " + expressaoNumerica);
                    } catch (Exception e) {
                        System.out.println("Erro ao obter a entrada: " + e);
                    }
                    

                    //criando um matcher para comparar a entrada do usuario com o padrao
                    Matcher matcher = pattern.matcher(expressaoNumerica);

                    if (matcher.matches()) {
                        flagEntradaExpressaoNumerica = true;
                        permiti = true;
                    }
                    else{
                        flagEntradaExpressaoNumerica = false;
                    }

                    // verificando se todos os parentesis foram fechdos
                    try {
                        flagP = Main.validarAberturaParentesis(this.expressaoNumerica);
                        this.flagParentesis = flagP;
                    } catch (Exception e) {
                        System.out.println("Ha parentesis que nao foram fechados na entrada! ");
                    }

                    // verificando se ha pelo menos um operador
                    try {
                        flagOp = Main.validarOperadores(this.expressaoNumerica);
                        this.flagOperadores = flagOp;
                    } catch (Exception e) {
                        System.out.println("A expressao nao possui nenhum operador! ");
                    }
                    break;

                case 2:
                if(permiti) {
                    count = 0;
                    
                   for (int i = 0; i < expressaoNumerica.length(); i++) {
                       char c = expressaoNumerica.charAt(i);
                       e += c;
                       
                       if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                           if(armazem== null) {
                               count ++ ;
                               armazem += c;
                           }
                           else if(!armazem.contains(e)) {
                               count ++ ;
                               armazem += c;
                           }
                           }
                       e = "";
                       }
                   
                   valor = new int[count];
                   carac = new char[count];
                   int numCaracter = 0;
                   boolean test = true;
                   for (int j = 0; j < expressaoNumerica.length(); j++) {
                       char c = expressaoNumerica.charAt(j);
                       test = true;
                           if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                               for(int k = 0; k < count ; k++) {
                                   if(carac[k] == c) {
                                       test = false;
                                   }
                               }
                               if(test) {
                             boolean verfi = false;
                             do{
                                try{
                                       carac[numCaracter] = c;
                                       System.out.println("Informe o valor de " + c + ":");
                                       int input = scanner.nextInt();
                                       valor[numCaracter] = input;
                                       numCaracter++;
                                       verfi = true;
                                }catch(Exception e){
                                    System.out.println("Dígito errado! Insira um número válido.");
                                    scanner.nextLine();//limpa o scanner
                                }
                             }while(verfi == false);
                               }
                               }
                           }
                   
                }       
                else{
                   System.out.println("Informe a expressão primeiro");
               }

               break;
                    
                    
                case 3:
                    String expressaoPosFixa = Main.conversaoInfixaPosfixa(expressaoNumerica);
                    System.out.println("Expressao Posfixa: " + expressaoPosFixa);
                    this.expressao_PosFixa = expressaoPosFixa;
                    break;

                case 4: // apresentar os resultados 

                    // quando chamar o metodo preciso passar a expressao pos fixa
                    Main.calcular(this.expressao_PosFixa,this.carac,this.valor);
                   
                    break;

                case 5:
                    System.out.println("Programa encerrado");
                    scanner.close();
                    return; 

                default:
                    System.out.println("Opção inválida.");
            }
        } 
    }

}
