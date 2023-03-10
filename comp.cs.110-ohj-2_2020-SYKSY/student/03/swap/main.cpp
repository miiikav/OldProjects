#include <cstdlib>
#include <iostream>

// Write your swap function here.
int swap(int &a,int &b) {
    int temp1 = a;
    a=b;
    b=temp1;
    return a + b;
}


#ifndef UNIT_TESTING

int main()
{
    std::cout << "Enter an integer: ";
    int i = 0;
    std::cin >> i;

    std::cout << "Enter another integer: ";
    int j = 0;
    std::cin >> j;

    swap(i, j);
    std::cout << "The integers are " << i << " and " << j << std::endl;

    return EXIT_SUCCESS;
}

#endif
