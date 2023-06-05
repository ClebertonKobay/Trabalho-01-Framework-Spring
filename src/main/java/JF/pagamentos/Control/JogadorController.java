package JF.Pagamentos.Control;

import java.util.*;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JF.Pagamentos.Model.Jogador;
import JF.Pagamentos.Repository.JogadorRepository;

@RestController
@RequestMapping("/api")
public class JogadorController {


    @Autowired
    JogadorRepository rep;

    @PostMapping("/Jogador")
    public ResponseEntity<Jogador> realizarJogador(@RequestBody Jogador jg){
        try {
            Jogador _jg = rep.save(new Jogador(jg.getNome(),jg.getEmail(),jg.getDatanasc()));

            return new ResponseEntity<>(_jg, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Jogador")
    public ResponseEntity<List<Jogador>> getJogadors(@RequestParam(required= false) String nome){
        try
        {
            List<Jogador> jg = new ArrayList<Jogador>();

            if (nome == null)
                rep.findAll();
            else 
                rep.findByNome(nome).forEach(jg::add);
            
            if (jg.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(jg, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Jogador/{id}")
    public ResponseEntity<HttpStatus> deletarJogador(@PathVariable("id") long id){
        try {
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Jogadors/{id}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable("id") long id, @RequestBody Jogador jg)
    {
        Optional<Jogador> data = rep.findById(id);

        if (data.isPresent())
        {
            Jogador jgNew = data.get();
            jgNew.setNome(jg.getNome());
            jgNew.setEmail(jg.getEmail());
            jgNew.setDatanasc(jg.getDatanasc());
            
            return new ResponseEntity<>(rep.save(jgNew), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
