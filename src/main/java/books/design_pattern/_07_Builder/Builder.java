package books.design_pattern._07_Builder;

import java.util.List;

/**
 * Created on 2018-05-30.
 */
public interface Builder {
    Builder makeTitle(String title);
    Builder makeString(String str);
    Builder makeItems(List<String> list);
    void close();
}
