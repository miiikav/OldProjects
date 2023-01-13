#include <iostream>
#include <string>
#ifndef RECURSIVE_FUNC
#define RECURSIVE_FUNC
#endif

bool palindrome_recursive(std::string s)
{
  RECURSIVE_FUNC
  // Do not remove RECURSIVE_FUNC declaration, it's necessary for automatic testing to work
  // ------------


  // Add your implementation here
          int len = s.length();
          char start = s.at(0);
          char end = s.at(0);

          if(len>1){
              end = s.at(len-1);
          }

          if(start == end && len<=2){
              return true;
          }
          else if(start != end){
              return false;
          }
          else{
              s = s.substr(1, s.size() - 2);
              return palindrome_recursive(s);
          }
}

// Do not modify rest of the code, or the automated testing won't work.
#ifndef UNIT_TESTING
int main()
{
    std::cout << "Enter a word: ";
    std::string word;
    std::cin >> word;

    if(palindrome_recursive(word)){
        std::cout << word << " is a palindrome" << std::endl;
    } else {
        std::cout << word << " is not a palindrome" << std::endl;
    }
}
#endif
