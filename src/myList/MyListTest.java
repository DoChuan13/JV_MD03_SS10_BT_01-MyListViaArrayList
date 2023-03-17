package myList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(5);
        System.out.println("Inintial array size: " + myList.size());
        myList.add(0, 15);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(10);
        myList.add(100);
        System.out.println("After array size: " + myList.size());
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));
        System.out.println(myList.get(4));
        System.out.println(myList.get(5));
        System.out.println(myList.get(6));
        System.out.println(myList.get(7));
        myList.add(2, 23);
        myList.remove(5);

        System.out.println("Output result =>> "+myList.size());
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));
        System.out.println(myList.get(4));
        System.out.println(myList.get(5));
        System.out.println(myList.get(6));
        System.out.println(myList.get(7));

        System.out.println("Contain of value 10: " + myList.contains(10));
        System.out.println("Index of value 10: " + myList.indexOf(10));
        System.out.println("Contain of value 90: " + myList.contains(90));
//        myList.clear();
//        System.out.println("After clear array size: " + myList.size());
//        System.out.println("Output after clear all =>> ");
//        System.out.println(myList.get(2));

    }
}
