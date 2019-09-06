import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> box = new ArrayList<>();

    public void add(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        if (box.size() == 0) return 0;
        return box.size() * box.get(0).getWeight();
    }

    public boolean compareWeight(Box<?> boxToCompare) {
        return (getWeight() == boxToCompare.getWeight()) ? true : false ;
    }

    public void moveFrom(Box<T> from) {
        for (T fruit : from.getBox()) box.add(fruit);
        from.getBox().removeAll(from.getBox());
    }

    public ArrayList<T> getBox() {
        return box;
    }

}