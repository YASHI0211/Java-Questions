class Solution {
    public int titleToNumber(String c) {
        int res = 0;
        for (char ch : c.toCharArray())
            res = res * 26 + (ch - 'A' + 1);
        return res;
    }
}
