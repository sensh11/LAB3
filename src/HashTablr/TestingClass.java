package HashTablr;

import java.util.Random;

public class TestingClass {

    public static void main(String[] args) {
        // testing MyHashTable
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(1000));
            Student value = new Student("Student " + i);
            table.put(key, value);
        }

        MyHashTable.HashNode<MyTestingClass, Student>[] chainArray = table.getChainArray();
        for (int i = 0; i < chainArray.length; i++) {
            int count = 0;
            MyHashTable.HashNode<MyTestingClass, Student> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }

        // testing BST
        BST<Integer, String> bst = new BST<>();

        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(1000);
            String value = "Value " + i;
            bst.put(key, value);
        }

        System.out.println("Size of BST: " + bst.size());

        for (Integer key : bst.iterator()) {
            System.out.println("Key is " + key + " and value is " + bst.get(key));
        }
    }

    static class MyTestingClass {
        int value;
        public MyTestingClass(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }
}