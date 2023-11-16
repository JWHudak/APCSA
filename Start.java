import LinearStructures.ArrayList;
import LinearStructures.LinkedList;

public class Start {
    public static void main(String[] args) {
        LinkedList<Integer> testInt = new LinkedList<>();

        for(int i = 1; i <= 20; i++) {
            testInt.add(i);
        }

        System.out.println(testInt);

        for(int x : testInt) {
            System.out.println(x);
        }

    }
}
