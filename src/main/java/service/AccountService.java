package service;

import dao.AccDao;
import dto.AccountDto;
import model.Account;

import java.util.List;

public class AccountService {

    private AccDao accDao;

    public AccountService() {
        this.accDao = new AccDao();
    }

    public void register(AccountDto accountDto){
        if(accountDto.getPassword().length()<=5){
            throw new RuntimeException();
        }
        Account account=new Account();


    }


}
