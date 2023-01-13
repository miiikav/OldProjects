// Datastructures.cc

#include "datastructures.hh"

#include <random>

#include <cmath>

std::minstd_rand rand_engine; // Reasonably quick pseudo-random generator
using constIterator=std::unordered_map<PlaceID,Place *>::const_iterator;
using constIteratorArea=std::unordered_map<AreaID,Area *>::const_iterator;
template <typename Type>
Type random_in_range(Type start, Type end)
{
    auto range = end-start;
    ++range;

    auto num = std::uniform_int_distribution<unsigned long int>(0, range-1)(rand_engine);

    return static_cast<Type>(start+num);
}

// Modify the code below to implement the functionality of the class.
// Also remove comments from the parameter names when you implement
// an operation (Commenting out parameter name prevents compiler from
// warning about unused parameters on operations you haven't yet implemented.)

Datastructures::Datastructures()
{
}

Datastructures::~Datastructures()
{
}

int Datastructures::place_count()
{
    //returns the size of the container, which is also the place count
    return placeContainer.size();
}

void Datastructures::clear_all()
{
    //clears container
    placeContainer.clear();
}

std::vector<PlaceID> Datastructures::all_places()
{

    std::vector<PlaceID> placeIdVector;
    //iterate trough container
    for (auto& it: placeContainer) {
        if(!(it.first==NO_PLACE)){
            //put ids into container
            placeIdVector.push_back(it.first);
        }
    }
    //return full container
    return placeIdVector;
}

bool Datastructures::add_place(PlaceID id, const Name& name, PlaceType type, Coord xy)
{

    Place* NewPlace = new Place{};
    //insert name,type and coords into NewData
    NewPlace->DataName=name;
    NewPlace->DataPlaceType=type;
    NewPlace->DataCoord=xy;

    if(checkForId(id)==true){//if id is in datastucture
        return false;

    }
    else{//else create pair from id and data
        std::pair<PlaceID,Place*> NewPair;
        NewPair.first=id;
        NewPair.second=NewPlace;
        // and insert it in to the datastructure
        placeContainer.insert(NewPair);
        return true;
    }

}

std::pair<Name, PlaceType> Datastructures::get_place_name_type(PlaceID id)
{
    //save the found node into node iterator
    //so it doesent need to be seacrhed multiple times
    const auto found=placeContainer.find(id);
    if(found==placeContainer.end()){
        return {NO_NAME, PlaceType::NO_TYPE};
    }
    else{
        std::pair<Name, PlaceType > placeNameType;
        //add name and typer into pair
        placeNameType.first=found->second->DataName;
        placeNameType.second=found->second->DataPlaceType;
        return placeNameType;
    }
}

Coord Datastructures::get_place_coord(PlaceID id)
{
    const auto found=placeContainer.find(id);
    if(found==placeContainer.end()){
        return NO_COORD;
    }
    else{
        return found->second->DataCoord;
    }
}

bool Datastructures::add_area(AreaID id, const Name &name, std::vector<Coord> coords)
{
    Area* NewArea = new Area{};
    NewArea->AreaId=id;
    NewArea->AreaName=name;
    NewArea->AreaCoords=coords;
    std::pair<AreaID,Area*> NewPair;
    NewPair.first=id;
    NewPair.second=NewArea;
    if(checkForAreaId(id)==true){//if id is in datastucture
        return false;

    }
    else{// Else insert it in to the datastructure
        areaContainer.insert(NewPair);
        return true;
    }
}

Name Datastructures::get_area_name(AreaID id)
{
    const auto found=areaContainer.find(id);
    if(found==areaContainer.end()){
        return NO_NAME;
    }
    else{
        return found->second->AreaName;
    }
}

std::vector<Coord> Datastructures::get_area_coords(AreaID id)
{
    //save the found node into node iterator
    //so it doesent need to be seacrhed multiple times
    const auto found=areaContainer.find(id);
    if(found==areaContainer.end()){
        return {NO_COORD};
    }
    else{
        std::vector<Coord> vectorAreaCoords;
        for (auto& it: found->second->AreaCoords) {
            vectorAreaCoords.push_back(it);
        }
        return vectorAreaCoords;
    }
}

