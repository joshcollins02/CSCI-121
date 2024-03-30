import java.util.Scanner;
public class TestPatient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//creating three objects, one that you input your own values, two that you input your own patient values and takes the default BloodData values, and three that takes all default values
        Patient one = new Patient();
        Patient userPatient;
        Patient defaultDataPatient;
        try {
            System.out.println("Please enter Patient ID: ");
            int ID = sc.nextInt();
            System.out.println("Please enter Patient age: ");
            int age = sc.nextInt();
            System.out.println("Please enter Patient blood type: ");
            String bloodType = sc.next();
            System.out.println("Please enter Patient rh factor: ");
            String rhFactor = sc.next();

            userPatient = new Patient(ID, age, new BloodData(bloodType, rhFactor));

            defaultDataPatient = new Patient();
            System.out.println("Please enter Patient ID: ");
            int bloodID = sc.nextInt();
            System.out.println("Please enter Patient age: ");
            int bloodAge = sc.nextInt();
            defaultDataPatient.setID(bloodID);
            defaultDataPatient.setAge(bloodAge);

            System.out.println("Default Patient: ");
            displayPatient(one);
            System.out.println("\nUser Patient: ");
            displayPatient(userPatient);
            System.out.println("\nDefault Data Patient: ");
            displayPatient(defaultDataPatient);
//            creativity, only O bloodtypes can donate to O, so it will be false unless the bloodtype is O
            System.out.println("\nUser Patient can donate to Default Data Patient: " + userPatient.getBloodData().canDonate(defaultDataPatient.getBloodData().getBg()));

        } catch (Exception e) {
//            if the input is mismatched the exception will catch it
            System.out.println("Error: It shouldn't be what you put, FIX IT!");
        }
        sc.close();
    }

//    function that is called to display all the information once you finish using the scanner
    private static void displayPatient(Patient patient) {
        System.out.println("Patient ID: " + patient.getID());
        System.out.println("Patient Age: " + patient.getAge());
        System.out.println("Patient Blood Type: " + patient.getBloodData().getBg());
        System.out.println("Patient Rh Factor: " + patient.getBloodData().getRh());
    }
}
