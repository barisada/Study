package ourstudy.spring_study.aop;

import edu.princeton.cs.algs4.Transaction;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import ourstudy.spring_study.aop.proxy.TransactionAdvice;
import ourstudy.spring_study.aop.proxy.TxHandler;
import ourstudy.spring_study.aop.proxy.TxProxyFactoryBean;
import ourstudy.spring_study.aop.service.BusinessLoginOnlyServiceImpl;
import ourstudy.spring_study.aop.service.ConcreteService;
import ourstudy.spring_study.aop.service.SomeService;
import ourstudy.spring_study.aop.service.TxOnlyServiceImpl;

import javax.sql.DataSource;
import java.util.Arrays;


/**
 * Created by jw on 2017-07-27.
 */
@Configuration
public class TestConfig {

    @Bean(name="concreteService")
    @Description("test service1")
    public ConcreteService concreteService(){
        ConcreteService concreteService = new ConcreteService();
        concreteService.setTransactionManager(transactionManager());
        return concreteService;
    }

    @Bean(name="someService")
    @Description("tx와 비지니스로직을 분리하여 사용할수 있는 서비스")
    public TxOnlyServiceImpl txOnlyService(){
        TxOnlyServiceImpl txOnlyService = new TxOnlyServiceImpl();
        txOnlyService.setTransactionManager(transactionManager());
        txOnlyService.setService(blOnlyService());
        return txOnlyService;
    }

    @Bean(name="blService")
    @Description("비지니스 로직만 있는 서비스")
    public BusinessLoginOnlyServiceImpl blOnlyService(){
        return new BusinessLoginOnlyServiceImpl();
    }

    @Bean(name="txHandler")
    @Description("다아나믹 프록시를 사용한 트렌젝션 핸들러")
    public TxHandler txHandler(){
        TxHandler txHandler = new TxHandler();
        txHandler.setTransactionManager(transactionManager());
        txHandler.setPattern(Arrays.asList("add", "delete"));
        txHandler.setTarget(blOnlyService());
        return txHandler;
    }

    @Bean(name="txService")
    @Description("팩토리빈 다이나믹 프록시를 사용하여 트랜잭션이 되는 서비스")
    public TxProxyFactoryBean txProxyFactoryBean(){
        TxProxyFactoryBean txProxyFactoryBean = new TxProxyFactoryBean();
        txProxyFactoryBean.setTarget(blOnlyService());
        txProxyFactoryBean.setPattern(Arrays.asList("add", "delete"));
        txProxyFactoryBean.setTransactionManager(transactionManager());
        txProxyFactoryBean.setServiceInterface(SomeService.class);
        return txProxyFactoryBean;
    }

    @Bean(name="txAdvice")
    @Description("MethodInterceptor를 구현한 txAdvice")
    public TransactionAdvice transactionAdvice(){
        TransactionAdvice transactionAdvice = new TransactionAdvice();
        transactionAdvice.setTransactionManager(transactionManager());
        return transactionAdvice;
    }

    @Bean(name="txPointCut")
    @Description("tx point cut")
    public NameMatchMethodPointcut nameMatchMethodPointcut(){
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.setMappedNames("add", "delete");
        return nameMatchMethodPointcut;
    }

    @Bean(name="txAdvisor")
    @Description("tx advisor")
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setAdvice(transactionAdvice());
        defaultPointcutAdvisor.setPointcut(nameMatchMethodPointcut());
        return defaultPointcutAdvisor;
    }

    @Bean(name="service")
    @Description("ProxyFactoryBean을 사용한 서비스")
    public ProxyFactoryBean proxyFactoryBean(){
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(blOnlyService());
        proxyFactoryBean.setInterceptorNames("txAdvisor");
        return proxyFactoryBean;
    }


    @Bean(name="tx")
    @Description("transaction manager")
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean(name="dataSource")
    @Description("inmemory hsqldb datasource")
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.hsqldb.jdbcDriver.class);
        dataSource.setUrl("jdbc:hsqldb:mem:dataSource");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

}
