class Solution {
    public int maxSumDivThree(int[] nums) {
         int total = 0;

        int min1 = Integer.MAX_VALUE, secondMin1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE, secondMin2 = Integer.MAX_VALUE;

        for (int num : nums) {
            total += num;
            int r = num % 3;
            if (r == 1) {
                if (num < min1) {
                    secondMin1 = min1;
                    min1 = num;
                } else if (num < secondMin1) {
                    secondMin1 = num;
                }
            } else if (r == 2) {
                if (num < min2) {
                    secondMin2 = min2;
                    min2 = num;
                } else if (num < secondMin2) {
                    secondMin2 = num;
                }
            }
        }

        if (total % 3 == 0) return total;

        int option1 = Integer.MAX_VALUE, option2 = Integer.MAX_VALUE;

        if (total % 3 == 1) {
            if (min1 != Integer.MAX_VALUE) option1 = min1;
            if (min2 != Integer.MAX_VALUE && secondMin2 != Integer.MAX_VALUE) option2 = min2 + secondMin2;
        } else if (total % 3 == 2) {
            if (min2 != Integer.MAX_VALUE) option1 = min2;
            if (min1 != Integer.MAX_VALUE && secondMin1 != Integer.MAX_VALUE) option2 = min1 + secondMin1;
        }

        int subtract = Math.min(option1, option2);

        if (subtract == Integer.MAX_VALUE) return 0;

        return total - subtract;
    
    }
    }