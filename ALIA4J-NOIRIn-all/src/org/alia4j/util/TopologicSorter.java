package org.alia4j.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Based on source from http://www.java2s.com/Code/Java/Collections-Data-Structure/Topologicalsorting.htm
 * 
 * @author bockisch
 */
public class TopologicSorter<T> {
    
    private final Object vertexList[]; // list of vertices
    
    private final int matrix[][]; // adjacency matrix
    
    private int numVerts; // current number of vertices
    
    private final Object[] sortedArray;
    
    @SuppressWarnings("unchecked")
    public static <T> List<T> sort(Set<T> values, List<Pair<Set<T>, Set<T>>> relations) {
        TopologicSorter<T> sorter = new TopologicSorter<T>(values);
        int index = 0;
        Map<T, Integer> value2Index = new HashMap<T, Integer>();
        for (T value : values) {
            sorter.setValue(index, value);
            value2Index.put(value, index);
            index++;
        }
        for (Pair<Set<T>, Set<T>> relation : relations) {
            for (T left : relation.getLeft()) {
                for (T right : relation.getRight()) {
                    sorter.addEdge(value2Index.get(left), value2Index.get(right));
                }
            }
        }
        sorter.topo();
        return (List<T>) Arrays.asList(sorter.sortedArray);
    }
    
    private TopologicSorter(Set<T> values) {
        this.vertexList = new Object[values.size()];
        this.matrix = new int[values.size()][values.size()];
        this.numVerts = values.size();
        this.sortedArray = new Object[values.size()]; // sorted vert labels
    }
    
    private void setValue(int index, T value) {
        this.vertexList[index] = value;
    }
    
    private void addEdge(int start, int end) {
        if (this.matrix[end][start] == 1)
            throw new IllegalArgumentException("No direct cycles allowed.");
        this.matrix[start][end] = 1;
    }
    
    private void topo() // toplogical sort
    {
        while (this.numVerts > 0) // while vertices remain,
        {
            // get a vertex with no successors, or -1
            int currentVertex = this.noSuccessors();
            // insert vertex label in sorted array (start at end)
            this.sortedArray[this.numVerts - 1] = this.vertexList[currentVertex];
            
            this.deleteVertex(currentVertex); // delete vertex
        }
    }
    
    private int noSuccessors() // returns vert with no successors
    {
        boolean isEdge; // edge from row to column in adjMat
        
        for (int row = 0; row < this.numVerts; row++) {
            isEdge = false; // check edges
            for (int col = 0; col < this.numVerts; col++) {
                if (this.matrix[row][col] > 0) // if edge to another,
                {
                    isEdge = true;
                    break; // this vertex has a successor try another
                }
            }
            if (!isEdge) // if no edges, has no successors
                return row;
        }
        // no
        throw new IllegalArgumentException("No (transitive) cycles allowed.");
    }
    
    private void deleteVertex(int delVert) {
        if (delVert != this.numVerts - 1) // if not last vertex, delete from vertexList
        {
            for (int j = delVert; j < this.numVerts - 1; j++)
                this.vertexList[j] = this.vertexList[j + 1];
            
            for (int row = delVert; row < this.numVerts - 1; row++)
                this.moveRowUp(row, this.numVerts);
            
            for (int col = delVert; col < this.numVerts - 1; col++)
                this.moveColLeft(col, this.numVerts - 1);
        }
        this.numVerts--; // one less vertex
    }
    
    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++)
            this.matrix[row][col] = this.matrix[row + 1][col];
    }
    
    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++)
            this.matrix[row][col] = this.matrix[row][col + 1];
    }
    
}
