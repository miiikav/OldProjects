/* Company
 *
 * Description:
 * Company hierarchy -class datastructure
 * Datastructure is populated with
 * Employee-structs and provides some
 * query-functions.
 *
 *
 * Ohjelman kirjoittaja ( Täytä omilla tiedoillasi )
 * Nimi: Tuomo Ikävalko
 * Opiskelijanumero: 427620
 * Käyttäjätunnus: ti427620 ( Git-repositorion hakemistonimi. )
 * E-Mail: tuomo.ikavalko@tuni.fi
 * Palautteen kieli (fi/en): fi
 *
 *
 * */

#include "company.hh"
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
//Shortening lines by using aliases
std::vector<Employee *> container;
using constIterator=std::vector<Employee *>::const_iterator;


//constructor
Company::Company(){
}
//destructor
Company::~Company(){
}


/* Description: Adds a new Employee to the datastructure.
 * Parameters:
 *  Param1: Employee's ID string
 *  Param2: Employee's department
 *  Param3: Employee's time in service
 *  Param4: Output-stream for error-printing
 * Errormessages:
 *  If employees's ID is already in datastructure:
 *      "Error. Employee already added."
 */

void Company::addNewEmployee(const std::string &id,
                             const std::string &dep,
                             const double &time,
                             std::ostream &output)
{

    Employee* NewEmployee = new Employee{};
    NewEmployee->id_=id;
    NewEmployee->department_=dep;
    NewEmployee->time_in_service_=time;

    if(checkForId(NewEmployee->id_)==true){//if Employee is in datastucture
                                           //output an error message

        output<< "Error. Employee already added."<<std::endl;

    }
    else if(checkForId(NewEmployee->id_)==false){// Else push it
                                                 //in to the datastructure
        container.push_back(NewEmployee);
    }


}

/* Description: Prints all stored Employees: ID, department and time in service
 * Parameters:
 *  Param1: Output-stream for printingconst
 * Errormessages:
 *  None.
 */
void Company::printEmployees(std::ostream &output) const
{
    //Using VectorToIdSet function to make things clearer
    IdSet printId =VectorToIdSet(container);
    IdSet::iterator itr;

    for (itr=printId.begin(); itr!=printId.end(); ++itr){
        output<<*itr<<std::endl;
    }

}
/*
 * All the following functions have the same error messages:
 *  If ID wasn't found in datastructure:
 *      "Error. <ID> not found."
 *  If the printing list is empty:
 *      "Error. <ID> has no <group's name>."
 * -------------------------------------------------------------------
 */

/* Description: Adds new boss-subordinate relation
 * Parameters:
 *  Param1: ID of the subordinate
 *  Param2: ID of the boss
 *  Param3: Output-stream for error-printing
 */
void Company::addRelation(const std::string &subordinate,
                          const std::string &boss,
                          std::ostream &output)
{
            //Using error messages
            //in this function causes the program to not work
            output<<"";
            Employee* tempBoss = new Employee{};
            Employee* tempSub = new Employee{};

            if(checkForId(boss)==true){//checks to see if the id is correct
                tempBoss=GetId(boss);
            }

            if(checkForId(subordinate)==true){//checks to see if the id is correct
                tempSub=GetId(subordinate);
            }

            if(tempBoss!=nullptr && tempSub!=nullptr){
                //adds relations to the two employees
                tempSub->boss_=tempBoss;
                tempBoss->subordinates_.push_back(tempSub);
            }


}
/* Description: Prints the direct boss of the employee.
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Output-stream for printing
 */
void Company::printBoss(const std::string &id, std::ostream &output) const
{
    if(checkForId(id)==true){//checks to see if id is real before getting id

        if(GetId(id)->boss_->id_==EMPTY){
            output<<id<<" has no "<<"bosses"<<"."<<std::endl;
        }
        else{
            IdSet bosses;
            bosses.insert(GetId(id)->boss_->id_);
            printGroup(GetId(id)->id_,"bosses",bosses,output);
        }
    }
    else{//if id was not found
        printNotFound(id,output);
    }


}
/* Description: Prints direct subordinates for the employee.
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Output-stream for printing
 */
