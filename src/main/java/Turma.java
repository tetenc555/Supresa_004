import java.util.ArrayList;

public class Turma {
    private String codigo;
    private Professor professor;
    private Disciplina disciplina;
    private ArrayList<Aluno> alunos;

    public Turma(String codigo, Professor professor, Disciplina disciplina) {
        this.setCodigo(codigo);
        this.setProfessor(professor);
        this.setDisciplina(disciplina);
        this.setAlunos(new ArrayList<>());
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.equals("")) {
            throw new IllegalArgumentException("Deve possuir um codigo");
        }
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getProfessorNome() {
        return professor.getNome();
    }

    public void setProfessor(Professor professor) {
        if (professor == null) {
            throw new NullPointerException("Deve possuir um professor.");
        }
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new NullPointerException("Deve possuir uma disciplina.");
        }
        this.disciplina = disciplina;
    }

    public String getNomeDisciplina() {
        return disciplina.getNome();
    }




    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void matricularAluno(Aluno aluno) {
        if (this.alunoIsPresent(aluno)) {
            throw new IllegalArgumentException("Aluno ja esta matriculado.");
        }
        this.alunos.add(aluno);
    }

    public void desmatricularAluno(Aluno aluno) {
        if (!this.alunoIsPresent(aluno)){
            throw new IllegalArgumentException("Aluno nao esta matriculado!");
        }
        this.alunos.remove(aluno);
    }

    public Boolean alunoIsPresent(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public ArrayList<String> getNomesAlunos() {
        ArrayList<String> nomesAlunos = new ArrayList<>();
        for (Aluno aluno : alunos) {
            nomesAlunos.add(aluno.getNome());
        }
        return nomesAlunos;
    }
}
