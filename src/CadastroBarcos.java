public  class CadastroBarcos {

    private Barcos[] barcos;
    private int quantidade;

    public CadastroBarcos() {
        this.barcos = new Barcos[10];
        this.quantidade = 0;
    }

    public boolean adicionaBarco(Barcos barco) {
        if (quantidade < barcos.length) {
            barcos[quantidade] = barco;
            quantidade++;
            return true;
        }
        return false;
    }

    public Barcos buscaBarcoNome(String nome) {
        for (int i = 0; i < quantidade; i++) {
            if (barcos[i].getNome().equals(nome)) {
                return barcos[i];
            }
        }
        return null;
    }

    public boolean removeBarco(String nome) {
        for (int i = 0; i < quantidade; i++) {
            if (barcos[i].getNome().equals(nome)) {
                barcos[i] = barcos[quantidade - 1];
                barcos[quantidade - 1] = null;
                quantidade--;
                return true;
            }
        }
        return false;
    }

    public void mostraBarcos() {
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Nome: " + barcos[i].getNome() + ", Código: " + barcos[i].getCodigo() + ", Lotação: " + barcos[i].getLotacao());
        }
    }
}