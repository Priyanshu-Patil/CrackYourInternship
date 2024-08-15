class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int deletions = 0;

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int freq: map.values()) {
            while (freq > 0 && set.contains(freq)) {
                freq--;
                deletions++;
            }

            set.add(freq);
        }

        return deletions;
    }
}