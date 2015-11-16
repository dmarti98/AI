package edu.csula.cs460.graph;

public class Node<T> implements Comparable<Node>{
    private int id;
    private T data;
    private int distance;

    public Node(int id) {
        this.id = id;
        this.data = null;
        this.distance = 9999;
    }
    public Node(int id, T data) {
        this.id = id;
        this.data = data;
    }

    public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        return getId() == node.getId();

    }

    @Override
    public String toString() {
        return "Node{" +
            "id=" + id +
            '}';
    }

    @Override
    public int hashCode() {
        return getId();
    }
    
	@Override
	public int compareTo(Node o) {
		if(this.getDistance() > o.getDistance()){
			return 1;
		}else if(this.getDistance() < o.getDistance()){
			return -1;
		}else{
			return 0;
		}		
	}
}
