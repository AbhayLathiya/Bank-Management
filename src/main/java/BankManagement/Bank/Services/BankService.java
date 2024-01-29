package BankManagement.Bank.Services;

import BankManagement.Bank.BankRepository.BankRepo;
import BankManagement.Bank.Model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {
    @Autowired
    BankRepo bankRepo;

    public Bank openAccount(Bank bank) {
        return bankRepo.save(bank);
    }

    public Bank withdraw(long acNo,double amount) {
        Bank user = bankRepo.getByAcNo(acNo);
        user.setBalance(user.getBalance()-amount);
        bankRepo.save(user);
        return user;
    }

    public Bank deposit(long acNo, double amount) {
        Bank user = bankRepo.getByAcNo(acNo);
        user.setBalance(user.getBalance()+amount);
        bankRepo.save(user);
        return user;
    }

    public List<Bank> transfer(long recAcNo,long senAcNo,double amount) {
        Bank sender = bankRepo.getByAcNo(senAcNo);
        sender.setBalance(sender.getBalance()-amount);
        bankRepo.save(sender);

        Bank receiver = bankRepo.getByAcNo(recAcNo);
        receiver.setBalance(receiver.getBalance()+amount);
        bankRepo.save(receiver);
        List<Bank> list = new ArrayList<>();
        list.add(sender);
        list.add(receiver);
        return list;
    }

    public double balance(long id) {
        Bank user = bankRepo.getByAcNo(id);
        return user.getBalance();
    }
}
