// nome: Ryan Ledo RA: 10352727
public class PilhaInt {
    private static final int TAM_DEFAULT = 100; 
    private int topoPilha; 
    private char e[ ]; 

    public	PilhaInt() { // construtor 2
        this(TAM_DEFAULT);
    }


    public PilhaInt(int tamDefault) {
        
    }
    
    
        //Verifica se a pilha
    //está vazia
    public boolean isEmpty() {
        if (this.topoPilha == -1)
            return true;
        else
            return false;	
    }
    // Verifica se a pilha está
    // cheia
    public boolean isFull() {
    if (this.topoPilha == this.e.length-1)
            return true;
    else
            return false;	
    }
    // insere um elemento e 
    // no topo da pilha
    public void push(char e) {
        if (! this.isFull( ))
            this.e[++this.topoPilha] = e;
        else 
            System.out.println("overflow - Estouro de Pilha");
    }
    //remove um elemento 
    //do topo da pilha
    public char pop() {
        if (! this.isEmpty( ))
            return this.e[this.topoPilha--];
        else{
            System.out.println( "underflow - Esvaziamento de Pilha");
        return '1';
        }  
    }
    //Retorna o elemento que está
    //no topo da pilha
    public char topo() {
    if ( ! this.isEmpty( ))
            return this.e[this.topoPilha];
        else{
            System.out.println("Underlow - Esvaziamento de Pilha");
            return '1';
        }
    }
    // obtém o total de elementos 
    //armazenados na Pilha
    public int sizeElements() {
    return topoPilha+1;
    }



    // Sobrescrita/sobreposição (override) do método toString(), que veio da superclasse Object.
    // O retorno do método toString() é a representação de um objeto em formato string, e toString()
    // geralmente é executado (de forma implícita) quando passamos um objeto ao System.out.print*().
    //
    // Experimente incluir o seguinte código na main() e veja a saída:
    // Pilha p = new Pilha();
    // System.out.println(f);
    //
    // Depois, remova/comente o método toString() abaixo e rode o código acima novamente.
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[Pilha] topoPilha: ")
            .append(topoPilha)
            .append(", capacidade: ")
            .append(e.length)
            .append(", quantidade de elementos: ")
            .append(sizeElements());
        if (topoPilha != -1) {
            sb.append(", valor do Topo: ")
                .append(topo());
        }else sb.append(", valor do Topo: PILHA VAZIA");

        sb.append("\nConteudo da Pilha': [ ");
            
        for (int i = 0; i <= topoPilha; ++i)
            if (i != topoPilha) sb.append( e[i] + ", ");
            else sb.append( e[i] );
        sb.append( " ]");
        return sb.toString();
    }

}

