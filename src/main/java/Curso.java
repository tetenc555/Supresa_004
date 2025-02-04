import java.util.ArrayList;

public class Curso {
    private ArrayList<Turma> turmas;
    private ArrayList<Aluno> alunos;

    public Curso() {
        this.setAlunos(new ArrayList<>());
        this.setTurmas(new ArrayList<>());
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    //fim get set constructor padrao


}
