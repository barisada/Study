package books.design_pattern._07_Builder;

import java.util.List;

/**
 * Created on 2018-05-30.
 */
public class HTMLBuilder implements Builder {
    private String fileName;
    private StringBuilder sb = new StringBuilder();

    @Override
    public Builder makeTitle(String title) {
        fileName = title + ".html";

        sb.append("<html><head><title>" + title + "</title></head><body>"
                + System.lineSeparator());
        sb.append("<h1>" + title + "</h1>"+ System.lineSeparator());
        return this;
    }

    @Override
    public Builder makeString(String str) {
        sb.append("<p>" + str + "</p>" + System.lineSeparator());
        return this;
    }

    @Override
    public Builder makeItems(List<String> list) {
        sb.append("<ul>" + System.lineSeparator());
        for(String item : list){
            sb.append("\t<li>" + item + "</li>" + System.lineSeparator());
        }
        sb.append("</ul>" + System.lineSeparator());
        return this;
    }

    @Override
    public void close() {
        sb.append("</body></html>" + System.lineSeparator());
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
