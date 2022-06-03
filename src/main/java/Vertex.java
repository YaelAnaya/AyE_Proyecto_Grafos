
import java.util.LinkedList;
import java.util.List;

public class Vertex <T>{
    private T value;
    private List<Vertex<T>> adjacent;
    private boolean visited;
    private int vertex_ID;
    private int degree;

    public Vertex(T value){
        this.value = value;
        this.adjacent = new LinkedList<>();
        this.visited = false;
    }

    public Vertex(T value, int vertex_ID){
        this.value = value;
        this.vertex_ID = vertex_ID;
        this.adjacent = new LinkedList<>();
    }

    public T getValue(){
        return this.value;
    }

    public boolean isVisited(){
        return this.visited;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public void addAdjacent(Vertex<T> vertex){
        if (!this.adjacent.contains(vertex))
            this.adjacent.add(vertex);
    }

    public List<Vertex<T>> getAdjacent(){
        return this.adjacent;
    }

    public String toString(){
        return this.value.toString();
    }

}
