import LinearStructures.ArrayList;

public class Start {
    public static void main(String[] args) {
        ArrayList<Integer> testInt = new ArrayList<>();
        ArrayList<String> testString = new ArrayList<>();

        for(int i = 1; i <= 20; i++) {
            testInt.add(i);
        }

        testString.add("A");
        testString.add("B");
        testString.add("C");
        testString.add("D");

        System.out.println(testInt);
        System.out.println(testString);

        for(String x : testString) {
            System.out.println(x);
        }


    }
}
