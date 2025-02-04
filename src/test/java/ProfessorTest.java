import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {
    
    @Test
    void naoDeveDefinirProfessorSemNome(){
        try{
            Professor p = new Professor ("");
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O nome deve ser preenchido.", e.getMessage());
        }
    }
    
    @Test
    void deveDefinirProfessor(){
        Professor p = new Professor("Maycon");
        assertEquals("Maycon", p.getNome());
    }
}