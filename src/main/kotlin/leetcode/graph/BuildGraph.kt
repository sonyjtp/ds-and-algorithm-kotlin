package leetcode.graph

// from array of edges
fun buildGraph(edges: List<List<Int>>)= edges.associate { Pair(it[0], it[1])}

// from adjacency list

