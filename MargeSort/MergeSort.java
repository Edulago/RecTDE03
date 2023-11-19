public class MergeSort {
    
    // Função de ordenação
    public static void mergeSort(int[] A, int[] Aa, int ini, int fim){
        if (ini < fim) {
            int meio = (ini + fim) / 2; // Encontra o ponto médio
            mergeSort(A, Aa, ini, meio); // Ordena a metade esquerda
            mergeSort(A, Aa, meio + 1, fim); // Ordena a metade direita
            intercalar(A, Aa, ini, meio, fim);// Intercala as duas metades ordenadas
        }
    }

    public static void intercalar(int[] A, int[] Aa, int ini, int meio, int fim){
        int f = ini;
        int m = meio + 1;
        // Copia os elementos para o array auxiliar Aa
        for (int i = ini; i <= fim; i++) {
            Aa[i] = A[i];
        }
        // Intercala os elementos de Aa de volta para A
        for (int i = ini; i <= fim; i++) {
            if (f > meio) {
                A[i] = Aa[m++];
            } else if (m > fim) {
                A[i] = Aa[f++];
            } else if (Aa[f] < Aa[m]) {
                A[i] = Aa[f++];
            } else {
                A[i] = Aa[m++];
            }
        }
    }
     // Função para imprimir
    public static void imprimir(int[] array, String nome) {
        System.out.print("Array " + nome + ": ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // Função para mesclar dois arrays ordenados em um terceiro array ordenado
    public static int[] mergeArrays(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < A.length) {
            C[k++] = A[i++];
        }

        while (j < B.length) {
            C[k++] = B[j++];
        }

        return C;
    }
}
