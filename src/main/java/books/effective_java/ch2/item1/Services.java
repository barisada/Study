package books.effective_java.ch2.item1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {

    private Services(){}

    private static final Map<String, ServiceProvider> providers = new ConcurrentHashMap<>();
    private static final String DEFUALT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(ServiceProvider serviceProvider){
        registerProvider(DEFUALT_PROVIDER_NAME, serviceProvider);
    }

    public static void registerProvider(String defualtProviderName, ServiceProvider serviceProvider) {
        providers.put(defualtProviderName, serviceProvider);
    }

    public static Service newInstance(){
        return newInstance(DEFUALT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        ServiceProvider sp = providers.get(name);
        if(sp == null){
            throw new IllegalArgumentException("No provider registered with name "  + name);
        }
        return sp.newService();
    }
}
