import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {
    @Test
    void naoDeveDefinirTurmaSemCodigo(){
        try{
            Turma t = new Turma("",new Professor("Maycon"),new Disciplina("Estruturamento"));
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Deve possuir um codigo", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirTurmaSemProfessor(){
        try{
            Turma t = new Turma("DCC022",null,new Disciplina("Estruturamento"));
            fail();
        }
        catch(NullPointerException e){
            assertEquals("Deve possuir um professor.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirTurmaSemDisciplina(){
        try{
            Turma t = new Turma("DCC022",new Professor("Maycon"),null);
            fail();
        }
        catch(NullPointerException e){
            assertEquals("Deve possuir uma disciplina.", e.getMessage());
        }
    }

    @Test
    void deveRetornarProfessor() {
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        assertEquals("Maycon",t.getProfessorNome());
    }

    @Test
    void deveRetornarDisciplina() {
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        assertEquals("Estruturamento",t.getNomeDisciplina());
    }

    @Test
    void deveRetornarNomesAlunos() {
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Aluno a = new Aluno("Joao Senhor Marihuana");
        Aluno b = new Aluno("Pedro do Marx Pao");
        Aluno c = new Aluno("Caua Moreno");
        t.matricularAluno(a);
        t.matricularAluno(b);
        t.matricularAluno(c);
        ArrayList<String> nomesVerificar = new ArrayList<>();
        nomesVerificar.add("Joao Senhor Marihuana");
        nomesVerificar.add("Pedro do Marx Pao");
        nomesVerificar.add("Caua Moreno");
        assertEquals(nomesVerificar,t.getNomesAlunos());
    }

    @Test
    void deveVerificarSeAlunoEstaTurmaPositivo(){
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Aluno a = new Aluno("Joao Senhor Marihuana");
        t.matricularAluno(a);
        assertTrue(t.alunoIsPresent(a));
    }

    @Test
    void deveVerificarSeAlunoEstaTurmaNegativo(){
        Turma t = new Turma("DCC022",new Professor("Maycon"),new Disciplina("Estruturamento"));
        Aluno b = new Aluno("Pedro do Marx Pao");
        assertFalse(t.alunoIsPresent(b));
    }
}