package myWork

object MyGenericAnimalsList {
 class MyList[+A]{
  // use the type A
  def add[B >: A](element : B) : MyList[B] = ???
}

  class MyMap[Key,Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList{
    def empty[A]: MyList[A]= ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. yes, list[cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalsList : CovariantList[Animal] = new CovariantList[Cat]

  //2. No = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //3.Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded type
  class Cage[A <: Animal](animal:A)
  val cage = new Cage(new Dog)

//  class Car
//  val newCage = new Cage(new Car)
}
