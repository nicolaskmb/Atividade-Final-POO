import java.util.ArrayList;

public class Lista {
    private int id;
    private String nome;
    private ArrayList<Cartao> cartoes;

    public Lista(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.cartoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Cartões: " + cartoes.size();
    }
}
