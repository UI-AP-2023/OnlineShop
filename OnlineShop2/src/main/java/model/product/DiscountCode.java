package model.product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DiscountCode {
    private double discountPercent;
    private LocalDate date;
    private int capacity;
    private String discountCode;
    private DiscountType discountType;

    public DiscountCode(double discountPercent, int capacity, String date, String discountType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.date = LocalDate.parse(date, formatter);
        this.discountPercent = discountPercent;
        this.capacity = capacity;
        this.discountType = DiscountType.valueOf(discountType);
        this.discountCode = creatDiscountCode();
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = creatDiscountCode();
    }

    private String creatDiscountCode() {
        StringBuilder code = new StringBuilder();
        if (this.discountType == DiscountType.Welcome) {
            code.append("Welcome-");
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                code.append(random.nextInt(0, 10));
            }

        } else if (this.discountType == DiscountType.Encouragement) {
            code.append("Encouragement-");
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                code.append(random.nextInt(0, 10));
            }
        }
        return code.toString();
    }

}
