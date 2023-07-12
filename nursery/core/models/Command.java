package final_control_work.nursery.core.models;

import java.util.Objects;

public record Command(String name) {
    public Command {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Command");
        sb.append(" - ").append(name);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(name, command.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
