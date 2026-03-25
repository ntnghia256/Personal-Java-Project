public class Main {
    public static void main(String[] args) {

        // Generics class
        Generics_Class<String> strGenerics = new Generics_Class<>("TrongNghia");
        System.out.println(strGenerics.getData());

        Generics_Class<Integer> intGenerics = new Generics_Class<>(256);
        System.out.println(intGenerics.getData());

        Generics_Class<Float> floatGenerics = new Generics_Class<>(256.02f);
        System.out.println(floatGenerics.getData());

        // Generics class
        String str = Generics_Method.getData("Generics class");
        int num = Generics_Method.getData(25062002);

        System.out.println(str);
        System.out.println(num);

        Integer[] arr = {1, 2, 3, 4, 5};
        // Static method -> global variable
        Generics_Method.swap(arr, 1, 2);
        for (Integer n : arr) {
            System.out.print(n + " ");
        }
    }
}
