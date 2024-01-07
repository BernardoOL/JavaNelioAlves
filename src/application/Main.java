package application;


import model.Contract;
import model.entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Número: ");
        int number = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);

        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract objContract = new Contract(number, date, totalValue);

        System.out.print("Entre com o número de parcelas: ");
        int installments = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());

        service.processContract(objContract, installments);

        System.out.println("Parcelas: ");
        for(Installment installment : objContract.getInstalments()){
            System.out.println(installment);
        }

    }
}