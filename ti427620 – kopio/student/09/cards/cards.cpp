#include "cards.hh"
#include <iostream>
using namespace std;
// TODO: Implement the methods here

Cards::Cards():top_(nullptr),bottom_(nullptr){

}
Cards::~Cards() {
   while ( top_ != nullptr ) {
      Card_data* item_to_be_released = top_;
      top_ = top_->next;

      delete item_to_be_released;
   }
}
// Adds a new card with the given id as the topmost element.
void Cards::add(int id){
    Card_data* new_item = new Card_data{id, nullptr};

    if ( top_ == nullptr ) {
       top_ = new_item;

    } else {
        top_->next=new_item;
        top_ = new_item;

    }

}
// Prints the content of the data structure with ordinal numbers to the
// output stream given as a parameter starting from the first element.
void Cards::print_from_top_to_bottom(std::ostream& s){
    s.seekp(0);
    if(top_!=nullptr){
        Card_data* item_to_be_printed = top_;
        int running_number = 1;
        while ( item_to_be_printed !=nullptr) {
           cout << running_number << ". " << item_to_be_printed->data<< endl;
           ++running_number;
           item_to_be_printed = item_to_be_printed->next;
        }
    }

}
// Removes the topmost card and passes it in the reference parameter id to the caller.
// Returns false, if the data structure is empty, otherwise returns true.
bool Cards::remove(int& id){
    if(top_==nullptr){
        return false;
    }
    else{
        Card_data* item_to_be_released = top_;
        top_ = top_->next;
        id=item_to_be_released->data;
        delete item_to_be_released;
        return true;
    }
}
// Moves the last element of the data structure as the first one.
// Returns false, if the data structure is empty, otherwise returns true.
bool Cards::bottom_to_top(){
    return false;
}

// Moves the first element of the data structure as the last one.
// Returns false, if the data structure is empty, otherwise returns true.
bool Cards::top_to_bottom(){
    return false;
}

// Prints the content of the data structure with ordinal numbers to the
// output stream given as a parameter starting from the last element.
void Cards::print_from_bottom_to_top(std::ostream& s){
    s.seekp(0);


}


