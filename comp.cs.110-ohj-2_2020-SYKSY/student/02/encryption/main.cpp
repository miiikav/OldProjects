// A C++ program to illustrate Caesar Cipher Technique
#include <iostream>
using namespace std;

// This function receives text and shift and
// returns the encrypted text
string encrypt(string text, string s)
{
    string result = "";

    // traverse text
    for (unsigned long i=0;i<text.length();i++)
    {
        // apply transformation to each character
        // Encrypt Lowercase letters
        if(text[i]=='a'){
            text[i]=s[0];
            result += char(text[i]);
        }
        else if(text[i]=='b'){
            text[i]=s[1];
            result += char(text[i]);
        }
        else if(text[i]=='c'){
            text[i]=s[2];
            result += char(text[i]);
        }
        else if(text[i]=='d'){
            text[i]=s[3];
            result += char(text[i]);
        }
        else if(text[i]=='e'){
            text[i]=s[4];
            result += char(text[i]);
        }
        else if(text[i]=='f'){
            text[i]=s[5];
            result += char(text[i]);
        }
        else if(text[i]=='g'){
            text[i]=s[6];
            result += char(text[i]);
        }
        else if(text[i]=='h'){
            text[i]=s[7];
            result += char(text[i]);
        }
        else if(text[i]=='i'){
            text[i]=s[8];
            result += char(text[i]);
        }
        else if(text[i]=='j'){
            text[i]=s[9];
            result += char(text[i]);
        }
        else if(text[i]=='k'){
            text[i]=s[10];
            result += char(text[i]);
        }
        else if(text[i]=='l'){
            text[i]=s[11];
            result += char(text[i]);
        }
        else if(text[i]=='m'){
            text[i]=s[12];
            result += char(text[i]);
        }
        else if(text[i]=='n'){
            text[i]=s[13];
            result += char(text[i]);
        }
        else if(text[i]=='o'){
            text[i]=s[14];
            result += char(text[i]);
        }
        else if(text[i]=='p'){
            text[i]=s[15];
            result += char(text[i]);
        }
        else if(text[i]=='q'){
            text[i]=s[16];
            result += char(text[i]);
        }
        else if(text[i]=='r'){
            text[i]=s[17];
            result += char(text[i]);
        }
        else if(text[i]=='s'){
            text[i]=s[18];
            result += char(text[i]);
        }
        else if(text[i]=='t'){
            text[i]=s[19];
            result += char(text[i]);
        }
        else if(text[i]=='u'){
            text[i]=s[20];
            result += char(text[i]);
        }
        else if(text[i]=='v'){
            text[i]=s[21];
            result += char(text[i]);
        }
        else if(text[i]=='w'){
            text[i]=s[22];
            result += char(text[i]);
        }
        else if(text[i]=='x'){
            text[i]=s[23];
            result += char(text[i]);
        }
        else if(text[i]=='y'){
            text[i]=s[24];
            result += char(text[i]);
        }
        else if(text[i]=='z'){
            text[i]=s[25];
            result += char(text[i]);
        }
    }
    // Return the resulting string
    return result;
}

// Driver program to test the above function
bool is_all_upper(const string& text){
    for(auto& c: text)
    if(!isupper(static_cast<unsigned char>(c)))
        return false;
return true;
}
bool is_alpha(const string& text){
    for(auto& c: text)
    if(!isalpha(static_cast<unsigned char>(c)))
        return false;
return true;
}
int main()
{
    string text="ATTACKATONCE";
    string s = "abcdefghijklmnopqrstuvwxyz";
    cout << "Enter the encryption key: ";
    cin >> s;
    if(s.length()!=26){
        cout<<"Error! The encryption key must contain 26 characters.";
        return EXIT_FAILURE;
    }

    else if(is_all_upper(text)==false){
        cout<<"Error! The encryption key must contain only lower case characters.";
        return EXIT_FAILURE;
    }
    else if(is_alpha(text)==false){
        cout<<"Error! The encryption key must contain all alphabets a-z.";
        return EXIT_FAILURE;
    }
    else{
        cout << "Enter the text to be encrypted: ";
        cin >> text;
        cout << "Encrypted text: " << encrypt(text, s);
        return 0;
    }
}
