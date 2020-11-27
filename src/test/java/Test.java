public class Test {
    public static void main(String[] args) {
   System.out.println(areEqual(4,2+2));
   System.out.println(areEqual(5,2+3));
   System.out.println(areEqual(8,5+3));
   System.out.println(areEqual(7,8-1));
    }
    private  static boolean areEqual(int expected, int actual){
        return actual==expected;
    }
}
