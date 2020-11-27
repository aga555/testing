public class StringCalculator {
    public int add(String input){
        if (input.isEmpty()){
            return 0;
        }
        String[] numbers=input.split(",");
        if(numbers.length==1){
            String number= numbers[0];
            return getIntFrom(number);
        } else {
            return getIntFrom(numbers[0]) +getIntFrom(numbers[1]);
        }
    }
    private int getIntFrom(String number){
        return Integer.parseInt(number);
    }
}
