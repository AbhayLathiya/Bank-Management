package BankManagement.Bank.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Random;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long acNo=generateAccountNumber();
    private String acHolName;
    private double balance;

    private long generateAccountNumber() {
        // Fixed prefix for the first 8 digits
        String fixedPrefix = "04491000";

        // Generate a random 6-digit number as the suffix
        Random random = new Random();
        int randomSuffix = 100000 + random.nextInt(900000);

        // Concatenate the prefix and suffix to form the 14-digit account number
        String accountNumberString = fixedPrefix + randomSuffix;

        // Parse the string as a Long
        return Long.parseLong(accountNumberString);
    }
}
