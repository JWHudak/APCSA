package LinearStructures;
public class IntVector {

    private final static int INITIAL_CAPACITY = 10;
    private int[] arr = new int[INITIAL_CAPACITY];
    private int size = 0;

    public IntVector() {};

    public IntVector(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        }
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    private void testBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void tryResize() {
        if(size >= arr.length - 1) {
            int[] temp = new int[1 + arr.length * 2];

            for(int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            
            arr = temp;
        }
    }

    public void add(int n) {
        tryResize();
        arr[size++] = n;
    }

    public int get(int index) {
        testBounds(index);
        return arr[index];
    }

    public void clear() {
        arr = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(int index, int value) {
        testBounds(index);
        int temp = arr[index];
        arr[index] = value;
        add(arr[size - 1]);
        for(int i = size - 2; i > index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index + 1] = temp;
    }

    public boolean remove(int value) {
        int counter = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i] == value && counter == 0) {
                counter++;
                if(i + 1 >= size) {
                    arr[i] = 0;
                    size--;
                    return true;
                }
            }
            if(counter == 1) {
                arr[i] = arr[i + 1];
                if(i + 1 >= size) {
                    arr[i] = 0;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }
        String t = "[" + arr[0];
        for(int i = 1; i < size; i++) {
            t += ", " + arr[i];
        }
        return t + "]";
    }

}