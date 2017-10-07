/**
 * Created by 216430 on 9/27/2017.
 */

public class LinkedList {

    Node head;
    Node tail;
    int count;

    public LinkedList(){
        head = null;
        tail = null;
        count = 0;
    }

    public Node getHead(){
        return head;
    }

    public void addToFront(Object object){

        Node newNode = new Node(object);
        newNode.next = head;

        head = newNode;
        if (count == 0){
            tail = head;
        }
        count++;

    }

    public void addToBack(Object object){
        if (count == 0){
            addToFront(object);
        } else {
            Node newNode = new Node(object);

            tail.setNextPtr(newNode);
            tail = newNode;
        }
        count++;
    }

    public Node removeFromFront(){
        if (count == 1){
            head = null;
            tail = null;
            count = 0;
            return null;
        } else {
            Node returnNode = head;
            head = head.getNextPtr();
            count--;
            return returnNode;
        }
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
            if (current.getNextPtr() == null) {
                returned += current.get();
            } else {
                returned += current.get() + ", ";
            }
            current = current.getNextPtr();
        }
        returned += "]";
        return returned;
    }

    public LinkedList duplicate(){
        LinkedList duplicated = new LinkedList();
        Node current = head;
        Object currentData = head.get();
        while (current.getNextPtr() != null){
            duplicated.addToBack(currentData);
            current = current.getNextPtr();
            currentData = current.get();
        }
        duplicated.addToBack(currentData);
        return duplicated;
    }

    public LinkedList reverse(){
        LinkedList reversed = new LinkedList();
        Node current = head;
        while (current.getNextPtr() != null){
            reversed.addToFront(current.get());
            current = current.getNextPtr();
        }
        reversed.addToFront(current.get());
        return reversed;
    }
}