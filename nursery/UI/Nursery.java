package final_control_work.nursery.UI;

import final_control_work.nursery.core.controller.NurseryEntry;
import final_control_work.nursery.core.infrastructure.Journal;
import final_control_work.nursery.core.models.Animal;
import final_control_work.nursery.core.models.Command;
import final_control_work.nursery.core.models.animals.Dog;

import java.time.LocalDate;
import java.util.ArrayList;

public class Nursery {

    public static void run() {
        NurseryEntry nurseryEntry = new NurseryEntry(new Journal());
        ConsoleView consoleView = new ConsoleView(nurseryEntry);

        while (true) {
            consoleView.showStartInfo();
            int code = consoleView.selectAction();
            switch (code) {
                case 1: {
                    boolean result = consoleView.addingAnimal();
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                    break;
                }
                case 2: {
                    consoleView.animalInfo();
                    break;
                }
            }
        }
    }
}
