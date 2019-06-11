package MinStack;


import java.util.ArrayList;
import java.util.Collections;

public class MinStack {
    ArrayList<Integer> list = null;

    public MinStack() {
        list = new ArrayList(16);
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        if(list.size()>0){
            list.remove(list.size()-1);
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        ArrayList<Integer> copyList = new ArrayList(list.size());
        for(int i=0;i<list.size();i++){
            copyList.add(list.get(i));
        }
        Collections.sort(copyList);
        return copyList.get(0);
    }
}
