#include <iostream>

using namespace std;
/*
void calc(int totalBalls, int drawnBalls){
    cout <<"total "<< totalBalls<<endl;
    cout <<"drawn "<<  drawnBalls<<endl;
    unsigned long int prob;
    for (int i = 1; i <= drawnBalls; i++){
        prob = prob * (totalBalls + 1 - i) / i;
        cout << prob<<endl;
    }

}*/
int calc(int n, int r)
{
    if (r == 0) return 1;

    /*
     Extra computation saving for large R,
     using property:
     N choose R = N choose (N-R)
    */
    if (r > n / 2) return calc(n, n - r);

    long res = 1;

    for (int k = 1; k <= r; ++k)
    {
        res *= n - k + 1;
        res /= k;
    }

    return res;
}
int main()
{
    int totalBalls = 0;
    int drawnBalls = 0;

    cout << "Enter the total number of lottery balls: ";
    cin >> totalBalls;
    cout << "Enter the number of drawn balls: ";
    cin >> drawnBalls;
    if (totalBalls <= 0){
        cout << "The number of balls must be a positive number.";
    }
    else if (drawnBalls <= 0){
        cout << "The number of balls must be a positive number.";
    }
    else if (drawnBalls > totalBalls){
        cout << "The maximum number of drawn balls is the total amount of balls.";
    }
    else{
       unsigned long int prob = calc(totalBalls, drawnBalls);
       cout << "The probability of guessing all "<< drawnBalls <<" balls correctly is " <<"1/"<<prob;

    }

    return 0;
}
