
import java.util.*;

class Request{
    String name;
    int from;
    int to;

    public Request(String name, int from, int to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }
}

class RequestNode{
    String name;
    int from;

    public RequestNode(String name, int from) {
        this.name = name;
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestNode that = (RequestNode) o;

        if (from != that.from) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + from;
        return result;
    }
}
public class Test2 {

    public static void main(String[] args) {

//        int[] res = canFinish(4, new Request[]{new Request("Alex", 1, 2),
//                new Request("Ben", 2, 1),
//                new Request("Chris", 1, 2),
//                new Request("David", 2, 3),
//                new Request("Ellen", 3, 1),
//                new Request("Frank", 4, 5)});

    }

//    public static int[] canFinish(int numCourses, Request[] prerequisites) {
//        Map<RequestNode, List<Integer>> graph = new HashMap<>();
//
//        for(int i=0;i<prerequisites.length;i++){
//            RequestNode node = new RequestNode(prerequisites[0].name, prerequisites[1].from);
//            if(graph.containsKey(node))
//                graph.put(node, new ArrayList());
//        }
//
//        Set<Integer>
//
//        boolean[] visited = new boolean[numCourses];
//        for(int i=0; i<prerequisites.length;i++){
//            graph[prerequisites[i][1]].add(prerequisites[i][0]);
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        int[] result = new int[numCourses];
//
//        for(int i=0; i<numCourses; i++){
//            if(!dfs(graph,visited,i, stack))
//                return new int[numCourses];
//        }
//        int index = 0;
//        while(!stack.isEmpty()){
//            result[index] = stack.pop();
//            index++;
//        }
//
//        return result;
//    }

    private static boolean dfs(ArrayList[] graph, boolean[] visited, int course, Stack<Integer> stack){
        if(visited[course])
            return false;
        else
            visited[course] = true;



        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i), stack)) {
                return false;
            }
        }
        if(!stack.contains(course))
            stack.push(course);

        visited[course] = false;
        return true;
    }
}
