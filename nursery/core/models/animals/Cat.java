package final_control_work.nursery.core.models.animals;

import final_control_work.nursery.core.models.AnimalGenus;
import final_control_work.nursery.core.models.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthday) {
        super(name, birthday);
        setAnimalGenius(AnimalGenus.CAT);
    }
}
