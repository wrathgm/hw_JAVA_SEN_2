import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 12, 1 };

        try {
            FileWriter logFile = new FileWriter("sort_log.txt");

            logFile.write("Original Array: ");
            printArray(array, logFile);

            bubbleSort(array, logFile);

            logFile.close();
            System.out.println("Sorting complete. Check sort_log.txt for results.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to log file: " + e.getMessage());
        }
    }

    public static void bubbleSort(int[] array, FileWriter logFile) throws IOException {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    logFile.write("Iteration " + (i + 1) + ": ");
                    printArray(array, logFile);
                }
            }
        }
    }

    public static void printArray(int[] array, FileWriter logFile) throws IOException {
        for (int i = 0; i < array.length; i++) {
            logFile.write(array[i] + " ");
        }
        logFile.write("\n");
    }
}