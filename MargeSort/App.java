import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] sizes = {50, 500, 1000, 5000, 10000}; // Tamanhos dos vetores

        for (int size : sizes) {
            long totalTime = 0;
            long totalSwaps = 0;
            long totalIterations = 0;
            int numRuns = 5;

            for (int run = 0; run < numRuns; run++) {
                int[] arr = generateRandomArray(size);

                long startTime = System.nanoTime();
                int[] result = mergeSort(arr);
                long endTime = System.nanoTime();

                totalTime += (endTime - startTime);
                totalSwaps += result[0];
                totalIterations += result[1];
            }

            long averageTime = totalTime / numRuns;
            long averageSwaps = totalSwaps / numRuns;
            long averageIterations = totalIterations / numRuns;

            System.out.println("Tamanho: " + size);
            System.out.println("Tempo Médio (nanossegundos): " + averageTime);
            System.out.println("Trocas Médias: " + averageSwaps);
            System.out.println("Iterações Médias: " + averageIterations);
            System.out.println();
        }
    }

    private static int[] mergeSort(int[] arr) {
        int n = arr.length;
        int[] aux = new int[n];
        int[] result = new int[2];  // [0] para swaps, [1] para iterations
        mergeSort(arr, aux, 0, n - 1, result);
        return result;
    }

    private static void mergeSort(int[] arr, int[] aux, int low, int high, int[] result) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, aux, low, mid, result);
            mergeSort(arr, aux, mid + 1, high, result);

            merge(arr, aux, low, mid, high, result);
        }
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high, int[] result) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int swaps = 0;
        int iterations = 0;

        // Realiza a mesclagem ordenada
        while (i <= mid && j <= high) {
            iterations++;
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
                swaps += mid - i + 1; // Conta as trocas ao mesclar.
            }
        }

        // Copia os elementos restantes da primeira metade, se houver
        while (i <= mid) {
            aux[k++] = arr[i++];
        }

        // Copia os elementos restantes da segunda metade, se houver
        while (j <= high) {
            aux[k++] = arr[j++];
        }

        // Copia os elementos ordenados de volta para o array original
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }

        // Atualiza as trocas e iterações
        result[0] += swaps;
        result[1] += iterations;
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000); // Valor máximo de 10.000
        }
        return arr;
    }
}
