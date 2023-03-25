package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {


  public void baiToanToMau(List<Node> nodes) {

   List<Node> sorted = nodes.stream().sorted(new SortCustom()).collect(Collectors.toList());
   List<Node> colored = new ArrayList<>();
   Node firstVertex = sorted.get(0);
   firstVertex.color = 1;
   colored.add(firstVertex);
   sorted.remove(firstVertex);

   for(Node node : sorted) {

     if(!node.neighbors.contains(firstVertex) && !colored.contains(node)) {
       System.out.println(node.color);
       colored.add(node);
       //sorted.remove(node); have to remove outside
     }

   }
//   return nodes.stream().skip(1).filter(node -> !node.neighbors.contains(node.color != 0));

  }


  public static void main(String[] args) {

    List<Integer> colors = new ArrayList<>();
    colors.add(1);
    colors.add(2);
    colors.add(3);
    colors.add(4);
    colors.add(5);

    List<Node> adjacencyList = new ArrayList<>();
    Node nodeA = new Node();
    Node nodeB = new Node();
    Node nodeL = new Node();
    Node nodeC = new Node();
    Node nodeD = new Node();
    Node nodeG = new Node();
    Node nodeH = new Node();
    Node nodeK = new Node();
    Node nodeE = new Node();
    Node nodeF = new Node();
    Node nodeI = new Node();
    Node nodeJ = new Node();

    adjacencyList.add(nodeA);
    adjacencyList.add(nodeB);
    adjacencyList.add(nodeC);
    adjacencyList.add(nodeD);
    adjacencyList.add(nodeE);
    adjacencyList.add(nodeF);
    adjacencyList.add(nodeJ);
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

    nodeJ.neighbors.add(nodeL);
    nodeJ.neighbors.add(nodeE);

    Main main = new Main();
    main.baiToanToMau(adjacencyList);

  }
}