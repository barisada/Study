package books.effective_java.ch8.item48;

import java.math.BigDecimal;

/**
 * Created by jw on 2018-03-29.
 */
public class DecimalCalculationTest {
    public static void main(String[] args) {
        System.out.println("using unsafe decimal calc..");
        double funds = 1.00;
        int itemsBought = 0;
        for(double price = .10; funds >= price; price += .10){
            funds = DecimalCalculationExample.unsafeMinus(funds, price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("change: $" + funds);System.out.println();

        System.out.println("using safe decimal calc");
        BigDecimal funds2 = new BigDecimal("1.00");
        BigDecimal tenCents = new BigDecimal(".10");
        itemsBought = 0;
        for(BigDecimal price = tenCents; funds2.compareTo(price) >= 0; price = price.add(tenCents)){
            itemsBought++;
            funds2 = DecimalCalculationExample.safeMinus(funds2, price);
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("money left over: $" + funds2);
        System.out.println();
    }
}
