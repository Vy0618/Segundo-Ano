package com.devsenai2a.apidesconto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class apidescontocontroller {
    @PostMapping("/descontar")
    public Map<String,Object>descontarJson(
        @RequestParam double valor,
        @RequestParam double desconto
    ){
        
         String descontoEspecial = "";
         double resultado = 0;
         String error = null;
         boolean check = false;
            

if(valor > 0 || desconto > 0 && desconto < 50){

             resultado = valor * (desconto/100);

              if(desconto > 30){
                descontoEspecial = "Sim";
            } else{
                descontoEspecial = "Não";
            }     
       
           
} else{
    check = true;
    error = "Preço ou desconto inválido";
}

            Map<String, Object> resp = new HashMap<>();

            if (check == false){
            resp.put ("Resultado", resultado);
            resp.put ("Desconto Especial foi Aplicado?", descontoEspecial);
            } else{
                resp.put("Erro: ", error);
            }

        return resp;
    }
    
}

