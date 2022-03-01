class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> lst;
    private Random random;
    
    public RandomizedSet() {
        
        map = new HashMap<>();
        lst = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val)) 
            return false;
        else
        {
            map.put(val,lst.size());
            lst.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        
        if(!map.containsKey(val)) 
            return false;
            
            int index = map.get(val);
            int temp = lst.get(lst.size()-1);
            lst.set(index, temp);
            map.put(temp, index);
            map.remove(val);
            lst.remove(lst.size()-1);
            return true;
        
    }
    
    public int getRandom() {
        
        int index = random.nextInt(lst.size());
        return lst.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */