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

    //relacionado a turmas

    public void addTurma(Turma turma) {
        if (this.turmas.contains(turma)) {
            throw new IllegalArgumentException("Turma ja esta cadastrada");
        }
        this.turmas.add(turma);
    }

    public void removeTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    public Boolean turmaIsPresent(Turma turma) {
        return this.turmas.contains(turma);
    }

    public ArrayList<String> getProfessores() {
        ArrayList<String> professores = new ArrayList<>();
        for (Turma turma : this.turmas) {
            professores.add(turma.getProfessorNome());
        }
        return professores;
    }

    public ArrayList<String> getDisciplinas() {
        ArrayList<String> disciplinas = new ArrayList<>();
        for (Turma turma : this.turmas) {
            disciplinas.add(turma.getNomeDisciplina());
        }
        return disciplinas;
    }

    public ArrayList<String> getAlunosDisciplinas() {
        ArrayList<String> alunosDisciplinas = new ArrayList<>();
        for (Turma turma : this.turmas) {
            ArrayList<String> alunoNome = turma.getNomesAlunos();
            alunosDisciplinas.addAll(alunoNome);
        }
        return alunosDisciplinas;
    }


    // relacionado a alunos

    public void matricularAluno(Aluno aluno) {
        if (this.alunoIsPresentOnCurso(aluno)) {
            throw new IllegalArgumentException("Aluno ja esta matriculado no curso.")
        }
        this.alunos.add(aluno);
    }

    public void desmatricularAluno(Aluno aluno) {
        if (!this.alunoIsPresentOnCurso(aluno)) {
            throw new IllegalArgumentException("Aluno nao encontrado no curso!");
        }
        this.alunos.remove(aluno);
    }

    public Boolean alunoIsPresentOnCurso(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public ArrayList<String> getNomesAlunosCurso() {
        ArrayList<String> nomesAlunos = new ArrayList<>();
        for (Aluno aluno : alunos) {
            nomesAlunos.add(aluno.getNome());
        }
        return nomesAlunos;
    }
}
