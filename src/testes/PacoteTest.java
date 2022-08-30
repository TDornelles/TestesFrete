package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import pacotes.Pacote;


class PacoteTest {

    @Test
    void testPositivo() {
        //massa de dados de valores positivos
        HashMap<Pacote, Double> massa = new HashMap<>();

        //preencher massa de dados
        massa.put(new Pacote(' ','A',' ',10), 30.0);
        massa.put(new Pacote(' ','A',' ',20), 60.0);
        massa.put(new Pacote(' ','A',' ',50), 100.0);
        massa.put(new Pacote('L','S','E',10), 20.0);
        massa.put(new Pacote('L','S','N',20), 40.0);
        massa.put(new Pacote('L','S','E',30), 60.0);
        massa.put(new Pacote('F','S','E',10), 20.0);
        massa.put(new Pacote('F','S','E',20), 40.0);
        massa.put(new Pacote('F','S','E',30), 90.0);
        massa.put(new Pacote('F','S','N',10), 20.0);
        massa.put(new Pacote('F','S','N',20), 40.0);
        massa.put(new Pacote('F','S','N',30), 60.0);

        //processamento com foreach
        massa.forEach((pacote, freteEsperado) -> assertEquals(freteEsperado, pacote.calcularFrete()));
    }

    @Test
    void testNegativo() {
    //cod erro tipo de entrega esta errado na classe

        //massa de dados de valores negativos
        HashMap<Pacote, Double> massa = new HashMap<>();

        massa.put(new Pacote('L','S','H',10), -4d);
        massa.put(new Pacote(' ','K',' ',20), -3d);
        massa.put(new Pacote('Y','S','E',10), -2d);
        massa.put(new Pacote('F','A','N','a'), -1d);
        massa.put(new Pacote('L','S','E',-10), -1d);
        massa.put(new Pacote('L','S','E',20), 40.0);
        massa.put(new Pacote('L','S','E',20.8), 41.6);

        //processamento com foreach
        massa.forEach((pacote, freteEsperado) -> assertEquals(freteEsperado, pacote.calcularFrete()));
    }

    @Test
    void testLimites() {
        //massa de dados de valores positivos
        HashMap<Pacote, Double> massa = new HashMap<>();

        //preencher massa de dados
        massa.put(new Pacote(' ','A',' ',0.01), 6.0);
        massa.put(new Pacote(' ','A',' ',1.99), 6.0);
        massa.put(new Pacote(' ','A',' ',2.01), 6.03);
        massa.put(new Pacote(' ','A',' ',19.99), 59.97);
        massa.put(new Pacote(' ','A',' ',20.01), 40.02);
        massa.put(new Pacote('L','S','E',19.99), 39.98);
        massa.put(new Pacote('L','S','E',20.01), 40.02);

        //processamento com foreach
        massa.forEach((pacote, freteEsperado) -> assertEquals(freteEsperado, pacote.calcularFrete()));
    }

}