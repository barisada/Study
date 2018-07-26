package books.design_pattern._06_Prototype.framework;

/**
 * Created on 2018-05-28.
 */
public interface Product extends Cloneable {
    void use(String s);
    Product createClone();
}
