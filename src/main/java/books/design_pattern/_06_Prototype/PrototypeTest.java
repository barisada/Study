package books.design_pattern._06_Prototype;

import books.design_pattern._06_Prototype.framework.Manager;
import books.design_pattern._06_Prototype.framework.Product;

import java.util.Arrays;

/**
 * Created on 2018-05-28.
 */
public class PrototypeTest {
    public static void main(String[] args) {
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        Manager manager = new Manager();
        manager.register("mbox", mbox);
        manager.register("sbox", sbox);
        manager.register("upen", upen);

        Arrays.asList(manager.create("mbox")
                ,manager.create("sbox")
                ,manager.create("upen")
        ).stream().forEach(p -> p.use("hello, world."));


    }
}
