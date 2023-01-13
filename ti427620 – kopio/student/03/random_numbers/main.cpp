#include <iostream>
#include <random>
#include <string>

using namespace std;

void produce_random_numbers(unsigned int lower, unsigned int upper)
{
    // Implement your function here
    int seed=42;
    cout << "Enter a seed value or an empty line: ";
    cin >> seed;
    cout<<""<< endl;
    std::default_random_engine generator(seed);
    std::uniform_int_distribution<int> distribution(lower,upper);
    //std::string line = "";
    //char enter = '\n';
    //char temp;
    bool loop=true;
    while (loop==true) {
        int dice_roll = distribution(generator);
        cout << "Your drawn random number is " << dice_roll << endl;


        cout<<"Press enter to continue or q to quit: ";
        char temp = '\n';
        //cin.peek()
        cin.get(temp);
        //getline(std::cin, line,enter);
        //cout<<"test"<< endl;
        //cout<<"temp: "<<temp<<endl;
        //cout<<"loop: "<<loop<<endl;
        //cout<<"";
        //char temp;
        //cin.get(temp);
        //cin.clear();
        //cin.ignore( numeric_limits <streamsize> ::max(), '\n' );
        //line.erase(0,1);
        //cout<<"line: "<<line<<endl;
        //cout<<"cin: "<<std::cin.get()<<endl;
        //string line_feed = "";
        //char enter = "\n";
        //getline(cin, line_feed,enter );
        if(cin.peek() == 'q'){
            //cout<<"cin: "<<std::cin.get()<<endl;
            cin.clear();
            loop=false;
            break;
        }
        else if(cin.peek()== '\n'){
            cout<<""<<endl;

            cin.clear();


            loop=true;
            //continue;
        }
    }
}
int main()
{
    unsigned int lower_bound, upper_bound;
    cout << "Enter a lower bound: ";
    cin >> lower_bound;
    cout << "Enter an upper bound: ";
    cin >> upper_bound;

    // Reading the line feed, which was left unread by >> operator above.
    // This is necessary since the seed value will be read by getline
    // in the function produce_random_numbers.
    string line_feed = "";
    getline(cin, line_feed);

    if(lower_bound >= upper_bound)
    {
        cout << "The upper bound must be strictly greater than the lower bound" << endl;
        return EXIT_FAILURE;
    }

    produce_random_numbers(lower_bound, upper_bound);

    return EXIT_SUCCESS;
}
