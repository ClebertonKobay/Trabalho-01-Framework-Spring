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
import org.springframework.web.bind.annotation.RestController;

import JF.Pagamentos.Model.Jogador;
import JF.Pagamentos.Model.Pagamento;
import JF.Pagamentos.Repository.PagamentoRepository;
import JF.Pagamentos.Repository.JogadorRepository;

@RestController
@RequestMapping("/api")
public class PagamentosController {

    @Autowired
    PagamentoRepository repP;
    @Autowired
    JogadorRepository repJg;

    @PostMapping("/pagamentos/{id}")
    public ResponseEntity<Pagamento> realizarPagamento(@RequestBody Pagamento pg, @PathVariable long id){
        try {
            Optional<Jogador> jg = repJg.findById(id);

            pg.setJogador(jg.get());

            Pagamento _p = repP.save(new Pagamento(pg.getAno(),pg.getMes(),pg.getValor(),pg.getJogador()) );

            return new ResponseEntity<>(_p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pagamentos")
    public ResponseEntity<List<Pagamento>> getPagamentos(){
        try
        {
            List<Pagamento> pg = new ArrayList<Pagamento>();

            repP.findAll().forEach(pg::add);

            if (pg.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(pg, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pagamentos/{id}")
    public ResponseEntity<HttpStatus> deletarPagamento(@PathVariable("id") long id){
        try {
            repP.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pagamentos/{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable("id") long id, @RequestBody Pagamento pg)
    {
        Optional<Pagamento> data = repP.findById(id);

        if (data.isPresent())
        {
            Pagamento pgNew = data.get();
            pgNew.setAno(pg.getAno());
            pgNew.setMes(pg.getMes());
            pgNew.setValor(pg.getValor());
            pgNew.setJogador(pg.getJogador());

            
            return new ResponseEntity<>(repP.save(pgNew), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}