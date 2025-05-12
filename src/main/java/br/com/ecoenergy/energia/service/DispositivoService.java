package br.com.ecoenergy.energia.service;

import br.com.ecoenergy.energia.model.Dispositivo;
import br.com.ecoenergy.energia.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public Dispositivo gravar (Dispositivo dispositivo){
       return dispositivoRepository.save(dispositivo);
    }

    public Dispositivo buscarPorId(Long id){
        Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findById(id);

        if(dispositivoOptional.isPresent()){
            return dispositivoOptional.get();
        } else {
            throw new RuntimeException("Dispositivo não encontrado!");
        }
    }

    public List<Dispositivo> listarTodosDispositivos(){
       return dispositivoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findById(id);

        if(dispositivoOptional.isPresent()){
            dispositivoRepository.delete(dispositivoOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public List<Dispositivo> mostrarDispositivosAtualizados(LocalDate dataInicial, LocalDate dataFinal){
        return dispositivoRepository.findByUltimaAtualizacaoBetween(dataInicial, dataFinal);
    }

    public Dispositivo atualizar(Dispositivo dispositivo){
        Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findById(dispositivo.getId());

        if(dispositivoOptional.isPresent()){
           return dispositivoRepository.save(dispositivo);
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public Dispositivo buscarPeloNome(String nome){
         Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findByNome(nome);

         if(dispositivoOptional.isPresent()){
             return dispositivoOptional.get();
         } else {
             throw new RuntimeException("Contato não encontrado!");
         }
    }
}
