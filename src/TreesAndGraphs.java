import java.util.LinkedList;
import java.util.Queue;

import org.jgrapht.DirectedGraph;

public class TreesAndGraphs {
	/*
     * Problem 1
     */
	static boolean isBalanced(Node root) {
		if (root == null)
			return false;
		else
			return height(root) != -1;
	}

	static int height(Node n) {
		if (n.left == null && n.right == null) {
			return 1;
		} else {
			int h_left = 0;
			int h_right = 0;
			if (n.left != null) h_left = height(n.left);
			if (n.right != null) h_right = height(n.right);
			if (h_left == -1 || h_right == -1 || Math.abs(h_left - h_right) > 1)
				return -1;
			else
				return Math.max(h_left, h_right) + 1;
		}

	}

	/*
	 * Problem 2
	 */
	static boolean isDirectedRoute(Vertex start, Vertex end, DirectedGraph<Vertex, Edge> g) {
		for (Vertex v : g.vertexSet())
			v.visited = false;

		Vertex v;
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(start);
		while(!q.isEmpty()) {
			v = q.remove();
			for (Edge e : g.outgoingEdgesOf(v)) {
				Vertex v2 = e.v;
				if (v2 == end)
					return true;
				else
					q.add(v2);
			}
		}
		return false;
	}

	/*
	 * Default Node class
	 */
	static class Node {
		int data;
		Node left;
		Node right;
	}

	/*
	 * Default Edge & Vertex classes
	 */
	static class Vertex {
		private boolean visited;
	}

	static class Edge {
		private Vertex v;
	}
}
