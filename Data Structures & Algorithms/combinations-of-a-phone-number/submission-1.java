class Solution {
    // Constant mapping keypad digits to letters
    private static final String[] DIGIT_TO_LETTERS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        StringBuilder currentPath = new StringBuilder();
        backtrack(digits, 0, currentPath, combinations);
        return combinations;
    }

    private void backtrack(String digits, int index, StringBuilder currentPath, List<String> combinations) {
        // Base case: formed a full combination
        if (index == digits.length()) {
            combinations.add(currentPath.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = DIGIT_TO_LETTERS[digit];

        for (int i = 0; i < letters.length(); i++) {
            currentPath.append(letters.charAt(i));
            backtrack(digits, index + 1, currentPath, combinations);
            currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack
        }
    }
}