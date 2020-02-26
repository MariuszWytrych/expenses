import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Expense {
    private LocalDateTime time;
    private BigDecimal amount;
//    private int category;
    private Category category;

    public static final Category[] CATEGORIES = {
            new Category(0, "Rachunki"),
            new Category(1, "Jedzenie"),
            new Category(2, "Samochód"),
            new Category(3, "Ubrania"),
            new Category(4, "Inne...")

    };

    public Expense(LocalDateTime time, BigDecimal amount, Category category) {
        this.time = time;
        this.amount = amount;
        this.category = category;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public String toString(){
        return "Wydatek{" +
                "kiedy=" + time +
                ", ile=" + amount +
                ", za co=" + category +
                '}';
    }

}