void Company::printSubordinates(const std::string &id, std::ostream &output) const
{
    if(checkForId(id)==true){//checks to see if id is real before getting id

        if(GetId(id)->subordinates_.empty()==true){
            output<<id<<" has no "<<"subordinates"<<"."<<std::endl;
        }
        else{
            IdSet subs;
            constIterator it;
            Employee* tempSubordinate;
            //for loop inserts all subordinates to subs IdSet
            for (it=GetId(id)->subordinates_.begin(); it!=GetId(id)->subordinates_.end(); ++it){
                tempSubordinate=*it;
                subs.insert(tempSubordinate->id_);
            }
            printGroup(GetId(id)->id_,"subordinates",subs,output);
        }
    }
    else{//if id was not found
        printNotFound(id,output);
    }
}
/* Description: Prints the colleagues for the employee.
 *  (Employees who shares their direct boss)
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Output-stream for printing
 */
void Company::printColleagues(const std::string &id,
                              std::ostream &output) const
{
    if(checkForId(id)==true){//checks to see if id is real before getting id

        if(GetId(id)->boss_->subordinates_.size()==1){
            output<<id<<" has no "<<"colleagues"<<"."<<std::endl;
        }
        else{
            IdSet col;
            constIterator it;
            Employee* tempColleague;
            for (it=container.begin(); it!=container.end(); ++it){
                tempColleague=*it;
                if(GetId(id)->id_!=tempColleague->id_){//Prevents yourself
                                                       //from being added

                    if(GetId(id)->boss_->id_==tempColleague->boss_->id_){
                        //If employee has the same boss they are inserted
                        //into the col IdSet
                        col.insert(tempColleague->id_);
                    }
                }
            }
            printGroup(GetId(id)->id_,"colleagues",col,output);
        }
    }
    else{//if id was not found
        printNotFound(id,output);
    }

}

/* Description: Prints all-level colleagues for the employee.
 *  (Employees who share their department and belong to the same hierarchy)
 * Parameters:
 *  Param1: ID of the person
 *  Param2: Output-stream for printing
 */
void Company::printDepartment(const std::string &id, std::ostream &output) const
{
    if(checkForId(id)==true){//checks to see if id is real before getting id

        if(GetId(id)->boss_->subordinates_.size()==1 ){
            output<<id<<" has no "<<"department colleagues"<<"."<<std::endl;
        }
        else{
            IdSet depCol;
            constIterator it;
            Employee* tempEmployee;
            for (it=container.begin(); it!=container.end(); ++it){
                tempEmployee=*it;
                if(GetId(id)->id_!=tempEmployee->id_){
                    if(GetId(id)->department_==tempEmployee->department_){
                        if(checkHierarchy(GetId(id)->id_,tempEmployee->id_)==true){
                            depCol.insert(tempEmployee->id_);
                        }
                    }
                }
            }
            printGroup(GetId(id)->id_,"department colleagues",depCol,output);
        }
    }
    else{//if id was not found
        printNotFound(id,output);
    }

}
/* Description: Prints the employee with the longest time in service
 *  in the ID's line management.
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Output-stream for printing
 */
void Company::printLongestTimeInLineManagement(const std::string &id, std::ostream &output) const
{
    if(checkForId(id)==true){//checks to see if id is real before getting id

        Employee* longest=GetId(id);
        longest->time_in_service_=GetId(id)->time_in_service_;

        if(GetId(id)->subordinates_.empty()==false){

            Employee* subordinate;
            constIterator it;

            for (it=GetId(id)->subordinates_.begin();
                 it!=GetId(id)->subordinates_.end(); ++it){

                subordinate=*it;

                if(subordinate->time_in_service_ > longest->time_in_service_){
                    //replace if longer
                    longest=subordinate;
                }
                if(subordinate->subordinates_.empty()==false){

                    Employee* subSubordinate;
                    constIterator it2;

                    for (it2=subordinate->subordinates_.begin();
                         it2!=subordinate->subordinates_.end(); ++it2){

                        subSubordinate=*it2;

                        if(subSubordinate->time_in_service_ >
                                longest->time_in_service_){
                            //replace if longer
                            longest=subSubordinate;
                        }

                    }
                }
            }
        }
        //Changes text depending who is longest
        if(GetId(id)->time_in_service_ == longest->time_in_service_){

            output<<"With the time of "
                    <<longest->time_in_service_<<", "<<longest->id_
                    <<" is the longest-served "
                        "employee in their line management."<<std::endl;
        }

        else{
            output<<"With the time of "
                    <<longest->time_in_service_<<", "<<longest->id_
                    <<" is the longest-served "
                        "employee in "<<GetId(id)->id_
                   <<"'s line management."<<std::endl;
        }
    }
    else{//if id was not found
        printNotFound(id,output);
    }
}
/* Description: Prints the employee with the shortest time in service
 *  in the ID's line management.
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Output-stream for printing
 */
