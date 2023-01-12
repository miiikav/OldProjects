const people = [
    {id: 1, firstName: "Adam", lastName: "Smith", age: 16},
    {id: 2, firstName: "Amy", lastName: "Johnson", age: 45},
    {id: 3, firstName: "Barbara", lastName: "Jackson", age: 18},
    {id: 4, firstName: "Bill", lastName: "Norton", age: 12}
  ];

//1

//console.log(people.find(person => return person.id === 3));
//console.log(people.find(function (person) { return person.id; }));
//console.log(people.find(person => {person.id === 3}));
console.log(people.find(function (person) { return person.id === 3; }));
console.log(people.find(person => person.id === 3));
//console.log(people.find(person => person.id));
console.log(people.find((person) => { return person.id === 3; }));


//2
//console.log(people.filter(person => person.age > 18));
console.log(people.filter((person) => person.age >= 18));
//console.log(people.filter(person => person.age < 18));
//console.log(people.filter(person => person.age === 18));
console.log(people.filter(person => person.age >= 18));

//3
if (people.every(person => person.age > 10)) console.log("All older than 10"+people.every(person => person.age > 10));
//if (people.some(person => person.age > 10)) console.log("All older than 10"+people.some(person => person.age > 10));
//if (people.every(person => person.age >= 10)) console.log("All older than 10"+people.every(person => person.age >= 10));
//if (people.some(person => person.age >= 10)) console.log("All older than 10"+people.some(person => person.age >= 10));
if (!people.some(person => person.age <= 10)) console.log("All older than 10"+!people.some(person => person.age <= 10));
if (!people.every(person => person.age <= 10)) console.log("All older than 10"+!people.every(person => person.age <= 10));
//if (people.some(person => person.age <= 10)) console.log("All older than 10"+people.some(person => person.age <= 10));

//4

//console.log(people.map(person => person));
//console.log(function (person) { return person.lastName; });
//console.log(people.map(person => person.id));
//console.log(people.map(person => person["lastName"]));
console.log(people.map(person => person.lastName));

//5
console.log(people.sort((person1, person2) => person1.lastName.localeCompare(person2.lastName)));
//console.log(people.sort((person1, person2) => person2.lastName.localeCompare(person1.lastName)));
//console.log(people.sort((person1, person2) => person1.lastName > person2.lastName));
//console.log(people.sort((person1, person2) => person1.lastName < person2.lastName));

const people2 = [
    {id: 1, firstName: "Adam", lastName: "Smith", age: 16},
    {id: 2, firstName: "Amy", lastName: "Johnson", age: 45},
    {id: 3, firstName: "Barbara", lastName: "Jackson", age: 18},
    {id: 4, firstName: "Bill", lastName: "Norton", age: 12}];
for (let person of people) {
  const newPerson = {
    id: person.id, name: `${person.firstName} ${person.lastName}`
  };
  people2.push(newPerson);
}
//const people2 = people.map(person => { id: person.id, name: `${person.firstName} ${person.lastName}` });
//const people2 = people.map(person => ({ id: person.id, name: `${person.firstName} ${person.lastName}` }));
//const people2 = people.map(person => { return { id: person.id, name: `${person.firstName} ${person.lastName}` }; });


//9
const arr = [ 2, 10, 7, 5, 1, 23 ];
//arr.sort();
arr.sort((a, b) => a > b);
//arr.sort((a, b) => a - b);
//arr.sort((a, b) => a < b);
//arr.sort((a, b) => b - a);
console.log(arr);


//10
const numbers = [ 2, 10, 7, 5, 1, 23, 39, 8 ];
//let sum = 0; for (let number of numbers) {sum += number;}
let sum = numbers.reduce((sum, number) => sum + number);
//let sum = numbers.reduce((sum, number) => sum + number, 0);
//let sum = numbers.reduce((sum, number) => { sum += number; });
//let sum = numbers.reduce((sum, number) => { sum += number; }, 0);
console.log(sum);

const categories = { children: [], adults: [] };

for (let person of people) {
  if (person.age < 18) {
    categories.children.push(person)
  } else {
    categories.adults.push(person);
  }
}
console.log(categories);

/* Answer a: 
const categoriesA = people.reduce(
    (categories, person) => {
      if (person.age > 18) {
        categories.children.push(person)
      } else {
        categories.adults.push(person);
      }
    }, { children: [], adults: [] }
  );
  console.log(categoriesA);*/

/* Answer b: */
const categoriesB = people.reduce(
    (categories, person) => {
      if (person.age < 18) {
        categories.children.push(person)
      } else {
        categories.adults.push(person);
      }
      return categories;
    }, { children: [], adults: [] }
  );
  console.log(categoriesB);

/* Answer c: 
const categoriesC = people.reduce(
    (categories, person) => {
      person.age > 18 ? categories.children.push(person) : categories.adults.push(person);
    }, { children: [], adults: [] }
  );
  console.log(categoriesC);*/

/* Answer d: */
const categoriesD = people.reduce(
    (categories, person) => {
      person.age < 18 ? categories.children.push(person) : categories.adults.push(person);
      return categories;
    }, { children: [], adults: [] }
  );
  console.log(categoriesD);