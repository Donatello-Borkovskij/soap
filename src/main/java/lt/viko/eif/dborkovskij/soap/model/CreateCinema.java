package lt.viko.eif.dborkovskij.soap.model;

import java.util.ArrayList;
import java.util.List;

public class CreateCinema {

    public static Cinema generateCinema(){
        Cinema cinema = new Cinema();
        cinema.setTheaterRooms(generateTheaterRooms());
        cinema.setFilms(generateFilms(cinema.getTheaterRooms()));//cinema.setFilms(generateFilms());

        return cinema;
    }

    public static List<Film> generateFilms(List<TheaterRoom> theaterRooms){
        List<Film> films = new ArrayList<>();

        Film film1 = new Film();
        film1.setId(1);
        film1.setName("Dune");
        film1.setScore(8);
        film1.setTheaterRoom(theaterRooms.get(1)); //new TheaterRoom(1)
        film1.setDateTime("1-1-1");
        film1.setAbout("About1");

        Film film2 = new Film();
        film1.setId(2);
        film1.setName("Spider-Man: No Way Home");
        film1.setScore(8);
        film1.setTheaterRoom(theaterRooms.get(1));
        film1.setDateTime("2-3-4");
        film1.setAbout("About2");

        Film film3 = new Film();
        film1.setId(2);
        film1.setName("Shrek");
        film1.setScore(12);
        film1.setTheaterRoom(theaterRooms.get(1));
        film1.setDateTime("3-4-5");
        film1.setAbout("About3");

        films.add(film1);
        films.add(film2);
        films.add(film3);

        return films;
    }

    public static List<TheaterRoom> generateTheaterRooms(){
        List<TheaterRoom> theaterRooms = new ArrayList<>();

        TheaterRoom theaterRoom1= new TheaterRoom();
        theaterRoom1.setId(1);
        theaterRoom1.setNumberOfSeats(300);
        TheaterRoom theaterRoom2= new TheaterRoom();
        theaterRoom2.setId(2);
        theaterRoom2.setNumberOfSeats(300);
        TheaterRoom theaterRoom3= new TheaterRoom();
        theaterRoom3.setId(3);
        theaterRoom3.setNumberOfSeats(300);

        theaterRooms.add(theaterRoom1);
        theaterRooms.add(theaterRoom2);
        theaterRooms.add(theaterRoom3);

        return theaterRooms;
    }
}
