package lt.viko.eif.dborkovskij.soap.model;

public class TheaterRoom {
    private int id;
    private int numberOfSeats;

    public TheaterRoom() {
    }

    public TheaterRoom(int id) {
        this.id = id;
        this.numberOfSeats = 300;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
