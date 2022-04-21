/*
Spanning Tree Projekt
erstellt von: Benjamin Arp 8961416
fertiggestelt am: 21.04.2022
Beschreibung: Simulation der Erstellung Spanning Trees
 */


import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        DataManager dataManager = DataManager.getInstance();

        ArrayList<Node> nodeList = dataManager.nodeList;

        boolean continueLoop = true;

        //get the user Input from program argument

        int exitCriteria;
        try {
            exitCriteria = Integer.parseInt(args[0]);
        }catch (Exception e){
            exitCriteria = 10;
        }

        //calculate the Spanning Tree

        while (continueLoop){
            Random rand = new Random();
            Node sendingNode = nodeList.get(rand.nextInt(nodeList.size()));
            sendingNode.sendMessages();
            continueLoop = checkContinuing(nodeList,exitCriteria);
        }

        //Print out result to terminal

        var root = getRoot(nodeList);
        System.out.println("Root: " + root.name);

        for (Node i: nodeList) {
            if (i.name.equals(i.rootNode.name)){
                continue;
            }
            System.out.println(i.name + " -> " + i.designatedNode.name + " (" + i.costToRoot + ")");
        }
    }



    public static Node getRoot(ArrayList<Node> nodeList){
        for(Node i: nodeList){
            if(i.name.equals(i.rootNode.name)){
                return i;
            }
        }
        //if no root was defined what should not happen return first Node
        return nodeList.get(0);
    }

    public static boolean checkContinuing(ArrayList<Node> nodeList, int exitCriteria){
        for(Node i: nodeList){
            if(i.numberSendMessages < exitCriteria){
                return true;
            }
        }
        //else exit loop
        return false;
    }

}
