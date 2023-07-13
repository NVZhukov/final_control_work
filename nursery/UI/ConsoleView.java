package final_control_work.nursery.UI;

import final_control_work.nursery.core.controller.NurseryEntry;
import final_control_work.nursery.core.models.Animal;
import final_control_work.nursery.core.models.AnimalGenus;
import final_control_work.nursery.core.models.Command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ConsoleView {

    private NurseryEntry nurseryEntry;
    private Scanner scanner;

    public ConsoleView(NurseryEntry nurseryEntry) {
        this.nurseryEntry = nurseryEntry;
        scanner = new Scanner(System.in);
    }

    record AnimalData(String name, LocalDate birthDate, AnimalGenus animalGenus) {
    }

    public void showStartInfo() {
        List<Animal> animalList = nurseryEntry.getAnimals();
        if (animalList.isEmpty()) {
            System.out.println("Пока в питомнике нет животных!");
        } else {
            System.out.println("На данный в питомнике живут: ");
            nurseryEntry.printNursery();
        }
    }

        public int selectAction() {
        int action = 0;
        System.out.println("Выберите дальнейшее действие: ");
        System.out.println("1 - Добавить животное");
        System.out.println("2 - Информация о конкретном животном");
        System.out.println("3 - Обучить новой команде");
        System.out.println("4 - Выписать животное");
        System.out.println("5 - Завершить работу");
        try {
            scanner = new Scanner(System.in);
            action = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return action;
    }

    public boolean addingAnimal() {
        String infoMessage = "Введите параметры животного в виде строки: \"имя день_рождения род_животного\"\n" +
                "день_рождения имеет вид: dd-mm-yyyy (12-03-2022): \n" +
                "род_животного может принимать значения: " + Arrays.asList(AnimalGenus.values());
        System.out.println(infoMessage);
        while (true) {
            try {
                System.out.print("Ввод: ");
                scanner = new Scanner(System.in);
                String inputData = scanner.nextLine();
                AnimalData data = animalData(inputData);
                return nurseryEntry.createAnimal(data.name, data.birthDate, data.animalGenus);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты рождения");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    public Animal animalInfo() {
        String infoMessage = String.format("Введите номер животного (1 - %d)", nurseryEntry.getAnimals().size());
        System.out.println(infoMessage);
        while (true) {
            try {
                scanner = new Scanner(System.in);
                int animalNumber = scanner.nextInt();
                Animal animal = nurseryEntry.getAnimals().get(animalNumber - 1);
                printAnimalInfo(animal);
                return animal;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Запись с таким номером отсутствует");
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean animalTraining(Animal animal) {
        System.out.println("Укажите название команды: ");
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(animal.getName() + " успешно обучен команде: " + input);
        return animal.learnCommand(new Command(input));
    }

    public boolean deleteAnimal() {
        String infoMessage = String.format("Введите номер животного (1 - %d)", nurseryEntry.getAnimals().size());
        System.out.println(infoMessage);
        while (true) {
            try {
                scanner = new Scanner(System.in);
                int animalNumber = scanner.nextInt();
                Animal animal = nurseryEntry.getAnimals().get(animalNumber - 1);

                return nurseryEntry.removeAnimal(animal);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Запись с таким номером отсутствует");
            }
        }
    }

    private AnimalData animalData(String data) {
        String[] result = data.split(" ");
        if (result.length < 3) {
            throw new IllegalArgumentException("Недостаточное количество данных");
        }
        if (result.length > 3) {
            throw new IllegalArgumentException("Слишком много данных");
        }
        String animalName = result[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDay = LocalDate.parse(result[1], formatter);
        AnimalGenus genus = AnimalGenus.valueOf(result[2].toUpperCase());
        return new AnimalData(animalName, birthDay, genus);
    }

    public void printAnimalInfo(Animal animal) {
        System.out.printf("Род животного: %s\n", animal.getAnimalGenus().getTitle());
        System.out.printf("Имя: %s\n", animal.getName());
        System.out.printf("Дата рождения: %s\n", animal.getBirthday());
        System.out.printf("Возраст (в месяцах): %d\n", animal.getAge());
        System.out.printf("Умения: %s\n", animal.getCommandList());
    }
}
