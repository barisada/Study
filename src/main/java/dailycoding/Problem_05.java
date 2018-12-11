package dailycoding;

/**
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 *
 * Given this implementation of cons:
 *
 * def cons(a, b):
 *     def pair(f):
 *         return f(a, b)
 *     return pair
 * Implement car and cdr.
 */
public class Problem_05 {

    public static void main(String[] args) {
        Cons cons = new Cons(3,4);
        new Car(cons);
        new Cdr(cons);
    }
}

class Cons{
    Object a;
    Object b;
    public Cons(Object a, Object b){
        this.a = a ;
        this.b = b;
    }
}

class Car {
    private Cons cons;
    public Car(Cons cons){
        this.cons = cons;
        System.out.println(cons.a);
    }
}
class Cdr {
    private Cons cons;
    public Cdr(Cons cons){
        this.cons = cons;
        System.out.println(cons.b);
    }
}