import java.io.IOException;
import java.util.Scanner;


public class calculator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num1;
        int num2;
        char operation = 0;
        int result;
        System.out.println("Введите выражение: ");
        String expression = scanner.nextLine();              // считываем введенную строку
        for (int i = 0; i < expression.length(); i++) {      // находим знак операции
            switch (expression.charAt(i)) {
                case '+':
                    operation = '+';
                    break;
                case '-':
                    operation = '-';
                    break;
                case '/':
                    operation = '/';
                    break;
                case '*':
                    operation = '*';
                    break;
            }
        }
        String[] arrayNum = expression.split("[+-/*]"); // делим строку на операнды
        if (arrayNum.length > 2) {
            throw new IOException("формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *)");
        } else if (arrayNum.length < 2) {
            throw new IOException("строка не является математической операцией");
        }
        String strNum1 = arrayNum[0].trim();
        String strNum2 = arrayNum[1].trim();
        num1 = convert.romanToArabic(strNum1.toUpperCase());
        num2 = convert.romanToArabic(strNum2.toUpperCase());
        if (num1 < 0 && num2 < 0) {
            num1 = Integer.parseInt(strNum1);
            num2 = Integer.parseInt(strNum2);
            result = calculate.calculated(num1, num2, operation);
            System.out.println(result);
        } else if (num1 < 0 || num2 < 0) {
            throw new IOException("используются одновременно разные системы счисления");
        } else {
            result = calculate.calculated(num1, num2, operation);
            if ( result <= 0){
                throw new IOException("в римской системе нет отрицательных чисел");
            }
            String romanResult = convert.arabicToRoman(result);
            System.out.println(romanResult);
        }
    }
}

