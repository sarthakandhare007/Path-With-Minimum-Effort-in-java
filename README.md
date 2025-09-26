# Path-With-Minimum-Effort-in-javaProblem

You are given an m x n grid of heights.
You can move up, down, left, right.
The effort of a path = the maximum absolute height difference between two consecutive cells along the path.

Return the minimum effort required to travel from (0,0) to (m-1,n-1).


---

Example

Input: heights = [
  [1,2,2],
  [3,8,2],
  [5,3,5]
]
Output: 2

Path: (0,0)→(0,1)→(0,2)→(1,2)→(2,2)
Efforts: [1,0,0,3] → max = 3
But better path gives max = 2


---

🔹 Intuition

This is like shortest path in weighted graph, where:

Each cell is a node.

Edge weight = |height[a] - height[b]|.

We want a path minimizing the maximum edge weight along the path.


Approaches:

1. Binary Search + BFS/DFS → check feasibility for effort mid.


2. Dijkstra ✅ more efficient:

Instead of summing weights, keep track of the max edge so far.

Use a min-heap (priority queue) to always expand the path with least current effort.


