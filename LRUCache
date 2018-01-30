public class LRUCache {
    private int capacity = 0;
    private Node head = null;
    private Node tail = null;
    private Map<Integer, Node> map = new HashMap<>();
    
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(node != head){
                if(node == tail){
                    Node pre = node.pre;
                    tail = pre;
                    tail.next = null;
                    
                    node.pre = node;
                    node.next = head;
                    head.pre = node;
                    head = node;
                }else{
                    Node pre = node.pre;
                    Node next = node.next;
                    pre.next = next;
                    next.pre = pre;
                    
                    node.pre = node;
                    node.next = head;
                    head.pre = node;
                    head = node;
                }
            }
            return node.getValue();
        }
        else{
            return -1;
        }
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(!map.containsKey(key)){
            if(map.size() == 0){
                head = new Node(key,value);
                head.pre = head;
                tail = head;
                map.put(key,head);
            }
            else if(map.size() < capacity){
                Node node = new Node(key,value);
                node.pre = node;
                node.next = head;
                head.pre = node;
                head = node;
                map.put(key,head);
            }
            else{
                
                int tailKey = tail.getKey();
                map.remove(tailKey,tail);
        
                Node node = tail;
                node.setKey(key);
                node.setValue(value);
                
                Node pre = node.pre;
                tail = pre;
                tail.next = null;
                
                node.pre = node;
                node.next = head;
                head.pre = node;
                head = node;
                map.put(key,head);
            }
        }
        else{
            Node node = map.get(key);
            node.setValue(value);
            if(node != head){
                if(node == tail){
                    Node pre = node.pre;
                    tail = pre;
                    tail.next = null;
                    
                    node.pre = node;
                    node.next = head;
                    head.pre = node;
                    head = node;
                }else{
                    Node pre = node.pre;
                    Node next = node.next;
                    pre.next = next;
                    next.pre = pre;
                    
                    node.pre = node;
                    node.next = head;
                    head.pre = node;
                    head = node;
                }
            }
        }
    }
}


class Node{
    private int key;
    private int value;
    public Node pre = null;
    public Node next = null;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    public int getKey(){
        return key;
    }
    
    public void setKey(int key){
        this.key = key;
    }
}