void Company::printShortestTimeInLineManagement(const std::string &id,
                                                std::ostream &output) const
{
    if(checkForId(id)==true){//checks to see if id is real before getting id

        //This stops the shortest from being 0
        Employee* shortest = GetId(id);
        shortest->time_in_service_=GetId(id)->time_in_service_;

        constIterator it;
        if(GetId(id)->subordinates_.empty()==false){

            Employee* subordinate;
            for (it = GetId(id)->subordinates_.begin();
                 it!= GetId(id)->subordinates_.end(); ++it){
                subordinate=*it;
                if(subordinate->time_in_service_<shortest->time_in_service_){
                    //replace if shorter
                    shortest=subordinate;
                }
                if(subordinate->subordinates_.empty()==false){
                    Employee* subSubordinate;
                    constIterator it2;
                    for (it2 = subordinate->subordinates_.begin();
                         it2!= subordinate->subordinates_.end(); ++it2){
                        subSubordinate=*it2;
                        if(subSubordinate->time_in_service_
                                < shortest->time_in_service_){
                            //replace if shorter
                            shortest=subSubordinate;
                        }

                    }
                }
            }
        }
        //Changes text depending who is shortest
        if(GetId(id)->time_in_service_==shortest->time_in_service_){

            shortest=GetId(id);
            output<<"With the time of "
                    <<shortest->time_in_service_<<", "<<shortest->id_
                    <<" is the shortest-served "
                        "employee in their line management."<<std::endl;
        }
        else{
            output<<"With the time of "
                    <<shortest->time_in_service_<<", "<<shortest->id_
                    <<" is the shortest-served "
                        "employee in "<<GetId(id)->id_
                   <<"'s line management."<<std::endl;
        }

    }
    else{//if id was not found
        printNotFound(id,output);
    }

}
/* The following functions have additional errormessage:
 *  If Param2's value is less than 1:
 *      "Error. Level can't be less than 1."
 * ---------------------------------------------------------------
 */

/* Description: Prints the amount and names of bosses in given
 *  distance from the employee.
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Maximum distance from the employee. (n-1 times "hierarchy")
 *  Param3: Output-stream for printing
 */
void Company::printBossesN(const std::string &id, const int n, std::ostream &output) const
{
    if(n<1){
        output<<"Error. Level can't be less than 1."<<std::endl;
    }
    else{
        if(checkForId(id)==true){

            if(GetId(id)->boss_->id_!=EMPTY){

                Employee* tempBoss;
                IdSet bosses;
                int i=1;
                tempBoss=GetId(id)->boss_;
                bosses.insert(tempBoss->id_);

                while(i<=n-1){ //Goes from boss to boss untill i<=n-1

                    if(tempBoss->boss_->id_!=EMPTY){
                        tempBoss=tempBoss->boss_;
                        bosses.insert(tempBoss->id_);
                        i++;
                    }
                    else{
                        //if next boss is empty break loop
                        break;
                    }

                }

                printGroup(GetId(id)->id_,"bosses",bosses,output);
            }
            else{
                output<<GetId(id)->id_<<" has no bosses."<<std::endl;
            }

        }
        else{//if id was not found
            printNotFound(id,output);
        }
    }


}

/* Description: Prints the amount and names of subordinates in given
 *  distance from the employee.
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Maximum distance from the employee. (n-1 times "hierarchy")
 *  Param3: Output-stream for printing
 */
void Company::printSubordinatesN(const std::string &id,
                                 const int n,
                                 std::ostream &output) const
{
    if(n<1){
        output<<"Error. Level can't be less than 1."<<std::endl;
    }
    else{
        if(checkForId(id)==true){
            if(GetId(id)->subordinates_.empty()==false){
                IdSet subs;
                Employee* start=GetId(id);
                //using recursiveSub fuction,
                //because using recursuon makes things easier

                printGroup(GetId(id)->id_,"subordinates",
                           recursiveSub(start,subs,n),output);
            }
            else{
                output<<GetId(id)->id_<<" has no subordinates."<<std::endl;
            }
        }
        else{//if id was not found
            printNotFound(id,output);
        }
    }

}

