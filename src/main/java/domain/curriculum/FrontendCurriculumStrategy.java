package domain.curriculum;

import domain.BackendFramework;
import domain.FrontendFramework;
import domain.LanguageType;
import domain.Skill;

import java.util.ArrayList;
import java.util.List;

public class FrontendCurriculumStrategy implements CurriculumStrategy {
    @Override
    public Skill learn(LanguageType languageType) {
        List<FrontendFramework> list;
        switch (languageType) {
            case JAVA -> list = FrontendFramework.JavaFrontendFrameworks();
            case JAVASCRIPT -> list = FrontendFramework.JavascriptFrontendFrameworks();
            default -> throw new IllegalArgumentException("지원하지 않는 언어입니다.");
        }
        Skill skill = new Skill();
        skill.addFrontend(list);
        return skill;
    }
}
