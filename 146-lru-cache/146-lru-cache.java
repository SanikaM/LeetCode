class LRUCache {

    Node head = new Node();
    Node tail = new Node();
    int capacity ;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
    
        this.capacity = capacity; 
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        
        int result = -1;
       Node node = map.get(key);
        
        if( node != null) {
            
            removeNode(node);
            addNode(node);
            result = node.val;
        }
    
        return result;
    }
    
    public void put(int key, int value) {
        
         Node node = map.get(key);
        if(node !=null){
            removeNode(node);
            node.val = value;
            addNode(node);
        }
        else{
            if(map.size() == capacity){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            
            Node new_node = new Node();
            
            new_node.key = key;
            new_node.val = value;
            
            addNode(new_node);
            map.put(key, new_node);
        }
        
    }
    
    private void addNode(Node node) {
        
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        Node first = node.prev;
        Node end = node.next;
        node.next = first.next;
        end.prev = first;
        first.next = end;
        
        
        
    }
    
    class Node {
        
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */