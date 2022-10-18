package dencka.kim.medium.stacks;

import java.util.*;

class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(balancedBrackets("([]asdf)(){}(()asf)()()")); // true
    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                    stack.add(')');
                    break;
                case '[':
                    stack.add(']');
                    break;
                case '{':
                    stack.add('}');
                    break;
                default:
                    if (ch != ')' && ch != '}' && ch != ']') break;
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != ch) return false;
            }
        }
        return true;
    }
}
