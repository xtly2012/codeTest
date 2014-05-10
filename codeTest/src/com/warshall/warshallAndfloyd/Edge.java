package com.warshall.warshallAndfloyd;

public class Edge
{
    int weight;
    Vertex start;
    Vertex end;

    public Edge(Vertex a, Vertex b, int w)
    {
        start = a;
        end = b;
        weight = w;
    }
}
