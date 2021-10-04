package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MontadoraProxyTest {

    @BeforeEach
    void setUp() {
        BD.addMontadora(new Montadora(1, "Mario", "Juiz de Fora", 8.0f, 9.0f));
        BD.addMontadora(new Montadora(2, "Ivone", "Juiz de Fora", 10.0f, 10.0f));
    }

    @Test
    void deveRetornarDadosPessoaisMontadora() {
        MontadoraProxy Montadora = new MontadoraProxy(1);

        assertEquals(Arrays.asList("Mario", "Juiz de Fora"), Montadora.obterDadosPessoais());
    }

    @Test
    void deveRetonarNotasMontadora() {
        Funcionario funcionario = new Funcionario("Edit", true);
        MontadoraProxy Montadora = new MontadoraProxy(2);

        assertEquals(Arrays.asList(10.0f, 10.0f), Montadora.obterNotas(funcionario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarNotasMontadora() {
        try {
            Funcionario funcionario = new Funcionario("Julia", false);
            MontadoraProxy Montadora = new MontadoraProxy(2);

            Montadora.obterNotas(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}