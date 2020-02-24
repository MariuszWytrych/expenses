import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Expenses {
    public static void main(String[] args) {
        System.out.println("WITAJ W PROGRAMIE WYDATKI!");

        Scanner scanner = new Scanner((System.in));
        System.out.println("Wpisz kwotę wydadków: ");
        String amountString = scanner.nextLine();
        while (!amountString.matches("\\d+(\\.\\d{1,2})?")){
            System.out.println("Podano niepoprawny format kwoty! Wpisz Popnownie: ");
            amountString = scanner.nextLine();
        }
        System.out.println("Wybierz (1-5) kategorię wydatków: ");

        for (Category category : Expense.CATEGORIES){
            System.out.println(category.getNumber() + 1 + ". " + category.getName());
        }
        String categoryString = scanner.nextLine();
        while (!categoryString.matches("[1-5]")){
            System.out.println("Wybrano niedozwoloną opcję! Wybierz ponownie: ");
            categoryString = scanner.nextLine();
        }
        System.out.println("Kwota: " + amountString + " na " + "Kategorię: " + categoryString );

        Expense expense = new Expense(LocalDateTime.now(),new BigDecimal(amountString), Expense.CATEGORIES [Integer.parseInt(categoryString)] );


    }
}
