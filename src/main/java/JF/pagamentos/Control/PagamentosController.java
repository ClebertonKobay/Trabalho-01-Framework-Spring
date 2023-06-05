package JF.pagamentos.Control;

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

import JF.pagamentos.Model.Pagamento;
import JF.pagamentos.Repository.PagamentoRepository;

@RestController
@RequestMapping("/api")
public class PagamentosController {

    @Autowired
    PagamentoRepository rep;

    @PostMapping("/pagamentos")
    public ResponseEntity<Pagamento> realizarPagamento(@RequestBody Pagamento pg){
        try {
            Pagamento _p = rep.save(new Pagamento(pg.getAno(),pg.getMes(),pg.getValor(),pg.getCod_jogador()));

            return new ResponseEntity<>(_p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pagamentos")
    public ResponseEntity<List<Pagamento>> getPagamentos(@RequestParam(required= false) int cod_jogador){
        try
        {
            List<Pagamento> pg = new ArrayList<Pagamento>();

            if (cod_jogador == 0)
                rep.findAll();
            else 
                rep.findbyJogador(cod_jogador);

            if (pg.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(pg, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pagamentos/{id}")
    public ResponseEntity<HttpStatus> deletarPagamento(@PathVariable("id") long id){
        try {
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pagamentos/{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable("id") long id, @RequestBody Pagamento pg)
    {
        Optional<Pagamento> data = rep.findById(id);

        if (data.isPresent())
        {
            Pagamento pgNew = data.get();
            pgNew.setAno(pg.getAno());
            pgNew.setMes(pg.getMes());
            pgNew.setValor(pg.getValor());
            pgNew.setCod_jogador(pg.getCod_jogador());

            
            return new ResponseEntity<>(rep.save(pgNew), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}