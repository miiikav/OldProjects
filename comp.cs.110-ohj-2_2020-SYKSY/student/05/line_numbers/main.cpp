#include <iostream>
#include <fstream>  // Huomaa kirjasto
#include <string>
#include <sstream>

using namespace std;

int main() {
    string input_file = "";
    string output_file = "";
    std::cout << "Input file: ";
    getline(std::cin, input_file);
    std::cout << "Output file: ";
    getline(std::cin, output_file);
    ifstream infile(input_file);
    if ( not infile ) {
        cout << "Error! The file "<<input_file<<" cannot be opened." << endl;
        return EXIT_FAILURE;
    }
    else{


        ofstream outfile(output_file);

        string rivi;
        string content;
        stringstream stream;
        int i=0;


        while ( getline(infile, rivi) ) {
            ++i;
            stream << i;
            string istr = stream.str();
            content += istr;
            istr="";
            stream.str(std::string());
            content += " ";
            content += rivi;
            content += "\n";
        }
        infile.close();
        outfile << content;                 // output
        outfile.close();
        return 0;
    }
}
