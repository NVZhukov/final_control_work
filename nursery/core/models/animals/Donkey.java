package final_control_work.nursery.core.models.animals;

import final_control_work.nursery.core.models.AnimalGenus;
import final_control_work.nursery.core.models.PackAnimal;

import java.time.LocalDate;

public class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthday) {
        super(name, birthday);
        setAnimalGenius(AnimalGenus.DONKEY);
    }
}
