import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Expenses {
    final static Scanner scanner = new Scanner((System.in));

    public static void main(String[] args) {
        System.out.println("WITAJ W PROGRAMIE WYDATKI!");
        Expense[] expenses = new Expense [100];
        int index = 0;
        int option;
        do {
            printMenu();
            String optionString = scanner.nextLine();
            while (!optionString.matches("[1-5]")) {
                printMenu();
                optionString = scanner.nextLine();
            }
            option = Integer.parseInt(optionString);
            switch (option) {
                case 1:
                    expenses[index++] = addExpnse();

                    break;
                case 2:
                        showExpensesAll(expenses);
                    break;
                case 3:
                        showExpensesFromCategory(expenses);
                    break;
                case 4:
                        showExpensesGreaterThan(expenses);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.");
            }
        } while (option != 5);
        System.out.println("Żegnaj!");


    }
    private static void printMenu() {
        System.out.println("Wybierz co chcesz zrobić: ");
        System.out.println("1. Dodanie wydatków");
        System.out.println("2. Wyświetlenie wydatków");
        System.out.println("3. Wyświetlenie wydatków z danej kategorii");
        System.out.println("4. Wyświetlenie wydatków większych od X");
        System.out.println("5. Wyjście z programu");
    }

    private static Expense addExpnse() {
        System.out.println("Wpisz kwotę wydadków: ");
//        String amountString = scanner.nextLine();
//        while (!amountString.matches("\\d+(\\.\\d{1,2})?")) {
//            System.out.println("Podano niepoprawny format kwoty! Wpisz Popnownie: ");
//            amountString = scanner.nextLine();
//        }
        BigDecimal amount = readAmount();
        System.out.println("Podaj kategorię wydatków: ");
        Category category = readCategory();
//        System.out.printf("Kwota: %s, kategoria: %s\n", amountString, category.getName());
//
//        return new Expense(LocalDateTime.now(), new BigDecimal(amountString), category);
        System.out.printf("Kwota: %s, kategoria: %s\n", amount, category.getName());

        return new Expense(LocalDateTime.now(), amount, category);
    }
    private static void showExpensesAll(Expense[] expenses) {
//        if (expenses.length == 0) {
//            System.out.println("Brak wydatków!");
//        }
        for (Expense expense : expenses) {
            if (expense != null) {
                System.out.println(expense.toString());
            }
        }
    }

        private  static Category readCategory() {
//            System.out.println("Wybierz (1-5) kategorię wydatków: ");

            for (Category category : Expense.CATEGORIES) {
                System.out.println(category.getNumber() + 1 + ". " + category.getName());
            }
            String categoryString = scanner.nextLine();
            while (!categoryString.matches("[1-5]")) {
                System.out.println("Wybrano niedozwoloną opcję! Wybierz ponownie: ");
                categoryString = scanner.nextLine();
            }
            return Expense.CATEGORIES[Integer.parseInt(categoryString) - 1];
        }
    private static BigDecimal readAmount() {
        String amountString = scanner.nextLine();
        while (!amountString.matches("\\d+(\\.\\d{1,2})?")) {
            System.out.println("Nieprawidłowy format kwoty, wpisz ponownie!");
            amountString = scanner.nextLine();
        }
        return new BigDecimal(amountString);
    }

    private static void showExpensesFromCategory(Expense[] expenses) {
        System.out.println("Podaj kategorię: ");
        Category category = readCategory();
        Expense [] expenseFromCategory = new Expense[100];
        int index = 0;

        if (expenses.length == 0) {
            System.out.println("Brak wydatków!");
        }
        for (Expense expense : expenses) {
            if (expense != null && expense.getCategory().getNumber()==category.getNumber()) {
                expenseFromCategory [index++] = expense;

            }
        }
        showExpensesAll(expenseFromCategory);
    }
    private static void showExpensesGreaterThan(Expense[] expenses) {
        System.out.println("Podaj minimalną kwotę");
        BigDecimal minimum = readAmount();

        Expense[] expensesGreaterThan = new Expense[100];
        int index = 0;
        for (Expense expense: expenses) {
            if (expense != null && expense.getAmount().compareTo(minimum) > 0) {
                expensesGreaterThan[index++] = expense;
            }
        }

        showExpensesAll(expensesGreaterThan);
    }



//        System.out.println("Kwota: " + amountString + " na " + "Kategorię: " + categoryString);
//        Expense expense = new Expense(LocalDateTime.now(), new BigDecimal(amountString), Expense.CATEGORIES[Integer.parseInt(categoryString) - 1]);
//        return new Expense(LocalDateTime.now(), new BigDecimal(amountString), Expense.CATEGORIES[Integer.parseInt(categoryString) - 1]);
    }








