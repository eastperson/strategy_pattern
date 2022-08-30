package domain;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    
    private List<BackendFramework> backendFrameworks = new ArrayList<>();
    private List<FrontendFramework> frontendFrameworks = new ArrayList<>();

    public void addBackend(List<BackendFramework> list) {
        this.backendFrameworks.addAll(list);
    }

    public void addFrontend(List<FrontendFramework> list) {
        this.frontendFrameworks.addAll(list);
    }

    public void add(Skill skill) {
        this.backendFrameworks.addAll(skill.backendFrameworks);
        this.frontendFrameworks.addAll(skill.frontendFrameworks);
    }

    public boolean hasBackendSkill() {
        return !this.backendFrameworks.isEmpty();
    }

    public boolean hasFrontendSkill() {
        return !this.frontendFrameworks.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (!backendFrameworks.equals(skill.backendFrameworks)) return false;
        return frontendFrameworks.equals(skill.frontendFrameworks);
    }

    @Override
    public int hashCode() {
        int result = backendFrameworks.hashCode();
        result = 31 * result + frontendFrameworks.hashCode();
        return result;
    }
}
