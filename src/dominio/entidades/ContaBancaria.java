package dominio.entidades;

import dominio.exceptions.FormatadorContaBancariaException;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class ContaBancaria {
    private Integer numeroConta;
    private String agencia;
    private String nomeCliente;
    private BigDecimal saldo;

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

    public ContaBancaria(Integer numeroConta, String agencia, String nomeCliente, BigDecimal saldo) throws FormatadorContaBancariaException {
        try {
            if(valida(agencia) && valida(numeroConta)){
                this.nomeCliente = nomeCliente;
                this.numeroConta = numeroConta;
                this.agencia = agencia;
                this.saldo = saldo;
            }
        } catch (Exception e) {
            throw new FormatadorContaBancariaException("O valor passado está incosistente do esperado ", e.getCause());
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
