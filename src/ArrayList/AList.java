package ArrayList;

public class AList {
    private int[] items;
    private int size;

    public AList() {
        items = new int[999];
        size = 0;
    }

    public void addLast(int x) {
        items[size] = x;
        size++;
    }

    public int get(int i){
        return items[i];
    }

    public int size() {
        return size;
    }
}
