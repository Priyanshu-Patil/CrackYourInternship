class StockSpanner {
    Stack<int[]> s;

    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        //monotonically dec stack
        while (!s.isEmpty() && s.peek()[0] <= price) {
            ans += s.pop()[1];
        }

        s.push(new int[]{price, ans});

        return ans;
    }
}