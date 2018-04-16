package com.camnter.basicexercises.graph;

import com.camnter.basicexercises.core.AdjacencyMatrixGraph;


/**
 * 最短路径（迪杰斯特拉算法）
 *
 * @author CaMnter
 */
public class Dijkstra<T> {

    private static final int MAX = Integer.MAX_VALUE;

    /**
     * @param graph    邻接矩阵
     * @param start    起始点
     * @param pre      在计算最短路径，得出起始点到某点的最短路径，pre 就是记录某一点的最短路径上的 上个顶点
     *                 比如 A 到 D 点的最短路径，在计算中算出来是 A C B D，那么 pre[DIndex] = B，记录了
     *                 D 的最短路径的上个顶点 B
     * @param distance 记录各个点的最短路径值，总权值
     */
    public void dijkstra(AdjacencyMatrixGraph<T> graph,
                         int start,
                         int[] pre,
                         int[] distance) {
        /**
         * 记录 顶点数，被访问标记数组，矩阵
         */
        final int size = graph.vertexes.size();
        boolean[] visited = new boolean[size];
        int[][] matrix = graph.adjacencyMatrix;


        /**
         * 初始化 被访问标记数组，最短路径前顶点数组，最短路径记录数组
         */
        for (int i = 0; i < size; i++) {
            visited[i] = false;
            pre[i] = 0;
            distance[i] = matrix[start][i];
        }

        /**
         * 标记 起始顶点 被访问
         * 最短路径设置，起始顶点的路径 为 0
         */
        visited[start] = true;
        distance[start] = 0;

        int k = 0;
        /**
         * 剩下要加入的 n-1 个顶点
         */
        for (int i = 1; i < size; i++) {
            int min = MAX;
            /**
             * 横向查找顶点 i 能通向的节点 j
             * j 的话，如果不是直接能通往的顶点就是 Integer.MAX_VALUE
             * 不然的话，则有确定值。这样的话，就是直接顶点
             */
            for (int j = 0; j < size; j++) {
                if (visited[j]) continue;
                /**
                 * 没被访问
                 *
                 * 如果之前已经保存了 j 的最短最短距离，并且 min 比之前保存的最短距离还小
                 * 那么，锁定 j
                 * 保存为 k。同时，保存 k 的最短路径为 min
                 * 为了方便计算 k 下面那些顶点的最短距离
                 */
                if (distance[j] < min) {
                    min = distance[j];
                    k = j;
                }
            }

            visited[k] = true;

            /**
             * 开始 k 的横向遍历
             * 就是尝试计算 k 的后继顶点的最短路径
             */
            for (int j = 0; j < size; j++) {
                if (visited[j]) continue;
                /**
                 * 没被访问
                 *
                 * 如果 和 k 不是直接顶点，取 MAX
                 * 如果 和 k 是直接顶点，取上面保存的 k 最短距离 + 直接顶点的与 k 的距离（ matrix[k][j] ）
                 * 保存为 temp
                 *
                 * temp 比之前保存的最短距离还小
                 *
                 * 覆盖最短距离保存记录
                 * 并且记录 改点的 前继最短距离顶点为 k
                 */
                int temp = matrix[k][j] == MAX ? MAX : (min + matrix[k][j]);
                if (temp < distance[j]) {
                    distance[j] = temp;
                    pre[j] = k;
                }
            }
        }

    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph<String> graph = getBiggerGraph();

        Dijkstra<String> dijkstra = new Dijkstra<String>();
        int size = graph.vertexes.size();
        int[] pre = new int[size];
        int[] distance = new int[size];
        dijkstra.dijkstra(graph, 0, pre, distance);

        for (int i = 0; i < size; i++) {
            System.out.print(graph.vertexes.get(i) + "(" + distance[i] + ") ");
        }
    }

    public static AdjacencyMatrixGraph<String> getBiggerGraph() {
        final String[] vertexes = {"D", "C", "E", "F", "B", "G", "A"};
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<String>(vertexes.length);
        for (String vertex : vertexes) {
            graph.addVertex(vertex);
        }
        graph.adjacencyMatrix = new int[][]{
                {0/* D */, 3/* C */, 4/* E */, MAX/* F */, MAX/* B */, MAX/* G */, MAX/* A */},  // D
                {3/* D */, 0/* C */, 5/* E */, 6/* F */, 10/* B */, MAX/* G */, MAX/* A */},     // C
                {4/* D */, 5/* C */, 0/* E */, 2/* F */, MAX/* B */, 8/* G */, MAX/* A */},      // E
                {MAX/* D */, 6/* C */, 2/* E */, 0/* F */, 7/* B */, 9/* G */, 16/* A */},       // F
                {MAX/* D */, 10/* C */, MAX/* E */, 7/* F */, 0/* B */, MAX/* G */, 12/* A */},  // B
                {MAX/* D */, MAX/* C */, 8/* E */, 9/* F */, MAX/* B */, 0/* G */, 14/* A */},   // G
                {MAX/* D */, MAX/* C */, MAX/* E */, 16/* F */, 12/* B */, 14/* G */, 0/* A */}, // A
        };
        return graph;
    }

}
