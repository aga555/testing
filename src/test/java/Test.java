public class Test {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println(areEqual(2, calculator.add("2"), "Calculator should return number when number is  given"));
        System.out.println(areEqual(3, calculator.add("2,1"), "Calculator should return  sum when two number given"));
        System.out.println(areEqual(4, calculator.add("2,2"), "Calculator should return sum when two number given"));

    }

    private static String areEqual(int expected, int actual, String s) {
        if (actual == expected) {
            return s + " - passed";
        } else {
            return s + " - failed";
        }

    }
}
