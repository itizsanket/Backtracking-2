// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Program2 {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(String s, int start, List<String> temp) {
        // base case
        if (start >= s.length()) {
            result.add(new ArrayList<>(temp));
        }
        // logic 
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(s, i + 1, temp); // 'a'  'ab' ['a''b'] ['ab']
                // backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        if (l == r)
            return true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
