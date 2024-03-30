//creating enumerators for blood group and rh factor
enum BloodGroup {
    O,
    A,
    B,
    AB
}
enum Rh_Factor {
    POSITIVE,
    NEGATIVE
}


public class BloodData {
//    creating objects bg and rh
    private BloodGroup bg;
    private Rh_Factor rh;

//    creating constructor that gives default values if none are called
    public BloodData() {
        this.bg = BloodGroup.O;
        this.rh = Rh_Factor.POSITIVE;
    }

//    creating overriding constructor that calls bg and rh objects as input values
    public BloodData(String bg, String rh) {
        this.bg = BloodGroup.valueOf(bg);
        this.rh = Rh_Factor.valueOf(rh);
    }

//    getters and setters
    public BloodGroup getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = BloodGroup.valueOf(bg);
    }

    public Rh_Factor getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = Rh_Factor.valueOf(rh);
    }

//    creativity, if patients can donate blood to each other, only O can donate to O, but O can donate to everyone,
//    so when I set it up later in TestPatient I made it user donates
//    since there's a chance of it being false rather than always true
    public boolean canDonate(BloodGroup next) {
        return this.bg == BloodGroup.O || this.bg == next ||
                (this.bg == BloodGroup.AB && this.rh == Rh_Factor.POSITIVE && next != BloodGroup.O);
    }
}