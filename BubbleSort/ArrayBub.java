public class ArrayBub {
    private long[] a; // Referencia ao vetor a
    private int nElems; // Numero de itens de dados

    public ArrayBub(int max) { // Construtor
        a = new long[max]; // Criar o vetor
        nElems = 0; // sem itens ainda
    }

    public void insert(long value) { // insere elementos ao vetor
        a[nElems] = value; // insere-o
        nElems++; // Aumenta tamanho
    }

    public void display() { // Mostra o conteudo do vetor
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(); // Adiciona uma quebra de linha
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) { // laço externo (para trás)
            for (in = 0; in < out; in++) { // laço interno (para frente)
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}