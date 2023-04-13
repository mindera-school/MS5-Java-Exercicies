public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> bT = new BinaryTree<>();

        bT.add(5);
        bT.add(6);
        bT.add(2);
        bT.add(19);
        bT.add(5);
        bT.add(3);
        bT.add(2);

        System.out.println(bT.max());
        System.out.println(bT.min());

    }
}