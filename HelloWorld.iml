import java.util.*;
import java.lang.*;
public class MyClass {
    
    public static void main(String args[]) {
    List<String> list  = new ArrayList<>();
    list.add("id");
    list.add("age");
    list.add("value");
    
    
    Spreadsheet sheet = new Spreadsheet(list);
    
    sheet.set(0, "id", 12312);
    sheet.set(0, "age", 25);
    sheet.set(1, "value", -12);
    
    sheet.print();
    
    }
}

class Spreadsheet{
    
    Map<Integer, Map<String, Integer>> map;
    Map<String, Integer> col;
    
    Spreadsheet(List<String> list){
        col = new HashMap<>();
        int i=0;
        for(String str : list){
            col.put(str, 0);
        }
        
        map = new HashMap<>();
    }
    
    boolean set(int index, String col, int val){
        if(map.containsKey(index)){
            if(!map.get(index).containsKey(col)) return false;
            map.get(index).put(col,val);
        }
        else{
            Map<String, Integer> newCol = new HashMap<>();
            for(String eachCol : this.col.keySet()){
                if(eachCol.equals(col)){
                    newCol.put(eachCol, val);
                }
                else{
                    newCol.put(eachCol, 0);
                }
            }
            map.put(index, newCol);
        }
        return true;
    }
    
    Integer get(int index, String col){
        if(map.containsKey(index)){
            if(!map.get(index).containsKey(col)) return null;
            return map.get(index).get(col);
        }
        return null;
    }
    
    void print(){
        List<Integer> list = new ArrayList(map.keySet());
        int[] keys = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(keys);
        for(int key : keys){
            System.out.println("Index: " +key);
            Set<String> cols = map.get(key).keySet();
            for(String col : cols){
                System.out.println("ColName: " +col +"-> Values: " +map.get(key).get(col));    
            }
            
        }
    }

}
