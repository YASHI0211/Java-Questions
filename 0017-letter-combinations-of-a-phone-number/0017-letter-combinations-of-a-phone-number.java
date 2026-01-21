class Solution {
    private String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backtrack(res, digits, "", 0);
        return res;
    }

    private void backtrack(List<String> res, String digits, String current, int index) {
        if (index == digits.length()) {
            res.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            backtrack(res, digits, current + c, index + 1);
        }
    }
}