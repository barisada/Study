package books.design_pattern._06_Prototype;

import books.design_pattern._06_Prototype.framework.Product;

/**
 * Created on 2018-05-28.
 */
public class UnderlinePen implements Product {
    private char ul;

    public UnderlinePen(char ul) {
        this.ul = ul;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;

        StringBuilder uls = new StringBuilder();
        for(int i = 0; i < length; i++){
            uls.append(ul);
        }

        System.out.println("\"" + s + "\"");
        System.out.println(uls.toString());
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
