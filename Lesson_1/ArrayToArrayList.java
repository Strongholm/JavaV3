import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToArrayList<T extends Number> {
    T[] array;

    public ArrayToArrayList(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public ArrayList<T> convert() {
        return new ArrayList<T>(Arrays.asList(array));
    }
}