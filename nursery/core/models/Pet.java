package final_control_work.nursery.core.models;

import java.time.LocalDate;

public abstract class Pet extends Animal{
    public Pet(String name, LocalDate birthday) {
        super(name, birthday);
    }
}
