public class Generics_Class<T> {
    private T data;

    public Generics_Class(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
