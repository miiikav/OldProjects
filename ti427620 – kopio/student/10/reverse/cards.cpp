#include <iostream>
#include <memory>
#include "cards.hh"


Cards::Cards(): top_( nullptr ) {
}


void Cards::add(int id) {
    std::shared_ptr<Card_data> new_card 
            = std::make_shared<Card_data>(Card_data{id, top_});
    top_ = new_card;
}

void Cards::print(std::ostream& s) {
   std::shared_ptr<Card_data> to_be_printed = top_;
   int nr = 1;

   while( to_be_printed != 0 ) {
      s << nr << ": " << to_be_printed->data << std::endl;
      to_be_printed = to_be_printed->next;
      ++nr;
   }
}

bool Cards::remove(int &id)
{
    std::shared_ptr<Card_data> to_be_printed = top_;
    to_be_printed->data=id;
    to_be_printed = to_be_printed->next;
    to_be_printed=top_;
    if(top_==nullptr){
        return false;
    }
    else{
        return true;
    }
}

void Cards::reverse()
{
    std::shared_ptr<Card_data> to_be_printed = top_;
    std::shared_ptr<Card_data> to_be_printed2 = to_be_printed->next;
    while( to_be_printed != 0 ) {
        swap(to_be_printed,to_be_printed2);
        to_be_printed = to_be_printed->next;
        to_be_printed2 = to_be_printed->next;
    }


}

// Tip for writing code more efficiently:
// Do not write the stubs of the methods remove and reverse by yourself here,
// but open the file cards.hh and click the declaration of the method
// by the right mouse button and select
// Refactor > Add definition in cards.cpp
