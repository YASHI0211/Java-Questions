
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> countT = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) countT.put(c, countT.getOrDefault(c, 0) + 1);
        int have = 0, need = countT.size(), l = 0, resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) have++;
            while (have == need) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res = new int[]{l, r};
                }
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if (countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))) have--;
                l++;
            }
        }
        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}