import java.util.*;

public class ReverseSubstring {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(ch != ')'){
                stack.push(ch);
            }else{ // ch == ')'
                ArrayList<Character> list = new ArrayList<>();
                while(stack.peek() != '('){
                    list.add(stack.pop());
                }
                stack.pop(); // remove the '('
                for(char c: list){
                    stack.push(c);
                }
            }
        }
        
        StringBuilder str = new StringBuilder();
        for(char ch: stack){
            str.append(ch);
        }
        return str.toString();
    }
}
