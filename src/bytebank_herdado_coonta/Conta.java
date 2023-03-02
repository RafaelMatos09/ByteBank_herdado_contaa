package bytebank_herdado_coonta;

public abstract class Conta {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular = new Cliente();
	private static int total;

	// construtor com parametros
	public Conta(int agencia, int numero) {
		
		if(agencia < 1) {
            throw new IllegalArgumentException("Agencia inválida");
        }
		
		if(numero < 1) {
            throw new IllegalArgumentException("Numero da conta inválido");
        }
		
		Conta.total++;
		System.out.println("o total de contas é" + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		System.out.println("estou criando uma conta " + this.numero);
	}

	public abstract void deposita(double valor);

	public void saca(double valor) throws SaldoInsuficienteExecption {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteExecption("Saldo: " + this.saldo + ", Valor: " + valor);

		}
		this.saldo -= valor;

	}

	public void transfere(double valor, Conta destino) throws SaldoInsuficienteExecption {
		this.saca(valor);
		destino.deposita(valor);

	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("nao pode valor <= 0");
			return;
		}
		this.numero = numero;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("nao pode valor menor igual a 0");
			return;
		}
		this.agencia = agencia;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public Cliente getTitular() {
		return titular;
	}

	public static int getTotal() {
		return Conta.total;
	}

}
