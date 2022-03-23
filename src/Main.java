import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DataManager dataManager = DataManager.getInstance();

        ArrayList<Node> nodeList = dataManager.nodeList;


        for (int j = 0; j < 10; j++){
            for (Node i: nodeList) {
                i.sendMessages();
            }
        }
        nodeList.get(3).sendMessages();

        for (Node i: nodeList) {
            System.out.println(i.name + " : -> " + i.designatedNode.name + " (" + i.costToRoot + ")");
        }
    }

}
