class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();
        
        for (String i: string_list) {
            char[] ch = i.toCharArray();
            Arrays.sort(ch);
            
            String s = String.valueOf(ch);
            
            if (map.containsKey(s)) {
                map.get(s).add(i);
            } else {
                List<String> li = new ArrayList<>();
                li.add(i);
                ans.add(li);
                map.put(s, li);
            }
        }
        
        return ans;
    }
}