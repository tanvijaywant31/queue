import java.util.Stack;

/**
 * 
 * Complexity:
 * O(1) : time push,

 * 
 * O(n) : space
 * 
 */
public class QueueUsingStack<T> { 
    
    private final Stack<T> in;
    private final Stack<T> out;
    
    private QueueUsingStack() {
        this.in = new Stack<T>();
        this.out = new Stack<T>();
    }
    
    /**
     * null item can in used as input
     */
    public synchronized void add(T item) {
        in.push(item);
    }

    /**
     *  null is valid input
     *  throws exception on being empty
     */
    public synchronized T poll() {
        if (out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        
        return out.isEmpty() ? null : out.pop();
    }
    
    
    public static void main(String[] args) {
        QueueUsingStack<Integer> qus = new QueueUsingStack<Integer>();
        qus.add(1);
        qus.add(2);
        qus.add(3);
        
        System.out.println(qus.poll());
        System.out.println(qus.poll());
        System.out.println(qus.poll());
        System.out.println(qus.poll()); // printing null.

    }
}
