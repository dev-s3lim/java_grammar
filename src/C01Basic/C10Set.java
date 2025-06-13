package C01Basic;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class C10Set {
    public static void main(String[] args) throws IOException {
        // 중복이 없고, 순서 보장이 안된다.
        Set<String> mySet = new HashSet<>();
        mySet.add("h");
        mySet.add("h");
        mySet.add("e");
        mySet.add("l");
        mySet.add("l");
        mySet.add("l");
        mySet.add("o");

        System.out.println(mySet);
        //for each 문으로 꺼내면 됨
    }
}