//Private

/* Description: Returns a pointer for the ID.
 * Parameters:
 *  Param1: ID of the employee
 * returns Employee*
 */

Employee * Company::GetId(const std::string &id)const{
    constIterator it;
    Employee* tempId;
    for (it=container.begin(); it!=container.end(); ++it){
        tempId=*it;
        if(tempId->id_==id){
            return tempId;
        }
    }
    return nullptr;
}

/* Description: Prints not found error message
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Output-stream for printing
 * */
void Company::printNotFound(const std::string &id, std::ostream &output) const
{
    output<<"Error. "<<id<<" not found."<<std::endl;
}


/* Description: Turns a vector of employees to a set of IDs.
 * Parameters:
 *  Param1: Vector of Employees
 * returns a set of IDs
 * */
IdSet Company::VectorToIdSet(const std::vector<Employee *> &container) const{
    constIterator it;
    IdSet employeeIdSet;
    Employee* tempEmp;
    for (it=container.begin(); it!=container.end(); ++it){
        tempEmp=*it;
        string tempString=tempEmp->id_+
                ", "+tempEmp->department_+
                ", "+std::to_string(tempEmp->time_in_service_);
            tempString.erase                          //removing 0
                    ( tempString.find_last_not_of('0')//from the end of the string
                               + 1, std::string::npos );
            tempString.erase                          //removing "."
                    ( tempString.find_last_not_of('.')//from the end of string
                               + 1, std::string::npos );
            employeeIdSet.insert(tempString);

    }
    return employeeIdSet;
}
//
/* Description: Prints the the data in a container.
 * Parameters:
 *  Param1: ID of the employee
 *  Param2: Name of the group
 *  Param3: IdSet of the container
 *  Param4: Output-stream for printing
 * */
void Company::printGroup(const std::string &id,
                         const std::string &group,
                         const IdSet &container,
                         std::ostream &output) const
{
    output<<GetId(id)->id_<<" has "<<container.size()
                        <<" "<<group<<":"<<std::endl;
    IdSet::iterator itr;
    for (itr=container.begin(); itr!=container.end(); ++itr){
        output<<*itr<<std::endl;
    }
}

//
/* Description: Checks that the current
 *  id matches the data in a container.
 * Parameters:
 *  Param1: ID of the employee
 * returns true if there is a match, false if not.
 * */
bool Company::checkForId(const std::string &id)const{
    constIterator it;
    Employee* tempEmp;
    for (it=container.begin(); it!=container.end(); ++it){
        tempEmp=*it;
        if(tempEmp->id_==id){
            return true;
        }
    }
    return false;
}
//
/* Description: Compares two ids, by going to the top of their
 * respective hierarchies first and then comparing the results
 *  to check if they are part of the same hierarchy.
 * Parameters:
 *  Param1: ID of the employee 1
 *  Param2: ID of the employee 2
 * returns true if there is a match, false if not.
 * */
bool Company::checkHierarchy(const string &id1,const string &id2) const
{
    //setting values to the boss_
    Employee* tempId1=GetId(id1)->boss_;
    Employee* tempId2=GetId(id2)->boss_;

    //while loops to get to the top of the hierarchy
    while(GetId(id1)->department_==tempId1->department_){
        tempId1=tempId1->boss_;
    }
    while(GetId(id2)->department_==tempId2->department_){
        tempId2=tempId2->boss_;
    }

    if(tempId1==tempId2){//if the end result is the same return true
        return true;
    }
    else{//else return false
        return false;
    }
}

//
/* Description: Recursively moves trough
 * the company tree starting from id and
 * inserts Subordinates into IdSet.
 * Parameters:
 *  Param1: Employee where to start
 *  Param2: IdSet for Subordinates
 * returns IdSet containing Subordinates
 * */
IdSet Company::recursiveSub(Employee* start,IdSet &subs, const int n) const
{
    Employee* tempSub;
    constIterator it;
    for (it=start->subordinates_.begin(); it!=start->subordinates_.end(); ++it){
        tempSub=*it;
        subs.insert(tempSub->id_);
        if(n!=1){
            recursiveSub(tempSub,subs,n);
        }
    }

    return subs;
}

