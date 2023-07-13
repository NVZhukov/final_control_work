package final_control_work.nursery.core.models;

public enum AnimalGenus {
    DOG ("Собака"),
    CAT ("Кошка"),
    HAMSTER ("Хомяк"),
    HORSE ("Лошадь"),
    CAMEL ("Верблюд"),
    DONKEY ("Осёл");

    private String title;

    AnimalGenus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
