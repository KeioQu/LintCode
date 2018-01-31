/*
 *使用单向链表实现栈的数据结构
 *再使用一个链表，按照栈中元素的数据值大小顺序存储在该链表中
 *栈进行push()和pop()操作时，出栈或者入栈的元素按数据值的大小顺序维护在链表中的位置
 *栈进行min()操作时，则取出链表的第一个元素
 */
public class MinStack {
    Node head = null;
    List<Node> sortStack;
    
    public MinStack() {
        // do intialization if necessary
        sortStack = new ArrayList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if(head == null){
            head = new Node(number);
            head.next = null;
            sortStack.add(head);
        }
        else{
            Node node = new Node(number);
            node.next = head;
            head = node;
            sortStack.add(head);
            Collections.sort(sortStack);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(head != null){
            Node node = head;
            head = node.next;
            node.next = null;
            sortStack.remove(node);
            Collections.sort(sortStack);
            return node.data;
        }else{
            return Integer.MIN_VALUE;
        }
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        if(sortStack.size() > 0){
            Node minNode = sortStack.get(0);
            return minNode.data;
        }
        else{
            return Integer.MIN_VALUE;
        }
    }
}

/*
 * 使用单向链表实现栈
 * 元素实现Comparable接口，另外一个链表按照数据值的大小顺序维护栈中元素
 * 
 */
class Node implements Comparable<Node>{
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    
    public int compareTo(Node o){
        return this.data - o.data;
    }
}
