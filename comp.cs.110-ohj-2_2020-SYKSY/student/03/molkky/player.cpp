#include "player.hh"
#include <iostream>
#include <string>

using namespace std;

Player::Player(const std::string name):
  name(name){

}

int Player::get_points(){
    return points_;
};
string Player::get_name(){
    return name;
}
bool Player::has_won(){
    if(winner==true){
        return true;
    }
    else{
        return false;
    }
}
void Player::add_points(int pts){

    if(points_+pts==50){
        points_+=pts;
        winner=true;
    }
    else if(points_+pts>50){
        points_=25;
        std::cout<<name<<" gets penalty points!" << std::endl;
    }
    else{
        points_+=pts;
    }

}
