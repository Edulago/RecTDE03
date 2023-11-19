import java.util.Random;

public class BubbleSortApp {
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
                int[] result = bubbleSort(arr);
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

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        int iterations = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                iterations++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) {
                break;
            }
        }

        return new int[]{swaps, iterations};
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
