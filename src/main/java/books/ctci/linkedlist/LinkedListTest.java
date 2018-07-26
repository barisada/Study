package books.ctci.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i = 0; i < 10; i++){
            linkedList.add(i);
        }

        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());

        linkedList.insertAt(0, 100);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());

        linkedList.insertAt(1, 99);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());
        linkedList.insertAt(3, 98);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());
        linkedList.insertAt(5, 97);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());

        linkedList.removeAt(0);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());
        linkedList.removeAt(3);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());
        linkedList.removeAt(5);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());
        linkedList.removeAt(10);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());

        System.out.println("============================");
        linkedList.removeLast();
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());

        linkedList.insertAt(linkedList.size , -1);
        System.out.println(linkedList);
        System.out.println("size : " + linkedList.size());
    }
}
