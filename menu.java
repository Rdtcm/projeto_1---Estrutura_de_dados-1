import java.util.Scanner;


public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;
        String expressaoNumerica;
        //fazendo o menu
        while(true) {
            System.out.println("\n");
            System.out.println("\033[1;34m*************************************\033[0m");
            System.out.println("\033[1;34m*               Menu                *\033[0m");
            System.out.println("\033[1;34m*************************************\033[0m");
            System.out.println("\033[1;32m1. Opção 1: Entrada da expressão aritmética na notação infixa X\033[0m");
            System.out.println("\033[1;32m2. Opção 2: Entrada dos valores numéricos associados às variáveis Y\033[0m");
            System.out.println("\033[1;32m2. Opção 3: Converter Expressao e Mostrar Y\033[0m");
            System.out.println("\033[1;32m2. Opção 4: Apresentar Resultados Y\033[0m");
            System.out.println("\033[1;32m3. Opção 5: Sair\033[0m");
            System.out.println("\033[1;34m*************************************\033[0m");

            System.out.println("Digite a opção desejada: ");
            op = scanner.nextInt();

            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Digite a expressão: ");
                    expressaoNumerica = scanner.nextLine();
                    System.out.println("Voce digitou a expressao: " + expressaoNumerica);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Programa encerrado");
                    scanner.close();
                    break;
            }
        }
    }
}