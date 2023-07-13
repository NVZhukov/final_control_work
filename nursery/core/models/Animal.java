package final_control_work.nursery.core.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Animal {
    protected final String name;
    protected final LocalDate birthday;
    protected ArrayList<Command> commandList;
    protected AnimalGenus animalGenus;
    private static int count;
    private final int id = ++count;

    public Animal(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        commandList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public ArrayList<Command> getCommandList() {
        return commandList;
    }

    public int getId() {
        return id;
    }

    public AnimalGenus getAnimalGenus() {
        return animalGenus;
    }

    public void setAnimalGenius(AnimalGenus animalGenus) {
        this.animalGenus = animalGenus;
    }

    public boolean learnCommand(Command newCommand) {
        if (commandList.contains(newCommand)) {
            return false;
        }
        commandList.add(newCommand);
        return true;
    }

    public int getAge() {
        int years = Period.between(birthday, LocalDate.now()).getYears();
        int months = Period.between(birthday, LocalDate.now()).getMonths();
        return years * 12 + months;
    }
}