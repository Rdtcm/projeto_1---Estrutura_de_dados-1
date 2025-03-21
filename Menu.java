// nome: Ryan Ledo RA: 10352727
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Menu {

    public static boolean flagEntradaExpressaoNumerica;


    private String expressaoNumerica;

    public String expressao_PosFixa;

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

                    // criando objeto pattern com o padrao estabelecido acima
                    Pattern pattern = Pattern.compile(formatoPadraoParainput);

                    //solicitando a entrada do usuario
                    System.out.println("Digite a expressão: ");
                    expressaoNumerica = scanner.nextLine();  // Recebe a expressão
                    System.out.println("Você digitou a expressão: " + expressaoNumerica);

                    //criando um matcher para comparar a entrada do usuario com o padrao
                    Matcher matcher = pattern.matcher(expressaoNumerica);

                    if (matcher.matches()) 
                        flagEntradaExpressaoNumerica = true;
                    else
                        flagEntradaExpressaoNumerica = false;
                    
                    break;

                case 2:
                    System.out.println("Informe os numeros das variaveis: ");
                    String input = scanner.nextLine();

                    // dividindo a string em partes
                    String[] partes = input.split(" ");

                    // convertendo cada parte para inteiro e guardando em um array
                    int[] entrada = new int[partes.length];
                    for (int i = 0; i < partes.length; i++) {
                        entrada[i] = Integer.parseInt(partes[i]);
                    }
                    
                    

                case 3:
                    String expressaoPosFixa = Main.conversaoInfixaPosfixa(expressaoNumerica);
                    System.out.println("Expressao Posfixa: " + expressaoPosFixa);
                    this.expressao_PosFixa = expressaoPosFixa;
                    break;

                case 4: // apresentar os resultados 

                    // quando chamar o metodo preciso passar a expressao pos fixa
                    Main.calcular(this.expressao_PosFixa);
                   
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
