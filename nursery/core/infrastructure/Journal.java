package final_control_work.nursery.core.infrastructure;

import final_control_work.nursery.core.models.Animal;
import final_control_work.nursery.core.models.PackAnimal;
import final_control_work.nursery.core.models.Pet;
import final_control_work.nursery.core.models.animals.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Journal {

    private HashMap<Integer, Animal> animalNursery = new HashMap<>();

    public Journal() {
        init();
    }

    private void init() {
        Pet cat = new Cat("Tom", LocalDate.of(2021, 3, 1));
        animalNursery.put(cat.getId(),cat);
        Pet dog = new Dog("Spike", LocalDate.of(2019, 9, 14));
        animalNursery.put(dog.getId(),dog);
        Pet hamster = new Hamster("Homa", LocalDate.of(2023, 1, 29));
        animalNursery.put(hamster.getId(),hamster);
        PackAnimal horse = new Horse("Bullet", LocalDate.of(2020,11,26));
        animalNursery.put(horse.getId(), horse);
        PackAnimal camel = new Camel("Dune", LocalDate.of(2010,7,6));
        animalNursery.put(camel.getId(), camel);
        PackAnimal donkey = new Horse("Brake", LocalDate.of(2015,1,26));
        animalNursery.put(donkey.getId(), donkey);
    }

    public boolean addAnimal(Animal animal) {
        boolean flag = false;
        if (!animalNursery.containsKey(animal.getId())) {
            animalNursery.put(animal.getId(), animal);
            flag = true;
        }
        return flag;
    }

    public boolean removeAnimal(Animal animal) {
        boolean flag = false;
        if (animalNursery.containsKey(animal.getId())) {
            animalNursery.remove(animal.getId());
            flag = true;
        }
        return flag;
    }

    public void getAllAnimal() {
        for (Animal animal: animalNursery.values()){
            System.out.println("Id: " + animal.getId() + " Name: " + animal.getName() + " Birthday: " + animal.getBirthday());
        }
    }

    public List<Animal> getAnimalList() {
        List<Animal> result = new ArrayList<>();
        for (Animal animal: animalNursery.values()) {
            result.add(animal);
        }
        return result;
    }
}
