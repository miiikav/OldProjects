#include <iostream>
#include <string>
#include <vector>


// TODO: Implement split function here
// Do not change main function

std::vector<std::string> split(std::string inputString,char separator,bool ignore=false){
    std::string buff{""};
    std::vector<std::string> v;
    if(ignore==true){
        for(auto n:inputString)
        {
            if(n != separator) buff+=n; else
            if(n == separator && buff != "") { v.push_back(buff); buff = ""; }
        }
        if(buff != "") v.push_back(buff);
    }
    else{
        for(auto n:inputString)
        {
            if(n != separator && buff == ""){
                buff+=n;
            }
            if(n == separator && buff == ""){
                buff=" ";
                v.push_back(buff);
                buff = "";
            }
            if(n != separator && buff.at(0)==separator){
                v.push_back(buff);
                buff = "";
                buff+=n;
            }
            else if(n != separator && buff.at(0)!=separator){
                buff+=n;
            }
            else if(n == separator && buff.at(0)==separator){
                v.push_back(buff);
                buff=" ";
                v.push_back(buff);
                buff = "";
            }
            else if(n == separator && buff.at(0)!=separator){
                v.push_back(buff);
                buff = " ";
                v.push_back(buff);
                buff = "";

            }


        }
        if(buff != "") v.push_back(buff);
    }

    return v;
}
int main()
{
    std::string line = "";
    std::cout << "Enter a string: ";
    getline(std::cin, line);
    std::cout << "Enter the separator character: ";
    char separator = getchar();

    std::vector< std::string > parts  = split(line, separator);
    std::cout << "Splitted string including empty parts: " << std::endl;
    for( auto part : parts ) {
        std::cout << part << std::endl;
    }

    std::vector< std::string > parts_no_empty  = split(line, separator, true);
    std::cout << "Splitted string ignoring empty parts: " << std::endl;
    for( auto part : parts_no_empty ) {
        std::cout << part << std::endl;
    }
}
