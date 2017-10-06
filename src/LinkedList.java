/**
 * Created by 216430 on 9/27/2017.
 */

public class LinkedList {

    Node head;
    int count;
    //add to front, add to back, tail, remove from front

    public LinkedList(){
        head = null;
        count = 0;
    }

    public Node getNode(int index){
        if (index < 0 || index >= count){
            return null;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++){
                current = current.getNextPtr();
            }
            return current;
        }
    }
    public void add(Object object){
        Node newNode = new Node(object);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public Object get(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNextPtr();
        }
        return current.get();
    }

    public int getCount(){
        return count;
    }

    public String toString(){
        Node current = head;
        String returned = "[";
        while (current != null){
            returned += current + ", ";
            current = current.getNextPtr();
        }
        returned += "]";
        return returned;
    }
}