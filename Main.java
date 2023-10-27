public class Main {
    public static void main(String[] args) {
        try {
            IntVector test = new IntVector(0);

            for(int i = 0; i < 20; i++) {
                test.add(i);
            }

            System.out.println(test);

            test.add(0, 50);
            System.out.println(test);

            test.remove(3);
            System.out.println(test);




            
           
        } catch(IllegalArgumentException ex) {
            System.out.println("That's illegal!");
        } catch(ArithmeticException ex) {
            System.out.println("Bad math!");  
        } catch(Exception ex) {
            System.out.println("Generic Exception!");
        }
            
        
    }
}