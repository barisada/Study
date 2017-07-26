package ourstudy.spring_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ourstudy.spring_study.config.TestConfig;
import ourstudy.spring_study.service.ConcreteService;

/**
 * Created by jw on 2017-07-27.
 */
public class TestClient {

    public static void main(String...args){
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfig.class);
        ConcreteService service = (ConcreteService) ctx.getBean("concreteService");
        service.add();
        service.delete();
        ctx.close();
    }
}
