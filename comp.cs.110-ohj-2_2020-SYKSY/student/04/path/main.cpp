/* Polku
 *
 * Kuvaus:
 *  Ohjelma toteuttaa Polku-älypelin. Pelilauta on kooltaan ROWS x COLUMNS
 * (5x4), ja joka kierroksella pelaaja antaa lähtö- ja kohdepisteet (yhteensä
 * neljä lukua), minkä jälkeen kyseinen nappula siirretään kohdepisteeseen
 * (mikäli mahdollista). Ohjelma tarkistaa, voidaanko käyttäjän antama siirto
 * tehdä.
 *  Aluksi kaikki vihreät nappulat ovat ylimmällä rivillä ja kaikki punaiset
 * nappulat alimmalla. Peli päättyy, kun kaikki vihreät nappulat on siirretty
 * alimmalle riville ja kaikki punaiset ylimmälle. Nappulat eivät saa hyppiä
 * toistensa yli.
 *  Pelilauta piirretään niin, että 'G' tarkoittaa vihreää (green) nappulaa,
 * 'R' punaista (red) nappulaa, 'o' tyhjää kohtaa ja välilyönti kohtaa, joka
 * ei ole käytässä.
 *
 * Ohjelman kirjoittaja ( Täytä omilla tiedoillasi )
 * Nimi: Tuomo Ikävalko
 * Opiskelijanumero: 427620
 * Käyttäjätunnus: ti427620 ( Git-repositorion hakemistonimi. )
 * E-Mail: tuomo.ikavalko@tuni.fi
 * Palautteen kieli (fi/en): fi
 *
 * Huomioita ohjelmasta ja sen toteutuksesta:
 *
 * */
#include <iostream>
#include <vector>
#include <sstream>
#include <iterator>

using namespace std;

enum Slot_type {RED, GREEN, EMPTY, UNUSED};
const unsigned int ROWS = 5;
const unsigned int COLUMS = 4;

const string INPUT_TEXT = "Enter start point (x, y) and destination point (x, y), or q to quit: ";
const string INVALID_POINT = "Invalid start/destination point.";
const string CANNOT_MOVE = "There is no path between start point and destination point.";
const string GAME_OVER = "Game over. Congratulations!";
const string MOVES_MADE = " move(s) made.";

// Prints the grid
void print(const std::vector<vector<int>>/*vector of vectors or a compatible type*/& g)
{
    cout << "===============" << endl;
    cout << "|   | 1 2 3 4 |" << endl;
    cout << "---------------" << endl;
    for(unsigned int i = 0; i < ROWS; ++i)
    {
        cout << "| " << i + 1 << " | ";
        for(unsigned int j = 0; j < COLUMS; ++j)
        {
            switch(g.at(i).at(j))
            {
            case GREEN: cout << "G "; break;
            case RED: cout << "R "; break;
            case EMPTY: cout << "o "; break;
            case UNUSED: cout << "  "; break;
            }
        }
        cout << "|" << endl;
    }
    cout << "===============" << endl;
}

// Converts the given numeric string to the corresponding integer
// (by calling stoi).
// If the given string is not numeric, returns 0.
unsigned int stoi_with_check(const string& str)
{
    bool is_numeric = true;
    for(unsigned int i = 0; i < str.length(); ++i)
    {
        if(not isdigit(str.at(i)))
        {
            is_numeric = false;
            break;
        }
    }
    if(is_numeric)
    {
        return stoi(str);
    }
    else
    {
        return 0;
    }
}

