package tmonstudy.spring.aop.proxy;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by jw on 2017-07-27.
 * 다아나믹 프록시 예제
 */

public class TxHandler implements InvocationHandler {
    Object target;
    PlatformTransactionManager transactionManager;
    List<String> pattern;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(pattern.contains(method.getName())){
            return invokeTransaction(method, args);
        } else {
            return method.invoke(target, args);
        }
    }

    private Object invokeTransaction(Method method, Object[] args) throws Throwable {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            Object ret = method.invoke(target, args);
            transactionManager.commit(status);
            return ret;
        } catch (InvocationTargetException e){
            System.out.println(method.getName() + " fail");
            transactionManager.rollback(status);
            e.printStackTrace();
            throw e.getTargetException();
        }
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setPattern(List<String> pattern) {
        this.pattern = pattern;
    }
}
