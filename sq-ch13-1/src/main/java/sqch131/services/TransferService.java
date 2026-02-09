package sqch131.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sqch131.model.Account;
import sqch131.repositores.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Transactional
    public void transferMoney(int idSender, int idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findAmountById(idSender);
        Account receiver = accountRepository.findAmountById(idReceiver);
        if (sender == null || receiver == null) {
            throw new RuntimeException("Account not found");
        }

        if (sender.getAmount().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }


        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(idSender ,senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

    }
    public List<Account> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
