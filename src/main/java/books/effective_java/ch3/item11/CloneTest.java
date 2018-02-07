package books.effective_java.ch3.item11;



public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        BadCloneEx bad = new BadCloneEx();
        bad.add(1);
        bad.add(2);
        bad.add(3);
        bad.add(4);

        BadCloneEx badClone = bad.clone();
        badClone.insert(1, 11);

        for(int i = 1; i <= 4; i++){
            if(!bad.get(i).equals(badClone.get(i))){
                System.out.println("[" + i  + "]" + "bad : not same");
                break;
            }
            System.out.println("[" + i  + "]" + "bad : same");
        }

        CloneExample good = new CloneExample();
        good.addItem(1);
        good.addItem(2);
        good.addItem(3);
        good.addItem(4);
        CloneExample goodClone = good.clone();
        goodClone.insert(3, 33);
        for(int i = 0; i < 4; i++){
            if(!good.get(i).equals(goodClone.get(i))){
                System.out.println("[" + i  + "]" + "good : not same");
                break;
            }
            System.out.println("[" + i  + "]" + "good : same");
        }

    }
}
