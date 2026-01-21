class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length(), currNum = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) currNum = currNum * 10 + (c - '0');
            if (!Character.isDigit(c) && !Character.isSpaceChar(c) || i == len - 1) {
                if (op == '-') stack.push(-currNum);
                else if (op == '+') stack.push(currNum);
                else if (op == '*') stack.push(stack.pop() * currNum);
                else if (op == '/') stack.push(stack.pop() / currNum);
                op = c; currNum = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}