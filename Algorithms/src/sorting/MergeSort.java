package sorting;

import static sorting.QuickSort.printArray;

public class MergeSort {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Tìm điểm chính giữa
            int m = l + (r - l) / 2;

            // Đệ quy chia đôi mảng
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Trộn hai nửa đã sắp xếp
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // Tìm kích thước của hai mảng con cần trộn
        int n1 = m - l + 1;
        int n2 = r - m;

        // Tạo các mảng tạm
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Sao chép dữ liệu vào mảng tạm
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        // Trộn các mảng tạm lại
        int i = 0, j = 0;
        int k = l; // Chỉ số bắt đầu của mảng đã trộn
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Mảng gốc:");
        printArray(arr1);

        // Chạy Merge Sort
        int[] mergeArr = arr1.clone();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Sau Merge Sort:");
        printArray(mergeArr);
    }
}
