package Other;

import java.util.HashSet;
import java.util.Set;

public class HashSet1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Sriyan");
        set.add("Srian");
        set.forEach(System.out::println);

    }
}
