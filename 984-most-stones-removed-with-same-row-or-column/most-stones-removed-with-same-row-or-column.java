class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i<n; i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findParent(int node){
        if(parent.get(node)!=node){
            parent.set(node, findParent(parent.get(node)));
        }
        return parent.get(node);
    }

    public void UnionByRank(int u, int v){
        int p1 = findParent(u);
        int p2 = findParent(v);
        if(p1 == p2){
            return;
        }
        if(rank.get(p1) < rank.get(p2)){
            parent.set(p1, p2);
        }
        else if(rank.get(p1) > rank.get(p2)){
            parent.set(p2, p1);
        }
        else{
            parent.set(p2, p1);
            rank.set(p1, rank.get(p1)+1);
        }
    }

    public void UnionBySize(int u, int v){
        int p1 = findParent(u);
        int p2 = findParent(v);
        if(p1 == p2){
            return;
        }
        if(size.get(p1) < size.get(p2)){
            parent.set(p1, p2);
            size.set(p2, size.get(p1) + size.get(p2));
        }
        else{
            parent.set(p2, p1);
            size.set(p1, size.get(p1) + size.get(p2));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int row = 0;
        int col = 0;
        for(int i = 0; i<stones.length; i++){
            row = Math.max(stones[i][0], row);
            col = Math.max(stones[i][1], col);
        }

        DisjointSet ds = new DisjointSet(row + col + 2);
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<stones.length; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + row + 1;
            ds.UnionBySize(nodeRow, nodeCol);
            mp.put(nodeRow, 1);
            mp.put(nodeCol, 1);
        }

        int removed = 0;
        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            if(ds.findParent(it.getKey()) == it.getKey()){
                removed++;
            }
        }

        return n-removed;

    }
}