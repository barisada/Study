package books.design_pattern._04_Factory_method.tv;

import books.design_pattern._04_Factory_method.framework.Product;

import java.util.Random;

/**
 * Created on 2018-05-28.
 */
public class Television extends Product {
    private String owner;

    Television(String owner) {
        System.out.println("create " + owner + "'s Tv");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + " is watching TV for " + new Random().nextInt(24) + " hours");
    }

    @Override
    public String getOwner() {
        return owner;
    }
}
