import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите пример: ");

        Scanner console = new Scanner(System.in);
        String example = console.nextLine();

        System.out.println(calc(example));
    }

    public static String calc(String input) throws Exception {
        String[] exampleArray = input.split(" ");

        int one = 0;
        int two = 0;

        if (exampleArray.length != 3) {
            throw new Exception("Калькулятор выполняет операции следующего вида: a + b, a - b, a * b, a / b.");
        }

        if (!(exampleArray[0].matches(".*[0-9].*")) || !(exampleArray[2].matches(".*[0-9].*"))) {
            throw new Exception("Калькулятор умеет работать только с арабскими числами");
        }

        if (input.matches(".*[0-9].*")) {
            one = Integer.parseInt(exampleArray[0]);
            two = Integer.parseInt(exampleArray[2]);
        }

        if ((one > 10) || (two > 10)) {
            throw new Exception("Калькулятор принимает числа от 1 до 10 включительно, не более");
        }
        if ((one < 1) || (two < 1)) {
            throw new Exception("Калькулятор принимает числа от не менее 1 до не более 10 включительно");
        }
        int result;
        switch (exampleArray[1]) {
            case "+" -> {
                result = one + two;
            }
            case "-" -> {
                result = one - two;
            }
            case "*" -> {
                result = one * two;
            }
            case "/" -> {
                result = one / two;
            }
            default -> throw new Exception("Калькулятор может принимать только следующие операции: +, -, *, /");
        }
        return String.valueOf(result);
    }
}
