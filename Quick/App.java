import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000}; // Tamanhos dos vetores

        for (int tamanho : tamanhos) {
            long tempoTotal = 0;
            long totalParticoes = 0;
            long totalIteracoes = 0;
            int numExecucoes = 5;

            for (int execucao = 0; execucao < numExecucoes; execucao++) {
                int[] arr = new int[tamanho];
                QuickSort.preencherArrayAleatorio(arr, tamanho);

                QuickSort quickSortObject = new QuickSort();

                long inicio = System.nanoTime();
                quickSortObject.quickSort(arr, 0, arr.length - 1);
                long fim = System.nanoTime();

                tempoTotal += (fim - inicio);
                totalParticoes += quickSortObject.getParticoes();
                totalIteracoes += quickSortObject.getIteracoes();
            }

            long tempoMedio = tempoTotal / numExecucoes;
            long particoesMedias = totalParticoes / numExecucoes;
            long iteracoesMedias = totalIteracoes / numExecucoes;

            System.out.println("Tamanho: " + tamanho);
            System.out.println("Tempo Médio (nanossegundos): " + tempoMedio);
            System.out.println("Partições Médias: " + particoesMedias);
            System.out.println("Iterações Médias: " + iteracoesMedias);
            System.out.println();
        }
    }
}
