package books.design_pattern._02_adapter.adapter;

import books.design_pattern._02_adapter.adaptee.Banner;
import books.design_pattern._02_adapter.target.Print;

/**
 * Created on 2018-05-16.
 */
public class PrintBannerWithInheritance extends Banner implements Print {
    public PrintBannerWithInheritance(String str) {
        super(str);
    }

    @Override
    public void printWeak() {
        showWIthParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
