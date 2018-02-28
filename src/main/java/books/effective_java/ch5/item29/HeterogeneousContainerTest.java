package books.effective_java.ch5.item29;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeterogeneousContainerTest {
    private static Logger logger = LoggerFactory.getLogger(HeterogeneousContainerTest.class);
    public static void main(String[] args) {
        HeterogeneousContainerExample container = new HeterogeneousContainerExample();
        container.putFavorite(String.class, "favorite string");
        container.putFavorite(Integer.class, 777);
        container.putFavorite(Class.class, HeterogeneousContainerExample.class);

        String favoriteString = container.getFavorite(String.class);
        int favoriteInt = container.getFavorite(Integer.class);
        Class<?> favoriteClass = container.getFavorite(Class.class);

        logger.info("{}, {}, {} is my favorite", favoriteString, favoriteInt, favoriteClass.getName());



    }
}
