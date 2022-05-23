import java.util.Scanner;


public class calculator {
    static Scanner scanner = new Scanner(System.in);
    static int a;
    static int b;
    static char operation;
    static int result;

    public static void main (String[] args) throws Exception {
        System.out.println("Введите необходимое действие с числами от 1 до 10, числа могут быть римскими: ");
        String input = scanner.nextLine();
        char[] sim = new char[10];
        for (int i = 0; i < input.length(); i++) {
            sim[i] = input.charAt(i);
            if (sim[i] == '+') {
                operation = '+';
            }
            if (sim[i] == '-') {
                operation = '-';
            }
            if (sim[i] == '*') {
                operation = '*';
            }
            if (sim[i] == '/') {
                operation = '/';
            } 
        }
        String opString = String.valueOf(sim);
        String[] unit = opString.split("[+-/*]");
        String str1 = unit[0];
        String str2 = unit[1];
        String str3 = str2.trim();
        a = romToArab(str1);
        b = romToArab(str3);
        if (a < 0 && b < 0) {
            result = 0;
        } else {
            result = calculation(a, b, operation);
            String resultRoman = arabToRom(result);
            System.out.println("Результат: " + resultRoman);
        }
        try {
        a = Integer.parseInt(str1);
        b = Integer.parseInt(str3);
        result = calculation(a, b, operation);
        System.out.println("Результат: " + result);
        } catch (Exception e){
        	String exe = "Данная операция невозможна";
        	throw new Exception(exe);
        }
    }

    private static String arabToRom (int arab) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String r = roman[arab];
        return r;
    }
    private static int romToArab (String roman) {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        return -1;
    }

    public static int calculation (int a, int b, char op) {
        int result = 0;
        try {
        switch (op) {
            case '+'-> result = a + b;
            case '-'-> result = a - b;
            case '*'-> result = a * b;
            case '/'-> result = a / b;
            default -> System.out.println(new RuntimeException("Операция не распознана!"));
        }
        } catch(RuntimeException e) {
        	throw new RuntimeException("Операция не распознана!");
        }
        return result;
    }
}