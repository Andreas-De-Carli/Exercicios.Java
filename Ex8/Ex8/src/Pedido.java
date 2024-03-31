public class Pedido {
    private static int numeroPedidoAtual = 1;
    private int numeroPedido;
    private Pizza pizza;
    private String tamanho;
    private double valor;
    private String enderecoEntrega;

    public Pedido(Pizza pizza, String tamanho, String enderecoEntrega) {
        this.numeroPedido = numeroPedidoAtual++;
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.valor = pizza.getValor(); 
        this.enderecoEntrega = enderecoEntrega;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getValor() {
        return valor;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
        
        if (tamanho.equalsIgnoreCase("grande")) {
            this.valor = pizza.getValor() * 1.5; 
        } else if (tamanho.equalsIgnoreCase("média")) {
            this.valor = pizza.getValor() * 1.2; 
        } else {
            this.valor = pizza.getValor(); 
        }
    }
}