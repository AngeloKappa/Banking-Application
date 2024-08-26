package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.dto.TransactionDto;
import net.javaguides.banking.dto.TransferFundDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


//@RestController is a specialized version of the controller.
//It includes the @Controller and @ResponseBody annotations

//Spring @Controller annotation is also a specialization of @Component annotation.
//The @Controller annotation indicates that a particular class serves the role of a controller.
//Spring Controller annotation is typically used in combination with annotated handler methods based on the @RequestMapping annotation.
//It’s used to mark a class as a web request handler. It’s mostly used with Spring MVC applications.
//This annotation acts as a stereotype for the annotated class, indicating its role.

//@Component is an annotation that allows Spring to detect our custom beans automatically.
//In other words, without having to write any explicit code, Spring will:
//Scan our application for classes annotated with @Component.
//Instantiate them and inject any specified dependencies into them. Inject them wherever needed.

//The @ResponseBody annotation tells a controller that the object returned is automatically
// serialized into JSON and passed back into the HttpResponse object.
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    //In Spring Boot, when you define a constructor with a dependency,
    //Spring automatically injects the required beans without needing @Autowired on the constructor.
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }



    //ResponseEntity is a class in Spring Framework that represents the entire HTTP response,
    // including the status code, headers, and body.
    // It allows you to customize the response that your RESTful API sends back to the client.

    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){

        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete Account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }

    // Build transfer REST API
    @PostMapping("/transfer")
    public ResponseEntity<String> transferFund(@RequestBody TransferFundDto transferFundDto){
        accountService.transferFunds(transferFundDto);
        return ResponseEntity.ok("Transfer Successful");
    }

    // Build transactions REST API
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionDto>> fetchAccountTransactions(@PathVariable("id") Long accountId){

        List<TransactionDto> transactions = accountService.getAccountTransactions(accountId);

        return ResponseEntity.ok(transactions);
    }
}
