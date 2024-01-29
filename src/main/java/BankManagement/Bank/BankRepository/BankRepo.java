package BankManagement.Bank.BankRepository;

import BankManagement.Bank.Model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank,Integer> {
    Bank getByAcNo(long acNo);
}