// More functions
//Funktio on ylöspäin liikkumisen koodia varten, se palauttaa numeroita 0-3, jotka antavat eri status koodeja
int moveUpCode(int y,std::vector<vector<int> >& currentTable,vector<int>& currentMove, int start){
    //cout<<y;
    if(y != currentMove.at(0)-1){
        //Tarkistetaan osuuko polku nappulaan
        if((currentTable[currentMove.at(1)-1][y]==RED) || (currentTable[currentMove.at(1)-1][y]==GREEN)){
            //cout<<"debug1";
            return 2;
        }//Tarkistetaan osuuko polku päätepisteeseen
        else if(y == currentMove.at(2)-1 && currentMove.at(1)-1==currentMove.at(3)-1){
            currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
            if(start==0){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
            }
            else if(start==1){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
            }
            return 3;
        }
        else{//jatkuu
            //for luuppi 2. saraketta pitkin, kunnes törmää oikeaan riviin
            for (int x = currentMove.at(1)-1; x <= currentMove.at(3)-1 ; x++) {
                //Tarkistetaan osuuko polku nappulaan
                if(((currentTable[x].at(2)==RED) || (currentTable[x].at(2)==GREEN)) && currentTable[x].at(1)!=currentTable[currentMove.at(0)-1].at(1)){
                    //cout<<"debug2";
                    return 2;
                }//Tarkistetaan osuuko polku päätepisteeseen
                else if(1 == currentMove.at(2)-1 && x==currentMove.at(3)-1){
                    currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                    if(start==0){
                        currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                    }
                    else if(start==1){
                        currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                    }
                    return 3;
                }
                else{//currentMove.at(3)-1 rivi, josta yritetään päästä oikeaan sarakkeeseen
                    for (int y = 2; y <= currentMove.at(2)-1 ; y++) {
                        //Tarkistetaan osuuko polku nappulaan
                        if((currentTable[currentMove.at(3)-1][y]==RED) || (currentTable[currentMove.at(3)-1][y]==GREEN)){
                            //cout<<"debug3";
                            return 2;
                        }//Tarkistetaan osuuko polku päätepisteeseen
                        else if(y == currentMove.at(2)-1){
                            currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                            if(start==0){
                                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                            }
                            else if(start==1){
                                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                            }
                            return 3;
                        }
                    }
                }
            }
            currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
            if(start==0){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
            }
            else if(start==1){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
            }
            return 3;
        }
    }//Tarkistetaan osuuko polku päätepisteeseen
    else if(1 == currentMove.at(2) && currentMove.at(1)==currentMove.at(3)){
        currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
        if(start==0){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
        }
        else if(start==1){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
        }
        return 3;
    }
    else{//jatkuu
        //for luuppi 2. saraketta pitkin, kunnes törmää oikeaan riviin
        for (int x = currentMove.at(1)-1; x <= currentMove.at(3)-1 ; x++) {
            //Tarkistetaan osuuko polku nappulaan
            if(((currentTable[x].at(1)==RED) || (currentTable[x].at(1)==GREEN)) && currentTable[x].at(1)!=currentTable[currentMove.at(1)-1].at(1)){

                //cout<<"debug2"<<currentTable[x].at(1)<<currentTable[currentMove.at(0)].at(2);
                return 2;
            }//Tarkistetaan osuuko polku päätepisteeseen
            else if(1 == currentMove.at(2)-1 && x==currentMove.at(3)-1){
                currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                if(start==0){
                    currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                }
                else if(start==1){
                    currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                }
                return 3;
            }
            else{//currentMove.at(3)-1 rivi, josta yritetään päästä oikeaan sarakkeeseen
                for (int y = 2; y <= currentMove.at(2)-1 ; y++) {
                    //Tarkistetaan osuuko polku nappulaan
                    if((currentTable[currentMove.at(3)-1][y]==RED) || (currentTable[currentMove.at(3)-1][y]==GREEN)){
                        //cout<<"debug3";
                        return 2;
                    }//Tarkistetaan osuuko polku päätepisteeseen
                    else if(y == currentMove.at(2)-1){
                        currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                        if(start==0){
                            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                        }
                        else if(start==1){
                            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                        }
                        return 3;
                    }
                }
            }
        }//jos ei ole törmätty muihin nappuloihin niin polku on valmis
        currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
        if(start==0){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
        }
        else if(start==1){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
        }
        return 3;

    }
    cout<<"return 0 debug1";
    return 0;
}
//Funktio on nappuloiden ylöspäin liikuttamista varten,
//se tarkistaa kuinka lähellä sarake 2 on, ja lähettää syötteen eteenpäin
int moveUp(std::vector<vector<int> >& currentTable,vector<int>& currentMove, int start){
    //Tarkistetaan kuinka lähellä sarake 2 on
    if(currentMove.at(0)==1 || currentMove.at(0)==2){
        //Aloitusrivi, josta yritetään päästä oikeaan sarakkeeseen
        for (int y = currentMove.at(0)-1; y <= 1; y++) {
            int result = moveUpCode(y,currentTable,currentMove,start);
            switch(result) {//Paluuarvot lähetetään eteenpäin move funktiolle
              case 0:
                return result;
                break;
              case 1:
                return result;
                break;
              case 2:
                return result;
                break;
              case 3:
                return result;
                break;
              default:
                return result;
                break;
            }
        }
    }
    else{//Jos käyttäjän antama luku on 3 tai 4
        //Aloitusrivi, josta yritetään päästä oikeaan sarakkeeseen
        for (int y = currentMove.at(0)-1; y >= 1; y--) {
            int result = moveUpCode(y,currentTable,currentMove,start);
            switch(result) {//Paluuarvot lähetetään eteenpäin move funktiolle
              case 0:
                return result;
                break;
              case 1:
                return result;
                break;
              case 2:
                return result;
                break;
              case 3:
                return result;
                break;
              default:
                return result;
                break;
            }
        }
    }
    cout<<"return 0 debug 2"<<currentMove.at(0);
    return 0;
}//Funktio on alas liikkumisen koodia varten, se palauttaa numeroita 0-3, jotka antavat eri status koodeja
int moveDownCode(int y,std::vector<vector<int> >& currentTable,vector<int>& currentMove,int start){
    if(y != currentMove.at(0)-1){
        //Tarkistetaan osuuko polku nappulaan
        if((currentTable[currentMove.at(1)-1][y]==RED) || (currentTable[currentMove.at(1)-1][y]==GREEN)){
            //cout<<"debug1";
            return 2;
        }//Tarkistetaan osuuko polku päätepisteeseen
        else if(y == currentMove.at(2)-1 && currentMove.at(1)-1==currentMove.at(3)-1){
            currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
            if(start==0){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
            }
            else if(start==1){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
            }
            return 3;
        }
        else{//jatkuu
            //for luuppi 2. saraketta pitkin, kunnes törmää oikeaan riviin
            for (int x = currentMove.at(1)-1; x >= currentMove.at(3)-1 ; x--) {
                //Tarkistetaan osuuko polku nappulaan
                if(((currentTable[x].at(1)==RED) || (currentTable[x].at(1)==GREEN)) && currentTable[x].at(1)!=currentTable[currentMove.at(0)-1].at(1)){
                    //cout<<"debug2";
                    return 2;
                }//Tarkistetaan osuuko polku päätepisteeseen
                else if(1 == currentMove.at(2)-1 && x==currentMove.at(3)-1){
                    currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                    if(start==0){
                        currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                    }
                    else if(start==1){
                        currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                    }
                    return 3;
                }
                else{//currentMove.at(3)-1 rivi, josta yritetään päästä oikeaan sarakkeeseen
                    for (int y = 2; y <= currentMove.at(2)-1 ; y++) {
                        //Tarkistetaan osuuko polku nappulaan
                        if((currentTable[currentMove.at(3)-1][y]==RED) || (currentTable[currentMove.at(3)-1][y]==GREEN)){
                            //cout<<"debug3";
                            return 2;
                        }//Tarkistetaan osuuko polku päätepisteeseen
                        else if(y == currentMove.at(2)-1){
                            currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                            if(start==0){
                                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                            }
                            else if(start==1){
                                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                            }
                            return 3;
                        }
                    }
                }
            }
            currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
            if(start==0){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
            }
            else if(start==1){
                currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
            }
            return 3;
        }
    }//Tarkistetaan osuuko polku päätepisteeseen
    else if(1 == currentMove.at(2) && currentMove.at(1)-1==currentMove.at(3)-1){
        currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
        if(start==0){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
        }
        else if(start==1){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
        }
        return 3;
    }
    else{//jatkuu
        //cout<<"jatkuu";
        if(((currentTable[currentMove.at(1)-1][y]==RED) || (currentTable[currentMove.at(1)-1][y]==GREEN)) && currentTable[currentMove.at(1)-1][y]!=currentTable[currentMove.at(1)-1][currentMove.at(0)-1]){
            //cout<<"debug1";
            return 2;
        }
        //for luuppi 2. saraketta pitkin, kunnes törmää oikeaan riviin
        for (int x = currentMove.at(1)-1; x >= currentMove.at(3)-1 ; x--) {
            //Tarkistetaan osuuko polku nappulaan
            if(((currentTable[x].at(1)==RED) || (currentTable[x].at(1)==GREEN)) && currentTable[x].at(1)!=currentTable[currentMove.at(1)-1].at(1)){
                //cout<<"debug2";
                return 2;
            }//Tarkistetaan osuuko polku päätepisteeseen
            else if(1 == currentMove.at(2)-1 && x==currentMove.at(3)-1){
                currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                if(start==0){
                    currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                }
                else if(start==1){
                    currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                }
                return 3;
            }
            else{//currentMove.at(3)-1 rivi, josta yritetään päästä oikeaan sarakkeeseen
                for (int y = 2; y <= currentMove.at(2)-1 ; y++) {
                    //Tarkistetaan osuuko polku nappulaan
                    if((currentTable[currentMove.at(3)-1][y]==RED) || (currentTable[currentMove.at(3)-1][y]==GREEN)){
                        //cout<<"debug3";
                        return 2;
                    }//Tarkistetaan osuuko polku päätepisteeseen
                    else if(y == currentMove.at(2)-1){
                        currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
                        if(start==0){
                            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
                        }
                        else if(start==1){
                            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
                        }
                        return 3;
                    }
                }
            }
        }//jos ei ole törmätty muihin nappuloihin niin polku on valmis
        currentTable[currentMove.at(1)-1][currentMove.at(0)-1]=EMPTY;
        if(start==0){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=RED;
        }
        else if(start==1){
            currentTable[currentMove.at(3)-1][currentMove.at(2)-1]=GREEN;
        }
        return 3;
    }
    //cout<<"return 0 debug 3";
    return 0;
}
//Funktio on nappuloiden alaspäin liikuttamista varten,
//se tarkistaa kuinka lähellä sarake 2 on, ja lähettää syötteen eteenpäin
int moveDown(std::vector<vector<int> >& currentTable,vector<int>& currentMove ,int start){
    //Tarkistetaan kuinka lähellä sarake 2 on
        if(currentMove.at(0)==1 || currentMove.at(0)==2){
            //Aloitusrivi, josta yritetään päästä oikeaan sarakkeeseen
            for (int y = currentMove.at(0)-1; y <= 1; y++) {
                int result = moveDownCode(y,currentTable,currentMove,start);
                switch(result) {//Paluuarvot lähetetään eteenpäin move funktiolle
                  case 0:
                    return result;
                    break;
                  case 1:
                    return result;
                    break;
                  case 2:
                    return result;
                    break;
                  case 3:
                    return result;
                    break;
                  default:
                    return result;
                    break;
                }
            }
        }
        else{//Jos käyttäjän antama luku on 3 tai 4
            //Aloitusrivi, josta yritetään päästä oikeaan sarakkeeseen
            for (int y = currentMove.at(0)-1; y >= 1; y--) {
                int result = moveDownCode(y,currentTable,currentMove,start);
                switch(result) {//Paluuarvot lähetetään eteenpäin move funktiolle
                  case 0:
                    return result;
                    break;
                  case 1:
                    return result;
                    break;
                  case 2:
                    return result;
                    break;
                  case 3:
                    return result;
                    break;
                  default:
                    return result;
                    break;
                }
            }
        }
        cout<<"return 0 debug 4";
        return 0;
}
//Funktio tarkistaa käyttäjä syötteen eri ominaisuuksia
//ja lähettää sen eteenpäin moveUp tai moveDown
//funktioille jotka antavat lopulta paluuarvon, joka lähetetään Input funktiolle
int move(std::vector<vector<int> >& currentTable,vector<int>& currentMove){
    //currentTable;
    //currentMove;
    //Look for the start point
    int start=0;
    int destination=0;
    try {//Tarkistetaan ovatko pisteet pelilaudalla
        start = currentTable.at(currentMove.at(1)-1).at(currentMove.at(0)-1);         // x=.at(0),y=.at(1)
        destination = currentTable.at(currentMove.at(3)-1).at(currentMove.at(2)-1);   // x=.at(2),y=.at(3)
    }
    catch (const std::out_of_range& e) {
    //std::cout<<"test";
        return 1;
    }
    //cout<<"start:"<<start<<endl;
    //cout<<"destination:"<<destination<<endl;
    //cout<<"currentMove.at(0):"<<currentMove.at(0)<<endl;
    //cout<<"currentMove.at(1):"<<currentMove.at(1)<<endl;
    //cout<<"currentMove.at(2):"<<currentMove.at(2)<<endl;
    //cout<<"currentMove.at(3):"<<currentMove.at(3)<<endl;
    //Tarkistetaan pisteet(ovatko ne punaisia/vihreitä ja onko maaliruutu tyhjä)
    if(((start==0) || (start==1)) && (destination==2)){
        //Tarkistetaan ovatko lähtö ja kohdepisteet samoja
        if(currentMove.at(0)==currentMove.at(2) && currentMove.at(1)==currentMove.at(3)){

            return 1;
        }
        else{//alas vai ylös
            if(currentMove.at(1)<=currentMove.at(3)){//ylös esim 1<5
                //cout<<"ylös";
                int result = moveUp(currentTable,currentMove,start);
                switch(result) {
                  case 0:
                    return result;
                    break;
                  case 1:
                    return result;
                    break;
                  case 2:
                    return result;
                    break;
                  case 3:
                    return result;
                    break;
                  default:
                    return result;
                    break;
                }

            }
            else if(currentMove.at(1)>=currentMove.at(3)){//alas esim 5>1
                //cout<<"alas";
                int result = moveDown(currentTable,currentMove,start);
                switch(result) {
                  case 0:
                    return result;
                    break;
                  case 1:
                    return result;
                    break;
                  case 2:
                    return result;
                    break;
                  case 3:
                    return result;
                    break;
                  default:
                    return result;
                    break;
                }
            }


        }
    }
    else{
        //std::cout<<"return 1 vika lähtö- tai kohdepisteessä";
        return 1;

    }
std::cout<<"end of line  return 0";
    return 0;

}

