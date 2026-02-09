package sqch131.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sqch131.dto.TransferRequest;
import sqch131.model.Account;
import sqch131.services.TransferService;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;
    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }
    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transfer) {
        transferService.transferMoney(transfer.getSenderAccountId(),
                transfer.getReceiverAccountId(),
                transfer.getAmount());
    }

    @GetMapping("accounts")
    public List<Account> findAllAccounts() {
        return transferService.findAllAccounts();
    }
}
