package books.design_pattern._04_Factory_method.idcard;

import books.design_pattern._04_Factory_method.framework.Product;

/**
 * Created on 2018-05-28.
 */
public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println("create " + owner + "'s card");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("use " + owner + "'s card");
    }

    @Override
    public String getOwner() {
        return owner;
    }
}
