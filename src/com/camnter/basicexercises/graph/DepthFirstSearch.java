package com.camnter.basicexercises.graph;

import com.camnter.basicexercises.core.AdjacencyMatrixGraph;

import java.util.Stack;

/**
 * 图 深度优先搜索（BFS）
 * <p/>
 *
 * @author CaMnter
 */
public class DepthFirstSearch<T> {

    public void dfs(AdjacencyMatrixGraph<T> graph) {
        boolean[] visited = new boolean[graph.getNumOfVertex()];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < graph.vertexes.size(); i++) {
            if (visited[i]) continue;

            /**
             * 顶点 序号入栈
             */
            stack.add(i);
            do {
                /**
                 * 顶点 序号出栈
                 */
                int cur = stack.pop();
                if (!visited[cur]) {

                    /**
                     * 标记 && 打印
                     */
                    System.out.print(graph.vertexes.get(cur) + " ");
                    visited[cur] = true;

                    /**
                     * 逆序遍历，是因为栈是后进先出的
                     * V2 V3 进去的话
                     * 先出栈的是 V3
                     */
                    for (int j = graph.vertexes.size() - 1; j >= 0; j--) {
                        /**
                         * 横向遍历 && 排除访问
                         * 都入栈
                         */
                        if (visited[j]) continue;
                        if (graph.adjacencyMatrix[cur][j] == 1) {
                            stack.push(j);
                        }
                    }

                }
            } while (!stack.isEmpty());
        }
    }


    public static void main(String[] args) {
        DepthFirstSearch<String> depthFirstSearch = new DepthFirstSearch<String>();
        depthFirstSearch.dfs(AdjacencyMatrixGraph.getBiggerGraph());
    }

}
