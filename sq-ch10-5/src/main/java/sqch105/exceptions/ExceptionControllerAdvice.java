package sqch105.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sqch105.model.ErrorDetails;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler (NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> notEnoughMoney(NotEnoughMoneyException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
    // currently method parameter is doing nothing,
    // it is generally used to get information about exception that occurred ,
    // from  controller's action to advice
    // spring will auto inject that parameter .
}
