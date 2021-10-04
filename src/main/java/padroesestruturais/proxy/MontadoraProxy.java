package padroesestruturais.proxy;

import java.util.List;

public class MontadoraProxy implements IMontadora {

    private Montadora Montadora;

    private Integer matricula;

    public MontadoraProxy(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.Montadora == null) {
            this.Montadora = new Montadora(this.matricula);
        }
        return this.Montadora.obterDadosPessoais();
    }

    @Override
    public List<Float> obterNotas(Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.Montadora == null) {
            this.Montadora = new Montadora(this.matricula);
        }
        return this.Montadora.obterNotas(funcionario);
    }
}
