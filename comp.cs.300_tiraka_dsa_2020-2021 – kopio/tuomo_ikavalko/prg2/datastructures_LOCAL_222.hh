// Datastructures.hh

#ifndef DATASTRUCTURES_HH
#define DATASTRUCTURES_HH

#include <string>
#include <vector>
#include <tuple>
#include <utility>
#include <limits>
#include <functional>

// Types for IDs
using PlaceID = long long int;
using AreaID = long long int;
using Name = std::string;
using WayID = std::string;
using NodePosition =struct Coord;

// Return values for cases where required thing was not found
PlaceID const NO_PLACE = -1;
AreaID const NO_AREA = -1;
WayID const NO_WAY = "!!No way!!";


// Return value for cases where integer values were not found
int const NO_VALUE = std::numeric_limits<int>::min();

// Return value for cases where name values were not found
Name const NO_NAME = "!!NO_NAME!!";

// Enumeration for different place types
// !!Note since this is a C++11 "scoped enumeration", you'll have to refer to
// individual values as PlaceType::SHELTER etc.
enum class PlaceType { OTHER=0, FIREPIT, SHELTER, PARKING, PEAK, BAY, AREA, NO_TYPE };

// Type for a coordinate (x, y)
struct Coord
{
    int x = NO_VALUE;
    int y = NO_VALUE;
};

// Example: Defining == and hash function for Coord so that it can be used
// as key for std::unordered_map/set, if needed
inline bool operator==(Coord c1, Coord c2) { return c1.x == c2.x && c1.y == c2.y; }
inline bool operator!=(Coord c1, Coord c2) { return !(c1==c2); } // Not strictly necessary

struct CoordHash
{
    std::size_t operator()(Coord xy) const
    {
        auto hasher = std::hash<int>();
        auto xhash = hasher(xy.x);
        auto yhash = hasher(xy.y);
        // Combine hash values (magic!)
        return xhash ^ (yhash + 0x9e3779b9 + (xhash << 6) + (xhash >> 2));
    }
};

// Example: Defining < for Coord so that it can be used
// as key for std::map/set
inline bool operator<(Coord c1, Coord c2)
{
    if (c1.y < c2.y) { return true; }
    else if (c2.y < c1.y) { return false; }
    else { return c1.x < c2.x; }
}

// Return value for cases where coordinates were not found
Coord const NO_COORD = {NO_VALUE, NO_VALUE};

// Type for a distance (in metres)
using Distance = int;

// Return value for cases where Duration is unknown
Distance const NO_DISTANCE = NO_VALUE;



// This is the class you are supposed to implement
enum class NodeType { WHITE, GREY, BLACK};


struct Way{

    WayID WayId;
    std::vector<Coord> WayCoords;
    struct Way* ChildWay;

};
struct Node{
    NodePosition NodePosition;
    NodeType NodeColor;
    struct Node* LastNode;
    std::vector<std::pair<Way*,Node*>> NodeWaysFrom;
};
struct Place{

    Name DataName;
    PlaceType DataPlaceType;
    struct Coord DataCoord;
};
struct Area{
    AreaID AreaId;
    Name AreaName;
    struct std::vector<Coord> AreaCoords;
    struct Area* parentArea;
    struct Area* childArea;
};

class Datastructures
{
public:
    Datastructures();
    ~Datastructures();

    // Estimate of performance: O(1)
    // Short rationale for estimate:
    // returns the size of the container, which is fast.
    int place_count();

    // Estimate of performance: worst case is O(n)
    // Short rationale for estimate:
    //It has linear complexity in the container's size
    //as the destructor of each element must be called.
    void clear_all();

    // Estimate of performance: O(n)
    // Short rationale for estimate:
    //It has linear complexity in the container's size
    //because it has to go through every node in container
    std::vector<PlaceID> all_places();

    // Estimate of performance: Constant O(9)? on average, worst case linear in the size of the container.
    // Short rationale for estimate:
    // insert() and find() are both constant on average, but they can be worse.
    bool add_place(PlaceID id, Name const& name, PlaceType type, Coord xy);

    // Estimate of performance: on average O(5) worst case O(n)
    // Short rationale for estimate:
    // find is the most demanding operation in this function
    std::pair<Name, PlaceType> get_place_name_type(PlaceID id);

    // Estimate of performance: Constant O(3) on average, worst case linear in the size of the container.
    // Short rationale for estimate:
    // Only operation is .find(id) and find is constant on average
    Coord get_place_coord(PlaceID id);

    // We recommend you implement the operations below only after implementing the ones above

    // Estimate of performance: O(n log n)
    // Short rationale for estimate:
    // according to cppreference sort is O(n log n)
    std::vector<PlaceID> places_alphabetically();

