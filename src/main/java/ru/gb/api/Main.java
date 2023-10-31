package ru.gb.api;

import org.assertj.core.api.LocalDateAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {


    public static void main(String[] args) {
        assertConditionA();

        assertConditionB();

        System.out.println(sum(2_147_483_647, 2));

        happyNY();

        expectedValue();

        checkingShoppingCart();

        String[] colors = {"aqua", "yellow", "blue", "orange", "green", "violet", "gold"};
        testingJavaCollectionsAssertJ(colors);

        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);
        checkingHero(emmett);
    }

    /**
     * 1) Нужно найти и исправить ошибку в условиях assert
     */
    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2;
        System.out.println("В неделе " + weekends.length + " дня выходных");
    }

    /**
     * 2) Нужно найти и исправить ошибку в условиях assert
     */
    public static void assertConditionB() {
        int x = -1;
        assert x < 0;
    }

    /**
     * 3) Нужно, используя данную функцию, попробовать сложить два следующих числа
     * 2_147_483_647 и 1, написать assert если нужно
     * (https://habr.com/ru/company/pvs-studio/blog/306748/)
     *
     * @param a первое число
     * @param b второе число
     * @return сумму переданных чисел
     * @apiNote assert boolean_выражение : сообщение_об_ошибке;
     */
    public static int sum(int a, int b) {
        assert Integer.MAX_VALUE - a >= b : "Выход за пределы буфера";
        return a + b;
    }

    /**
     * 4) Нужно найти и исправить ошибку в условиях assert
     * windows fail - https://habr.com/ru/company/pvs-studio/blog/698404/
     */
    public static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = "01/01/2023 00:00:00";

        // Получили строку currentDateTime в формате "09/12/2022 20:20:04"

        assert currentDateTime.equals("01/01/2023 00:00:00") : "Еще 2022 год :(";
        System.out.println("С новым годом!");
    }

    /**
     * 5) Утверждение предупреждает об ошибке, нужно исправить код, чтобы утверждение не выбрасывало ошибку
     */
    public static void checkingShoppingCart() {
        ArrayList<String> productCategories = new ArrayList<>();
        productCategories.add("fruits");
        productCategories.add("vegetables");
        productCategories.add("bakery");
        productCategories.add("beverages");

        ArrayList<String> products = new ArrayList<>();
        products.add("apple");
        products.add("tomato");
        products.add("bread");
        products.add("water");

        for (String product : products) {
            switch (product) {
                case "apple" -> System.out.println("category: " + productCategories.get(0));
                case "tomato" -> System.out.println("category: " + productCategories.get(1));
                case "bread" -> System.out.println("category: " + productCategories.get(2));
                case "water" -> System.out.println("category: " + productCategories.get(3));
                default -> {
                    assert false : "Unknown category for the product " + product;
                }
            }
        }
    }

    /**
     * 6) Найдите ошибку
     */
    public static void expectedValue() {

        assertThat(sum(2, 3)).isEqualTo(5);
    }

    /**
     * Нужно передать в метод массив, который соответствует условиям в утверждении
     *
     * @param colors массив с цветами
     */
    public static void testingJavaCollectionsAssertJ(String[] colors) {
        assertThat(colors)
                .isNotEmpty()
                .hasSize(7)
                .doesNotHaveDuplicates()
                .contains("orange", "green", "violet")
                .endsWith("gold")
                .startsWith("aqua")
                .containsSequence("yellow", "blue")
                .doesNotContain("red", "black");
    }

    /**
     * 8) Удовлетворить всем условиям: <p>
     * 1. Проверить, что герой создался с именем Emmett<p>
     * 2. Проверить, что значение прочности брони героя равно 50<p>
     * 3. Проверить, что у героя оружие типа sword<p>
     * 4. Проверить содержимое инвентаря героя (размер 3, содержимое "Bow", "Axe", "Gold", порядок не важен)<p>
     * 5. Проверить, что герой это человек (свойство isHuman)<p>
     */
    public static void checkingHero(Hero emmett) {
        /*
        1. Проверить, что герой создался с именем Emmett
        2. Проверить, что значение прочности брони героя равно 50
        3. Проверить, что у героя оружие типа sword
        4. Проверить содержимое инвентаря героя (не пустой, размер 3, содержимое "Bow", "Axe", "Gold", порядок не важен)
        5. Проверить, что герой человек (свойство true)
        */

        assert "Emmett".equals(emmett.getName()) : "Name should be Emmett";
        // Далее продолжите сами ...
        assertThat(emmett.getArmorStrength()).isEqualTo(50);
        assertThat(emmett.getWeapon()).isEqualTo("sword");
        assertThat(emmett.getBag()).isNotEmpty().hasSize(3).contains("Bow", "Axe", "Gold");
        assertThat(emmett.isHuman).isTrue();

    }

    // 1.8 (Черный ящик)
    static class Hero {
        private String name;
        private int armorStrength;
        private String weapon;
        private List<String> bag;
        private boolean isHuman;

        public Hero(String name, int armorStrength, String weapon, List<String> bag, boolean isHuman) {
            this.name = name;
            this.armorStrength = armorStrength;
            this.weapon = weapon;
            this.bag = bag;
            this.isHuman = isHuman;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getArmorStrength() {
            return armorStrength;
        }

        public void setArmorStrength(int armorStrength) {
            this.armorStrength = armorStrength;
        }

        public String getWeapon() {
            return weapon;
        }

        public void setWeapon(String weapon) {
            this.weapon = weapon;
        }

        public List<String> getBag() {
            return bag;
        }

        public void setBag(List<String> bag) {
            this.bag = bag;
        }

        public boolean isHuman() {
            return isHuman;
        }

        public void setHuman(boolean human) {
            isHuman = human;
        }
    }
}