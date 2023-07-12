package final_control_work.nursery.core.models.animals;

import final_control_work.nursery.core.models.AnimalGenus;
import final_control_work.nursery.core.models.PackAnimal;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthday) {
        super(name, birthday);
        setAnimalGenius(AnimalGenus.HORSE);
    }
}
