class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> hash = new HashMap<>();
        int l = 0, r = 0, m = t.length(), n = s.length();
        int minlen = Integer.MAX_VALUE, startIndex = -1, count = 0;

        for (int i = 0; i < m; i++) {
            hash.put(t.charAt(i), hash.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (r < n) {
            char rightChar = s.charAt(r);
            if (hash.containsKey(rightChar)) {
                hash.put(rightChar, hash.get(rightChar) - 1);
                if (hash.get(rightChar) >= 0) {
                    count++;
                }
            }

            while (count == m) {
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    startIndex = l;
                }

                char leftChar = s.charAt(l);
                if (hash.containsKey(leftChar)) {
                    hash.put(leftChar, hash.get(leftChar) + 1);
                    if (hash.get(leftChar) > 0) {
                        count--;
                    }
                }

                l++;
            }

            r++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minlen);
    }
}