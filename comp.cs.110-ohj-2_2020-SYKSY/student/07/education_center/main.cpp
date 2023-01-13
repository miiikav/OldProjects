
/* Kurssikeskus
 *
 * Kuvaus:
 *
 *  Ohjelma toteuttaa Kurssikeskus-sovelluksen, joka lukee käynnistyessään
 *  kurssikeskuksen (kansalaisopiston) kursseihin liittyviä tietoja tiedostosta,
 *  tallentaa ne sopivaan tietorakenteeseen.tietorakenteeseen tallentamisen jälkeen
 *  ohjelma poistaa tietorakenteesta kurssit jotka ovat siellä useampaan kertaan
 *  ja lopulta antaa käyttäjälle mahdollisuuden tehdä hakuja kyseiseen
 *  tietorakenteeseen.
 *  Tietorakenne on vektori jonka sisällä on map ja mapin sisällä on string avain
 *  ja struct arvo.
 *
 *  Kun käyttäjä tekee haun se pistetään saman split funktion käpi kuin
 *  tiedostoa luettaessa ja jonka paluuarvo on map, josta käyttäjän komento ja
 *  mahdolliset parametrit luetaan. Käyttäjä voi tehdä hakuja, kunnes hän kirjoittaa
 *  "quit", jonka jälkeen ohjelma sammuu.
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
#include <fstream>
#include <vector>
#include <map>
#include <algorithm>
#include <set>

using namespace std;
//struct sisältää kurssint tiedot
struct Course {
    string theme;//teema
    string name;//nimi
    int enrollments;//osallistujamäärä
};
//funktio hoitaa käyttäjän kyselyn paikkakunnista ja tulostaa vastaukset
void locations(std::vector<std::map<string,Course>> data){
    set<string> locations;
    //käy läpi paikkakunnat datasta
    for (unsigned long i = 0; i < data.size(); i++) {
        //for lisää paikkakunnan datasta set rakenteeseen, mutta koska
        //set vaatii unikkeja arvoja kaksoiskappaleet poistuvat automaattisesti
        locations.insert(data.at(i).begin()->first);
    }
    //set arvot ovat automattisesti aakkosjärjestyksessä joten ne
    //pitää vain tulostaa
    for (auto it=locations.begin(); it != locations.end(); ++it) {

        std::cout << *it<<endl;
    }

}
//funktio tulostaa kurssin nimen mukaisessa aakkosjärjestyksessä
//kaikki kyseisen paikkakunnan(string location) kurssit,jotka löytyvät kyseiseltä
//paikkakunnalta ja kyseisestä teemasta(string theme) sekä osallistujamäärät.
void courses(std::vector<std::map<string,Course>> data,string location,string theme){
    set<string> courses;
    for (unsigned long i = 0; i < data.size(); i++) {
        if(data.at(i).begin()->first==location){//etsi paikkakunta
            if(data.at(i).begin()->second.theme==theme){//etsi teema
                string name=data.at(i).begin()->second.name;
                int numEnroll=data.at(i).begin()->second.enrollments;
                string stringEnroll;
                if(numEnroll==50){//jos täynä kirjoita full
                    stringEnroll="full";
                }
                else{//jos ei muuta numero string muotoon
                    stringEnroll=to_string(numEnroll);
                    stringEnroll+=" enrollments";
                }
                //yhdistä eri kohdat yhdeksi stringiksi
                string combine=name+" --- "+stringEnroll;
                courses.insert(combine);
            }
        }
    }
    //tulosta tiedot
    for (auto it=courses.begin(); it != courses.end(); ++it) {
        std::cout << *it<<endl;
    }

}
//funktio tulostaa näytölle kaikkien paikkakuntien kaikista
//kursseista ne, joille voi vielä ilmoittautua eli jotka eivät
//ole täynnä. Kursseista tulostetaan paikkakunta, teema ja nimi.
//Tulostettavassa listassa kurssit ovat aakkosjärjestyksessä
//ensin paikkakunnan, sitten teeman ja lopuksi kurssin nimen mukaan.
void available(std::vector<std::map<string,Course>> data){

    set<string> available;
    for (unsigned long i = 0; i < data.size(); i++) {

        if(data.at(i).begin()->second.enrollments!=50){
            //Paikkakunta
            string location=data.at(i).begin()->first;
            //Teema
            string theme=data.at(i).begin()->second.theme;
            //Kurssin nimi
            string name=data.at(i).begin()->second.name;
            //yhdistä eri kohdat yhdeksi stringiksi
            string combine=location+" : "+theme+" : "+name;
            available.insert(combine);
        }
    }
    //Tulostataan
    for (auto it=available.begin(); it != available.end(); ++it) {
        std::cout << *it<<endl;
    }

}
//Funktio tulostaa kaikilta paikkakunnilta
//annettuun teemaan(string theme) kuuluvat kurssit aakkosjärjestyksessä
void courses_in_theme(std::vector<std::map<string,Course>> data,string theme){
    set<string> themes;

    for (unsigned long i = 0; i < data.size(); i++) {
        //etsitään teemaa
        if(data.at(i).begin()->second.theme==theme){
            themes.insert(data.at(i).begin()->second.name);
        }
    }
    //tulostetaan
    for (auto it=themes.begin(); it != themes.end(); ++it) {
        std::cout << *it<<endl;
    }

}
//Funktio tulostaa suosituimman teeman. Kuhunkin teemaan kuuluvien kurssien
//osanottajamäärät lasketaan siis yhteen ja tulostetaan tämä suurin osanottajamäärä
//sekä teema (tai teemat), joilla on suurin osanottajamäärä.
void favorite_theme(std::vector<std::map<string,Course>> data){
    //Map, jossa teema on avain ja määrä on arvo,
    //koska teema on uniikki ja tasapelejä voi tapahtua
    std::map<string,int> favorites;
    //ensimmäisellä sijalla oleva
    int first=0;
    //jos saman verran useammassa teemassa
    int firstTie=0;

    for (unsigned long i = 0; i < data.size(); i++) {
        //väliaikainen sijoituspaikka määrälle
        int tempAmount=data.at(i).begin()->second.enrollments;
        //väliaikainen sijoituspaikka teemalle
        string tempTheme=data.at(i).begin()->second.theme;

        for (unsigned long j = 0; j < data.size(); j++) {

            if(i!=j){//estää itsensä vertailun
                if(tempTheme==data.at(j).begin()->second.theme){
                    tempAmount+=data.at(j).begin()->second.enrollments;
                }
            }
        }
        //jos suurempi
        if(tempAmount>first){

            //jos aikaisemmin oli tasapeli niin nollataan
            if(first==firstTie&&first!=0){
                firstTie=0;

            }
            //Uusi luku ottaa ensimmäisen sijan
            first=tempAmount;
            //poistetaan pienemmät luvut map rakenteesta.
            favorites.empty();
            favorites.insert(pair <string,int>(tempTheme,first));
        }
        //Tasapeli
        else if(tempAmount==first){
            //Enemmän kuin kahden teeman tasapeli
            if(first==firstTie&&first!=0){
                favorites.insert(pair <string,int>(tempTheme,tempAmount));
            }
            else{
                tempAmount=firstTie;
                favorites.insert(pair <string,int>(tempTheme,firstTie));
            }
        }
    }
    //jos tietorakenne on tyhjä tai osallistujia ei ole merkattu
    if(first==0){
        std::cout <<"No enrollments"<<endl;
    }
    //tulostetaan
    else{
        std::cout <<first<<" enrollments in themes"<<endl;
        if(favorites.size()>1){
            for(std::map<string,int>::iterator it = favorites.begin(); it != favorites.end(); ++it) {
                std::cout << "--- "<< it->first << std::endl;
            }
        }
        else{
            std::cout << "--- "<< favorites.begin()->first<< std::endl;
        }
    }

}
//Funktio poistaa tietorakenteesta kurssit jotka esiintyvät useampaan
//kertaan niin, että myöhemmin esiintyvä säästyy aina.
std::vector<std::map<string,Course>> removeDuplicates(std::vector<std::map<string,Course>> data){
    for (unsigned long i = 0; i < data.size(); i++) {
        //Verrataan tietoja ja jos paikka ,teema ja kurssi ovat samoja
        //niin poistetaan ylempi elementti.

        for (unsigned long j = 0; j < data.size(); j++) {
            //verrataan paikkoja
            if(data.at(i).begin()->first==data.at(j).begin()->first){
                //verrataan teemoja
                if(data.at(i).begin()->second.theme==data.at(j).begin()->second.theme){
                    //verrataan nimiä
                    if(data.at(i).begin()->second.name==data.at(j).begin()->second.name){
                        //jos kyseessä ei ole itsensä vertaminen
                        //niin poistetaan ylempi elementti
                        if(i!=j){
                            data.erase(data.begin()+i);
                            break;
                        }

                    }

                }

            }

        }

    }
    return data;
}
//Funktio pilkkoo saadun tekstin osiin delimiter parametrin kohdalta
//ja pistää osat map rakenteeseen
std::map<string,Course>split(string inputString,string delimiter){

    int delimiter_counter=0;

    size_t pos = 0;
    std::string token;
    std::map<string,Course> line;
    //väliaikainen map avaimen sijoituspaikka
    string tempString;
    //väliaikainen map arvon sijoituspaikka
    Course tempCourse;
    while ((pos = inputString.find(delimiter)) != std::string::npos) {
        token = inputString.substr(0,pos);
        if(inputString.at(0)!='\"'){
            inputString.erase(0, pos + delimiter.length());
        }
        //jost tyhjä palauta tyhjä map
        if(token==""){
            delimiter_counter=0;
            return {};
        }
        if(delimiter_counter==0){
            tempString=token;
            delimiter_counter++;

        }

        else if(delimiter_counter==1){
            tempCourse.theme=token;
            delimiter_counter++;

        }
        else if(delimiter_counter==2){
            //lainausmerkkien käsittely
            if(inputString.at(0)=='\"' && delimiter == " "){
                inputString.erase(std::remove(inputString.begin(),inputString.end(),'\"'),inputString.end());
                token = inputString;
                tempCourse.name=token;
                line.insert(pair <string,Course> (tempString,tempCourse));
                delimiter_counter=0;
                return line;
            }
            tempCourse.name=token;
            delimiter_counter++;
        }
    }
    //Tiedoston käsittely
    if(delimiter_counter==3 && delimiter == ";"){
        token = inputString.substr(inputString.find(delimiter) + 1);
        if(token=="full"){
            int IntToken=50;
            tempCourse.enrollments=IntToken;
        }
        else{
            int StoiToken=stoi(token);
            tempCourse.enrollments=StoiToken;
        }
        line.insert(pair <string,Course> (tempString,tempCourse));
        delimiter_counter=0;
        return line;

    }

    else if(delimiter == ";"){
        delimiter_counter=0;
        return {};
    }
    //käyttäjän komennon käsittely
    else{
        if(delimiter_counter==0 && delimiter == " "){
            token = inputString;
            tempString=token;//komento
        }
        if(delimiter_counter==1 && delimiter == " "){
            tempCourse.theme=inputString;//kaupunki

        }
        if(delimiter_counter==2 && delimiter == " "){
            //lainausmerkkien käsittely
            if(inputString.at(0)=='\"' && delimiter == " "){
                inputString.erase(std::remove(inputString.begin(),inputString.end(),'\"'),inputString.end());
                token = inputString;
                tempCourse.name=token;//teema
                line.insert(pair <string,Course> (tempString,tempCourse));
                delimiter_counter=0;
                return line;
            }
            token = inputString;
            tempCourse.name=inputString;//teema
        }
        line.insert(pair <string,Course> (tempString,tempCourse));
        return line;
    }

    return {};
}
//Funktio hoitaa käyttäjän syötteet tiedoston lukemisen jälkeen
void input(std::vector<std::map<string,Course>> data, bool running){

    string inputString;
    std::map<string,Course> command_line;

    while(running==true){//Ohjelma pysyy luupissa
        std::cout << "> ";
        getline(cin, inputString);

        if(inputString=="quit"){//kirjoittiko käyttäjä quit
            running=false;//sammuta ohjelma

        }
        //käyttäjä ei sammuttanut ohjelmaa
        else{
            command_line=split(inputString," ");

            if(command_line.begin()->first=="locations"){
                locations(data);
            }

            else if(command_line.begin()->first=="courses"){
                string location=command_line.begin()->second.theme;
                string theme=command_line.begin()->second.name;
                bool isLocation=false;
                bool isTheme=false;
                //virheentarkistus
                if(location!=""&&theme!=""){
                    std::vector<map<string,Course>>::iterator vecIter;
                    //Iteroidaan paikkakunnat läpi
                    for(vecIter = data.begin(); vecIter != data.end(); ++vecIter){
                        if(vecIter->begin()->first==location){
                            //jos löytyi niin laitetaan muistiin
                            isLocation=true;
                            //iteroidaan teemat läpi
                            for(vecIter = data.begin(); vecIter != data.end(); ++vecIter) {
                                if(vecIter->begin()->second.theme==theme){
                                    //jos löytyi niin laitetaan muistiin
                                    isTheme=true;
                                    //rikotaan luuppi
                                    break;
                                }

                            }
                        }
                        //Jos teema löytyi niin rikotaan ulkoinen luuppi
                        if(isTheme==true){
                            break;
                        }
                        //Jos teemasa ei löytynyt rikotaan luuppi myöhemmin
                        else if(vecIter == data.end()){
                            break;
                        }
                    }
                    //Jos molemmat löytyivät kutsutaan funktio
                    if(isLocation==true){
                        if(isTheme==true){
                            courses(data,location,theme);
                        }
                        else{
                            std::cout <<"Error: unknown theme"<< std::endl;
                        }
                    }
                    else{
                        std::cout <<"Error: unknown location name"<< std::endl;
                    }
                }
                else{
                    std::cout <<"Error: error in command courses"<< std::endl;
                }
            }

            else if(command_line.begin()->first=="available"){
                available(data);

            }
            else if(command_line.begin()->first=="courses_in_theme"){
                string theme=command_line.begin()->second.theme;
                bool isTheme=false;
                //virheentarkastus
                if(theme!=""){
                    std::vector<map<string,Course>>::iterator vecIter;
                    for(vecIter = data.begin(); vecIter != data.end(); ++vecIter) {
                        if(vecIter->begin()->second.theme==theme){
                            isTheme=true;
                            break;
                        }
                    }
                    if(isTheme==true){
                        courses_in_theme(data,theme);
                    }
                    else{
                        std::cout <<"Error: unknown theme"<< std::endl;
                    }
                }
                else{
                    std::cout <<"Error: error in command courses_in_theme"<< std::endl;
                }


            }

            else if(command_line.begin()->first=="favorite_theme"){
                favorite_theme(data);
            }
            //komentoa ei tunnistettu
            else{
                std::cout << "Error: Unknown command: "<<command_line.begin()->first<<std::endl;
            }
        }
    }

}
//pääfunktio
int main()
{
    //pyöriikö ohjelma
    bool running=true;

    string input_file = "";
    string output_file = "";
    std::cout << "Input file: ";
    //Lukee tiedoston
    getline(std::cin, input_file);
    ifstream infile(input_file);

    //Ei ole tiedosto
    if ( not infile ) {
        cout << "Error: The input file cannot be opened." << endl;
        return EXIT_FAILURE;
    }
    //On tiedosto
    else{
        string rivi;
        std::vector<std::map<string,Course>> data;
        std::map<string,Course> vec_rivi;

        while ( getline(infile, rivi) ) {
            vec_rivi=split(rivi,";");

            if(!vec_rivi.empty()){
                data.push_back(vec_rivi);
            }

            else{
                std::cout << "Error: empty field"<<std::endl;
                return EXIT_FAILURE;
            }


        }
        //poistetaan kaksoiskappaleet
        data=removeDuplicates(data);
        //kunnellaan käyttäjää
        input(data,running);
    }
}
