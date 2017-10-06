/**
 * Created by 216430 on 9/25/2017.
 */
public class Node {
    Object data;
    Node next;

    public Node(){
        data = null;
        next = null;
    }

    public Node(Object data){
        this.data = data;
        next = null;
    }

    public Object get(){
        return data;
    }

    public void set(Object data){
        this.data = data;
    }

    public Node getNextPtr(){
        return next;
    }

    public void setNextPtr(Node next){
        this.next = next;
    }

    public String toString(){
        return "Object: " + data;
    }
}
