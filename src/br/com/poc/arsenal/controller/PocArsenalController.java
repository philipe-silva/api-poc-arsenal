package br.com.poc.arsenal.controller;

import br.com.poc.arsenal.exception.ArsenalException;
import br.com.poc.arsenal.model.ArsenalModel;
import br.com.poc.arsenal.repository.ArsenalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PocArsenalController {

    protected  ArsenalRepository repository;

    public PocArsenalController(ArsenalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/allArsenal")
    public List<ArsenalModel> getAll(){
        return repository.findAll();
    }


    @PostMapping("/arsenal-register")
    public ArsenalModel newArsenal(@RequestBody ArsenalModel newArsenal) {
        return repository.save(newArsenal);
    }

    @GetMapping("/arsenal/{id}")
    public ArsenalModel one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ArsenalException(id));
    }

    @PutMapping("/arsenal/{id}")
    public ArsenalModel replaceArsenal(@RequestBody ArsenalModel arsenalModel, @PathVariable Long id) {

        return repository.findById(id)
                .map(arsenal -> {
                    arsenal.setName(arsenalModel.getName());
                    return repository.save(arsenal);
                })
                .orElseGet(() -> {
                    arsenalModel.setId(id);
                    return repository.save(arsenalModel);
                });
    }

    @DeleteMapping("/arsenal/{id}")
    public void deleteArsenal(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
