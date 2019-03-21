
import java.util.Stack;



public class Test2 {

    public static void main(String[] args) {
        System.out.println(fibonacci(4));

    }

    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    public static int fibonacci(int n){
        if( n == 0) return 0;
        if(n == 1) return 1;

        int first = 0;
        int second = 1;
        int third;
        for(int i = 2 ; i <= n; i++){
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }

        public static int findProblem(String[] locks){
            Stack<String> stack = new Stack<>();
            int n = locks.length;

            for(int i = 0; i < n; i++){
                if(locks[i].contains("ACQUIRE")){
                    if(!stack.contains(locks[i])){
                        stack.push(locks[i]);
                    }
                    else{
                        return i + 1;
                    }
                }
                else{
                    String id = locks[i].split(" ")[1];
                    if(stack.peek().contains(id)){
                        stack.pop();
                    }
                    else{
                        return i + 1;
                    }
                }
            }

            return !stack.isEmpty() ? n + 1 : 0;

    }
}
