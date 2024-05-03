import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        System.out.println(calc("VI / III")); // Пример использования
    }

    public static String calc(String input) {
        HashMap<String, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put("I", 1);
        romanNumerals.put("II", 2);
        romanNumerals.put("III", 3);
        romanNumerals.put("IV", 4);
        romanNumerals.put("V", 5);
        romanNumerals.put("VI", 6);
        romanNumerals.put("VII", 7);
        romanNumerals.put("VIII", 8);
        romanNumerals.put("IX", 9);
        romanNumerals.put("X", 10);

        String[] elements = input.split(" ");
        if (elements.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }

        String first = elements[0];
        String operator = elements[1];
        String second = elements[2];

        if (!isValidInput(first, second, romanNumerals)) {
            throw new IllegalArgumentException("Используются разные системы счисления");
        }

        int a = romanNumerals.containsKey(first) ? romanNumerals.get(first) : Integer.parseInt(first);
        int b = romanNumerals.containsKey(second) ? romanNumerals.get(second) : Integer.parseInt(second);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }

        int result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция");
        }

        if (romanNumerals.containsKey(first)) {
            if (result < 1) {
                throw new IllegalArgumentException("Результат для римских чисел должен быть больше 0");
            }
            return toRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    private static boolean isValidInput(String first, String second, HashMap<String, Integer> romanNumerals) {
        if (romanNumerals.containsKey(first) && !romanNumerals.containsKey(second)) {
            return false;
        } else if (!romanNumerals.containsKey(first) && romanNumerals.containsKey(second)) {
            return false;
        }
        return true;
    }

    private static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException();
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (number > 0) {
            if (number - values[i] >= 0) {
                sb.append(numerals[i]);
                number -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
