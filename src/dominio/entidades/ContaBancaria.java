package dominio.entidades;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContaBancaria {
    private Integer numeroConta;
    private String agencia;
    private String nomeCliente;

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    private BigDecimal saldo;

    public ContaBancaria(Integer numeroConta, String agencia, String nomeCliente, BigDecimal saldo) {
        if(valida(agencia) && valida(numeroConta)){
         this.nomeCliente = nomeCliente;
         this.numeroConta = numeroConta;
         this.agencia = agencia;
         this.saldo = saldo;
        }
    }

    private boolean valida(String agencia) {
        return Pattern.compile("^0*\\d{3}-\\d$").matcher(agencia).matches();
    }

    private boolean valida(Integer numeroConta) {
        return Pattern.compile("\\d{4}").matcher(numeroConta.toString()).matches();
    }

    @Override
    public String toString(){
        return String.format("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta " +
                "%d e seu saldo %.2f já está disponível para saque.",
                this.nomeCliente,
                this.agencia,
                this.numeroConta,
                this.saldo);
    }
}
