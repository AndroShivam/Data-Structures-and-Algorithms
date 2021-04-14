class RandomizedCollection {

    private final ArrayList<Integer> list;
    private final Map<Integer, Set<Integer>> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val))
            map.put(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        
        return map.get(val).size() == 1;
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        
        if(index < list.size() - 1){
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            map.get(lastElement).remove(list.size() - 1);
            map.get(lastElement).add(index);
        }
        
        list.remove(list.size() - 1);
        if(map.get(val).isEmpty())
            map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int random = (int)(Math.random() * list.size());
        return list.get(random);
    }
}