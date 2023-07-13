package final_control_work.nursery.UI;

import final_control_work.nursery.core.controller.NurseryEntry;
import final_control_work.nursery.core.infrastructure.Journal;

public class Nursery {

    public static void run() {
        NurseryEntry nurseryEntry = new NurseryEntry(new Journal());
        ConsoleView consoleView = new ConsoleView(nurseryEntry);
        boolean flag = true;
        System.out.println("Вас привествует программа учета животных в питомнике!");
        while (flag) {
            consoleView.showStartInfo();
            int animalCount = nurseryEntry.getAnimals().size();
            int code = consoleView.selectAction();
            switch (code) {
                case 1: {
                    boolean result = consoleView.addingAnimal();
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                    break;
                }
                case 2: {
                    if (animalCount < 1) {
                        System.out.println("На данный момент нет животных для вывода информации");
                    } else {
                        consoleView.animalInfo();
                    }
                    break;
                }
                case 3: {
                    if (animalCount < 1) {
                        System.out.println("На данный момент нет животных для обучения командам");
                    } else {
                        consoleView.animalTraining(consoleView.animalInfo());
                    }
                    break;
                }
                case 4: {
                    if (animalCount < 1) {
                        System.out.println("На данный момент нет животных для выписки");
                    } else {
                        consoleView.deleteAnimal();
                    }
                    break;
                }
                case 5: {
                    System.out.println("Покааа!");
                    flag = false;
                }
            }
        }
    }
}
