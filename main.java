import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in );
		char nome[]= {'A','B','E'};
		int valor[]= {0,0,0};
		
		Pilha pilha = new Pilha();
		
		OperaPilha pihla2 = new OperaPilha(pilha);
		System.out.println("Digite o valor dos numeros:");
		for(int i = 0 ; i < nome.length ; i++) {
			System.out.print(nome[i] +"=");
			  valor[i] = scan.nextInt();
		}
		for(int i = 0 ; i < nome.length ; i++) {
			System.out.println(nome[i] +"="+ valor[i]);
			 
		}	
		char check = '0';
		String expre = "AB^E^";
		
		for(int i = 0; i < expre.length() ; i++) {
			check = expre.charAt(i);
			if ((check >= 65 && check <= 90) || (check >= 97 && check <= 122)) {
			    for(int j=0; j< nome.length; j++) {
			    	if(check == nome[j] || check - 32 == nome[j]|| check + 32 == nome[j]) {
			    		
			    		pilha.push(valor[j]);
			    		System.out.println(pilha);
			    	}
			    }
			}if(check == '+') {
				pihla2.soma();
				System.out.println(pilha);
			}
			if(check == '-') {
				pihla2.sub();
				System.out.println(pilha);
			}
			if(check == '*') {
				pihla2.multi();
				System.out.println(pilha);
			}
			if(check == '/') {
				pihla2.div();
				System.out.println(pilha);
			}
			if(check == '^') {
				pihla2.expo();
				System.out.println(pilha);
			}

		}
				 
	

	}

}
