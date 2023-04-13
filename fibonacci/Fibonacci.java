import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Choose the size of sequence:");
        int size = scanner.nextInt();
        int[] sequence = new int[size];
        sequence[0] = 0;
        sequence[1] = 1;

        for (int i =2; i < sequence.length; i++){
            sequence[i] = sequence[i - 1] + sequence[i -2];
        }
        for (int i =0; i < sequence.length; i++) {
            System.out.println(sequence[i]);
        }

    }
}
