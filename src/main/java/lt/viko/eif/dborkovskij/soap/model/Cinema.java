package lt.viko.eif.dborkovskij.soap.model;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Film> films = new ArrayList<>();
    private List<TheaterRoom> theaterRooms = new ArrayList<>();

    public Cinema() {
    }

//    public Cinema(int x) {
////        for (int i = 1;i<x;i++){
////            this.theaterRooms.add(new TheaterRoom(i));
////        }
//        this.theaterRooms.add(new TheaterRoom(1));
//        this.theaterRooms.add(new TheaterRoom(2));
//        this.theaterRooms.add(new TheaterRoom(3));
//
//        this.films.add(new Film("Dune",1,8,new TheaterRoom(1),"1-1-1","About1"));
//        this.films.add(new Film("Spider-Man: No Way Home",2,8,new TheaterRoom(2),"2-3-4","About2"));
//        this.films.add(new Film("shrek",3,12,new TheaterRoom(3),"3-4-5","About3"));
//    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<TheaterRoom> getTheaterRooms() {
        return theaterRooms;
    }

    public void setTheaterRooms(List<TheaterRoom> theaterRooms) {
        this.theaterRooms = theaterRooms;
    }
}
