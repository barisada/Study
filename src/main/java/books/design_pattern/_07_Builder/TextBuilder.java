package books.design_pattern._07_Builder;

import java.util.List;

/**
 * Created on 2018-05-30.
 */
public class TextBuilder implements Builder {
    private StringBuilder sb = new StringBuilder();

    @Override
    public Builder makeTitle(String title) {
        sb.append("================================" + System.lineSeparator());
        sb.append("#" + title + System.lineSeparator());
        sb.append(System.lineSeparator());
        return this;
    }

    @Override
    public Builder makeString(String str) {
        sb.append("*" + str + System.lineSeparator());
        sb.append(System.lineSeparator());
        return this;
    }

    @Override
    public Builder makeItems(List<String> list) {
        for(String item : list){
            sb.append("\t - " + item + System.lineSeparator());
        }
        sb.append(System.lineSeparator());
        return this;
    }

    @Override
    public void close() {
        sb.append("================================");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
