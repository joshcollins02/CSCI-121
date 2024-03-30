public class Patient {
//    creating objects ID, age, and bloodData that calls from BloodData
    private int ID;
    private int age;
    private BloodData bloodData;

//    constructor that gives default values
    public Patient() {
        ID = 0;
        age = 0;
        bloodData = new BloodData();
    }

//    overriding constructor that calls ID age and bloodData objects as user inputs
    public Patient(int ID, int age, BloodData bloodData) {
        this.ID = ID;
        this.age = age;
        this.bloodData = bloodData;
    }

//    getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BloodData getBloodData() {
        return bloodData;
    }

    public void setBloodData(BloodData bloodData) {
        this.bloodData = bloodData;
    }
}
