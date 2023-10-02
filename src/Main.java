import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию: ");
        String input = scanner.nextLine().replaceAll(" ", "");
        calc(input);
    }

    public static String calc(String input) throws ScannerException {
        input = input.replaceAll("(\\d+|\\b[IVXLCDM]+\\b)"," $1 ");
        input = input.trim();
        String[] stringArray = input.split(" ");
        System.out.println(Arrays.toString(stringArray));
            if (stringArray.length == 3) {
                if (stringArray[0].matches("\\b[IVXLCDM]+\\b") && stringArray[2].matches("\\b[IVXLCDM]+\\b")) {
                    int numRom1 = convertToArab(stringArray[0]);
                    int numRom2 = convertToArab(stringArray[2]);
                    String operRom = stringArray[1];
                    if ((numRom1 < 11 && numRom1 > 0) && (numRom2 < 11 && numRom2 > 0)) {
                        switch (operRom) {
                            case "+":
                                input = String.valueOf(numRom1 + numRom2);
                                System.out.println(convertToRoman(Integer.parseInt(input)));
                                break;
                            case "-":
                                input = String.valueOf(numRom1 - numRom2);
                                System.out.println(convertToRoman(Integer.parseInt(input)));
                                break;
                            case "*":
                                input = String.valueOf(numRom1 * numRom2);
                                System.out.println(convertToRoman(Integer.parseInt(input)));
                                break;
                            case "/":
                                input = String.valueOf(numRom1 / numRom2);
                                System.out.println(convertToRoman(Integer.parseInt(input)));
                                break;
                        }
                    } else {
                        throw new ScannerException("Введите числа от I до X включительно");
                    }
                } else if ((stringArray[0].matches("[-+]?\\d+")) && (stringArray[2].matches("[-+]?\\d+"))) {
                    int num1 = Integer.parseInt(stringArray[0]);
                    int num2 = Integer.parseInt(stringArray[2]);
                    String oper = stringArray[1];
                    if ((num1 < 11 && num1 > 0) && (num2 < 11 && num2 > 0)) {
                        switch (oper) {
                            case "+":
                                input = String.valueOf(num1 + num2);
                                System.out.println(input);
                                break;
                            case "-":
                                input = String.valueOf(num1 - num2);
                                System.out.println(input);
                                break;
                            case "*":
                                input = String.valueOf(num1 * num2);
                                System.out.println(input);
                                break;
                            case "/":
                                input = String.valueOf(num1 / num2);
                                System.out.println(input);
                                break;
                        }
                    } else {
                        throw new ScannerException("Введите числа от 1 до 10 включительно");
                    }
                } else if ((stringArray[0].matches("[-+]?\\d+") && stringArray[2].matches("\\b[IVXLCDM]+\\b")) ||
                        (stringArray[0].matches("\\b[IVXLCDM]+\\b") && stringArray[2].matches("[-+]?\\d+"))) {
                    throw new ScannerException("Используются одновременно разные системы счисления");
                } else {
                    throw new ScannerException("Ввести можно только арабские или римские числа только целые");
                }
            } else {
                throw new ScannerException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           }
            return input;
        }

    public static String convertToRoman(int numArabian) throws ScannerException {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if (numArabian < 0) {
            throw new ScannerException("В римской системе нет отрицательных чисел");
        }
        final String number = roman[numArabian];
        return number;
    }

    static int convertToArab (String numRoman) {
        try {
            switch (numRoman) {
                case "I" -> {return 1;}
                case "II" -> {return 2;}
                case "III" -> {return 3;}
                case "IV" -> {return 4;}
                case "V" -> {return 5;}
                case "VI" -> {return 6;}
                case "VII" -> {return 7;}
                case "VIII" -> {return 8;}
                case "IX" -> {return 9;}
                case "X" -> {return 10;}
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        } return -1;
    }
}