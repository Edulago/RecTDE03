public class ArraySel {
    
    private long[] a; //refencia ao vetor a 
    private int nElements; //numero de itens de dados

    public ArraySel(int max){ // construtor
        a = new long[max]; // cria o vetor
        nElements = 0; // sem itens ainda
    }

    public void insert(long value){  //insere elementos no vetor
        a[nElements] = value; // insere-o
        nElements++; // aumenta o tamanho 
    }

    public void display(){  //mostra na tela o vetor
        for( int i = 0; i < nElements; i++){
            System.out.print(a[i] + " ");
            System.out.println("");
        }
    }

    public void selectionSort() {
        int in, out, min;
    
        for (out = 0; out < nElements - 1; out++) { // laço externo
            min = out; // índice do mínimo
    
            for (in = out + 1; in < nElements; in++) { // laço interno
                if (a[in] < a[min]) { // se encontrarmos um valor menor
                    min = in; // atualizamos o índice do mínimo
                }
            }
    
            if (out != min) { // se o índice do mínimo mudou
                swap(out, min); // troca os elementos
            }
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
