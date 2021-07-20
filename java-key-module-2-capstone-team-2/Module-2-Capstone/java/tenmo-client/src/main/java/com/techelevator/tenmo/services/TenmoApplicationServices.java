package com.techelevator.tenmo.services;

import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.transfer.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.models.account.Account;
import com.techelevator.view.ConsoleService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

/*******************************************************************************************************
 * This is where you code Application Services required by your solution
 * 
 * Remember:  theApp ==> ApplicationServices  ==>  Controller  ==>  DAO
********************************************************************************************************/

public class TenmoApplicationServices {

private final String API_BASE_URL;
private RestTemplate theAPI = new RestTemplate();
private final ConsoleService console = new ConsoleService(System.in, System.out);

public TenmoApplicationServices(String apiURL) {
    API_BASE_URL = apiURL;
}

//--------------------------------LIST ALL ACCOUNTS---------------------------------------------------
public Account[] listAccounts() {
    return theAPI.getForObject(API_BASE_URL + "accounts", Account[].class);
}

//------------------------------------GET BALANCE--------------------------------------------------
public double viewCurrentBalance(AuthenticatedUser currentUser) {
    Account anAccount;

    anAccount = theAPI.exchange(API_BASE_URL + "accounts/" + currentUser.getUser().getId(), HttpMethod.GET, makeAuthEntity(currentUser), Account.class).getBody();
    //anAccount = theAPI.getForObject(API_BASE_URL + "accounts/" + currentUser.getToken() + currentUser.getUser().getId(), Account.class);
    return anAccount.getBalance();
}

//--------------------------------GET USER ID AND USERNAME---------------------------------------
public User[] listUsers() {
    return  theAPI.getForObject(API_BASE_URL + "users", User[].class);
}

//---------------------------------TRANSFER FUNDS----------------------------------------------------
public Transfer updateAccount(AuthenticatedUser currentUser) {
    Transfer updatedAccounts = new Transfer();

    User receivingUser = console.displayForSendTEBucks(theAPI.exchange(API_BASE_URL + "users",HttpMethod.GET, makeAuthEntity(currentUser), User[].class).getBody());
    //User receivingUser = console.displayForSendTEBucks(theAPI.getForObject(API_BASE_URL + "users", User[].class));
    double transactionAmount = Double.parseDouble(console.getUserInput("How much money do you want to send ?"));
    User sendingUser = currentUser.getUser();

//    Account receivingAccount = theAPI.getForObject(API_BASE_URL + "accounts/" + receivingUser.getId(),Account.class);
//    Account sendingAccount = theAPI.getForObject(API_BASE_URL + "accounts/" + sendingUser.getId(),Account.class);

    Account receivingAccount = theAPI.exchange(API_BASE_URL + "accounts/" + receivingUser.getId(), HttpMethod.GET, makeAuthEntity(currentUser), Account.class).getBody();
    Account sendingAccount = theAPI.exchange(API_BASE_URL + "accounts/" + sendingUser.getId(),HttpMethod.GET, makeAuthEntity(currentUser),Account.class).getBody();

    HttpHeaders theHeaders = new HttpHeaders();
    theHeaders.setBearerAuth(currentUser.getToken());
    theHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity updateRequest = new HttpEntity(updatedAccounts, theHeaders);

    updatedAccounts.setAccount_to(receivingAccount);
    updatedAccounts.setAccount_from(sendingAccount);
    updatedAccounts.setAmount(transactionAmount);
    updatedAccounts.setTransfer_status_id(2);
    updatedAccounts.setTransfer_type_id(2);

    try {
        if (transactionAmount <= sendingAccount.getBalance()) {
       //updatedAccounts = theAPI.postForObject(API_BASE_URL + "accounts/transfers", updateRequest, Transfer.class);
            updatedAccounts = theAPI.exchange(API_BASE_URL + "accounts/transfers", HttpMethod.POST, updateRequest, Transfer.class).getBody();
          }
        else {
            System.out.println("Balance is too low");
        }
    } catch (RestClientResponseException ex) {
        System.out.println(ex.getRawStatusCode() + " : " + ex.getStatusText());
    }
        catch(ResourceAccessException ex) {
        System.out.println(ex.getMessage());
        }

    return updatedAccounts;
}


public Transfer[] listTransfers(AuthenticatedUser currentUser) {

    //return theAPI.getForObject(API_BASE_URL + "transfers" ,Transfer[].class);
    return theAPI.exchange(API_BASE_URL + "transfers" , HttpMethod.GET, makeAuthEntity(currentUser),Transfer[].class).getBody();

}






//   public void sendMoney(AuthenticatedUser currentUser) {
//
//        User receivingUser = console.displayForSendTEBucks(theAPI.getForObject(API_BASE_URL + "users", User[].class));
//        double transactionAmount = Double.parseDouble(console.getUserInput("How much money do you want to send ?"));
//        User sendingUser = currentUser.getUser();
//
//

       //update sending account by subtracting transaction
       //update receiving account by adding transaction
       //create transfer object and send it to API to store record of transfer
       // no DTO needed


       // display all userID and Name - ListAllAccounts method
       //	console.displayForSendTEBucks(appServices.listUsers());
       // user input selection of userID to transfer to
       // user input amount to transfer
       // 		method to check the balance to make sure transfer amount <= balance
       // 		method reduce sender balance by transfer amount
       // 		method to increase receiver balance by transfer amount
       // 		set transfer status to 'approve' - reminds me of account POJO for STARTING_BALANCE



    //--------------------------------NEW ACCOUNT-------------------------------------------------
/*    public Account addAccount(){
        Account anAccount = new Account();

        HttpHeaders theHeaders = new HttpHeaders();
        theHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity anEntity = new HttpEntity(anAccount, theHeaders);
        try {
            anAccount = theAPI.postForObject(API_BASE_URL + "accounts", anEntity, Account.class);

        } catch (RestClientResponseException exceptionObject) {
            System.out.println(exceptionObject.getRawStatusCode() + " : " + exceptionObject.getStatusText());
        } catch (ResourceAccessException exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
        return anAccount;*/

//    return theAPI.postForObject(API_BASE_URL + "accounts", Account.class);
//    }


//----------------------------------HELPER----------------------------------
//private Account makeNewAccount (AuthenticatedUser currentUser) {
//    return new Account(theAPI.(API_BASE_URL + "accounts/")  , currentUser.getUser().getId(), )
//}

private HttpEntity makeAuthEntity (AuthenticatedUser currentUser) {
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(currentUser.getToken());
    HttpEntity entity = new HttpEntity<>(headers);
    return entity;
}


} // end
