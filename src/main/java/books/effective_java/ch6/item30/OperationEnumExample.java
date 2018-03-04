package books.effective_java.ch6.item30;

import java.util.HashMap;
import java.util.Map;

public enum OperationEnumExample {

    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MIUNS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private static final Map<String, OperationEnumExample> stringToEnum
             = new HashMap<>();
    static{
        for(OperationEnumExample op : values()){
            stringToEnum.put(op.toString(), op);
        }
    }

    public static OperationEnumExample fromString(String symbol){
        return stringToEnum.get(symbol);
    }

    private final String symbol;
    OperationEnumExample(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);
}
