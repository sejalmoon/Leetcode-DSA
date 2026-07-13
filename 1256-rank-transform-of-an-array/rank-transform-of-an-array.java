class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] sarr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sarr);

        int rank = 1;
        for(int i = 0; i<arr.length; i++){
            if(i>0 && sarr[i] > sarr[i-1]) rank++;
            mp.put(sarr[i], rank);
        }

        for(int i = 0; i<arr.length; i++){
            arr[i] = mp.get(arr[i]);
        }
        return arr;
    }
}