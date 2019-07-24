package desingPattern;

/**
 * 전략패턴은
 * 추상전략을 인터페이스로 만들고
 * 추상전력을 구현하는 구체적 전략을 만든다.
 *
 * 전략을 사용하는 크라스에서 추상전력을 인젝트 받고 변경가능한 세터를 만든다.
 * 전략을 사용하는 크라스는 추상전략 크라스에 전략을 델리게이트한다.
 */
public class StrategyPattern {

    public static void main(String[] args) {
        PetOwner owner = new PetOwner(new Cat());
        owner.talkToPet();

        owner.setPet(new Dog());
        owner.talkToPet();

    }

    //전략을 사용할 크라스
    static class PetOwner{
        private Animal pet;
        public PetOwner(Animal pet){
            this.pet = pet;
        }

        //전략위임
        public void talkToPet(){
            pet.sound();
        }

        public void setPet(Animal pet){
            this.pet = pet;
        }
    }

    // 전략 인터페이스
    interface Animal{
        void sound();
    }

    //전략 구현
    static class Cat implements Animal{

        @Override
        public void sound() {
            System.out.println("야옹");
        }
    }

    static class Dog implements Animal{

        @Override
        public void sound() {
            System.out.println("멍멍");
        }
    }
}
