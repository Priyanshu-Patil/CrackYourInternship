class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;

            char ch = (char) (columnNumber % 26 + 'A');

            columnNumber /= 26;

            ans.append(ch);
        }

        return ans.reverse().toString();
    }
}