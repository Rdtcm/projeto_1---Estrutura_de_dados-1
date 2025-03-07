
import java.util.Scanner;

public class Menu {


    private String expressaoNumerica;

    // Construtor da classe
    public Menu() {
        this.expressaoNumerica = "";
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int op;

        // Exibe o menu
        while (true) {
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

            System.out.println("Digite a opção desejada: ");
            op = scanner.nextInt();
            scanner.nextLine();  // Limpeza do buffer

            switch (op) {
                case 1:
                    System.out.println("Digite a expressão: ");
                    expressaoNumerica = scanner.nextLine();  // Recebe a expressão
                    System.out.println("Você digitou a expressão: " + expressaoNumerica);
                    break;

                case 2:
                    
                    break;

                case 3:
                    String expressaoPosFixa = Main.conversaoInfixaPosfixa(expressaoNumerica);
                    System.out.println("Expressao Posfixa: " + expressaoPosFixa);
                    break;

                case 4:
                   
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

    // Getter para expressaoNumerica
    public String getExpressaoNumerica() {
        return expressaoNumerica;
    }

    // Setter para expressaoNumerica
    public void setExpressaoNumerica(String expressaoNumerica) {
        this.expressaoNumerica = expressaoNumerica;
    }
}
