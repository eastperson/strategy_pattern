package domain.curriculum;

import domain.Developer;
import domain.LanguageType;
import domain.Skill;

import java.util.List;
@FunctionalInterface
public interface CurriculumStrategy {
    Skill learn(LanguageType languageType);
}