//Funktio pilkkoo käyttäjän syötteen ja lisää sen vektoriin
vector<int> split(string inputString){
    //cout<<inputString;
    std::stringstream iss( inputString );
    int number;
    std::vector<int> myNumbers;
    while ( iss >> number )
      myNumbers.push_back( number );

    return myNumbers;

}
//Funktio tarkistaa loppuiko peli
bool win(std::vector<vector<int> > currentTable){
    for (int i = 0; i <= 3; i++) {
        if(currentTable.at(0)[i]!=0){
            return false;
            break;
        }
        if(currentTable[4][i]!=1){
            return false;
            break;
        }
    }
    return true;
}
//Funktio hoitaa käyttäjän syötteet
void input(std::vector<vector<int> > currentTable, std::string inputString, bool running){
    int moves=0;//laskee siirtojen määrän
    while(running==true){//Ohjelma pysyy luupissa
        bool stoiCheck=false;//Syötteen virheellisyys
        std::cout<<INPUT_TEXT;
        getline(cin, inputString);
        if(inputString=="q"){//painoiko käyttäjä q:ta
            std::cout<<moves<<MOVES_MADE;//tulostaa siirtojen määrän
            running=false;//sammuta ohjelma

        }
        else{
            for (unsigned long i = 0; i < inputString.length(); i++) {
                std::string delimiter = " ";
                std::string token = inputString.substr(i, inputString.find(delimiter));
                if(token!=" "){
                    if(stoi_with_check(token)==0){
                        stoiCheck=true;
                    }
                }
            }
            if(stoiCheck==true){
                cout<<INVALID_POINT<<std::endl;
                //break;
            }
            else {//Jos syöte läpäisee stoi chekin se voi jatkaa
                vector<int> currentMove= split(inputString);
                switch(move(currentTable,currentMove)) {
                case 0://Virhe
                    std::cout<<"Error return 0";
                    break;
                case 1://Siirto epäonnistui, tulosta virhekoodi
                    std::cout<<INVALID_POINT<<std::endl;
                    break;
                case 2://Siirto epäonnistui, tulosta virhekoodi
                    std::cout<<CANNOT_MOVE<<std::endl;
                    break;
                case 3://Siirto onnistui, tulosta taulukko
                    print(currentTable);
                    moves++;
                    if(win(currentTable)==true){//Tarkista onko peli ohi
                        std::cout<<GAME_OVER<<std::endl;
                        std::cout<<moves<<MOVES_MADE;//tulostaa siirtojen määrän
                        running=false;//sammuta ohjelma
                    }
                    break;
                default:
                    std::cout<<"Error default";
                    running=false;
                    break;
                }
            }
        }
    }
}

int main(){
    // More code
    bool running=true;
    std::vector<vector<int> > start{ { GREEN, GREEN, GREEN, GREEN },
                                     { UNUSED, EMPTY, UNUSED, UNUSED },
                                     { UNUSED, EMPTY, EMPTY, UNUSED },
                                     { UNUSED, EMPTY, UNUSED, UNUSED },
                                     { RED, RED, RED, RED } }; ;

    print(start);
    std::vector<vector<int> > currentTable = start;
    //std::cout << currentTable[4].at(0);//0 x=5 y=1
    //std::cout << currentTable.at(3).at(1);//2 x=2 y=4
    std::string inputString="1 2 3 3";
    input(currentTable,inputString,running);

}
