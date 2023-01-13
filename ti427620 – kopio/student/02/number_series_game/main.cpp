#include <iostream>


int main()
{
    int num = 0 ;
    std::cout << "How many numbers would you like to have? ";
    std::cin >> num;
    for(int i = 1; i <=num; i++){
        if(i % 3 == 0 && i % 7 == 0){
          std::cout << "zip boing\n";
        }
        else if(i % 3 == 0){
            std::cout << "zip\n";
         }
        else if(i % 7 == 0){
          std::cout << "boing\n";
        }
        else{
          std::cout << i << "\n";
        }
    }
}
