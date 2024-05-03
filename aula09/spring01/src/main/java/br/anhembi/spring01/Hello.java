package br.anhembi.spring01;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // informa que esta classe será um controller REST
@RequestMapping("/hello") // mapeamento do 'nome do recurso'
public class Hello {

    // O método será acionado via chamada GET (http)
    @GetMapping("/{nome}/{senha}")
    public ResponseEntity<String> helloWorld(@PathVariable String nome, @PathVariable String senha) {
        if (nome.equals("Emerson") && senha.equals("1234")) {
            return ResponseEntity.ok("Bom dia! Acesso permitido."); // ok = status 200
        }
        return ResponseEntity.badRequest().build(); //badRequest = status 400
    }
}
