package final_control_work.nursery.core.infrastructure;

import final_control_work.nursery.core.models.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Journal {

    private HashMap<Integer, Animal> animalNursery;

    public Journal() {
        animalNursery = new HashMap<>();
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
