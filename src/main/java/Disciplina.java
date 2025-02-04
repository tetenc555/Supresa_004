public class Disciplina {
    private String nome;

    Disciplina(String nome){
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome deve ser preenchido.");
        }
        this.nome = nome;
    }
}
