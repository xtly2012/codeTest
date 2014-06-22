package com.warshall.warshallAndfloyd;


public class Vertex {
    public String key;
    public Vertex(String k) {
       key = k;
       Floyd_Warshall.i++;
       Floyd_Warshall.vertexList.add(this);
    }
}