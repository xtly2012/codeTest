package com.warshall.common;

import java.util.Random;

//矩阵类   
public class MatrixE {

	private int[][] matrix;

	Random random = new Random();

	// 构造方法
	public MatrixE() {
		matrix = new int[3][3];

	}

	public MatrixE(int n) {
		matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = random.nextInt(100);
			}
		}
	}

	public MatrixE(int n, int m) {
		matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = random.nextInt(100);
			}
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	// 输出矩阵中所有元素
	public void output() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// 求一个矩阵的转置矩阵
	public MatrixE transpose() {

		int n = matrix.length;
		int m = matrix[0].length;

		MatrixE transMatrix = new MatrixE(n, m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				transMatrix.getMatrix()[i][j] = matrix[j][i];
			}
		}

		return transMatrix;
	}

	// 判断一个矩阵是否为上三角矩阵
	public boolean isTriangular() {

		// 用相反的思路进行判断
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				if (matrix[i][j] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	// 判断是否为对称矩阵
	public boolean isSymmetry() {

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != matrix[j][i]) {
					return false;
				}
			}
		}

		return true;
	}

	// 矩阵的相加
	public void add(MatrixE b) {

		int[][] matrixOfB = b.getMatrix();

		int n = matrixOfB.length;
		int m = matrixOfB[0].length;

		if (n != matrix.length || m != matrix[0].length) {
			System.out.println("矩阵的长度不一致，不能相加");
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] += matrixOfB[i][j];
				}
			}

		}
	}

	public static void main(String[] args) {

		// 测试
		MatrixE test1 = new MatrixE(4);

		System.out.println("原始矩阵");
		test1.output();

		MatrixE transMatrix = test1.transpose();

		System.out.println("转置矩阵");
		transMatrix.output();

		System.out.println("是否是上三角矩阵");
		System.out.println(test1.isTriangular());

		System.out.println("是否是对称矩阵");
		System.out.println(test1.isSymmetry());

		System.out.println("----------------------");

		MatrixE test2 = new MatrixE();

		test2.output();

		System.out.println(test2.isTriangular());
		System.out.println(test2.isSymmetry());

		System.out.println("----------------------");

		MatrixE test3 = new MatrixE(4);
		MatrixE test4 = new MatrixE(4);

		test3.add(test2);

		System.out.println("矩阵1");
		test3.output();
		System.out.println("矩阵2");
		test4.output();

		System.out.println("矩阵相加");
		test3.add(test4);

		test3.output();
	}

}
