import java.util.*;

public class Streams {
    public static void main(String[] args) {
        String prayer = "Oh Lord, won't you buy me a trash Mercedes Benz\n" +
                "My friends all drive trash Porsches, I must make trash amends\n" +
                "Worked hard all my trash lifetime, no help from my trash friends\n" +
                "So Lord, won't you buy me a trash Mercedes Benz";

        Arrays.stream(prayer.split("\s"))
                .filter(c -> !c.equals("trash"))
                .map(c -> c.toUpperCase() + " ")
                .forEach(System.out::print);
    }
}