void Datastructures::creation_finished()
{
    // NOTE!! It's quite ok to leave this empty, if you don't need operations
    // that are performed after all additions have been done.
}


std::vector<PlaceID> Datastructures::places_alphabetically()
{

    std::vector<PlaceID> placeIdAlphabet;
    std::vector<std::pair<Name,PlaceID>> namePair;
    //increases the size of the namePair vector to the size of the container
    namePair.resize(placeContainer.size());
    int i=0;
    //first loop inserts data into pair vector
    for (auto& it: placeContainer) {
        if(!(it.first==NO_PLACE)){
            namePair.at(i).first=it.second->DataName;
            namePair.at(i).second=it.first;
            i++;
        }
    }
    //sorts data alphabetically
    std::sort(namePair.begin(), namePair.end());
    //second for loop gets the id from pairs
    for (auto& it: namePair) {
        //inserts id into vector
        placeIdAlphabet.push_back(it.second);
    }
    return placeIdAlphabet;
}

std::vector<PlaceID> Datastructures::places_coord_order()
{
    std::vector<PlaceID> placeIdCoord;
    std::vector<std::pair<Coord,PlaceID>> coordPair;
    //resize to fit the data
    coordPair.resize(placeContainer.size());
    int i=0;
    for (auto& it: placeContainer) {
        if(!(it.first==NO_PLACE)){
            coordPair.at(i).first= it.second->DataCoord;
            coordPair.at(i).second=it.first;
            i++;
        }
    }
    //sort according to the documentation
    std::sort(coordPair.begin(), coordPair.end(),[this](std::pair<Coord,PlaceID> a, std::pair<Coord,PlaceID> b){

        return compareCoords(a.first, b.first);

    });
    //add ids into vector
    for (auto& it: coordPair) {
        placeIdCoord.push_back(it.second);
    }
    return placeIdCoord;
}

std::vector<PlaceID> Datastructures::find_places_name(Name const& name)
{
    std::vector<PlaceID> placeIdName;
    //find places that have the name
    for (auto& it: placeContainer) {
        if(!(it.first==NO_PLACE)){
            if(it.second->DataName==name){
                //put their id in a vector
                placeIdName.push_back(it.first);
            }
        }
    }
    //if the vector contains at least one id
    if(!placeIdName.empty()){
        //return vector of the ids
        return placeIdName;
    }
    else{
        return {};
    }

}

std::vector<PlaceID> Datastructures::find_places_type(PlaceType type)
{
    std::vector<PlaceID> placeIdType;
    //find places that have the type
    for (auto& it: placeContainer) {
        if(!(it.first==NO_PLACE)){
            if(it.second->DataPlaceType==type){
                //put their id in a vector
                placeIdType.push_back(it.first);
            }
        }
    }
    //if the vector contains at least one id
    if(!placeIdType.empty()){
        //return vector of the ids
        return placeIdType;
    }
    else{
        return {};
    }
}

bool Datastructures::change_place_name(PlaceID id, const Name& newname)
{
    //save the found node into node iterator
    //so it doesent need to be seacrhed multiple times
    const auto found=placeContainer.find(id);
    if(found!=placeContainer.end()){
        found->second->DataName=newname;
        return true;
    }
    else{
        return false;
    }

}

bool Datastructures::change_place_coord(PlaceID id, Coord newcoord)
{
    //save the found node into node iterator
    //so it doesent need to be seacrhed multiple times
    const auto found=placeContainer.find(id);
    if(found!=placeContainer.end()){
        found->second->DataCoord=newcoord;
        return true;
    }
    else{
        return false;
    }
}

