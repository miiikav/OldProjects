#include "array_operations.hh"
#include <iostream>
using namespace std;
/*
 * Returns the greatest element of the array.
 * int* itemptr: pointer to the first array element to be examined
 * int size: number of elements to be examined
 * return value: the greatest element of the array
 */
int greatest_v1(int* itemptr, int size){
    int biggest=0;
    for (int i = 0; i < size; i++) {
        if(itemptr[i]>biggest){
            biggest=itemptr[i];
        }

    }
    return biggest;
}
/*
 * Returns the greatest element of the array.
 * int* itemptr: pointer to the first array element to be examined
 * int* endptr: pointer to the memory address after the last element of the array
 * return value: the greatest element of the array
 */
int greatest_v2(int* itemptr, int* endptr){
    int biggest=0;
    int i=0;
    while(&itemptr[i] != endptr) {
        if(itemptr[i]>biggest){
            biggest=itemptr[i];
        }
        i++;
    }
    return biggest;
}
/* Copies the content of the array to another array
 * int* itemptr: pointer to the first array element to be copied
 * int* endptr: pointer to the memory address after the last element of the array to be copied
 * int* targetptr: pointer to the head of the array, to which to copy
 */
void copy(int* itemptr, int* endptr, int* targetptr){
    int i=0;
    while(&itemptr[i] != endptr) {
        targetptr[i]=0;
        targetptr[i]=itemptr[i];
        i++;
    }
}
/* Reverses the elements of the array
 * int* leftptr: pointer to the first element of the reversable part
 * int* rightptr: pointer to the next memory address after the reversable part
 */
void reverse(int* leftptr, int* rightptr){
    int i=0;
    int size=0;
    while(&leftptr[i] != rightptr) {
        //cout <<size<< endl;
        size++;
        i++;
    }
    i=0;
    int temp[size];
    while(&leftptr[i] != rightptr) {
        temp[i]=leftptr[i];
        i++;
    }
    i=0;
    while(&leftptr[i] != rightptr) {
        leftptr[i]=0;
        leftptr[i]=temp[(size-1)-i];
        //leftptr[(size-1)-i]=0;
        //cout <<i<<" "<<leftptr[(size-1)-i]<< endl;
        //leftptr[(size-1)-i]=0;
        //cout <<i<<" "<<leftptr[i]<< endl;
        i++;
    }

}
