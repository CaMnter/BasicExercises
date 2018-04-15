package com.camnter.basicexercises.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接矩阵 表示图
 * <p/>
 * V0----V1
 * |    / |
 * |  V2  |
 * | /  \ |
 * V3    V4
 * 用临界矩阵表示就是
 * {
 * {0, 1, 0, 1, 0},   // V0 连接 V1 V3
 * {1, 0, 1, 0, 1},   // V1 连接 V0 V2 V4
 * {0, 1, 0, 1, 1},   // V2 连接 V1 V3 V4
 * {1, 0, 1, 0, 0},   // V3 连接 V0 V2
 * {0, 1, 1, 0, 0},   // V4 连接 V1 V2
 * }
 * 1 又代表边
 * 1 的总数就是边的总数
 *
 * @author CaMnter
 */
public class AdjacencyMatrixGraph<V> {

    /**
     * 顶点
     */
    public List<V> vertexes;
    /**
     * 邻接矩阵
     * 存储边
     */
    public int[][] adjacencyMatrix;
    /**
     * 边数
     */
    public int edges;

    public AdjacencyMatrixGraph(int n) {
        this.edges = 0;
        this.adjacencyMatrix = new int[n][n];
        this.vertexes = new ArrayList<V>(n);
    }

    public int getNumOfVertex() {
        return this.vertexes.size();
    }

    public int getEdges() {
        return this.edges;
    }

    public V getValueByIndex(int i) {
        return this.vertexes.get(i);
    }

    /**
     * 返回 v1, v2 的权值
     *
     * @param v1 v1
     * @param v2 v2
     * @return weight
     */
    public int getWeight(int v1, int v2) {
        return this.adjacencyMatrix[v1][v2];
    }

    public void addVertex(V vertex) {
        this.vertexes.add(this.vertexes.size(), vertex);
    }

    /**
     * 添加边
     *
     * @param v1     v1
     * @param v2     v2
     * @param weight 权值
     */
    public void addEdge(int v1, int v2, int weight) {
        this.adjacencyMatrix[v1][v2] = weight;
        this.edges++;
    }

    public void deleteEdge(int v1, int v2) {
        this.adjacencyMatrix[v1][v2] = 0;
        this.edges--;
    }

    /**
     * 获取 第一个 与 V[index] 节点 相连接的节点的 index
     *
     * @param index index
     * @return index
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < this.vertexes.size(); j++) {
            if (this.adjacencyMatrix[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来取得下一个邻接结点（横向找）
     *
     * @param v1 v1
     * @param v2 v2
     * @return int
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < this.vertexes.size(); j++) {
            if (this.adjacencyMatrix[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * V0----V1
     * |    / |
     * |  V2  |
     * | /  \ |
     * V3    V4
     *
     * @return graph
     */
    public static AdjacencyMatrixGraph<String> getGraph() {
        final String[] vertexes = {"V0", "V1", "V2", "V3", "V4"};
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<String>(vertexes.length);
        for (String vertex : vertexes) {
            graph.addVertex(vertex);
        }
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 0, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(4, 1, 1);
        graph.addEdge(4, 2, 1);
        return graph;
    }

    /**
     * V0----V1-----V5-----V7
     * |    / |      |      |
     * |  V2  |      |      |
     * | /  \ |      |      |
     * V3    V4-----V6-----V8
     *
     * BFS：V0 V1 V3 V2 V4 V5 V6 V7 V8
     * DFS：V0 V1 V2 V3 V4 V6 V5 V7 V8
     *
     * @return graph
     */
    public static AdjacencyMatrixGraph<String> getBiggerGraph() {
        final String[] vertexes = {"V0", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8"};
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<String>(vertexes.length);
        for (String vertex : vertexes) {
            graph.addVertex(vertex);
        }
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 5, 1);
        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 0, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(4, 1, 1);
        graph.addEdge(4, 2, 1);
        graph.addEdge(4, 6, 1);
        graph.addEdge(5, 1, 1);
        graph.addEdge(5, 6, 1);
        graph.addEdge(5, 7, 1);
        graph.addEdge(6, 4, 1);
        graph.addEdge(6, 5, 1);
        graph.addEdge(6, 8, 1);
        graph.addEdge(7, 5, 1);
        graph.addEdge(7, 8, 1);
        graph.addEdge(8, 7, 1);
        graph.addEdge(8, 6, 1);
        return graph;
    }

}
