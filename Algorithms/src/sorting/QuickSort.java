package sorting;

public class QuickSort {
    /*
    Idea: Phân vùng và sau đó chọn pivot cố định, sau đó tiếp tục gọi đệ quy tìm pivot và hoàn thành sắp xếp.
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Noi pivot dung sau khi phan vung
            int pi = partition(arr, low, high);

            // Recursion
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if  (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Mảng gốc:");
        printArray(arr1);

        // Chạy Quick Sort
        int[] quickArr = arr1.clone();
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("Sau Quick Sort:");
        printArray(quickArr);
    }
}
