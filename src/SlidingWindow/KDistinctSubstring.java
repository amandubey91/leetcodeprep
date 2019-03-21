package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class KDistinctSubstring {


    public static void main(String[] args) {


        System.out.println(subStringKDist("awaglknagawunagwkwagl", 4));




    }
    public static List<String> subStringKDist(String inputStr, int num)
    {

        char[] sArr = inputStr.toCharArray();
        int strLen = sArr.length;

        HashSet<Character> set = new LinkedHashSet<>();
        List<String> result = new ArrayList<>();

        int l = 0;
        int r = 0;

        while(l <= strLen - num){
            for(int i = 0; i < num; i++){
                set.add(sArr[l]);
                l++;
            }
            String res = "";
            if(set.size() == num){
                for(Character c : set){
                    res += c;
                }
                if(!result.contains(res))
                    result.add(res);
            }
            set.clear();
            r++;
            l = r;
        }
        return result;

    }
}
