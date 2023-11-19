import java.util.Random;

public class QuickSort {

    private int particoes;
    private int iteracoes;

    void quickSort(int x[], int inferior, int superior) {
        if (inferior >= superior)
            return;

        particoes = 0;
        iteracoes = 0;

        quickSortHelper(x, inferior, superior);
    }

    private void quickSortHelper(int[] arr, int inferior, int superior) {
        if (inferior >= superior)
            return;

        int pivo = particiona(arr, inferior, superior);

        quickSortHelper(arr, inferior, pivo - 1);
        quickSortHelper(arr, pivo + 1, superior);
    }

    private int particiona(int[] arr, int inferior, int superior) {
        int pivo = arr[inferior];
        int i = inferior + 1;
        int j = superior;

        while (i <= j) {
            iteracoes++;
            if (arr[i] <= pivo) {
                i++;
            } else if (arr[j] > pivo) {
                j--;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
                particoes++;
            }
        }

        arr[inferior] = arr[j];
        arr[j] = pivo;

        return j;
    }

    int getParticoes() {
        return particoes;
    }

    int getIteracoes() {
        return iteracoes;
    }

    static void preencherArrayAleatorio(int[] array, int tamanho) {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(10000); // Modifique conforme necessário
        }
    }
}
