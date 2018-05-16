package books.design_pattern._02_adapter.adapter;

import books.design_pattern._02_adapter.adaptee.Banner;
import books.design_pattern._02_adapter.target.Print;

/**
 * Created on 2018-05-16.
 */
public class PrintBannerWithDelegator implements Print{
    private Banner banner;

    public PrintBannerWithDelegator(Banner banner){
        this.banner = banner;
    }
    @Override
    public void printWeak() {
        banner.showWIthParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
