#ifndef MAMMAL_H
#define MAMMAL_H
#include "animal.hh"


class Mammal: public Animal
{
public:
    Mammal();
    void suckle(std::ostream& output);

private:

};

#endif // MAMMAL_H
