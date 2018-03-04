package books.effective_java.ch6.item31;

public enum EnumInstanceFieldExample {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10),
    TRIPLE_QUARTET(12);

    private final int numOfMusician;
    EnumInstanceFieldExample(int size){
        this.numOfMusician = size;
    }

    public int numberOfMusicians(){
        return numOfMusician;
    }


    public static void main(String[] args) {
        for(EnumInstanceFieldExample ex : EnumInstanceFieldExample.values()){
            System.out.println(ex + " instance field value : " + ex.numberOfMusicians()
                    + " vs ordianl : " + ex.ordinal());
        }
    }
}
