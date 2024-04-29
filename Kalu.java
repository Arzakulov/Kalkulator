import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Введите первое число (арабские или римские): ");
        String num1 = input.next();
        
        System.out.println("Введите второе число (арабские или римские): ");
        String num2 = input.next();
        
        System.out.println("Выберите оператор (+,-,*,/): ");
        String operator = input.next();
        
        int int1, int2;
        
        if (isRoman(num1)) {
            int1 = romanToDecimal(num1);
        } else {
            int1 = Integer.parseInt(num1);
        }
        
        if (isRoman(num2)) {
            int2 = romanToDecimal(num2);
        } else {
            int2 = Integer.parseInt(num2);
        }
        
        int result = 0;
        
        switch (operator) {
            case "+":
                result = int1 + int2;
                break;
            case "-":
                result = int1 - int2;
                break;
            case "*":
                result = int1 * int2;
                break;
            case "/":
                result = int1 / int2;
                break;
            default:
                System.out.println("Неверный оператор");
        }
        
        System.out.println("Результат: " + result);
    }
    
    public static boolean isRoman(String str) {
        return str.matches("^[IVXLCDM]+$");
    }
    
    public static int romanToDecimal(String roman) {
        Map<Character, Integer> romanDict = new HashMap<>();
        romanDict.put('I', 1);
        romanDict.put('V', 5);
        romanDict.put('X', 10);
        romanDict.put('L', 50);
        romanDict.put('C', 100);
        romanDict.put('D', 500);
        romanDict.put('M', 1000);
        
        int num = 0;
        int prevNum = 0;
        
        for (int i = roman.length() - 1; i >= 0; i--) {
            int currNum = romanDict.get(roman.charAt(i));
            
            if (currNum < prevNum) {
                num -= currNum;
            } else {
                num += currNum;
            }
            
            prevNum = currNum;
        }
        
        return num;
    }
}
