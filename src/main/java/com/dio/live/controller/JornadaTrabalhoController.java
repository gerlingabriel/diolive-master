package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return new ResponseEntity<JornadaTrabalho>(jornadaService.saveJornada(jornadaTrabalho), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> getJornadaList(){
        return new ResponseEntity<List<JornadaTrabalho>>( jornadaService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho>  getJornadaByID(@PathVariable("idJornada") Long idJornada) {
        return  ResponseEntity.ok(jornadaService.getById(idJornada));

    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok( jornadaService.updateJornada(jornadaTrabalho));
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
       try {
           jornadaService.deleteJornada(idJornada);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    return new ResponseEntity<JornadaTrabalho>(HttpStatus.NO_CONTENT);
    }

}
