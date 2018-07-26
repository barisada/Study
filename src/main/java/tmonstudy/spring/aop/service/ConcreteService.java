package tmonstudy.spring.aop.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by jw on 2017-07-27.
 */
public class ConcreteService {
    private PlatformTransactionManager transactionManager;
    private int count;

    public void add(){
        TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            count++;
            this.doIt("added");
            this.transactionManager.commit(status);
        } catch (Exception e){
            System.out.println("added failed");
            this.transactionManager.rollback(status);
            e.printStackTrace();
        }
    }

    public void delete(){
        TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            count--;
            this.doIt("deleted");

            this.transactionManager.commit(status);
        } catch (Exception e){
            System.out.println("deleted failed");
            this.transactionManager.rollback(status);
            e.printStackTrace();
        }

    }

    private void doIt(String operation) {
        System.out.println("Transaction " + operation +" completed. Total : " + count);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
