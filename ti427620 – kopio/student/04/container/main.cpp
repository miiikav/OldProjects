#include <cstdlib>
#include <iostream>
#include <vector>
#include <algorithm>

void read_integers(std::vector<int>& ints, int count)
{
    int new_integer = 0;
    std::vector<int>::iterator it;
    for(int i = 0; i < count; ++i)
    {
        std::cin >> new_integer;// TODO: Implement your solution here
        it = ints.begin();
        ints.insert(it,new_integer);


    }
    std::reverse(ints.begin(),ints.end());
}

// TODO: Implement your solution here
bool same_values(std::vector<int>& ints){
    bool allAreEqual =
      find_if(ints.begin() + 1,
        ints.end(),
        bind1st(std::not_equal_to<int>(), ints.front())) == ints.end();
    if(allAreEqual==true){
        return true;
    }
    else{
        return false;
    }

}
bool is_ordered_non_strict_ascending(std::vector<int>& ints){
    //std::cout << ints[0];
    //std::cout << ints[1];
    if(is_sorted(ints.begin(), ints.end())==true){
        return true;
    }
    else{
        return false;
    }
}
bool is_arithmetic_series(std::vector<int>& ints){
    bool isArith=false;
    int firstTest = ints[1] - ints[0];
    for(unsigned long i = 0; i < ints.size(); ++i){
        if(ints[i]+firstTest==ints[i+1]){
            isArith=true;
            if(ints[i+1]==ints.back()){
                break;
            }
        }
        else{
            isArith=false;
            return false;
        }
    }
    if(isArith==true){
        return true;
    }
    else{
        return false;
    }
}
bool is_geometric_series(std::vector<int>& ints){
    bool isGeo = false;
    for(unsigned long i = 0; i < ints.size(); ++i){
        if(ints[i]+ints[i]==ints[i+1]){
            isGeo=true;
            if(ints[i+1]==ints.back()){
                break;
            }
        }
        else{
            isGeo=false;
            return false;
        }
    }
    if(isGeo==true){
        return true;
    }
    else{
        return false;
    }
}

int main()
{
    std::cout << "How many integers are there? ";
    int how_many = 0;
    std::cin >> how_many;

    std::cout << "Enter the integers: ";
    std::vector<int> integers;
    read_integers(integers, how_many);

    if(same_values(integers))
        std::cout << "All the integers are the same" << std::endl;
    else
        std::cout << "All the integers are not the same" << std::endl;

    if(is_ordered_non_strict_ascending(integers))
        std::cout << "The integers are in a non-strict ascending order" << std::endl;
    else
        std::cout << "The integers are not in a non-strict ascending order" << std::endl;

    if(is_arithmetic_series(integers))
        std::cout << "The integers form an arithmetic series" << std::endl;
    else
        std::cout << "The integers do not form an arithmetic series" << std::endl;

    if(is_geometric_series(integers))
        std::cout << "The integers form a geometric series" << std::endl;
    else
        std::cout << "The integers do not form a geometric series" << std::endl;

    return EXIT_SUCCESS;
}
