package tmonstudy.spring.aop.service;


import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by jw on 2017-07-27.
 */
@Deprecated
public class TxOnlyServiceImpl implements SomeService{
    private PlatformTransactionManager transactionManager;
    private SomeService service;

    @Override
    public void add() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            service.add();
            transactionManager.commit(status);
        } catch (Exception e){
            System.out.println("added fail");
            transactionManager.rollback(status);
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            service.delete();
            transactionManager.commit(status);
        } catch (Exception e){
            System.out.println("deleted fail");
            transactionManager.rollback(status);
            e.printStackTrace();
        }
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setService(SomeService service) {
        this.service = service;
    }
}
