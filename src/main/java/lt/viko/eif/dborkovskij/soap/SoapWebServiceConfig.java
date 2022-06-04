package lt.viko.eif.dborkovskij.soap;

import lt.viko.eif.dborkovskij.soap.model.Cinema;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration  //extends WsConfigurerAdapter
public class SoapWebServiceConfig {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/soapWS/*");
    }

    @Bean(name = "films")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema filmsSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("FilmsPort");
        definition.setTargetNamespace("http://localhost/cinema/film");
        definition.setSchema(filmsSchema);
        return definition;
    }

    @Bean(name = "theaterRooms")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema theaterRoomsSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("TheaterRoomsPort");
        definition.setTargetNamespace("http://localhost/cinema/theaterRoom");
        definition.setSchema(theaterRoomsSchema);
        return definition;
    }

    @Bean
    public XsdSchema filmsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("film.xsd"));
    }

    @Bean
    public XsdSchema theaterRoomsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("theaterRoom.xsd"));
    }

    @Bean
    public FilmService filmService(){
        return new FilmService();
    }

    @Bean
    public Cinema cinema(){
        return new Cinema();
    }
}
