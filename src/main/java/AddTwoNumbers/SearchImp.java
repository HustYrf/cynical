package AddTwoNumbers;

import CITS2200.Graph;
import CITS2200.Search;

import java.util.*;

public class SearchImp implements Search {

    /**
     * output an array specifying the parent vertex for each vertex
     * use breadth first search
     * @param graph Graph g
     * @param i start index
     * @return array
     */
    @Override
    public int[] getConnectedTree(Graph graph, int i) {
        int[][] edgeMatrix = graph.getEdgeMatrix();
        int length = edgeMatrix.length;
        boolean[] visited = new boolean[length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        int currentRow;
        while (!queue.isEmpty()) {
            currentRow = queue.poll();
            for (int k = 0; k < length; k++) {
                if (edgeMatrix[currentRow][k] == 1 && !visited[k]) {
                    queue.add(k);
                    map.put(k, currentRow);
                    visited[k] = true;
                }
            }
        }

        int[] result = new int[length];
        for (int temp = 0; temp < length; temp++) {
            result[temp] = -1;
        }
        for (Integer keyINT : map.keySet()) {
            result[keyINT] = map.get(keyINT);
        }

        return result;
    }

    /**
     * output an array specifying the distance each vertex is from the starting vertex
     * use breadth first search
     * @param graph Graph g
     * @param i start index
     * @return array
     */
    @Override
    public int[] getDistances(Graph graph, int i) {
        int[] connectedTree = getConnectedTree(graph, i);
        int[][] edgeMatrix = graph.getEdgeMatrix();
        int length = edgeMatrix.length;
        boolean[] visited = new boolean[length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        map.put(i, 0);
        visited[i] = true;
        int currentRow;
        while (!queue.isEmpty()) {
            currentRow = queue.poll();
            for (int k = 0; k < length; k++) {
                if (edgeMatrix[currentRow][k] == 1 && !visited[k]) {
                    queue.add(k);
                    int parentInteger = connectedTree[k];
                    if(parentInteger == -1){
                        map.put(k, -1);
                    }else{
                        Integer parentDistance = map.get(parentInteger);
                        map.put(k, parentDistance+1);
                    }
                    visited[k] = true;
                }
            }

        }

        int[] result = new int[length];
        for (int temp = 0; temp < length; temp++) {
            result[temp] = -1;
        }
        for (Integer keyINT : map.keySet()) {
            result[keyINT] = map.get(keyINT);
        }
        return result;
    }

    /**
     * output the start and finish times for each vertex
     * use depth first search
     * @param graph Graph g
     * @param i start index
     * @return array
     */
    @Override
    public int[][] getTimes(Graph graph, int i) {

        int[][] edgeMatrix = graph.getEdgeMatrix();
        int length = edgeMatrix.length;
        int[][] result = new int[length][2];
        boolean[] visited = new boolean[length];
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(i);
        result[i][0] = (int) System.nanoTime();
        System.out.print(stack.getFirst() + " ");
        result[i][1] = (int) System.nanoTime();
        visited[i] = true;
        while (!stack.isEmpty()) {
            int k = stack.getFirst();
            int j = 0;
            for (j = 0; j < length; j++) {
                if (edgeMatrix[k][j] == 1 && !visited[j]) {
                    stack.push(j);
                    result[j][0] = (int) System.nanoTime();
                    System.out.print(stack.getFirst() + " ");
                    result[j][1] = (int) System.nanoTime();
                    visited[j] = true;
                    break;
                }
            }
            if (j == length) {
                stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
