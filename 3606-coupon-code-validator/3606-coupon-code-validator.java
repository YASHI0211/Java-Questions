class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, Integer> order = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            // Check active
            if (!isActive[i]) continue;

            // Check business line
            if (!order.containsKey(businessLine[i])) continue;

            // Check code validity
            if (!isValidCode(code[i])) continue;

            valid.add(new String[]{businessLine[i], code[i]});
        }

        // Sort by business line order, then code
        valid.sort((a, b) -> {
            int cmp = order.get(a[0]) - order.get(b[0]);
            return cmp != 0 ? cmp : a[1].compareTo(b[1]);
        });

        // Extract result
        List<String> result = new ArrayList<>();
        for (String[] v : valid) {
            result.add(v[1]);
        }

        return result;
    }

    // Simple character check
    private boolean isValidCode(String s) {
        if (s == null || s.isEmpty()) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
}
