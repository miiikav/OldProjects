#ifndef PLAYER_HH
#define PLAYER_HH
#include <string>

class Player{
    public:
        // Constructor
        Player(std::string name);

        // More methods
        int get_points();
        std::string get_name();
        void add_points(int pts);
        bool has_won();

    private:

        // More attributes/methods
        std::string name;
        int points_;
        int in_turn;
        bool winner;


};
#endif // PLAYER_HH
