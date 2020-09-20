import java.util.Deque;
import java.util.LinkedList;

public class LeetCode71 {

    Deque<String> pathStack = new LinkedList<>();

    public String simplifyPath(String path) {
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                pathStack.push("/");
                while (i + 1 < path.length() && path.charAt(i + 1) == '/') {
                    i++;
                }
            }
            else {
                StringBuilder stringBuilder = new StringBuilder();
                while (i < path.length() && path.charAt(i) != '/') {
                    stringBuilder.append(path.charAt(i));
                    i++;
                }
                i--;
                String s = stringBuilder.toString();
                if (s.equals(".")) {
                    pathStack.pop();
                }
                else if (s.equals("..")) {
                    for (int m = 0; m < 3; m++) {
                        if (pathStack.size() > 0) {
                            pathStack.pop();
                        }
                    }
                }
                else {
                    pathStack.push(s);
                }
            }
        }
        if (pathStack.size() > 1 && pathStack.peek().equals("/")) {
            pathStack.pop();
        }
        if (pathStack.size() == 0) {
            pathStack.push("/");
        }
        return _toString();
    }

    public String _toString() {
        StringBuilder stringBuilder = new StringBuilder();
        while (!pathStack.isEmpty()) {
            stringBuilder.append(pathStack.pollLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode71 solve = new LeetCode71();
//        String path = "/home/";
//        String path = "/a/../../b/../c//.//";
//        String path = "/a//b////c/d//././/..";
//        String path = "/a/./b/../../c/";
        String path = "/.";
        System.out.println(solve.simplifyPath(path));
    }
}
