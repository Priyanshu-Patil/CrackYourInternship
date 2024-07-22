class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] directories = path.split("/");

        for (String dir: directories) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            } else if (dir.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(dir);
            }
        }

        return "/" + String.join("/", s);
    }
}