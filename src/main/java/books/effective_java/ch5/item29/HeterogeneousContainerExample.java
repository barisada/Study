package books.effective_java.ch5.item29;

import java.util.HashMap;
import java.util.Map;

public class HeterogeneousContainerExample {
    private Map<Class<?>, Object> favoriteMap = new HashMap<>();


    public <T> void putFavorite(Class<T> type, T instance){
        favoriteMap.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favoriteMap.get(type));
    }
}
