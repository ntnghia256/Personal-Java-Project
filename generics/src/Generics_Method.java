public class Generics_Method {
    public static <T> T getData(T data) {
        return data;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
