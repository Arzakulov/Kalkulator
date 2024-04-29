public class Calculator {
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            String result = calculator.calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    public String calc(String input) {
        String[] parts = input.split(" ");
        
        if (parts.length != 3) {
            throw new IllegalArgumentException("Некорректный формат ввода");
        }
        
        String operator = parts[1];
        int num1 = convertToNumber(parts[0]);
        int num2 = convertToNumber(parts[2]);
        
        int result;
        
        switch (operator) {
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
                if (num2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Некорректная операция");
        }
        
        return String.valueOf(result);
    }
    
    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            switch (input) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
                default:
                    throw new IllegalArgumentException("Неправильный формат числа");
            }
        }
    }
}
