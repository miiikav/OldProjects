#include "book.hh"
#include <iostream>
#include <string>
#include "date.hh"

using namespace std;

Book::Book(string author, string name):
    author(author),name(name){

}
void Book::print(){
    cout<<author<<" : " << name <<std::endl;
    if(on_loan == false){
        cout<<"- available"<<std::endl;

    }
    else if(on_loan == true){
        cout<<"- loaned: "; loan_date.print();
        cout<<"- to be returned: "; return_date.print();
    }
}
void Book::loan(Date today){
    if(on_loan == false){
        loan_date = today;
        Date next_date = today;
        next_date.advance(28);
        return_date=next_date;
        on_loan = true;

    }
    else if(on_loan == true){
        cout<<"Already loaned: cannot be loaned"<< endl;
    }
}
void Book::renew(){
    if(on_loan == false){
        cout<<"Not loaned: cannot be renewed"<< endl;

    }
    else if(on_loan == true){
        return_date.advance(28);
    }
}
void Book::give_back(){
    on_loan = false;
}
