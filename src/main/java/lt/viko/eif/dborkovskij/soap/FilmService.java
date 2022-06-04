package lt.viko.eif.dborkovskij.soap;

import lt.viko.eif.dborkovskij.soap.model.Cinema;

public class FilmService {
    private Cinema cinema = new Cinema(1);//CreateCinema.generateCinema();

    public FilmRepository filmRepository = new FilmRepository(cinema);
    public TheaterRoomRepository theaterRoomRepository= new TheaterRoomRepository(cinema);
}
