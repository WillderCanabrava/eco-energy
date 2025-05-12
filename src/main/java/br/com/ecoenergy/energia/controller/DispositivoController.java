package br.com.ecoenergy.energia.controller;

import br.com.ecoenergy.energia.model.Dispositivo;
import br.com.ecoenergy.energia.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DispositivoController {

    @Autowired
    private DispositivoService service;

    @PostMapping("/dispositivos")
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo gravar (@RequestBody Dispositivo dispositivo){
        return service.gravar(dispositivo);
    }

    @GetMapping("/dispositivos")
    @ResponseStatus(HttpStatus.OK)
    public List<Dispositivo> listarTodosDispositivos(){
        return service.listarTodosDispositivos();
    }

    @DeleteMapping("/dispositivos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }


    @PutMapping("/dispositivos")
    @ResponseStatus(HttpStatus.OK)
    public Dispositivo atualizar(@RequestBody Dispositivo dispositivo){
        return service.atualizar(dispositivo);
    }

    @GetMapping("/dispositivos/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Dispositivo buscarDispositivoPorNome(@PathVariable String nome){
        return service.buscarPeloNome(nome);
    }

    @GetMapping("/dispositivos/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<Dispositivo> mostrarDispositivosAtualizados (@PathVariable LocalDate dataInicial, @PathVariable LocalDate dataFinal){
        return service.mostrarDispositivosAtualizados(dataInicial, dataFinal);
    }


}
