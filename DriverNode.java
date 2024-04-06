public class DriverNode {
    private final Driver driver;
    private DriverNode next;

//    constructor for nodes
    public DriverNode(Driver driver) {
        this.driver = driver;
        this.next = null;
    }

//    getters and setters for driver and drivernode
    public Driver getDriver() {
        return driver;
    }

    public DriverNode getNext() {
        return next;
    }

    public void setNext(DriverNode next) {
        this.next = next;
    }
}
