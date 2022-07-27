package br.com.zup.edu.notafiscal.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping("/api/email")
    public ResponseEntity<?> enviar(){

//        emailService.sendEmail();
//        System.out.println("Chegou aqui");
        return ResponseEntity.noContent().build();
    }

}
