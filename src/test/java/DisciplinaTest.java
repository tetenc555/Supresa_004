import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {
    @Test
    void naoDeveDefinirDisciplinaSemNome(){
        try{
            Disciplina p = new Disciplina ("");
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O nome deve ser preenchido.", e.getMessage());
        }
    }

    @Test
    void deveDefinirDisciplina(){
        Disciplina p = new Disciplina("Maycon");
        assertEquals("Maycon", p.getNome());
    }
}