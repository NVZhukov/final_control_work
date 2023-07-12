package final_control_work.nursery.core.MVP;

import final_control_work.nursery.core.infrastructure.Journal;

public class Model {
    /*Работа с получением списка животных и сохранение данных*/
    Journal currentJournal;
    private String path;

    public Model(String path) {
        currentJournal = new Journal();
        this.path = path;
    }
}
