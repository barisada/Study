package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("resolved dead lock example");
        Person paul = new Person("Paul");
        Person bruce = new Person("Bruce");
        CompletableFuture.runAsync(() -> paul.sayHi(bruce), executorService);
        CompletableFuture.runAsync(() -> bruce.sayHi(paul), executorService);

        executorService.shutdown();
        Thread.sleep(100);
        System.out.println("==================END ======================= ");

        System.out.println("Dead Lock Example");

        DeadLockedPerson john = new DeadLockedPerson("John");
        DeadLockedPerson mary = new DeadLockedPerson("Mary");
        Thread t1 = new Thread(() -> john.sayHi(mary), "John Thread");
        Thread t2 = new Thread(() -> mary.sayHi(john), "Mary Thread");
        t1.start();
        t2.start();
    }

    static class Person{
        private String name;

        public Person(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void sayHi(Person otherPerson){
            synchronized (this){
                String happening = String.format("[%s] %s said \"hi\" to %s", Thread.currentThread().getName(), this.getName(), otherPerson.getName());
                System.out.println(happening);
            }
            synchronized (otherPerson){
                otherPerson.sayBye(this);
            }
        }

        public void sayBye(Person otherPerson){
            synchronized (this){
                String happening = String.format("[%s] %s said \"bye\" to %s", Thread.currentThread().getName(), this.getName(), otherPerson.getName());
                System.out.println(happening);
            }
        }
    }

    static class DeadLockedPerson {
        private String name;

        public DeadLockedPerson(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public synchronized void sayHi(DeadLockedPerson otherPerson){
            String happening = String.format("[%s] %s said \"hi\" to %s", Thread.currentThread().getName(), this.getName(), otherPerson.getName());
            System.out.println(happening);
            otherPerson.sayBye(this);
        }

        public synchronized void sayBye(DeadLockedPerson otherPerson){
            String happening = String.format("[%s] %s said \"bye\" to %s", Thread.currentThread().getName(), this.getName(), otherPerson.getName());
            System.out.println(happening);
        }
    }
}
