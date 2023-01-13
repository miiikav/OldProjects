#include <iostream>
#include <fstream>  // Huomaa kirjasto
#include <string>
#include <sstream>
#include <limits>
#include <map>

using namespace std;

int extractIntegerWords(string str)
{
    size_t last_index = str.find_last_not_of("0123456789");
    string result = str.substr(last_index + 1);
    int intresult = stoi(result);
    return intresult;
}

int main() {
    map<string, int> scoreboard;
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

        string rivi;
        string compareRow;
        string content ="Final scores:\n";
        int i=0;
        int score=0;
        while ( getline(infile, rivi) ) {

            score = extractIntegerWords(rivi);
            //std::cout << "score: "<<score;
            //infile.seekg(i);
            while ( getline(infile, compareRow) ) {
                //for (int j = 0; j < i; j++) {
                    //infile.ignore(numeric_limits<streamsize>::max(), '\n');
                //}
                std::string delimiter = ":";
                std::string token = rivi.substr(0, rivi.find(delimiter));
                std::string compareToken = compareRow.substr(0, compareRow.find(delimiter));
                //cout <<"token: "<<token<< endl;
                //cout <<"compareToken: "<<compareToken<< endl;
                //cout <<token.compare(compareToken)<< endl;
                 if (token.compare(compareToken)==0){
                     int compareScore=extractIntegerWords(compareRow);
                     //std::cout << "compareScore: "<<compareScore<<endl;
                     //std::cout << "score: "<<score<<endl;
                     if(scoreboard.find(token) != scoreboard.end()){
                         score+=compareScore;
                         scoreboard.at(token)+= score;

                     }
                     else{
                         score+=compareScore;
                         scoreboard.insert({token,score});
                     }
                 }
                 else if(scoreboard.find(token) != scoreboard.end()){
                     //scoreboard.at(token)+= score;
                     //cout <<"test: "<<token<< endl;
                 }
                 else{
                     scoreboard.insert({token,score});
                 }

            }++i;
            //ifstream infile(input_file);//Just in case infile.ignore deletes lines
            compareRow.clear();
            score=0;
            infile.clear();
            infile.seekg(0);
            for (int j = 0; j < i; j++) {
                infile.ignore(numeric_limits<streamsize>::max(), '\n');
            }
        }

        infile.close();
        cout <<content;
        map<string,int>::iterator iter;
        iter = scoreboard.begin();
        while ( iter != scoreboard.end() ) {
            cout << iter->first << ": "
                 << iter->second << endl;
            ++iter;
        }
        return 0;
    }
}
