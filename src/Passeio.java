public class Passeio {

    private Barcos barco;
    private double valorBilhete;
    private Passageiro[] passageiros;
    private int quantidadePassageiros;

    public Passeio(Barcos barco, double valorBilhete) {
        this.barco = barco;
        this.valorBilhete = valorBilhete;
        this.passageiros = new Passageiro[barco.getLotacao()];
        this.quantidadePassageiros = 0;
    }

    public Barcos getBarco() {
        return barco;
    }

    public void setBarco(Barcos barco) {
        this.barco = barco;
    }

    public double getValorBilhete() {
        return valorBilhete;
    }

    public void setValorBilhete(double valorBilhete) {
        this.valorBilhete = valorBilhete;
    }

    public boolean adicionaPassageiro(Passageiro passageiro) {
        if (quantidadePassageiros < passageiros.length) {
            passageiros[quantidadePassageiros] = passageiro;
            quantidadePassageiros++;
            return true;
        }
        return false;
    }

    public boolean removePassageiro(String nome) {
        for (int i = 0; i < quantidadePassageiros; i++) {
            if (passageiros[i].getNome().equals(nome)) {
                passageiros[i] = passageiros[quantidadePassageiros - 1];
                passageiros[quantidadePassageiros - 1] = null;
                quantidadePassageiros--;
                return true;
            }
        }
        return false;
    }

    public void mostraPasseio() {
        System.out.println("Barco: " + barco.getNome() + ", Valor do Bilhete: " + valorBilhete);
        for (int i = 0; i < quantidadePassageiros; i++) {
            System.out.println("Passageiro: " + passageiros[i].getNome() + ", Idade: " + passageiros[i].getIdade() + ", Profissão: " + passageiros[i].getProfissao());
        }
    }

    public int buscaPasProfissao(String profissao) {
        int count = 0;
        for (int i = 0; i < quantidadePassageiros; i++) {
            if (passageiros[i].getProfissao().equals(profissao)) {
                count++;
            }
        }
        return count;
    }

    public double buscaValorPasseio() {
        return valorBilhete * quantidadePassageiros;
    }
}