package com.camnter.basicexercises.graph;

import com.camnter.basicexercises.core.AdjacencyMatrixGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图 广度优先搜索（BFS）
 * <p/>
 * 类似于 树 BFS
 *
 * @author CaMnter
 */
public class BreadthFirstSearch<T> {

    public void bfs(AdjacencyMatrixGraph<T> graph) {
        boolean[] visited = new boolean[graph.getNumOfVertex()];
        Queue<T> queue = new LinkedList<T>();
        final int size = graph.vertexes.size();
        for (int i = 0; i < size; i++) {
            // 没访问过该 顶点
            if (visited[i]) continue;

            T t;
            t = graph.vertexes.get(i);

            /**
             * 入队 && 标记
             */
            queue.add(t);
            visited[i] = true;

            System.out.println(t.toString());

            while (!queue.isEmpty()) {
                queue.poll();

                for (int j = 0; j < size; j++) {
                    /**
                     * 排除 访问过 && 自己连自己的无效矩阵点
                     */
                    if (visited[j] || j == i) continue;
                    /**
                     * 矩阵内确认是否有 边
                     */
                    if (graph.adjacencyMatrix[i][j] == 0) continue;

                    /**
                     * 边上的另外一点 && 没访问过
                     */
                    t = graph.vertexes.get(j);

                    /**
                     * 入队 && 标记
                     */
                    visited[j] = true;
                    queue.add(t);
                    System.out.println(t.toString());
                }

            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch<String> breadthFirstSearch = new BreadthFirstSearch<String>();
        breadthFirstSearch.bfs(AdjacencyMatrixGraph.getGraph());
    }

}
