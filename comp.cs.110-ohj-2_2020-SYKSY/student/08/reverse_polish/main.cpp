#include <iostream>
#include <array>
using namespace std;

int main(){
    //taulukko_osoitin = luvut;
    // while ( taulukko_osoitin < luvut + 3 ) {
    //     cout << *taulukko_osoitin << endl;
    //     ++taulukko_osoitin;
    // }
    string line;
    std::cout << "Input an expression in reverse Polish notation (end with #):" << std::endl;
    std::cout <<"EXPR> ";
    getline(std::cin, line);
    int operand_counter=0;
    int operator_counter=0;
    if('+' == line.at(0)||'-' == line.at(0)||'*' == line.at(0)||'/' == line.at(0)){
        std::cout <<"Error: Expression must start with a number";
        return EXIT_FAILURE;
    }
    else{
        for(char& c : line) {
            if('0' == c && c == '/'){
                std::cout <<"Error: Division by zero";
                return EXIT_FAILURE;
            }
            if('0' <= c && c <= '9'){
                operand_counter++;
            }
            else if('+' == c||'-' == c||
                    '*' == c||'/' == c){
                operator_counter++;

            }
            else if('#' == c){
                operator_counter++;
                break;
            }
            else if(' ' != c){
                std::cout <<"Error: Unknown character";
                return EXIT_FAILURE;
            }

        }
    }
    if(operand_counter==operator_counter){
        int array[operand_counter];
        int size=0;
        for(char& c : line) {
            if('0' <= c && c <= '9'){
                array[size]=c - '0';
                size++;
            }
            else if('+' == c||'-' == c||
                    '*' == c||'/' == c){
                int tempnum=0;
                switch (c) {
                  case '+':
                    tempnum=array[size-2]+array[size-1];
                    break;
                  case '-':
                    tempnum=array[size-2]-array[size-1];
                    break;
                  case '*':
                    tempnum=array[size-2]*array[size-1];
                    break;
                  case '/':
                    if('0' == array[size-2]||'0' == array[size-1]){
                        std::cout <<"Error: Division by zero";
                        return EXIT_FAILURE;
                    }
                    tempnum=array[size-2]/array[size-1];
                    break;
                }
                array[size-2]=0;
                array[size-1]=0;
                array[size-2]=tempnum;
                size--;
            }
            else if('#' == c){
                break;
            }
        }
        std::cout <<"Correct: "<<array[0]<<" is the result";
        return EXIT_SUCCESS;
    }
    else if(operand_counter>operator_counter){
        std::cout <<"Error: Too few operators";
        return EXIT_FAILURE;
    }
    else if(operand_counter<operator_counter){
        std::cout <<"Error: Too few operands";
        return EXIT_FAILURE;
    }

    return 0;
}
