import java.util.ArrayList;

public class Node {
    public int id;
    public String name;
    public int costToRoot = 0;
    public int numberSendMessages = 0;
    public Node rootNode = this;
    public Node designatedNode = this;
    public ArrayList<Connection> connectionList = new ArrayList<>();

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Node(String[] var) {
        this.id = Integer.parseInt(var[1].replace("\"","").trim());
        this.name = var[0];
    }

    public void addConnection(Connection con){
        connectionList.add(con);
    }

    public void sendMessages(){
        for (Connection i: connectionList) {
            i.getPartner(this).processMessage(this.rootNode, this.costToRoot, i.costs, this);
        }
        this.numberSendMessages += 1;
    }
    public void processMessage(Node sendRoot, int costsRoot, int costsConnection, Node sendNode){
        if (sendRoot.id < this.rootNode.id){
            this.rootNode = sendRoot;
            this.designatedNode = sendNode;
            this.costToRoot = costsRoot + costsConnection;
        }
        else if(sendRoot.id == this.rootNode.id && this.costToRoot > costsRoot+costsConnection ){
            this.rootNode = sendRoot;
            this.designatedNode = sendNode;
            this.costToRoot = costsRoot + costsConnection;
        }
        else {
            //DO NOTHING
            }
    }
}
