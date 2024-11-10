package pt.iade.ei.thinktoilet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.ei.thinktoilet.models.Toilet;
import pt.iade.ei.thinktoilet.models.repositories.ToiletRepository;

@RestController
@RequestMapping(path = "/api/toilets")
public class ToiletController {
    private Logger logger = LoggerFactory.getLogger(ToiletController.class);
    @Autowired
    private ToiletRepository toiletRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Toilet> getToilets() {
        logger.info("Sending all toilets");
        return toiletRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Toilet> getToilet(@PathVariable int id) {
        logger.info("Sending toilet with id "+id);
        return toiletRepository.findById(id);
    }


}
