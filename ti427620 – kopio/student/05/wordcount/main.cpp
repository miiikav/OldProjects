#include <iostream>
#include <fstream>  // Huomaa kirjasto
#include <string>
#include <sstream>
#include <algorithm>
#include <map>
#include <functional>
#include <vector>
#include<unordered_set>

using namespace std;


int main() {
    string input_file = "";
    string output_file = "";
    std::cout << "Input file: ";
    getline(std::cin, input_file);
    ifstream infile(input_file);
    if ( not infile ) {
        cout << "Error! The file "<<input_file<<" cannot be opened." << endl;
        return EXIT_FAILURE;
    }
    else{
        map<string, std::vector<int>, std::less<std::string>> wordcount;
        string rivi;
        string content;
        stringstream stream;
        int rowCount=1;
        string tokenTest;


        while ( getline(infile, rivi) ) {

            //std::string::iterator it;
            //it = std::unique (rivi.begin(), rivi.end());   // 10 20 30 20 10 ?  ?  ?  ?
            //std::cout << it[0] << std::endl;
            //rivi.resize( std::distance(rivi.begin(),it) ); // 10 20 30 20 10
            rivi.append(" ");
            //std::cout << rivi << std::endl;
            unordered_set<string> hsh;
            std::string delimiter = " ";
            size_t pos = 0;
            std::string token;


            while ((pos = rivi.find(delimiter)) != std::string::npos) {
                token = rivi.substr(0, pos);

                while (hsh.find(token) == hsh.end()) {
                    hsh.insert(token);

                //std::cout << token << std::endl;
                if(wordcount.find(token) != wordcount.end()){
                         wordcount.at(token)[0]+= 1;
                         if(wordcount.at(token)[1]==0 && wordcount.at(token)[0]==1){
                             wordcount.at(token)[1]= rowCount;
                             //rowCount++;
                         }
                         else if(wordcount.at(token)[2]==0 && wordcount.at(token)[0]==2){
                             wordcount.at(token)[2]= rowCount;
                             //rowCount++;
                         }
                         else if(wordcount.at(token)[3]==0 && wordcount.at(token)[0]==3){
                             wordcount.at(token)[3]= rowCount;
                             //rowCount++;
                         }
                         else if(wordcount.at(token)[4]==0 && wordcount.at(token)[0]==4){
                             wordcount.at(token)[4]= rowCount;
                         }
                         else if(wordcount.at(token)[5]==0 && wordcount.at(token)[0]==5){
                             wordcount.at(token)[5]= rowCount;
                         }
                         else if(wordcount.at(token)[6]==0 && wordcount.at(token)[0]==6){
                             wordcount.at(token)[6]= rowCount;
                         }

                }
                else{
                         wordcount.insert({token,{1,rowCount}});
                         //rowCount++;
                }
                }

                rivi.erase(0, pos + delimiter.length());
            }rowCount++;
            hsh.clear();
            //std::cout << "token test" << std::endl;
        }
        map<string,std::vector<int>,std::less<std::string>>::iterator iter;
        iter = wordcount.begin();
        while ( iter != wordcount.end() ) {
            cout << iter->first<< " "
                 << iter->second[0]<< ": "
                 << iter->second[1];
            if(iter->second[2]!=0){
                cout <<", "<< iter->second[2];
            }
            if(iter->second[3]!=0 && iter->second[3]<=32){
                cout <<", "<< iter->second[3];
            }
            if(iter->second[4]!=0 && iter->second[4]<=32){
                cout <<", "<< iter->second[4];
            }
            if(iter->second[5]!=0 && iter->second[5]<=32){
                cout <<", "<< iter->second[5];
            }
            if(iter->second[6]!=0 && iter->second[6]<=32){
                cout <<", "<< iter->second[6] <<endl;
            }
            else{
                cout<<endl;
            }

            ++iter;
        }
        infile.close();
        return 0;
    }
}
