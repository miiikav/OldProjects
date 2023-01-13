#include <iostream>


// Write here a function counting the mean value

void counter(int num){
    int num2;
     float add = 0;
    for(int i = 1; i <=num; i++){
        std::cout << "Input "<< i << ". number: ";
        std::cin >> num2;
        //std::cout << "num2 test "<< num2;
        if(num2<=0){
            std::cout << "Cannot count mean value from "<< num2 << " numbers";
            break;
        }
        else{
            add += num2;
        }

    }
    std::cout << "Mean value of the given numbers is "<< add/num;
}

int main()
{
    int num = 0 ;
    std::cout << "From how many integer numbers you want to count the mean value? ";
    std::cin >> num;
    if(num<=0){
        std::cout << "Cannot count mean value from "<< num << " numbers";
    }
    else{
        counter(num);
    }

}