    // Estimate of performance: O(n log n)
    // Short rationale for estimate:
    // according to cppreference sort is O(n log n)
    std::vector<PlaceID> places_coord_order();

    // Estimate of performance: O(n)
    // Short rationale for estimate:
    // It has linear complexity in the container's size
    // because it has to go through every node in container
    std::vector<PlaceID> find_places_name(Name const& name);

    // Estimate of performance: O(n)
    // Short rationale for estimate:
    // It has linear complexity in the container's size
    // because it has to go through every node in container
    std::vector<PlaceID> find_places_type(PlaceType type);

    // Estimate of performance: Constant O(3)? on average, worst case linear in the size of the container.
    // Short rationale for estimate:
    // slowest operation is .find()
    bool change_place_name(PlaceID id, Name const& newname);

    // Estimate of performance: Constant O(3)? on average, worst case linear in the size of the container.
    // Short rationale for estimate:
    // slowest operation is .find()
    bool change_place_coord(PlaceID id, Coord newcoord);

    // We recommend you implement the operations below only after implementing the ones above

    // Estimate of performance: Constant O(9)? on average, worst case linear in the size of the container.
    // Short rationale for estimate:
    // insert() and find() are both constant on average, but they can be worse.
    bool add_area(AreaID id, Name const& name, std::vector<Coord> coords);

    // Estimate of performance: Constant O(3)? on average, worst case linear in the size of the container.
    // Short rationale for estimate:
    // Only operation is .find(id) and find is constant on average
    Name get_area_name(AreaID id);

    // Estimate of performance: O(n)
    // Short rationale for estimate:
    // It has linear complexity in the container's size
    // because it has to go through every node in container
    std::vector<Coord> get_area_coords(AreaID id);

    // Estimate of performance: O(n)
    // Short rationale for estimate:
    // It has linear complexity in the container's size
    // because it has to go through every node in container
    std::vector<AreaID> all_areas();

    // Estimate of performance: Constant on average, worst case linear in the size of the container.
    // Short rationale for estimate:
    // slowest operations are two .find() operations
    bool add_subarea_to_area(AreaID id, AreaID parentid);

    // Estimate of performance: O(n)
    // Short rationale for estimate:
    // recursiveTraversal function is linear
    std::vector<AreaID> subarea_in_areas(AreaID id);

    // Non-compulsory operations

    // Estimate of performance:
    // Short rationale for estimate:
    void creation_finished();

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<AreaID> all_subareas_in_area(AreaID id);

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<PlaceID> places_closest_to(Coord xy, PlaceType type);

    // Estimate of performance:
    // Short rationale for estimate:
    bool remove_place(PlaceID id);

    // Estimate of performance:
    // Short rationale for estimate:
    AreaID common_area_of_subareas(AreaID id1, AreaID id2);

    // Phase 2 operations

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<WayID> all_ways();

    // Estimate of performance:
    // Short rationale for estimate:
    bool add_way(WayID id, std::vector<Coord> coords);

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<std::pair<WayID, Coord>> ways_from(Coord xy);

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<Coord> get_way_coords(WayID id);

    // Estimate of performance:
    // Short rationale for estimate:
    void clear_ways();

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<std::tuple<Coord, WayID, Distance>> route_any(Coord fromxy, Coord toxy);

    // Non-compulsory operations

    // Estimate of performance:
    // Short rationale for estimate:
    bool remove_way(WayID id);

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<std::tuple<Coord, WayID, Distance>> route_least_crossroads(Coord fromxy, Coord toxy);

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<std::tuple<Coord, WayID>> route_with_cycle(Coord fromxy);

    // Estimate of performance:
    // Short rationale for estimate:
    std::vector<std::tuple<Coord, WayID, Distance>> route_shortest_distance(Coord fromxy, Coord toxy);

    // Estimate of performance:
    // Short rationale for estimate:
    Distance trim_ways();

private:
    // Add stuff needed for your class implementation here
    std::unordered_map<NodePosition,Node *,CoordHash> nodeContainer;
    std::unordered_map<WayID,Way *> wayContainer;
    std::unordered_map<PlaceID,Place *> placeContainer;
    std::unordered_map<AreaID,Area *> areaContainer;

    //Checks that PlaceId is in the datastucture
    bool checkForId(PlaceID &id)const;
    //Checks that AreaId is in the datastucture
    bool checkForAreaId(AreaID &id)const;
    //Checks that PlaceId is in the datastucture
    bool checkForWayId(WayID &id)const;
    //Traverses the Area from child node to parent node untill there is no parent node
    //and returns the vector of the IDs
    void recursiveTraversal(Area * subId, std::vector<AreaID>& areaIdVector);
    //compares two coordinates to see which one is bigger.
    bool compareCoords(Coord a, Coord b);
    //function that finds a way beatween two coordinates
};

#endif // DATASTRUCTURES_HH
