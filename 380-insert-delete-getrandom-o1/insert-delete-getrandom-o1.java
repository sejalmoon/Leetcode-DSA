class RandomizedSet {

    private ArrayList<Integer> list;
    private Map<Integer, Integer> mp;

    public RandomizedSet() {
        list = new ArrayList<>();
        mp = new HashMap<>();
    }

    public boolean search(int val){
        return mp.containsKey(val);
    }
    
    public boolean insert(int val) {
        if(search(val)) return false;

        list.add(val);
        mp.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!search(val)) return false;

        int index = mp.get(val);
        list.set(index, list.get(list.size()-1));
        mp.put(list.get(index), index);
        list.remove(list.size()-1);
        mp.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */