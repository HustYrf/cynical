package AddTwoNumbers;

import java.util.*;

/**
 * @Author zyj
 * @Date 2020/3/27 21:58
 **/
public class BFS {
    private int[][] matrix;
    private char[] vertex;

    public BFS(int[][] matrix, char[] vertex) {
        this.matrix = matrix;
        this.vertex = vertex;
    }


















    public List<Character> doBFS(char begin) {
        List<Character> result = new LinkedList<>();

        // 找到给定字符的位置
        int beginPosition = -1;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == begin) {
                beginPosition = i;
                break;
            }
        }



        int length = vertex.length;
        boolean[] visited = new boolean[length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(beginPosition);
        int distance = 1;
        map.put(beginPosition, distance - 1);
        visited[beginPosition] = true;
        boolean flag = false;
        int currentRow;
        while (!queue.isEmpty()) {
            currentRow = queue.poll();
            flag = false;
            for (int k = 0; k < length; k++) {
                if (matrix[currentRow][k] == 1 && !visited[k]) {
                    queue.add(k);
                    map.put(k, distance);
                    visited[k] = true;
                    flag = true;
                }
            }
            if (flag) {
                distance++;
            }
        }

        int[] result1 = new int[length];
        for (int temp = 0; temp < length; temp++) {
            result1[temp] = -1;
        }
        for (Integer keyINT : map.keySet()) {
            result1[keyINT] = map.get(keyINT);
        }



        return result;
    }

    public void print() {
        System.err.println(Arrays.deepToString(matrix));
        System.err.println(Arrays.toString(vertex));
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,0,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1},
                {1,0,0,0,1,1,1,0,1,1,0,0,0,0,0,0,0,1,0,0},
                {1,1,0,0,1,0,1,1,0,0,1,1,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0},
                {1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
                {0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,0,0,1,0,1},
                {0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,1},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0},
                {1,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0},
                {0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1},
                {0,0,0,0,1,1,0,1,0,1,0,0,0,1,1,0,0,1,1,0},
                {0,0,0,0,1,0,1,0,0,0,1,0,1,1,0,0,0,0,1,1},
                {1,0,0,0,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,1},
                {0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,1,0,0,1,0,1,0,0,0,0,1,0,1},
                {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,1,0,0,1,0,1,0,1,1,0,0,0,0,1,1},
                {1,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,1,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,0,0},
        };

        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I','J','K','L','M','N','O','P','Q','R','S','T'};

        BFS bfs = new BFS(matrix, vertex);
        //bfs.print();

        System.err.println(bfs.doBFS('A'));
    }
}
