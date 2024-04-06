public class TestFOne {
    public static void main(String[] args) {
//        creates all nodes with name, team, car number and lap time
        Driver maxVerstappen = new Driver("Max Verstappen", "Red Bull", 1, 1.27);
        Driver lewisHamilton = new Driver("Lewis Hamilton", "Ferrari", 44, 1.29);
        Driver landoNorris  = new Driver("Lando Norris", "Mclaren", 4, 1.28);
        Driver charlesLeclerc = new Driver("Charles Leclerc", "Ferrari", 16, 1.27);
        Driver georgeRussell = new Driver("George Russell", "Marcedes", 63, 1.28);
        Driver maxVerstappen2 = new Driver("Max Verstappen", "Red Bull", 1, 1.27);

//        assigns them to nodes
        DriverNode maxVerstappenNode = new DriverNode(maxVerstappen);
        DriverNode lewisHamiltonNode = new DriverNode(lewisHamilton);
        DriverNode landoNorrisNode = new DriverNode(landoNorris);
        DriverNode charlesLeclercNode = new DriverNode(charlesLeclerc);
        DriverNode georgeRussellNode = new DriverNode(georgeRussell);
        DriverNode maxVerstappenNode2 = new DriverNode(maxVerstappen2);

//        linking each node to each other, but not in a cycle, just linearly
        maxVerstappenNode.setNext(lewisHamiltonNode);
        lewisHamiltonNode.setNext(landoNorrisNode);
        landoNorrisNode.setNext(charlesLeclercNode);
        charlesLeclercNode.setNext(georgeRussellNode);
        georgeRussellNode.setNext(maxVerstappenNode2);

//        creates new linkedlist and inserts each node
        DriverLinkedList list = new DriverLinkedList();
        list.insertNode(maxVerstappen);
        list.insertNode(lewisHamilton);
        list.insertNode(landoNorris);
        list.insertNode(charlesLeclerc);
        list.insertNode(georgeRussell);
        list.insertNode(maxVerstappen2);

//        assigns a foundNode for each node that is searched for, can use any foundNode for testing
        DriverNode foundNode1 = list.searchNode("Max Verstappen");
        DriverNode foundNode2 = list.searchNode("Lewis Hamilton");
        DriverNode foundNode3 = list.searchNode("Lando Norris");
        DriverNode foundNode4 = list.searchNode("Charles Leclerc");
        DriverNode foundNode5 = list.searchNode("George Russell");

//        creates base list that is "referred to"
        System.out.println("List before removal:");
        list.printList();
//        returns removeAfter() method
        list.removeAfter(foundNode1);
        System.out.println("\nList after removal:");
        list.printList();
//        returns copy() method
        list.copy(foundNode1);
        System.out.println("\nList copied from Max Verstappen:");
        list.printList();
//        returns removeDuplicate() method
        list.removeDuplicate();
        System.out.println("\nList after removing duplicates:");
        list.printList();
//        returns max() method
        DriverNode headNode = list.getHead();
        int maxCarNumber = list.max(headNode);
        System.out.println("\nList after finding the max: " + maxCarNumber);
//        returns maxTwo()
        double minLapTime = list.maxTwo(headNode);
        System.out.println("\nList after finding the fastest lap: " + minLapTime);
    }
}
