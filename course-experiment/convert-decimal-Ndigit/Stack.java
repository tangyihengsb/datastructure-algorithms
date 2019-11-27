import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    List<E> list;
    //initial
    protected Stack () {
        list=new ArrayList<E>();
    }
    //push
    protected void push(E e) {
        list.add(e);
    }
    //peek
    protected E peek() {
        return list.get(list.size()-1);
    }
    //pop
    protected E pop() throws Exception{
        if(empty()) throw new Exception("stack is empty!");
        E ret=list.get(list.size()-1);
        list.remove(list.size()-1);
        return ret;
    }
    //isEmpty
    protected boolean empty() {
        return list.size()==0;
    }
}
