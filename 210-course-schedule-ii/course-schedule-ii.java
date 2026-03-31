class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adjList = new ArrayList<>();
       int[] ans = new int[numCourses];
       for(int i = 0; i<numCourses; i++){
        adjList.add(new ArrayList<>());
       } 
        int[] indegree = new int[numCourses];
        int count = 0;
       for(int i = 0; i<prerequisites.length; i++){
        adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        indegree[prerequisites[i][0]]++;
       }

       
       Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int ele = q.peek();
            q.remove();
            ans[count] = ele;
            count++;
            for(int it:adjList.get(ele)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        if(count == numCourses){
            return ans;
        }
        else{
            return new int[]{};
        }
    }
}