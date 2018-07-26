package books.design_pattern._04_Factory_method.idcard;

import books.design_pattern._04_Factory_method.framework.Factory;
import books.design_pattern._04_Factory_method.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018-05-28.
 */
public class IDCardFactory extends Factory {
    private List<String> owners;

    public IDCardFactory() {
        this.owners = new ArrayList<>();
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(product.getOwner());
    }
}
