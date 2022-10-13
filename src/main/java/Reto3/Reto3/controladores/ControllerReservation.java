package Reto3.Reto3.controladores;

import Reto3.Reto3.entidades.Reservation;
import Reto3.Reto3.servicios.ServiceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ControllerReservation {
    @Autowired
    private ServiceReservation sr;

    @GetMapping("/all")
    public List<Reservation> getReservationAll(){
        return sr.allReservation();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation insertReservation(@RequestBody Reservation res) {
        return sr.saveReservation(res);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation res){
        return sr.updateReservation(res);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@RequestBody Reservation res){
        sr.deleteReservation(res);
    }

    @GetMapping("/{doc}")
    public Reservation findReservationById(@PathVariable("doc")int doc){
        return sr.findReservationById(doc);
    }

    @DeleteMapping("/{doc}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservationById(@PathVariable("doc") int doc){
        sr.deleteReservationById(doc);
    }
}
