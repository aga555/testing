public class Test {
    public static void main(String[] args) {
       int expected =4;
       int actual= 2+2;
       boolean result= areEqual(expected,actual);
    }
    private  static boolean areEqual(int expected, int actual){
        return actual==expected;
    }
}
