public class Squares {
    public static void main(String[] args) {
        square(5);
    }
    public static void square(int numberOfBranches){
        for (int i = 0; i < numberOfBranches; i++){
            for (int j = 0; j < numberOfBranches; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
