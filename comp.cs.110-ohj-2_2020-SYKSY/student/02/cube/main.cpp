#include <iostream>

using namespace std;

int main()
{
    int new_integer = 0;
    int cube = 0;
    cout << "Enter a number: ";
    cin >> new_integer;
    cube = new_integer * new_integer * new_integer;
    if (cube >= 0){
        cout << "The cube of "<< new_integer <<" is "<< cube<<".";
    }
    else{
        cout << "Error! The cube of "<< new_integer <<" is not "<< cube<<".";
    }

    return 0;
}
