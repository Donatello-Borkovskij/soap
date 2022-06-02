package lt.viko.eif.dborkovskij.soap;

import lt.viko.eif.dborkovskij.soap.model.Cinema;
import lt.viko.eif.dborkovskij.soap.model.TheaterRoom;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class TheaterRoomRepository{
    private Cinema cinema;

    public TheaterRoomRepository(Cinema cinema) {
        this.cinema = cinema;
    }

    public TheaterRoom get(int id) {
        return cinema.getTheaterRooms().stream().filter(theaterRoom -> theaterRoom.getId() == id).findFirst().orElse(null);
    }

    public List<TheaterRoom> getAll(){
        return cinema.getTheaterRooms();
    }

    public void insert(TheaterRoom theaterRoom){
        cinema.getTheaterRooms().add(theaterRoom);
    }

    public void update(TheaterRoom theaterRoom){
        TheaterRoom theaterRoom1 = this.get(theaterRoom.getId());
        Integer integer = cinema.getTheaterRooms().indexOf(theaterRoom1);
        cinema.getTheaterRooms().set(integer,theaterRoom);
    }

    public void delete(Integer id){
        cinema.getTheaterRooms().remove(this.get(id));
    }
}
