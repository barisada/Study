package ourstudy.spring_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import ourstudy.spring_study.service.ConcreteService;

import javax.sql.DataSource;


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
