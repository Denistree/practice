import java.util.*;
public class Main {
    public static void main(String[] args) {
        double usdToRub = 75.0;
        double rubToUsd = 0.013;

        Scanner scanner = new Scanner(System.in);

        String[] options = {
                "1. Сложение",
                "2. Вычитание",
                "3. Конвертирование валют",
                "4. Выйти"
        };

        while (true) {
            System.out.println("Выберите операцию:");
            for (String option : options) {
                System.out.println(option);
            }

            String input = scanner.nextLine();
            if (input.equals("1")) {

                System.out.println("Введите значение в долларах ($):");
                String usdInput = scanner.nextLine();
                System.out.println("Введите значение в рублях (р):");
                String rubInput = scanner.nextLine();

                if (!usdInput.matches("^\\$\\d+(\\.\\d{1,2})?$") ||
                        !rubInput.matches("^\\d+(\\.\\d{1,2})?р$")) {
                    System.out.println("Введены некорректные данные. Повторите ввод.");
                    continue;
                }

                double usd = Double.parseDouble(usdInput.substring(1));
                double rub = Double.parseDouble(rubInput.substring(0, rubInput.length() - 1));

                double result = usd + rub / usdToRub;
                System.out.println(String.format("$%.2f = %.2fр", result, result * usdToRub));

            } else if (input.equals("2")) {

                System.out.println("Введите значение в долларах ($):");
                String usdInput = scanner.nextLine();
                System.out.println("Введите значение в рублях (р):");
                String rubInput = scanner.nextLine();

                if (!usdInput.matches("^\\$\\d+(\\.\\d{1,2})?$") ||
                        !rubInput.matches("^\\d+(\\.\\d{1,2})?р$")) {
                    System.out.println("Введены некорректные данные. Повторите ввод.");
                    continue;
                }


                double usd = Double.parseDouble(usdInput.substring(1));
                double rub = Double.parseDouble(rubInput.substring(0, rubInput.length() - 1));


                double result = usd - rub / usdToRub;
                System.out.println(String.format("$%.2f = %.2fр", result, result * usdToRub));

            } else if (input.equals("3")) {

                System.out.println("Выберите валюту и направление конвертации:");
                System.out.println("1. Доллары в рубли (курс " + usdToRub + ")");
                System.out.println("2. Рубли в доллары (курс " + rubToUsd + ")");
                String choice = scanner.nextLine();

                if (!choice.matches("^[12]$")) {
                    System.out.println("Введены некорректные данные. Повторите ввод.");
                    continue;
                }

                System.out.println("Введите значение для конвертации:");
                String valueInput = scanner.nextLine();

                if (!valueInput.matches("^\\d+(\\.\\d{1,2})?")) {
                    System.out.println("Введены некорректные данные. Повторите ввод.");
                    continue;
                }

                double value = Double.parseDouble(valueInput);

                if (choice.equals("1")) {
                    double result = value * usdToRub;
                    System.out.println(String.format("%.2fр = $%.2f", result, result * rubToUsd));
                } else {
                    double result = value * rubToUsd;
                    System.out.println(String.format("$%.2f = %.2fр", value, result));
                }

            } else if (input.equals("4")) {

                System.out.println("Выход из программы.");
                break;
            } else {

                System.out.println("Выбрана некорректная опция. Повторите ввод.");
            }
        }
    }
}