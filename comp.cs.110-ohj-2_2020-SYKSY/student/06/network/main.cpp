#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>
#include <iterator>

const std::string HELP_TEXT = "S = store id1 i2\nP = print id\n"
                              "C = count id\nD = depth id\n";


std::vector<std::string> split(const std::string& s, const char delimiter, bool ignore_empty = false){
    std::vector<std::string> result;
    std::string tmp = s;

    while(tmp.find(delimiter) != std::string::npos)
    {
        std::string new_part = tmp.substr(0, tmp.find(delimiter));
        tmp = tmp.substr(tmp.find(delimiter)+1, tmp.size());
        if(not (ignore_empty and new_part.empty()))
        {
            result.push_back(new_part);
        }
    }
    if(not (ignore_empty and tmp.empty()))
    {
        result.push_back(tmp);
    }
    return result;
}

void print(std::string id,std::map <std::string,std::map<int,std::string>> data){
    std::map <std::string,std::map<int,std::string>>   :: iterator itr;
    itr=data.find(id);
    if (itr != data.end()){
        /**for(auto const &itr : data) {*/
          std::cout  << itr->first<<" ";
          // ent1.first is the first key
          for(auto const &itr2 : itr->second) {
            // ent2.first is the second key
              std::cout  << itr2.first<<" ";
            // ent2.second is the data
              //std::cout  << itr2.second;
          }
          std::cout << std::endl ;
        //}
    }
    else{
        //std::cout  << itr2.first
    }

}
void count(std::string id,std::map <std::string,std::map<int,std::string>> data){
    std::map <std::string,std::map<int,std::string>>   :: iterator itr;
    itr=data.find(id);
    int count=0;
    if (itr != data.end()){
        std::cout  << itr->first<<" ";
        auto const itr2=itr->second;
        if(0==0){

        }


        std::cout  <<count << std::endl;
    }
}
void depth(std::string id,std::map <std::string,std::map<int,std::string>> data,int& x){
    std::map <std::string,std::map<int,std::string>>   :: iterator itr;
    std::map <std::string,std::map<int,std::string>>   :: iterator itr2;
    itr=data.find(id);
    itr2=itr;
    int count=x;
    if (itr != data.end()){
        std::cout  << itr->first<<" ";
        std::cout  << itr->second[0]<<" ";
        //std::cout  << itr->second[0][0]<<" ";
        //itr->second[0][0];
        itr2++;
        if(itr2->first==itr->second[0]){
            x++;
            depth(itr->second[0],data,x);
        }
        else{
            std::cout  <<count << std::endl;
            x=0;
        }


    }
    else{
        std::cout  <<count << std::endl;
        x=0;
    }
}
int main()
{
    // TODO: Implement the datastructure here
    std::map <std::string,std::map<int,std::string>> data;
    std::map <std::string,std::map<int,std::string>>   :: iterator itr;
    int i = 0;
    int x = 0;

    while(true){
        std::string line;
        std::cout << "> ";
        getline(std::cin, line);
        std::vector<std::string> parts = split(line, ' ', true);

        std::string command = parts.at(0);

        if(command == "S" or command == "s"){
            if(parts.size() != 3){
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id1 = parts.at(1);
            std::string id2 = parts.at(2);
            data.insert(std::make_pair(id1,std::map<int,std::string>()));
            data.at(id1).insert(std::make_pair(i,id2));
            i++;

            // TODO: Implement the command here!

        } else if(command == "P" or command == "p"){
            if(parts.size() != 2){
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id = parts.at(1);
            itr=data.find(id);

            /**for ( itr = data.begin(); itr != data.end(); itr++ ){
                std::cout << itr->first; // string (key)
                std::cout  << ':';
                std::cout  << itr->second[0];   // string's first value
                std::cout << std::endl ;


            }*/
            /**for(auto const &itr : data) {*/
              std::cout  << itr->first<<" ";
              // ent1.first is the first key
              for(auto const &itr2 : itr->second) {
                // ent2.first is the second key
                  std::cout  << itr2.first<<" ";
                // ent2.second is the data
                  //std::cout  << itr2.second;
              }
              std::cout << std::endl ;
            //}
            //std::cout << "a => " << list.equal_range(0)->first.find(id)->second << '\n';

            // TODO: Implement the command here!

        } else if(command == "C" or command == "c"){
            if(parts.size() != 2){
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id = parts.at(1);

            // TODO: Implement the command here!
            count(id,data);

        } else if(command == "D" or command == "d"){
            if(parts.size() != 2){
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id = parts.at(1);
            depth(id,data,x);

            // TODO: Implement the command here!

        } else if(command == "Q" or command == "q"){
           return EXIT_SUCCESS;
        } else {
            std::cout << "Erroneous command!" << std::endl << HELP_TEXT;
        }
    }
}
