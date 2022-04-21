import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        DataManager dataManager = DataManager.getInstance();

        ArrayList<Node> nodeList = dataManager.nodeList;

        boolean continueLoop = true;

        int exitCriteria = 10;

        while (continueLoop){
            Random rand = new Random();
            Node sendingNode = nodeList.get(rand.nextInt(nodeList.size()));
            sendingNode.sendMessages();
            continueLoop = checkContinuing(nodeList,exitCriteria);
        }

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
