public abstract class Pessoa {
    private String nome;
    private int id;

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
