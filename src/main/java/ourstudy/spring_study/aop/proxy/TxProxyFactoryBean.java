package ourstudy.spring_study.aop.proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import ourstudy.spring_study.aop.service.SomeService;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by jw on 2017-07-27.
 */
public class TxProxyFactoryBean implements FactoryBean<Object> {
    Object target;
    PlatformTransactionManager transactionManager;
    List<String> pattern;
    Class<?> serviceInterface;
    @Override
    public Object getObject() throws Exception {
        TxHandler txHandler = new TxHandler();
        txHandler.setTransactionManager(transactionManager);
        txHandler.setTarget(target);
        txHandler.setPattern(pattern);
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{serviceInterface}, txHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return serviceInterface;
    }

    @Override
    public boolean isSingleton() {
        return false;
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

    public void setServiceInterface(Class<?> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }
}
