package lt.viko.eif.dborkovskij.soap.model;

public class Film {
    private String name;
    private int id;
    private double score;
    private TheaterRoom theaterRoom;
    private String dateTime;
    private String about;

    public Film() {
    }

//    public Film(String name, int id, double score, TheaterRoom theaterRoom, String dateTime, String about) {
//        this.name = name;
//        this.id = id;
//        this.score = score;
//        this.theaterRoom = theaterRoom;
//        this.dateTime = dateTime;
//        this.about = about;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public TheaterRoom getTheaterRoom() {
        return theaterRoom;
    }

    public void setTheaterRoom(TheaterRoom theaterRoom) {
        this.theaterRoom = theaterRoom;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
