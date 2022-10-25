package dencka.kim.hard.stacks;

import java.util.Stack;

class ShortenPath {
    public static void main(String[] args) {
        String input = "/foo/../test/../test/../foo//bar/./baz";
        System.out.println(shortenPath(input));
    }

    public static String shortenPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] route;
        if (path.startsWith("/")) {
            route = path.substring(1).split("/");
            stack.add("");
        } else {
            route = path.split("/");
        }

        for (String s : route) {
            if (s.equals("..")) {
                if (stack.isEmpty() || stack.peek().equals("..")) {
                    stack.push(s);
                } else if (!stack.peek().equals("")) {
                    stack.pop();
                }
            } else if (s.equals("") || s.equals(".")) {
                continue;
            } else {
                stack.push(s);
            }
        }

        if (stack.size() == 1 && stack.peek().equals("")) return "/";
        return String.join("/", stack);
    }
}
