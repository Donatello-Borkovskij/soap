package lt.viko.eif.dborkovskij.soap;

import lt.viko.eif.dborkovskij.soap.model.Cinema;
import lt.viko.eif.dborkovskij.soap.model.CreateCinema;

public class FilmService {
    private Cinema cinema = CreateCinema.generateCinema();

    public FilmRepository filmRepository = new FilmRepository(cinema);
    public TheaterRoomRepository theaterRoomRepository= new TheaterRoomRepository(cinema);
}
