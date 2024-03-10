package lib;

public class Graph {
    private static final int MAX_VERTEX_NUM = 100; // 最大顶点数

    private class ArcMatrix {
        int val; // 顶点关键信息

        public ArcMatrix(int val) {
            this.val = val;
        }
    }

    private ArcMatrix[][] arcs; // 邻接矩阵，存储边，即顶点间的邻接关系
    private int vexnum; // 顶点数
    private int arcnum; // 边数

    public Graph(int vertexNum, int arcNum) {
        arcs = new ArcMatrix[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
        vexnum = vertexNum;
        arcnum = arcNum;
    }

    // 添加边
    public void addEdge(int source, int destination) {
        if (source >= 0 && source < vexnum && destination >= 0 && destination < vexnum) {
            arcs[source][destination] = new ArcMatrix(destination);
        }
    }

    // 删除边
    public void removeEdge(int source, int destination) {
        if (source >= 0 && source < vexnum && destination >= 0 && destination < vexnum) {
            arcs[source][destination] = null;
        }
    }

    // 获取顶点数
    public int getVertexCount() {
        return vexnum;
    }

    // 获取边数
    public int getArcCount() {
        return arcnum;
    }
}