std::vector<AreaID> Datastructures::all_areas()
{
    std::vector<AreaID> areaIdVector;
    //go through every area
    for (auto& it: areaContainer) {
        if(!(it.first==NO_AREA)){
            //and add them to vector
            areaIdVector.push_back(it.first);
        }
    }
    return areaIdVector;
}

bool Datastructures::add_subarea_to_area(AreaID id, AreaID parentid)
{

    const auto found=areaContainer.find(id);
    const auto foundParent=areaContainer.find(parentid);
    //if both ids were found
    if(found!=areaContainer.end() && foundParent!=areaContainer.end()){
        //and the area doesnt have a parent yet
        if(found->second->parentArea!=nullptr){
            return false;
        }
        else{
            //connect them together
            found->second->parentArea=foundParent->second;
            foundParent->second->childArea=found->second;
            return true;
        }

    }

    else{
        return false;
    }

}

std::vector<AreaID> Datastructures::subarea_in_areas(AreaID id)
{

    const auto found=areaContainer.find(id);
    //if id was found
    if(found!=areaContainer.end()){
        //and it has a parent
        if(found->second->parentArea==nullptr){
            return {};
        }
        else{
            std::vector<AreaID> areaIdVector;
            //call recursiveTraversal function to add the ids to vector
            recursiveTraversal(found->second,areaIdVector);
            return areaIdVector;
        }
    }

    else{
        return {NO_AREA};
    }
}

std::vector<PlaceID> Datastructures::places_closest_to(Coord xy, PlaceType type)
{
//    // Replace this comment with your implementation
    return {};
}

bool Datastructures::remove_place(PlaceID id)
{
//    // Replace this comment with your implementation
    return false;
}

std::vector<AreaID> Datastructures::all_subareas_in_area(AreaID id)
{
//    // Replace this comment with your implementation
    return {NO_AREA};
}

AreaID Datastructures::common_area_of_subareas(AreaID id1, AreaID id2)
{
//    // Replace this comment with your implementation
    return NO_AREA;
}
//
/* Description: Checks that the current
 *  id matches the data in a container.
 * Parameters:
 *  Param1: ID of the place
 * returns true if there is a match, false if not.
 * */
bool Datastructures::checkForId(PlaceID &id)const{
    constIterator it = placeContainer.find(id);
    if ( it == placeContainer.end() )//id not in container
        return false;
    else//id is in container
        return true;
}
/* Description: Checks that the current
 *  id matches the data in a container.
 * Parameters:
 *  Param1: ID of the area
 * returns true if there is a match, false if not.
 * */
bool Datastructures::checkForAreaId(AreaID &id)const{
    constIteratorArea it = areaContainer.find(id);
    if ( it == areaContainer.end() )//id not in container
        return false;
    else//id is in container
        return true;
}
/* Description: Compares two coordinates
 * to see which one is bigger.
 * Parameters:
 *  Param1: Coord a
 *  Param2: Coord b
 * returns true if a is smaller or equal, false if b is smaller.
 * */
bool Datastructures::compareCoords(Coord a, Coord b) {
    int squaredA = std::pow(a.x,2)+pow(a.y,2);
    int squaredB = std::pow(b.x,2)+pow(b.y,2);
    //compares the two coodinates
    if(squaredA == squaredB){
        if(a.y==b.y){
            return true;
        }
        return a.y < b.y;
    }
    return squaredA < squaredB;
};
/* Description: Traverses the Area from child node to
 * parent node untill there is no parent node
 * and returns the vector of the IDs
 * Parameters:
 *  Param1: ID of the Area
 *  Param2: Vector of the AreaIDs
 * returns Vector of the AreaIDs
 * */
void Datastructures::recursiveTraversal(Area * areaIterator, std::vector<AreaID> &areaIdVector) {

    if(areaIterator->parentArea==nullptr){
        areaIdVector.push_back(areaIterator->AreaId);
    }
    else{
        areaIdVector.push_back(areaIterator->AreaId);

        recursiveTraversal(areaIterator->parentArea,areaIdVector);
    }
};
