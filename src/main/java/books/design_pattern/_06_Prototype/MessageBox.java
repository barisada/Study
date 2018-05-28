package books.design_pattern._06_Prototype;


import books.design_pattern._06_Prototype.framework.Product;

/**
 * Created on 2018-05-28.
 */
public class MessageBox implements Product {
    private char decor;

    public MessageBox(char decor) {
        this.decor = decor;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;

        StringBuilder decorLine = new StringBuilder();
        for(int i = 0; i < length + 4 ; i++){
            decorLine.append(decor);
        }

        System.out.println(decorLine.toString());
        System.out.println(decor + " " + s + " " + decor);
        System.out.println(decorLine.toString());
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
