#include "account.hh"
#include <iostream>
#include <string>

using namespace std;

Account::Account(const std::string& owner, bool has_credit):
        owner(owner),has_credit(has_credit){
    generate_iban();
}

// Setting initial value for the static attribute running_number_
int Account::running_number_ = 0;
//string Account::iban_="";
void Account::generate_iban()
{
    ++running_number_;
    std::string suffix = "";
    if(running_number_ < 10)
    {
        suffix.append("0");
    }
    else if(running_number_ > 99)
    {
        std::cout << "Too many accounts" << std::endl;
    }
    suffix.append(std::to_string(running_number_));

    iban_ = "FI00 1234 ";
    iban_.append(suffix);
}
void Account::print() const{
    std::cout <<owner<<" : "<< iban_<<" : "<<balance<<" euros"<< std::endl;
}
void Account::print_three_accounts(Account a1,Account a2,Account a3){
    std::cout <<a1.owner<<" : "<< a1.iban_<<" : "<<a1.balance<<" euros"<< std::endl;
        std::cout <<a2.owner<<" : "<< a2.iban_<<" : "<<a2.balance<<" euros"<< std::endl;
            std::cout <<a3.owner<<" : "<< a3.iban_<<" : "<<a3.balance<<" euros"<< std::endl;
}
void Account::set_credit_limit(int amount){
            if(has_credit == true){
                credit_limit=amount;
            }
            else {
                std::cout << "Cannot set credit limit: the account has no credit card" << std::endl;
            }


}
void Account::take_money(int amount){
    if(amount>balance){
        if(has_credit == true){
            if(amount>balance+credit_limit){
                    cout<<"Cannot take money: balance underflow" << std::endl;
            }
            else{
                balance-=amount;
                cout<<amount<<" euros taken: new balance of "<<iban_<<" is "<< balance<<" euros" << std::endl;
            }

        }
        else{
            cout<<"Cannot take money: balance underflow" << std::endl;
        }
    }
    else{
        balance-=amount;
        cout<<amount<<" euros taken: new balance of "<<iban_<<" is "<< balance<<" euros" << std::endl;
    }
}
void Account::save_money(int amount){
    balance=+amount;

}
void Account::transfer_to(Account a1, int amount){
    if(amount>balance){
        if(has_credit == true){
            if(amount>balance+credit_limit){
                cout<<"Cannot take money: balance underflow" << std::endl;
                cout<<"Transfer from "<<iban_<<" failed" << std::endl;
            }
            else{
                balance-=amount;
                a1.balance+=amount;
                cout<<amount<<" euros taken: new balance of "<<iban_<<" is "<< balance<<" euros" << std::endl;
            }
        }
        else{
            cout<<"Cannot take money: balance underflow" << std::endl;
            cout<<"Transfer from "<<iban_<<" failed" << std::endl;
        }
    }
    else{
        balance-=amount;
        a1.balance+=amount;
        cout<<amount<<" euros taken: new balance of "<<iban_<<" is "<< balance<<" euros" << std::endl;
    }
}
