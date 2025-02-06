import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {


    @Test
    void deveAdicionarTurmaNaoPresente(){
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Curso c = new Curso();
        c.addTurma(t);
        assertTrue(c.turmaIsPresent(t));
    }

    @Test
    void naoDeveAdicionarTurmaPresente(){
        try{
            Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
            Curso c = new Curso();
            c.addTurma(t);
            c.addTurma(t);
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("Turma ja esta cadastrada", e.getMessage());
        }
    }

    @Test
    void deveRemoverTurma(){
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Curso c = new Curso();
        c.addTurma(t);
        c.removeTurma(t);
        assertFalse(c.turmaIsPresent(t)); //aqui tb e verificado o isPresente para nao presente
    }

    @Test
    void deveVerificarTurmaPresente(){
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Curso c = new Curso();
        c.addTurma(t);
        assertTrue(c.turmaIsPresent(t));
    }

    @Test
    void deveRetornarTodosProfessores(){
        Turma t1 = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Turma t2 = new Turma("DCC012",new Professor("Fernando"),new Disciplina("Desestruturamento"));
        Turma t3 = new Turma("DCC021",new Professor("Receba"),new Disciplina("Sinuca"));
        Curso c = new Curso();
        c.addTurma(t1);
        c.addTurma(t2);
        c.addTurma(t3);
        ArrayList<String> nomesVerificar = new ArrayList<>();
        nomesVerificar.add("Maycon");
        nomesVerificar.add("Fernando");
        nomesVerificar.add("Receba");
        assertEquals(nomesVerificar, c.getProfessores());
    }

    @Test
    void deveRetornarTodasDisciplinas(){
        Turma t1 = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Turma t2 = new Turma("DCC012",new Professor("Fernando"),new Disciplina("Desestruturamento"));
        Turma t3 = new Turma("DCC021",new Professor("Receba"),new Disciplina("Sinuca"));
        Curso c = new Curso();
        c.addTurma(t1);
        c.addTurma(t2);
        c.addTurma(t3);
        ArrayList<String> nomesVerificar = new ArrayList<>();
        nomesVerificar.add("Estruturamento");
        nomesVerificar.add("Desestruturamento");
        nomesVerificar.add("Sinuca");
        assertEquals(nomesVerificar, c.getDisciplinas());
    }

    @Test
    void deveRetornarTodosAlunosTurma(){
        Turma t1 = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Turma t2 = new Turma("DCC012",new Professor("Fernando"),new Disciplina("Desestruturamento"));
        Curso c = new Curso();
        Aluno a = new Aluno("Joao Senhor Marihuana");
        Aluno b = new Aluno("Pedro do Marx Pao");
        Aluno d = new Aluno("Caua Moreno");
        t1.matricularAluno(a);
        t2.matricularAluno(b);
        t2.matricularAluno(d);
        c.addTurma(t1);
        c.addTurma(t2);
        ArrayList<String> nomesVerificar = new ArrayList<>();
        nomesVerificar.add("Joao Senhor Marihuana");
        nomesVerificar.add("Pedro do Marx Pao");
        nomesVerificar.add("Caua Moreno");
        assertEquals(nomesVerificar, c.getAlunosDisciplinas());
    }

    @Test
    void naoDeveMatricularAlunoPresente(){
        try{
            Aluno a = new Aluno("Joao Senhor Marihuana");
            Curso c = new Curso();
            c.matricularAluno(a);
            c.matricularAluno(a);
        }
        catch(IllegalArgumentException e){
            assertEquals("Aluno ja esta matriculado no curso.",e.getMessage());
        }
    }

    @Test
    void deveMaatricularAlunoNaoPresente(){
        Aluno a = new Aluno("Joao Senhor Marihuana");
        Curso c = new Curso();
        c.matricularAluno(a);
        assertTrue(c.alunoIsPresentOnCurso(a)); //verifica verdadeiro pra alunoispresent
    }

    @Test
    void deveDesmatricularAlunoPresente(){
        Aluno a = new Aluno("Joao Senhor Marihuana");
        Curso c = new Curso();
        c.matricularAluno(a);
        c.desmatricularAluno(a);
        assertFalse(c.alunoIsPresentOnCurso(a)); //verifica falso pra alunoispresent
    }

    @Test
    void naoDeveDesmatricularAlunoNaoPresente(){
        try{
            Aluno a = new Aluno("Joao Senhor Marihuana");
            Curso c = new Curso();
            c.desmatricularAluno(a);
        }
        catch(IllegalArgumentException e){
            assertEquals("Aluno nao encontrado no curso!",e.getMessage());
        }
    }

    @Test
    void deveRetornarNomesAlunosCurso() {
        Curso d = new Curso();
        Aluno a = new Aluno("Joao Senhor Marihuana");
        Aluno b = new Aluno("Pedro do Marx Pao");
        Aluno c = new Aluno("Caua Moreno");
        d.matricularAluno(a);
        d.matricularAluno(b);
        d.matricularAluno(c);
        ArrayList<String> nomesVerificar = new ArrayList<>();
        nomesVerificar.add("Joao Senhor Marihuana");
        nomesVerificar.add("Pedro do Marx Pao");
        nomesVerificar.add("Caua Moreno");
        assertEquals(nomesVerificar,d.getNomesAlunosCurso());
    }
}