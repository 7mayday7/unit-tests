package homework1;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        testCalculatingDiscountValidDiscountAmount();
        testCalculatingDiscountWithInvalidDiscountAmount();
        testCalculatingDiscountWithNegativePurchaseAmount();
        testCalculatingDiscountWithNegativePurchaseAmount();
    }

    public static void testCalculatingDiscountValidDiscountAmount() {
        double purchaseAmount = 100.0;
        int discountAmount = 20;
        assertThat(Calculator.calculatingDiscount(purchaseAmount, discountAmount)).isEqualTo(80);
    }

    public static void testCalculatingDiscountWithInvalidDiscountAmount() {
        double purchaseAmount = 100.0;
        int discountAmount = 101;

        assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount)).isInstanceOf(ArithmeticException.class)
                .hasMessage("Размер скидки не может быть больше 100%");
    }

    public static void testCalculatingDiscountWithNegativeDiscountAmount() {
        double purchaseAmount = 100.0;
        int discountAmount = -20;

        assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount)).isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма скидки не может быть отрицательной");
    }
    public static void testCalculatingDiscountWithNegativePurchaseAmount() {
        double purchaseAmount = -100.0;
        int discountAmount = 20;
        // отрицательная сумма покупки
        assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount)).isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма закупки не может быть отрицательной");
    }
}
