package lt.viko.eif.dborkovskij.soap.endpoints;

import lt.viko.eif.dborkovskij.soap.localhost.cinema.film.*;
import lt.viko.eif.dborkovskij.soap.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FilmEndpoint {
    private static final String URI = "http://localhost/cinema/film";

    private final FilmService filmService;

    @Autowired
    public FilmEndpoint(FilmService filmService) {
        this.filmService = filmService;
    }

    @PayloadRoot(namespace = URI, localPart = "getFilmRequest")
    @ResponsePayload
    public GetFilmResponse getFilm(@RequestPayload GetFilmRequest request){
        GetFilmResponse response = new GetFilmResponse();
        response.setFilm(filmService.filmRepository.get(request.getId()));//filmService.filmRepository.get(request.getId())
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "getFilmsRequest")
    @ResponsePayload
    public GetFilmsResponse getFilms(@RequestPayload GetFilmsRequest request){
        GetFilmsResponse response = new GetFilmsResponse();
        response.getFilms().addAll(filmService.filmRepository.getAll());
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "insertFilmRequest")
    @ResponsePayload
    public InsertFilmResponse filmResponse(@RequestPayload InsertFilmRequest request){
        filmService.filmRepository.insert(request.getFilm());
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("201");
        serviceStatus.setMessage("Film was inserted");
        InsertFilmResponse response = new InsertFilmResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "updateFilmRequest")
    @ResponsePayload
    public UpdateFilmResponse updateFilmResponse(@RequestPayload UpdateFilmRequest request){
        filmService.filmRepository.update(request.getFilm());
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("204");
        serviceStatus.setMessage("Film was updated");
        UpdateFilmResponse response = new UpdateFilmResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = URI, localPart = "deleteFilmRequest")
    @ResponsePayload
    public DeleteFilmResponse deleteFilmResponse(@RequestPayload DeleteFilmRequest request){
        filmService.filmRepository.delete(request.getId());
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("204");
        serviceStatus.setMessage("Film was deleted");
        DeleteFilmResponse response = new DeleteFilmResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
