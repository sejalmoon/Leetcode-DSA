class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i<n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        Map<String,Integer> mailToAcc = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String mail = account.get(j);
                if(mailToAcc.containsKey(mail)) {
                    ds.UnionByRank(i, mailToAcc.get(mail));
                } else {
                    mailToAcc.put(mail, i);
                }
            }
        }

        Map<Integer,TreeSet<String>> merged = new HashMap<>();

        for(Map.Entry<String,Integer> entry : mailToAcc.entrySet()) {
            String mail = entry.getKey();
            int accIndex = entry.getValue();

            int parent = ds.findParent(accIndex);

            merged.putIfAbsent(parent, new TreeSet<>());
            merged.get(parent).add(mail);
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<Integer,TreeSet<String>> entry : merged.entrySet()) {
            int parent = entry.getKey();
            TreeSet<String> emails = entry.getValue();

            List<String> mergedAcc = new ArrayList<>();
            mergedAcc.add(accounts.get(parent).get(0)); 
            mergedAcc.addAll(emails);

            result.add(mergedAcc);
        }

        return result;

    }
}