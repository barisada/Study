package books.design_pattern._07_Builder;

import java.util.stream.Stream;

/**
 * Created on 2018-05-30.
 */
public class BuilderTest {
    public static void main(String[] args) {
        Stream.of(new TextBuilder(), new HTMLBuilder())
                .forEach(builder -> {
                    Director director = new Director(builder);
                    director.construct();
                    System.out.println(builder.toString());
                });


    }
}
