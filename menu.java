import java.util.Scanner;


public class menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int op;
        String expressaoNumerica;
        //fazendo o menu
        while(true) {
            System.out.println("Digite a opção desejada: ");
            op = scan.nextInt();

            if (op == 1) {
                System.out.println("Digite a expressão: ");
                expressaoNumerica = scan.nextLine();
            }
            if (op == 2) {

            }
            if (op == 3) {

            }
            if (op == 4) {

            }
            if (op == 5) {
                System.out.println("");
                break;
            }
        }
    }
}