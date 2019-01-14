package books.design_pattern._04_Factory_method;

import books.design_pattern._04_Factory_method.framework.Factory;
import books.design_pattern._04_Factory_method.framework.Product;
import books.design_pattern._04_Factory_method.idcard.IDCardFactory;
import books.design_pattern._04_Factory_method.tv.TelevisionFactory;

import java.util.Arrays;

/**
 * Created on 2018-05-28.
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        Factory idCardFactory = new IDCardFactory();
        Factory tvFactory = new TelevisionFactory();

        Arrays.asList(idCardFactory.create("John")
                ,idCardFactory.create("Kevin")
                ,idCardFactory.create("Mary")
                ,idCardFactory.create("Anne")
                ,tvFactory.create("John")
                ,tvFactory.create("Kevin")
                ,tvFactory.create("Mary")
                ,tvFactory.create("Anne")
                ,idCardFactory.create("Steve")
                ,idCardFactory.create("Michelle")
        ).parallelStream().forEach(Product::use);

       ((IDCardFactory) idCardFactory).showRegisteredOwners();
       ((TelevisionFactory) tvFactory).showRegisteredOwners();

    }
}
