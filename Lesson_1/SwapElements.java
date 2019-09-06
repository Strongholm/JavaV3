public class SwapElements<T> {
    T[] array;

    public SwapElements(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void swap(int pos1, int pos2) {
        T tmp;

        tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }

}