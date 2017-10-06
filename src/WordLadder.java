import java.util.*;
import java.io.*;

public class WordLadder {
    public static void main (String[] args) throws IOException{
        Scanner readDictionary = new Scanner(new File("dictionary.txt"));
        Scanner in = new Scanner(new File("input.txt"));

        HashSet<String> dictionary = new HashSet<String>();
        while (readDictionary.hasNext()) {
            dictionary.add(readDictionary.nextLine());
        }


        while (in.hasNext()){
            boolean goOn = true;
            boolean itWorks = false;
            LinkedList answer = new LinkedList();
            LinkedList queueOfStacks = new LinkedList(); // C R A Z Y
            String input = in.next();
            String goal = in.next();
            if (!dictionary.contains(input) || !dictionary.contains(goal)){
                goOn = false;
            } else if (input.equals(goal)){
                answer.addToFront(input);
                goOn = false;
                itWorks = true;
            }
            HashSet<String> usedWords = new HashSet<String>();
            usedWords.add(input);
            String[] wordsOffByOneLetterFromInput = oneLetterOff(input);
            for (int i = 0; i < wordsOffByOneLetterFromInput.length; i++){
                if (!usedWords.contains(wordsOffByOneLetterFromInput[i]) && dictionary.contains(wordsOffByOneLetterFromInput[i])){

                    usedWords.add(wordsOffByOneLetterFromInput[i]);
                    LinkedList stack = new LinkedList();
                    stack.addToFront(input);
                    stack.addToFront(wordsOffByOneLetterFromInput[i]);

                    queueOfStacks.addToBack(stack);
                    if (wordsOffByOneLetterFromInput[i].equals(goal)){
                        answer = stack.reverse();
                        goOn = false;
                        itWorks = true;
                        break;
                    }
                }
            }
            String topWord = "";
            if (goOn){topWord = ((String)((LinkedList) queueOfStacks.getHead().get()).getHead().get());}

                while (!topWord.equals(goal) && goOn){
                    LinkedList dequeue = (LinkedList) (queueOfStacks.removeFromFront().get());
                    String[] wordsOffByOneLetter = oneLetterOff(topWord);

                    for (int i = 0; i < wordsOffByOneLetter.length; i++){
                        if (!usedWords.contains(wordsOffByOneLetter[i]) && dictionary.contains(wordsOffByOneLetter[i])){
                            usedWords.add(wordsOffByOneLetter[i]);
                            LinkedList stack = dequeue.duplicate();

                            stack.addToFront(wordsOffByOneLetter[i]);
                            queueOfStacks.addToBack(stack);
                            if (wordsOffByOneLetter[i].equals(goal)){
                                answer = stack.reverse();
                                goOn = false;
                                itWorks = true;
                                break;
                            }
                        }
                    }
                    topWord = ((String)((LinkedList) queueOfStacks.getHead().get()).getHead().get());
                }
            if (!itWorks){
                System.out.println("There is no word ladder between " + input + " and " + goal + "!");
            } else if (itWorks){
                System.out.println(answer);
            }
        }

    }

    public static String[] oneLetterOff(String input){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String[] output = new String[25 * input.length()];
        int currentIndex = 0;
        for (int i = 0; i < input.length(); i++){
            for (int j = 0; j < 26; j++){
                if (letters.charAt(j) != input.charAt(i)){
                    char[] inputArr = input.toCharArray();
                    inputArr[i] = letters.charAt(j);
                    String altered = "";
                    for (int k = 0; k < input.length(); k++){
                        altered += inputArr[k];
                    }
                    output[currentIndex] = altered;
                    currentIndex++;
                }
            }
        }
        return output;
    }
}

