package com.camnter.basicexercises.graph;

import com.camnter.basicexercises.core.AdjacencyMatrixGraph;

/**
 * 图 深度优先搜索（BFS）
 * <p/>
 * 就是从一个顶点开始找，找到底为止
 *
 * @author CaMnter
 */
public class DepthFirstSearchRecursive<T> {

    public void dfsRecursive(AdjacencyMatrixGraph<T> graph) {
        boolean[] visited = new boolean[graph.getNumOfVertex()];
        for (int i = 0; i < graph.vertexes.size(); i++) {
            if (visited[i]) continue;
            recursive(graph, visited, i);
        }
    }

    public void recursive(AdjacencyMatrixGraph<T> graph, boolean[] visited, int i) {
        // 标记
        visited[i] = true;
        System.out.print(graph.vertexes.get(i).toString() + " ");

        for (int j = 0; j < graph.vertexes.size(); j++) {
            /**
             * 有边 && 没访问过边的另外一个节点
             */
            if (graph.adjacencyMatrix[i][j] == 1 && !visited[j]) {
                recursive(graph, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearchRecursive<String> depthFirstSearchRecursive = new DepthFirstSearchRecursive<String>();
        depthFirstSearchRecursive.dfsRecursive(AdjacencyMatrixGraph.getBiggerGraph());
    }

}
