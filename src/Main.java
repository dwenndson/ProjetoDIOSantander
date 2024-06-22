import dominio.entidades.ContaBancaria;
import dominio.exceptions.FormatadorContaBancariaException;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FormatadorContaBancariaException {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Por favor, digite o número da conta");
        int numeroConta = sc.nextInt();
        System.out.println("Por favor, digite o número da agência");
        sc.nextLine();
        String agencia = sc.nextLine();
        System.out.println("Por favor, digite o seu nome");
        String clientName = sc.nextLine();
        System.out.println("Por favor, digite o saldo ");
        BigDecimal saldo = sc.nextBigDecimal();

        ContaBancaria contaBancaria = new ContaBancaria(numeroConta, agencia, clientName, saldo);
        System.out.println(contaBancaria);

    }
}