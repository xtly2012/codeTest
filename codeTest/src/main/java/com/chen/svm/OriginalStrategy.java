package com.chen.svm;

import java.util.ArrayList;
import java.util.List;

public class OriginalStrategy {
	
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
		
		
		Point w = new Point();
		w.x = 0;
		w.y = 0;
		int b = 0;
		int n = 1;
		
		boolean flag = true;
		while(flag) {
			flag = false;
			for (Point temp : pointList) {
				if (temp.result * ((w.x * temp.x) +(w.y * temp.y) +b) <= 0) {
					w.x = w.x + (n * temp.result * temp.x);
					w.y = w.y + (n * temp.result * temp.y);
					b = b + temp.result;
					flag = true;
				}
			}
		}
			
		
		System.out.println("x = " +w.x +" , y =" +w.y +" , b = " +b);
	}
	
	
	public static class Point {
		public int x;
		
		public int y;
		
		public int result;
	}
}
