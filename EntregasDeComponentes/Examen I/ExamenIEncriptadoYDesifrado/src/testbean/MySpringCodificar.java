package testbean;

import codificador.Codificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Writer;


public class MySpringCodificar {
    private Codificador codificar;

    @Autowired
    public void setCodificar(Codificador pCodificar) {
        this.codificar = pCodificar;
    }

    public void run() {

        codificar.codificar();
    }
}
