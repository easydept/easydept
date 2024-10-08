package com.easydept.edbackend.controllers;

import com.easydept.edbackend.entity.Edificio;
import com.easydept.edbackend.services.EdificiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/edificios")
public class EdificiosController {

    @Autowired
    private EdificiosService edificiosService;

    @PostMapping
    public Edificio createEdificio(@RequestBody Edificio edificio) {
        return edificiosService.saveEdificio(edificio);
    }

    @GetMapping
    public List<Edificio> getEdificios() {
        return this.edificiosService.getAllEdificios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edificio> getEdificioById(@PathVariable Integer id) {
        Optional<Edificio> edificio = edificiosService.getEdificioById(id);
        return edificio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEdificioById(@PathVariable Integer id) {
        edificiosService.deleteEdificioById(id);
        return ResponseEntity.noContent().build();
    }

}

