package com.devsenai2a.apintoaaluno;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApintoaalunoController {
    @PostMapping("/calcular")
   public Map <String, Object>calcularJson(
    @RequestParam double nota1,
    @RequestParam double nota2,
    @RequestParam double nota3,
    @RequestParam double nota4,
    @RequestParam String nome
){

    String status = "";
    


   if (nota1 < 0 || nota2 < 0 || nota3 < 0 || nota4 < 0) {

            Map<String, Object> error = new HashMap<>();
            error.put("erro", "As notas não podem ser negativas");
            return error;

        } else{

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

       if (media > 7){
        status = "aprovado";
       }
       if (media >= 5 && media<= 7){
        status = "recuperacao";
       }
       if (media < 5){
        status = "reprovado";
       }


         Map<String, Object> resp = new LinkedHashMap<>();
        resp.put("Nome do Aluno: ", nome);
        resp.put("Nota 1: ", nota1);
        resp.put("Nota 2: ", nota2);
        resp.put("Nota 3: ", nota3);
        resp.put("Nota 4: ", nota4);
        resp.put("Média", media);
        resp.put("Status", status);
        return resp;


      }
   }
}
