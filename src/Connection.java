public class Connection {
    public Node nodeA;
    public Node nodeB;
    public int costs;

    public Connection(Node nodeA, Node nodeB, int costs) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.costs = costs;

        nodeA.addConnection(this);
        nodeB.addConnection(this);
    }

    public Node getPartner(Node partner){
        if (nodeA.id == partner.id) return nodeB;
        else return nodeA;
    }
}
