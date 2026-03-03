public class Application {
    public static void main(String[] args) {

        //first integer
        int number1 = -7;

        //second integer
        int number2 = 4;

        // a container for the sum
        int result;

        // create a new instance of this class to be able to access the two methods
        Calculator calculator = new Calculator();

        if (calculator.isPositive(number1) && calculator.isPositive(number2)) {
            result = calculator.addTwoPositiveNumbers(number1, number2);
            System.out.println("Both numbers are positive and the sum is " + result);
        } else
            System.out.println("Number1 or/and Number2 is/are not positive");
    }
}