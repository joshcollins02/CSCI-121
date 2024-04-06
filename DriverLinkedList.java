public class DriverLinkedList {
    private DriverNode head;
    private DriverNode tail;

//    sets head and tail to default
    public DriverLinkedList() {
        head = null;
        tail = null;
    }

//    insert node taken from notes
    public void insertNode(Driver driver) {
        DriverNode node = new DriverNode(driver);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

//    search node taken from notes, checks links between nodes
    public DriverNode searchNode(String driverName){
        DriverNode current = head;
        if(!current.getDriver().getDriverName().equals(driverName)) {
            while (current.getNext() != null) {
                String sname = current.getNext().getDriver().getDriverName();
                if (sname.equals(driverName)) {
                    System.out.println("Prev Node => " + current.getDriver().getDriverName());
                    System.out.println("Current Node => " + current.getNext().getDriver().getDriverName());
                    if (current.getNext().getNext() != null) {
                        System.out.println("Next Node => " + current.getNext().getNext().getDriver().getDriverName());
                    } else {
                        System.out.println("Next Node => null");
                    }
                    return current.getNext();
                } else {
                    current = current.getNext();
                }
            }
        }
        return current;
    }

    public void removeAfter(DriverNode driverName) {
//        returns after checking driverName field is null OR linked driverName field is null
        if (driverName == null || driverName.getNext() == null) {
//            if head is not null then it will continue through linkedlist
            if (head != null)
                head = head.getNext();
            return;
        }
//        assigns d to driverName
        String d = driverName.getDriver().getDriverName();
//        sets current as head of node
        DriverNode current = head;
//        when current is not null AND current driverName is true then it will iterate through list
        while (current != null && !current.getDriver().getDriverName().equals(d)) {
            current = current.getNext();
        }
//        when current is null OR the next current is null OR current driverName is true then it will return empty
        if (current == null || current.getNext() == null || !current.getDriver().getDriverName().equals(d))
            return;
//        nextNode is assigned to the next node
        DriverNode nextNode = current.getNext();
//        when nextNode is not null it will remove it
        if (nextNode != null) {
            current.setNext(nextNode.getNext());
        }
    }

    public void copy(DriverNode driverName) {
//        assigns d to a new DriverLinkedList
        DriverLinkedList d = new DriverLinkedList();
//        returns after checking if driverName field is null OR linked driverName field is null
        if (driverName == null || driverName.getNext() == null) {
            return;
        }
//        sets current as driverName in the node
        DriverNode current = driverName;
//        checks to see if current node contains something
        while (current != null) {
//            returns new linked list from specified node
            d.insertNode(current.getDriver());
            current = current.getNext();
        }
    }

    public void removeDuplicate() {
//        checks if list has a node
        if (head == null || head.getNext() == null) {
            return;
        }
//        sets head of node to current in the node
        DriverNode current = head;
//        checks to see if current node contains something
        while (current != null) {
            DriverNode d = current;
//            if duplicate node is not null in the field name, then it will remove it by bypassing it
            while (d.getNext() != null) {
                if (current.getDriver().getDriverName().equals(d.getNext().getDriver().getDriverName())) {
                d.setNext(d.getNext().getNext());
                } else {
                    d = d.getNext();
                }
            }
//            return statement
            current = current.getNext();
        }
    }

//    take the max integer of the carNumber field in the LinkedList and return it from the node
    public int max(DriverNode carNumber) {
//        if null then it will return 0
        if (carNumber == null) {
            return 0 ;
        }
//        largest int
        int largest = carNumber.getDriver().getCarNumber();
//        while carNumber field is not null, will search for largest integer
        while (carNumber != null) {
            if (carNumber.getDriver().getCarNumber() > largest) {
                largest = carNumber.getDriver().getCarNumber();
            }
            carNumber = carNumber.getNext();
        }
//        return statement
        return largest;
    }

//    creativity:
//    legit the same thing but I wanted to do it for fastest lap time as it makes sense to see who's the fastest
//    Dun Dun Dun Dun... MAX VERSTAPPEN!
    public double maxTwo(DriverNode lapTime) {
        if (lapTime == null) {
            return 0;
        }
        double smallest = lapTime.getDriver().getLapTime();
        while (lapTime != null) {
            if (lapTime.getDriver().getLapTime() < smallest) {
                smallest = lapTime.getDriver().getLapTime();
            }
            lapTime = lapTime.getNext();
        }
        return smallest;
    }

//    print list taken from notes
    public void printList(){
        DriverNode current = head;
        System.out.println("========Print Start=============");
        System.out.println(current.getDriver().getDriverName());
        while(current.getNext() != null){
            System.out.println(current.getNext().getDriver().getDriverName());
            current = current.getNext();
        }
        System.out.println("========Print End=============");
    }

//    get method called for max() method
    public DriverNode getHead() {
        return head;
    }
}
