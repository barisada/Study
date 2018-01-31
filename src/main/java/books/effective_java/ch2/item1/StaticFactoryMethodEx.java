package books.effective_java.ch2.item1;

public class StaticFactoryMethodEx {

    public static void main(String[] args) {
        Services.registerDefaultProvider(() -> () -> "Hello Static Factory Method!");
        Service service1 = Services.newInstance();
        Service service2 = Services.newInstance();
        System.out.println("service1 : " +  service1.doSomthingEx());
        System.out.println("service2 : " + service2.doSomthingEx());
        System.out.println(service1.hashCode() == service2.hashCode());

        Services.registerProvider("myProvider",
                () -> () -> "Hello MyProvider");
        Service service3 = Services.newInstance("myProvider");
        System.out.println("service3 : " + service3.doSomthingEx());
        System.out.println(service1.hashCode() == service3.hashCode());
    }
}
