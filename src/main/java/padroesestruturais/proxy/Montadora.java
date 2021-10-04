package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Montadora implements IMontadora {

    private Integer matricula;
    private String nome;
    private String cidade;
    private Float nota1;
    private Float nota2;

    public Montadora(int matricula) {
        this.matricula = matricula;
        Montadora objeto = BD.getMontadora(matricula);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.nota1 = objeto.nota1;
        this.nota2 = objeto.nota2;
    }

    public Montadora(Integer matricula, String nome, String cidade, Float nota1, Float nota2) {
        this.matricula = matricula;
        this.nome = nome;
        this.cidade = cidade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Integer getMatricula() {
        return matricula;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterNotas(Funcionario funcionario) {
        return Arrays.asList(this.nota1, this.nota2);
    }
}
