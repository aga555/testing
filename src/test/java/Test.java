public class Test {
    public static void main(String[] args) {
    StringCalculator calculator= new StringCalculator();
    int result= calculator.add("2");
    System.out.println(areEqual(2,result));

    }
    private  static boolean areEqual(int expected, int actual){
        return actual==expected;
    }
}
