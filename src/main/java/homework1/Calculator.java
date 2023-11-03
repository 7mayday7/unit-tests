package homework1;

public class Calculator {
    /**
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return возвращает сумму покупки с учетом скидки
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount < 0) {
            throw new ArithmeticException("Сумма закупки не может быть отрицательной");
        }

        if (discountAmount < 0) {
            throw new ArithmeticException("Сумма скидки не может быть отрицательной");
        }

        if (discountAmount > 100) {
            throw new ArithmeticException("Размер скидки не может быть больше 100%");
        }

        double discount = (purchaseAmount * discountAmount) / 100;
        return purchaseAmount - discount;
    }

}