package final_control_work.nursery.core.controller;

import final_control_work.nursery.core.infrastructure.Journal;
import final_control_work.nursery.core.models.Animal;
import final_control_work.nursery.core.models.animals.*;
import final_control_work.nursery.core.models.AnimalGenus;
import java.time.LocalDate;
import java.util.List;

public class NurseryEntry {
    private Journal journal;

    public NurseryEntry(Journal journal) {
        this.journal = journal;
    }

    public boolean createAnimal(String name, LocalDate birthDay, AnimalGenus animalGenus) {
        Animal animal = switch (animalGenus) {
            case CAT -> new Cat(name, birthDay);
            case DOG -> new Dog(name, birthDay);
            case HAMSTER -> new Hamster(name, birthDay);
            case HORSE -> new Horse(name, birthDay);
            case CAMEL -> new Camel(name, birthDay);
            case DONKEY -> new Donkey(name, birthDay);
        };
        return journal.addAnimal(animal);
    }

    public List<Animal> getAnimals() {
        return journal.getAnimalList();
    }

    public void printNursery() {
        journal.getAllAnimal();
    }

    public boolean removeAnimal(Animal animal) {
        if (animal == null) return false;
        return  journal.removeAnimal(animal);
    }
}
