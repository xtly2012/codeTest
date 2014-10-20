package com.warshall.warshallAndfloyd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *            图见：图.png
 * 
 */

/** 每对顶点间的最短路径Floyd_Warshall算法 */
public class Floyd_Warshall {
	public static int i;
	public static ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	public static HashMap<String, Integer> vertexLength = new HashMap<String, Integer>();
	public int[][] Matrix;

	public Floyd_Warshall() {
		buildGraph();
		/*
		 * 动态规划思想的体现: 如果k不是最短路径的中间顶点,那么最短路径的中间顶点都在{0,1,2……k-1}中
		 * 如果k是最短路径的中间顶点,那么可以将最短路径分为i——k——j
		 */
		for (int k = 0; k < i; k++) {
			for (int m = 0; m < i; m++) {
				for (int n = 0; n < i; n++) {
					if (Matrix[m][k] != Integer.MAX_VALUE
							&& Matrix[k][n] != Integer.MAX_VALUE
							&& Matrix[m][k] + Matrix[k][n] < Matrix[m][n]) {
						Matrix[m][n] = Matrix[m][k] + Matrix[k][n];
						vertexLength.put(
								vertexList.get(m).key + vertexList.get(n).key,
								Matrix[m][n]);
					}
				}
			}
		}
		System.out.println("传递闭包：");
		output();
	}

	public void buildGraph() {
		Vertex v1 = new Vertex("a");
		Vertex v2 = new Vertex("b");
		Vertex v3 = new Vertex("c");
		Vertex v4 = new Vertex("d");
		Vertex v5 = new Vertex("e");
		// 初始化邻接矩阵
		Matrix = new int[i][i];
		for (int m = 0; m < i; m++) {
			for (int n = 0; n < i; n++) {
				if (m == n)
					Matrix[m][n] = 0;
				else
					Matrix[m][n] = Integer.MAX_VALUE;
			}
		}
		addEdge(v1, v3, 4);
		addEdge(v1, v5, 6);
		addEdge(v2, v1, 4);
		addEdge(v2, v5, 7);
		addEdge(v2, v3, 2);
		addEdge(v3, v4, 7);
		addEdge(v4, v1, 3);
		addEdge(v4, v2, 4);
		addEdge(v5, v4, 2);
		addEdge(v5, v3, 3);
		output();
	}

	// 输出矩阵中所有元素
	public void output() {
		for (int i = 0; i < Matrix.length; i++) {
			for (int j = 0; j < Matrix[i].length; j++) {
				if (Matrix[i][j] == Integer.MAX_VALUE) {
					System.out.print(Matrix[i][j] + "\t");
				} else {
					System.out.print(Matrix[i][j] + "\t\t");
				}

			}
			System.out.println("\r\n");
		}
	}

	// 构造邻接矩阵
	public void addEdge(Vertex a, Vertex b, int w) {
		// 返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
		Matrix[vertexList.indexOf(a)][vertexList.indexOf(b)] = w;
		vertexLength.put(a.key + b.key, w);
	}

	public static void main(String[] args) {
		new Floyd_Warshall();
		List<Map.Entry<String, Integer>> paths = new ArrayList<Map.Entry<String, Integer>>(
				vertexLength.entrySet());
		for (Map.Entry<String, Integer> result : paths) {
			System.out.println(result.getKey() + "间的最短距离为" + result.getValue());
		}
	}
}
