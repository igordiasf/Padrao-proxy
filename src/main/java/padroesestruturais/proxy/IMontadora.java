package padroesestruturais.proxy;

import java.util.List;

public interface IMontadora {
    List<String> obterDadosPessoais();
    List<Float> obterNotas(Funcionario funcionario);
}
