public class Dipendente {

    private String nome;
    private int eta;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(String nome, int eta, double stipendio, Dipartimento dipartimento) {
        this.nome = nome;
        this.eta = eta;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    // Costruttore con solo il nome
    public Dipendente(String nome) {
        this.nome = nome;
        this.eta = 20;
        this.stipendio = 20000.0;
        this.dipartimento = Dipartimento.GENERICO;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    @Override
    public String toString() {
        return nome + " - " + "Età: " + eta + " - " + "Stipendio: " + stipendio + " - " + "Dipartimento: " + dipartimento;

    }

}