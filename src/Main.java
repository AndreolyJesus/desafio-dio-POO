import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo(" curso Java");
        curso1.setDescricao("descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo(" curso JS");
        curso2.setDescricao("descrição curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria Java");
        mentoria.setDescricao("descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);

        BootCamp bootCamp = new BootCamp();
        bootCamp.setNome("BootCamp Java Develope");
        bootCamp.setDescricao("Descrição BootCamp Java Develop");
        bootCamp.getConteudos().add(curso1);
        bootCamp.getConteudos().add(curso2);
        bootCamp.getConteudos().add(mentoria);

        Dev devAndreoly = new Dev();
        devAndreoly.setNome("Andreoly");
        devAndreoly.escreverBootcamp(bootCamp);
        System.out.println("Conteudos Inscritos Andreoly:"+devAndreoly.getConteudosInscristos());
        devAndreoly.progredir();
        devAndreoly.progredir();
        devAndreoly.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos Andreoly:"+devAndreoly.getConteudosInscristos());
        System.out.println("Conteudos Concluidos Andreoly:"+devAndreoly.getConteudosConcluidos());
        System.out.println("XP"+devAndreoly.calcularTotalXp());

        System.out.println("--------------------------");

        Dev devAndre = new Dev();
        devAndre.setNome("Andre");
        devAndre.escreverBootcamp(bootCamp);
        System.out.println("Conteudos Inscritos Andre:"+devAndre.getConteudosInscristos());
        devAndre.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos Andre:"+devAndre.getConteudosInscristos());
        System.out.println("Conteudos Concluidos Andre:"+devAndre.getConteudosConcluidos());
        System.out.println("XP"+devAndre.calcularTotalXp());
    }
}
