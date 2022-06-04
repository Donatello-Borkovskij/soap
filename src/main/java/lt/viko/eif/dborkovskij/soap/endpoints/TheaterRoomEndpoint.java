package lt.viko.eif.dborkovskij.soap.endpoints;

import lt.viko.eif.dborkovskij.soap.localhost.cinema.theaterroom.*;
import lt.viko.eif.dborkovskij.soap.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TheaterRoomEndpoint {
    private static final String URI = "http://localhost/cinema/theaterRoom";
    @Autowired
    private FilmService filmService;

    public TheaterRoomEndpoint(FilmService filmService) {
        this.filmService = filmService;
    }

    @PayloadRoot(namespace = URI, localPart = "getTheaterRoomRequest")
    @ResponsePayload
    public GetTheaterRoomResponse getTheaterRoom(@RequestPayload GetTheaterRoomRequest request){
        GetTheaterRoomResponse response = new GetTheaterRoomResponse();
        response.setTheaterRoom(filmService.theaterRoomRepository.get(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "getTheaterRoomsRequest")
    @ResponsePayload
    public GetTheaterRoomsResponse getTheaterRoomsResponse(@RequestPayload GetTheaterRoomsRequest request){
        GetTheaterRoomsResponse response = new GetTheaterRoomsResponse();
        response.getTheaterRooms().addAll(filmService.theaterRoomRepository.getAll());
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "insertTheaterRoomRequest")
    @ResponsePayload
    public InsertTheaterRoomResponse insertTheaterRoom(@RequestPayload InsertTheaterRoomRequest request){
        filmService.theaterRoomRepository.insert(request.getTheaterRoom());
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("201");
        serviceStatus.setMessage("TheaterRoom was inserted");
        InsertTheaterRoomResponse response = new InsertTheaterRoomResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "updateTheaterRoomRequest")
    @ResponsePayload
    public UpdateTheaterRoomResponse updateTheaterRoomResponse(@RequestPayload UpdateTheaterRoomRequest request){
        filmService.theaterRoomRepository.update(request.getTheaterRoom());
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("204");
        serviceStatus.setMessage("TheaterRoom was updated");
        UpdateTheaterRoomResponse response = new UpdateTheaterRoomResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "deleteTheaterRoomRequest")
    @ResponsePayload
    public DeleteTheaterRoomResponse deleteTheaterRoomResponse(@RequestPayload DeleteTheaterRoomRequest request){
        filmService.theaterRoomRepository.delete(request.getId());
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("204");
        serviceStatus.setMessage("TheaterRoom was deleted");
        DeleteTheaterRoomResponse response = new DeleteTheaterRoomResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
