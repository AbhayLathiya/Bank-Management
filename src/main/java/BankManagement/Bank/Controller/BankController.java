package BankManagement.Bank.Controller;

import BankManagement.Bank.Model.Bank;
import BankManagement.Bank.Services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService service;
    @PostMapping("/openAc")
    public ResponseEntity<?> openAccount(@RequestBody Bank bank) {
        try {
            Bank openedAccount = service.openAccount(bank);
            return new ResponseEntity<>(openedAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle the exception appropriately
            return new ResponseEntity<>("Failed to open account. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/debited")
    public Bank withdraw(@RequestParam long acNo,double amount){
        return service.withdraw(acNo,amount);
    }

    @PutMapping("/credited")
    public Bank deposit(@RequestParam long acNo,double amount){
        return service.deposit(acNo,amount);
    }

    @PutMapping("/transfer")
    public List<Bank> transfer(@RequestParam long recAcNo, long senAcNo, double amount){
        return service.transfer(recAcNo,senAcNo,amount);
    }

    @GetMapping("/balanceInquiry/{id}")
    public double balance(@PathVariable long id){
        return service.balance(id);
    }
}
