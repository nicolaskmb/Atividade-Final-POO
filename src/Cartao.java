public class Cartao {
    private int id;
    private String nome;
    private StatusCartao status;

    public Cartao(int id, String nome, StatusCartao status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setStatus(StatusCartao status) {
        this.status = status;
    }

    public StatusCartao getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Status: " + status;
    }
}
