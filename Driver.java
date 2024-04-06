public class Driver {
    private final String driverName;
    private final String team;
    private final int carNumber;
    private final double lapTime;

//    constructor for all field names
    public Driver(String driverName, String team, int carNumber, double lapTime) {
        this.driverName = driverName;
        this.team = team;
        this.carNumber = carNumber;
        this.lapTime = lapTime;
    }

//    getter driverName
    public String getDriverName() {
        return driverName;
    }

//    converts to string
    @Override
    public String toString() {
        return "Driver{" +
                "Name='" + driverName + '\'' +
                ", Team=" + team +
                ", Car Number=" + carNumber +
                ", Lap Time=" + lapTime +
                '}';
    }

//    getter carNumber
    public int getCarNumber() {
        return carNumber;
    }

    public double getLapTime() {
        return lapTime;
    }
}
