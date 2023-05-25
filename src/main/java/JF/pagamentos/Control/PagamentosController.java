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
    public ResponseEntity<List<Pagamento>> getAllPagamentos(@RequestParam(required= false) short ano, short mes){
        try {
            List<Pagamento> pg = new ArrayList<Pagamento>();

            if(ano == null || mes == null){
                
            }

        } catch (Exception e) {
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


}