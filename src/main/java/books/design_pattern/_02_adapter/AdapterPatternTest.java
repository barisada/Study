package books.design_pattern._02_adapter;

import books.design_pattern._02_adapter.adaptee.Banner;
import books.design_pattern._02_adapter.adapter.PrintBannerWithDelegator;
import books.design_pattern._02_adapter.adapter.PrintBannerWithInheritance;
import books.design_pattern._02_adapter.target.Print;

/**
 * Created on 2018-05-16.
 */
public class AdapterPatternTest {
    public static void main(String[] args) {
        doPrint(new PrintBannerWithInheritance("hello with inheritance"));
        doPrint(new PrintBannerWithDelegator(new Banner("hello with delegator")));
    }

    public static void doPrint(Print print){
        System.out.println("[" + print.getClass().getSimpleName() + "] : " );
        print.printWeak();
        print.printStrong();
        System.out.println();
    }
}
