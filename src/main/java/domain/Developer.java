package domain;

import domain.curriculum.CurriculumStrategy;

import java.util.Collection;
import java.util.Collections;

public class Developer {

    private final Languages languages = new Languages();
    private final Skill skill = new Skill();

    public Developer(Collection<LanguageType> languages) {
        languages.forEach(this.languages::acquire);
    }

    public Developer(LanguageType language) {
        this(Collections.singleton(language));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (!languages.equals(developer.languages)) return false;
        return skill.equals(developer.skill);
    }

    @Override
    public int hashCode() {
        int result = languages.hashCode();
        result = 31 * result + skill.hashCode();
        return result;
    }

    public void learn(CurriculumStrategy curriculumStrategy) {
        this.languages.addSkill(this.skill, curriculumStrategy);
    }

    public boolean isBackendDeveloper() {
        return this.skill.hasBackendSkill();
    }

    public boolean isFrontendDeveloper() {
        return this.skill.hasFrontendSkill();
    }
}
