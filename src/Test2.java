
import java.util.*;


public class Test2 {

    public static void main(String[] args) {

        List<List<Integer>> lot = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(new Integer[]{9, 0, 0});
        List<Integer> list2 = Arrays.asList(new Integer[]{1, 0, 0});
        List<Integer> list3 = Arrays.asList(new Integer[]{1, 9, 1});
        lot.add(list1);
        lot.add(list2);
        lot.add(list3);
        System.out.println(findMinDistance(3, 3, lot));
    }
    static class Pair{
        int index;
        int distance;
        public Pair(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }

    public static int findMinDistance(int numRows, int numColumns, List<List<Integer>> lot){
        if (lot == null || lot.size() == 0) {
            return 0;
        }

        int nr = numRows;
        int nc = numColumns;
        int minDistance = 0;
        boolean[][] visited = new boolean[nr][nc];

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if ((lot.get(r).get(c) == 1 || lot.get(r).get(c) == 9) && !visited[r][c]) {
                    visited[r][c] = true;
                    Queue<Pair> neighbors = new LinkedList<>();
                    neighbors.add(new Pair(r * nc + c, 0));
                    while (!neighbors.isEmpty()) {
                        Pair p = neighbors.remove();
                        int row = p.index / nc;
                        int col = p.index % nc;
                        int distance = p.distance;
                        if(lot.get(row).get(col) == 9){
                            return distance;
                        }

                        if (row - 1 >= 0 && (lot.get(row - 1).get(col) == 1 || lot.get(row - 1).get(col) == 9)) {
                            neighbors.add(new Pair((row-1) * nc + col, distance + 1));
                            visited[row - 1][col] = true;
                        }
                        if (row + 1 < nr && (lot.get(row + 1).get(col) == 1 || lot.get(row + 1).get(col) == 9)) {
                            neighbors.add(new Pair((row+1) * nc + col, distance + 1));
                            visited[row + 1][col] = true;
                        }
                        if (col - 1 >= 0 && (lot.get(row).get(col - 1) == 1 || lot.get(row).get(col - 1) == 9)) {
                            neighbors.add(new Pair(row * nc + col-1, distance + 1));
                            visited[row][col - 1] = true;
                        }
                        if (col + 1 < nc && (lot.get(row).get(col + 1) == 1 || lot.get(row).get(col + 1) == 9)) {
                            neighbors.add(new Pair(row * nc + col+1, distance + 1));
                            visited[row][col + 1] = true;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private static void helper(int[] nums, int index, int len, List<List<Integer>> res) {
        if(index == len){
            if(len == 0) return;
            List<Integer> list = new ArrayList<>();
            for(int i: nums) list.add(i);
            System.out.println(list);
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = index; i< len; i++) {
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            swap(nums, index, i);
            helper(nums, index+1, len, res);
            swap(nums, index, i);
        }
    }
    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static List<List<Character>> permuteUnique(char[] nums) {
        List<List<Character>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Character>> list, List<Character> tempList, char [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void getPermutations(char[] nums, List<Character> tempList, List<List<Character>> res){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                getPermutations(nums, tempList, res);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void subsets(int[] nums, List<Integer> tempList, List<List<Integer>> res, int start){
        res.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            subsets(nums, tempList, res, i + 1);
            tempList.remove(tempList.size() - 1);
        }
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
