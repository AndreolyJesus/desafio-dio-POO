package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscristos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void escreverBootcamp (BootCamp bootCamp){
        this.conteudosInscristos.addAll(bootCamp.getConteudos());
        bootCamp.getDevsInscrintos().add(this);                                          //<----Pegando tudo de dentro de conteudos e add em inscritos.
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscristos.stream().findFirst();
       if(conteudo.isPresent()) {
         this.conteudosConcluidos.add(conteudo.get());
         this.conteudosInscristos.remove(conteudo.get());                                //<----Colocando conteudo dos inscritos em comcluido.
       }else {
           System.err.println("Você não está matriculado em nenhum conteudo.");
       }
    }


    public double calcularTotalXp(){
        return  this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscristos() {
        return conteudosInscristos;
    }

    public void setConteudosInscristos(Set<Conteudo> conteudosInscristos) {
        this.conteudosInscristos = conteudosInscristos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscristos, dev.conteudosInscristos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscristos, conteudosConcluidos);
    }
}
