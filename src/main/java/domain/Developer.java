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
        if (!(o instanceof Developer developer)) return false;

        return languages.equals(developer.languages);
    }

    @Override
    public int hashCode() {
        return languages.hashCode();
    }

    public void learn(CurriculumStrategy curriculumStrategy) {
        this.languages.getLanguageList().forEach(languageType -> {
            this.skill.add(curriculumStrategy.learn(languageType));
        });
    }

    public boolean isBackendDeveloper() {
        return this.skill.hasBackendSkill();
    }

    public boolean isFrontendDeveloper() {
        return this.skill.hasFrontendSkill();
    }
}
