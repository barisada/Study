package ourstudy.spring.aop.service;

/**
 * Created by jw on 2017-07-27.
 */
public class BusinessLoginOnlyServiceImpl implements SomeService{
    int count;
    @Override
    public void add() {
        count++;
        this.doIt("added");
    }

    @Override
    public void delete() {
        count--;
        this.doIt("deleted");
    }

    private void doIt(String operation) {
        System.out.println("Transaction " + operation +" completed. Total : " + count);
    }
}
