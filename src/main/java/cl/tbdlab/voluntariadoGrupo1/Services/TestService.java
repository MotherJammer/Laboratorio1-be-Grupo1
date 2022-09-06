package cl.tbdlab.voluntariadoGrupo1.Services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @RequestMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }
}
