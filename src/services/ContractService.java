package services;

import model.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private final OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }
    public void processContract(Contract contract, Integer months){

        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++){
            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            LocalDate dueDate = contract.getDate().plusMonths(i);

            contract.getInstalments().add(new Installment(dueDate, quota));
        }
    }
}
