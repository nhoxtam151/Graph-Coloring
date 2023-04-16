package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


//Huynh Duc Tam -3120410459
public class Main {

  public void print(List<Node> nodes, Integer colors) {
    char[][] board = new char[nodes.size()][nodes.size()];
    System.out.println();
    System.out.println("Result board:");
    nodes.forEach(node -> System.out.print(node.name + " "));
    System.out.println();
    for (int i = 1; i <= colors; i++) {
      for(int j = 0; j < nodes.size(); j++) {
        if(nodes.get(j).color == i) {
          board[i][j] = 'x';
          System.out.print(board[i][j] + " "); // 1 x and 1 space
        } else {
          System.out.print("  "); //2 space
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    List<Node> adjacencyList = new ArrayList<>();
    Node nodeA = new Node();
    nodeA.name = 'A';
    Node nodeB = new Node();
    nodeB.name = 'B';
    Node nodeL = new Node();
    nodeL.name = 'L';
    Node nodeC = new Node();
    nodeC.name = 'C';
    Node nodeD = new Node();
    nodeD.name = 'D';
    Node nodeG = new Node();
    nodeG.name = 'G';
    Node nodeH = new Node();
    nodeH.name = 'H';
    Node nodeK = new Node();
    nodeK.name = 'K';
    Node nodeE = new Node();
    nodeE.name = 'E';
    Node nodeF = new Node();
    nodeF.name = 'F';
    Node nodeI = new Node();
    nodeI.name = 'I';
    Node nodeJ = new Node();
    nodeJ.name = 'J';

    adjacencyList.add(nodeA);
    adjacencyList.add(nodeB);
    adjacencyList.add(nodeC);
    adjacencyList.add(nodeD);
    adjacencyList.add(nodeE);
    adjacencyList.add(nodeF);
    adjacencyList.add(nodeG);
    adjacencyList.add(nodeH);
    adjacencyList.add(nodeI);
    adjacencyList.add(nodeJ);
    adjacencyList.add(nodeK);
    adjacencyList.add(nodeL);

    nodeA.neighbors.add(nodeC);
    nodeA.neighbors.add(nodeD);
    nodeA.neighbors.add(nodeG);
    nodeA.neighbors.add(nodeI);
    nodeA.neighbors.add(nodeF);

    nodeB.neighbors.add(nodeL);
    nodeB.neighbors.add(nodeH);
    nodeB.neighbors.add(nodeK);

    nodeC.neighbors.add(nodeA);
    nodeC.neighbors.add(nodeD);
    nodeC.neighbors.add(nodeG);

    nodeD.neighbors.add(nodeC);
    nodeD.neighbors.add(nodeA);
    nodeD.neighbors.add(nodeG);

    nodeG.neighbors.add(nodeA);
    nodeG.neighbors.add(nodeC);
    nodeG.neighbors.add(nodeD);

    nodeH.neighbors.add(nodeB);
    nodeH.neighbors.add(nodeL);
    nodeH.neighbors.add(nodeK);

    nodeK.neighbors.add(nodeH);
    nodeK.neighbors.add(nodeB);
    nodeK.neighbors.add(nodeL);

    nodeL.neighbors.add(nodeB);
    nodeL.neighbors.add(nodeH);
    nodeL.neighbors.add(nodeK);
    nodeL.neighbors.add(nodeE);
    nodeL.neighbors.add(nodeJ);

    nodeE.neighbors.add(nodeL);
    nodeE.neighbors.add(nodeJ);

    nodeF.neighbors.add(nodeA);
    nodeF.neighbors.add(nodeI);

    nodeI.neighbors.add(nodeF);
    nodeI.neighbors.add(nodeA);

    nodeJ.neighbors.add(nodeL);
    nodeJ.neighbors.add(nodeE);

    Main main = new Main();
    main.baiToanToMau(adjacencyList);

  }


  public void baiToanToMau(List<Node> nodes) {

    List<Node> sorted = nodes.stream().sorted(new SortCustom()).collect(Collectors.toList());

    Node firstColouredVertex = null;
    firstColouredVertex = sorted.get(0);
    firstColouredVertex.color = 1;
    int n = sorted.size();
    int color = 1;
    for (int i = 1; i < n; i++) {
      for (int j = i; j < n; j++) {
        int finalI = i;
        if (sorted.get(j).neighbors.stream().noneMatch(neighbor -> neighbor.color == finalI)
            && sorted.get(j).color == 0) {
          sorted.get(j).color = i;
          color = i;
        }
      }

    }
    sorted.forEach(
        node -> System.out.println("Coloured " + node.name + " with color " + node.color));

    print(sorted, color);
  }
}