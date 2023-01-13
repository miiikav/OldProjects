#include "queue.hh"
#include <iostream>

// Implement the member functions of Queue here
Queue::Queue(unsigned int cycle){
    cycle_=cycle;

}
Queue::~Queue() {
   while ( first_ != nullptr ) {
      Vehicle* item_to_be_released = first_;
      first_ = first_->next;

      delete item_to_be_released;
   }
}
// Inserts a vehicle, the register number of which is reg, to the queue.
void Queue::enqueue(string reg){
    if(is_green_==false){
        Vehicle* new_item = new Vehicle{reg, nullptr};
        if ( first_ == nullptr ) {
           first_ = new_item;
           last_ = new_item;
        } else {
           last_->next = new_item;
           last_ = new_item;
        }
    }
    else{
        cout << "GREEN: The vehicle "<<reg<<" need not stop to wait"<<endl;
    }

}

// Switches the color of traffic light from green to red or vice versa.
// If the new color is green, lets at least <cycle_> vehicles
// go on (i.e. calls dequeue at least <cycle_> times), and finally
// resets the color to red again.
void Queue::switch_light(){
    if(is_green_==false){
        is_green_=true;
        if(first_!=nullptr){
            cout << "GREEN: Vehicle(s) ";
            unsigned int running_number = 1;
            while(running_number<=cycle_){
                Vehicle* item_to_be_released = first_;
                if(first_ != nullptr){
                    first_ = first_->next;
                    cout <<item_to_be_released->reg_num<<" ";;
                    delete item_to_be_released;
                    ++running_number;
                }
                else{
                    break;
                }
            }
            cout << "can go on"<<endl;
            is_green_=false;
        }
        else{
            cout << "GREEN: No vehicles waiting in traffic lights"<<endl;
            is_green_=true;
        }
    }
    else{
        is_green_=false;
        if(first_!=nullptr){
            cout << "GREEN: Vehicle(s) ";
            unsigned int running_number = 1;
            while(running_number<=cycle_){
                Vehicle* item_to_be_released = first_;
                if(first_ != nullptr){

                    first_ = first_->next;
                    cout <<item_to_be_released->reg_num<<" ";;
                    delete item_to_be_released;
                    ++running_number;
                }
                else{
                    break;
                }
            }
            cout << "can go on"<<endl;
            is_green_=false;
        }
        else{
            cout << "RED: No vehicles waiting in traffic lights"<<endl;
            is_green_=false;
        }
    }
}

// Resets the attribute cycle_.
void Queue::reset_cycle(unsigned int cycle){
    cycle_=cycle;
}

// Prints the color of traffic light and the register numbers of those
// cars that are waiting in the traffic light queue (if any).
void Queue::print(){
    if(is_green_==false){
        if(first_!=nullptr){
            cout << "RED: Vehicle(s) ";
            Vehicle* item_to_be_printed = first_;
            int running_number = 1;

            while ( item_to_be_printed != nullptr ) {
               cout <<item_to_be_printed->reg_num<<" ";
               ++running_number;
               item_to_be_printed = item_to_be_printed->next;
            }
            cout << "waiting in traffic lights"<<endl;
        }
        else{
            cout << "RED: No vehicles waiting in traffic lights"<<endl;
        }
    }
}
