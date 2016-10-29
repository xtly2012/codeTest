package com.chen.svm;

import java.util.ArrayList;
import java.util.List;



public class PairingStrategy {
	
	
	public static void main(String[] argus) {
		List<Point> pointList = new ArrayList<Point>();
		Point point = new Point();
		point.x = 3;
		point.y = 3;
		point.result = 1;
		pointList.add(point);
		point = new Point();
		point.x = 4;
		point.y = 3;
		point.result = 1;
		pointList.add(point);
		point = new Point();
		point.x = 1;
		point.y = 1;
		point.result = -1;
		pointList.add(point);
		
		Integer[][] gramArr = new Integer[3][3];
		for (int i = 0; i < pointList.size(); i++) {
			Point rowPoint = pointList.get(i);
			for (int j = 0; j < pointList.size(); j++) {
				Point colPoint = pointList.get(j);
				gramArr[i][j] = rowPoint.x * colPoint.x + rowPoint.y * colPoint.y;
				System.out.println("i = " +i +", j = " +j +"gramArr = " + gramArr[i][j]);
			}
		}
		
		int a = 0;
		int b = 0;
		int n = 1;
		
		boolean flag = true;
		while(flag) {
			flag = false;
			for (int i = 0; i < pointList.size(); i++) {
				int result = 0;
				for (int j = 0; j < pointList.size(); j++) {
					result += a * pointList.get(j).result * gramArr[i][j];
				}	
				if (pointList.get(i).result * (result += b) <= 0) {
					a += n;
					b += pointList.get(i).result;
					flag = true;
					break;
				}
				
			}
		}
		
		System.out.println("a = " +a +", b =" +b);
	}
	
	public static class Point {
		public int x;
		
		public int y;
		
		public int result;
	}
}
