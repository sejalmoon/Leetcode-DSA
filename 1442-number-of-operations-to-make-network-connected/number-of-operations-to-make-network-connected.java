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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        for(int i = 0; i<connections.length; i++){
            if(ds.findParent(connections[i][0]) == ds.findParent(connections[i][1])){
                extra++;
            }
            else{
                ds.UnionBySize(connections[i][0], connections[i][1]);
            }
        }
        int separate = 0;
        for(int i = 0; i<n; i++){
            if(ds.parent.get(i) == i){
                separate++;
            }
        }
        if(extra>=separate-1){
            return separate-1;
        }
        return -1;
    }
}