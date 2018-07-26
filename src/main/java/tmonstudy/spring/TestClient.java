package tmonstudy.spring;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import tmonstudy.spring.aop.TestConfig;
import tmonstudy.spring.aop.proxy.TxHandler;
import tmonstudy.spring.aop.proxy.TxProxyFactoryBean;
import tmonstudy.spring.aop.service.ConcreteService;
import tmonstudy.spring.aop.service.SomeService;

import java.lang.reflect.Proxy;

/**
 * Created by jw on 2017-07-27.
 */
public class TestClient {

    public static void main(String...args) throws Exception {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfig.class);

        //concreteService(ctx);
        //decorationPatternExample(ctx);

        //dynamicProxyExample(ctx);
        //dynamicProxyFactoryBeanExample(ctx);

        proxyFactoryBeanEx(ctx);

        ctx.close();
    }

    private static void proxyFactoryBeanEx(AbstractApplicationContext ctx) {
        ProxyFactoryBean proxyFactoryBean = ctx.getBean("&service", ProxyFactoryBean.class);
        SomeService service = (SomeService) proxyFactoryBean.getObject();
        service.add();
        service.delete();
    }

    private static void dynamicProxyFactoryBeanExample(AbstractApplicationContext ctx) throws Exception {
        TxProxyFactoryBean txProxyFactoryBean = ctx.getBean("&txService", TxProxyFactoryBean.class);
        SomeService service = (SomeService) txProxyFactoryBean.getObject();
        service.add();
        service.delete();
    }

    private static void dynamicProxyExample(AbstractApplicationContext ctx) {
        TestClient tc = new TestClient();
        TxHandler txHandler = (TxHandler) ctx.getBean("txHandler");
        //다이나믹 프록시를 사용하면 빈으로 생성할수가 없어서 ctx에서 못가져옴..
        SomeService service = (SomeService) Proxy.newProxyInstance(tc.getClass().getClassLoader(), new Class[]{SomeService.class}, txHandler);
        service.add();
        service.delete();
    }

    public static void concreteService(AbstractApplicationContext ctx){
        ConcreteService cs = (ConcreteService) ctx.getBean("concreteService");
        cs.add();
        cs.delete();
    }

    public static void decorationPatternExample(AbstractApplicationContext ctx){
        SomeService ss = (SomeService) ctx.getBean("someService");
        ss.add();
        ss.delete();
    }
}
