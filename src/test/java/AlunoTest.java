import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    @Test
    void naoDeveDefinirAlunoSemNome(){
        try{
            Aluno p = new Aluno ("");
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O nome deve ser preenchido.", e.getMessage());
        }
    }

    @Test
    void deveDefinirAluno(){
        Aluno p = new Aluno("Maycon");
        assertEquals("Maycon", p.getNome());
    }
}