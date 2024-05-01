import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в формате 'число оператор число' (например, 2 + 3):");
        String input = scanner.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) {
        String[] tokens = input.split(" ");

        if(tokens.length != 3) {
            throw new IllegalArgumentException("Некорректный формат ввода. Введите выражение в формате 'число оператор число'.");
        }

        int num1 = convertToNumber(tokens[0]);
        int num2 = convertToNumber(tokens[2]);

        if((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new IllegalArgumentException("Некорректные числа. Введите числа от 1 до 10 включительно.");
        }

        int result;

        switch(tokens[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Некорректный оператор. Используйте '+', '-', '*', '/'");
        }

        return convertToRoman(result);
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // не удалось преобразовать как число, пробуем как римскую цифру
            return convertRomanToNumber(input);
        }
    }

    public static int convertRomanToNumber(String input) {
        if (input.equals("I")) return 1;
        if (input.equals("II")) return 2;
        if (input.equals("III")) return 3;
        if (input.equals("IV")) return 4;
        if (input.equals("V")) return 5;
        if (input.equals("VI")) return 6;
        if (input.equals("VII")) return 7;
        if (input.equals("VIII")) return 8;
        if (input.equals("IX")) return 9;
        if (input.equals("X")) return 10;

        throw new IllegalArgumentException("Некорректная римская цифра. Используйте от I до X.");
    }

    public static String convertToRoman(int number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Число должно быть от 1 до 10 для конвертации в римскую систему счисления.");
        }

        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        return romanNumerals[number - 1];
    }
}
