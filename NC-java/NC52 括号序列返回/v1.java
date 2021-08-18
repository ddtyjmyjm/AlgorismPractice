import java.util.*;


public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        Deque <Character> stack = new LinkedList<>();
        try{
            for(char c : s.toCharArray()){
                switch (c){
                case '[':
                case '{':
                case '(':
                    stack.addFirst(c);
                    break;
                case ']':
                    if(stack.removeFirst()!='[')
                        return false;
                    break;
                case '}':
                    if(stack.removeFirst()!='{')
                        return false;
                    break;
                case ')':
                    if (stack.removeFirst()!='(')
                        return false;
                    break;
                }
            }
        }catch (Exception e){
            // stack空仍去取的情况，直接返回
            return false;
        }
        
        if (stack.size()!=0)
            return false;
        return true;
    }
}