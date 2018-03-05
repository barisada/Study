package books.effective_java.ch6.item33;

import java.util.EnumMap;
import java.util.Map;

public enum PhaseEnumMapExample {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        final PhaseEnumMapExample src;
        final PhaseEnumMapExample dst;

        Transition(PhaseEnumMapExample src, PhaseEnumMapExample dst){
            this.src = src;
            this.dst = dst;
        }
    }

    private static final Map<PhaseEnumMapExample, Map<PhaseEnumMapExample, Transition>> map
            = new EnumMap<>(PhaseEnumMapExample.class);

    static {
        for(PhaseEnumMapExample p : PhaseEnumMapExample.values()){
            map.put(p, new EnumMap<>(PhaseEnumMapExample.class));
        }
        for(Transition trans : Transition.values()){
            map.get(trans.src).put(trans.dst, trans);
        }
    }

    public static Transition from(PhaseEnumMapExample src, PhaseEnumMapExample dst){
        return map.get(src).get(dst);
    }
}
