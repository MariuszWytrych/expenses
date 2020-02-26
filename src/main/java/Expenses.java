import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Expenses {
    final static Scanner scanner = new Scanner((System.in));

    public static void main(String[] args) {
        System.out.println("WITAJ W PROGRAMIE WYDATKI!");
        Expense[] expenses = new Expense [100];
        int index = 0;
        int option = -1;
        do {
            printMenu();
            String optionString = scanner.nextLine();
            while (!optionString.matches("[1-5]")) {
                printMenu();
            }
            option = Integer.parseInt(optionString);
            switch (option) {
                case 1:
                    addExpnse();
                    expenses[index++] = addExpnse();

                    break;
                case 2:
                        showExpensesAll(expenses);
                    break;
                case 3:
                        showExpensesFromCategory(expenses);
                    break;
                case 4:
//                        showExpensesGreaterThan(expenses);
                    break;
                default:
                    System.out.println("Nie ma takiej opcja");
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
        String amountString = scanner.nextLine();
        while (!amountString.matches("\\d+(\\.\\d{1,2})?")) {
            System.out.println("Podano niepoprawny format kwoty! Wpisz Popnownie: ");
            amountString = scanner.nextLine();
        }
        Category category = readCategory();
        System.out.printf("Kwota: %s, kategoria: %s\n", amountString, category.getName());

        return new Expense(LocalDateTime.now(), new BigDecimal(amountString), category);
    }
    private static void showExpensesAll(Expense[] expenses) {
        if (expenses.length == 0) {
            System.out.println("Brak wydatków!");
        }
        for (Expense expense : expenses) {
            if (expense != null) {
                System.out.println(expense.toString());
            }
        }
    }

        private  static Category readCategory() {
            System.out.println("Wybierz (1-5) kategorię wydatków: ");

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
    private static void showExpensesFromCategory(Expense[] expenses) {
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



//        System.out.println("Kwota: " + amountString + " na " + "Kategorię: " + categoryString);
//        Expense expense = new Expense(LocalDateTime.now(), new BigDecimal(amountString), Expense.CATEGORIES[Integer.parseInt(categoryString) - 1]);
//        return new Expense(LocalDateTime.now(), new BigDecimal(amountString), Expense.CATEGORIES[Integer.parseInt(categoryString) - 1]);
    }








