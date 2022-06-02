package lt.viko.eif.dborkovskij.soap;

import lt.viko.eif.dborkovskij.soap.model.Cinema;
import lt.viko.eif.dborkovskij.soap.model.Film;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmRepository{
    private Cinema cinema;

    public FilmRepository(Cinema cinema) {
        this.cinema = cinema;
    }

    public Film get(Integer id){
        return cinema.getFilms().stream().filter(film -> film.getId() == id).findFirst().orElse(null);//cinema.getFilms().stream().filter(film -> film.getId() == id).findFirst().orElse(null)
    }

    public List<Film> getAll(){
        return cinema.getFilms();
    }

    public void insert(Film film){
        cinema.getFilms().add(film);
    }

    public void update(Film film){
        Film film1 = this.get(film.getId());
        Integer integer = cinema.getFilms().indexOf(film1);
        cinema.getFilms().set(integer,film);
    }

    public void delete(Integer id){
        cinema.getFilms().remove(this.get(id));
    }
}
