#ifndef BOOK_HH
#define BOOK_HH
#include <string>
#include "date.hh"
class Book{
    public:
        // Constructor
        Book(std::string author,std::string book);

        // More methods
        void print_date(Date date);
        void print();
        void loan(Date today);
        void renew();
        void give_back();

    private:

        // More attributes/methods
        std::string author;
        std::string name;
        bool on_loan = false;
        Date loan_date;
        Date return_date;


};
#endif // BOOK_HH
