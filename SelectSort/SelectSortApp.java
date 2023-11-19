import java.util.Random;

public class SelectSortApp {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000}; // Tamanhos dos vetores

        for (int tamanho : tamanhos) {
            long tempoTotal = 0;
            long totalSelecoes = 0;
            long totalIteracoes = 0;
            int numExecucoes = 5;

            for (int execucao = 0; execucao < numExecucoes; execucao++) {
                int[] arr = gerarVetorAleatorio(tamanho);

                long inicio = System.nanoTime();
                int[] resultado = selectionSort(arr);
                long fim = System.nanoTime();

                tempoTotal += (fim - inicio);
                totalSelecoes += resultado[0];
                totalIteracoes += resultado[1];
            }

            long tempoMedio = tempoTotal / numExecucoes;
            long selecoesMedias = totalSelecoes / numExecucoes;
            long iteracoesMedias = totalIteracoes / numExecucoes;

            System.out.println("Tamanho: " + tamanho);
            System.out.println("Tempo Médio (nanossegundos): " + tempoMedio);
            System.out.println("Seleções Médias: " + selecoesMedias);
            System.out.println("Iterações Médias: " + iteracoesMedias);
            System.out.println();
        }
    }

    private static int[] selectionSort(int[] arr) {
        int n = arr.length;
        int selecoes = 0;
        int iteracoes = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                iteracoes++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                selecoes++;
            }
        }

        return new int[]{selecoes, iteracoes};
    }

    private static int[] gerarVetorAleatorio(int tamanho) {
        int[] arr = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            arr[i] = rand.nextInt(10000); // Valor máximo de 10.000
        }
        return arr;
    }
}
