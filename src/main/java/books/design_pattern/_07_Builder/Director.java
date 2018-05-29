package books.design_pattern._07_Builder;

import java.util.Arrays;

/**
 * Created on 2018-05-30.
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle("Greeting")
                .makeString("Morning and Noon")
                .makeItems(Arrays.asList(
                        "Good Morning",
                        "Good afternoon",
                        "Hi / Hello"
                ))
                .makeString("Night")
                .makeItems(Arrays.asList(
                        "Good-bye",
                        "Good night",
                        "See ya"
                ))
                .close();
    }
}
