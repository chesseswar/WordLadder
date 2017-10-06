import java.util.*;
import java.io.*;

public class WordLadder {
    public static void main (String[] args) throws IOException{
        Scanner in = new Scanner(new File("dictionary.txt"));
        /*
        HashSet<String> dictionary = new HashSet<String>();
        while (in.hasNext()){
            dictionary.add(in.nextLine());
        }*/
        LinkedList testList = new LinkedList();
        for (int i = 0; i < 5; i++){
            testList.addToFront(in.nextLine());
        }
        testList.addToBack("Heyboi");
        testList.removeFromFront();
        System.out.println("head: " + testList.head + " tail: " + testList.tail);
        System.out.println(testList);

    }
}

