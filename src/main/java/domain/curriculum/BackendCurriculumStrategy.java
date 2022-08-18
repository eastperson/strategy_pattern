package domain.curriculum;

import domain.BackendFramework;
import domain.LanguageType;
import domain.Skill;

import java.util.ArrayList;
import java.util.List;

public class BackendCurriculumStrategy implements CurriculumStrategy {
    public Skill learn(LanguageType languageType) {
        List<BackendFramework> list;
        switch (languageType) {
            case JAVA -> list = BackendFramework.JavaBackendFrameworks();
            case PYTHON -> list = BackendFramework.PythonBackendFrameworks();
            case JAVASCRIPT -> list = BackendFramework.JavascriptBackendFrameworks();
            case GO -> list = BackendFramework.GoBackendFrameworks();
            default -> throw new IllegalArgumentException("지원하지 않는 언어입니다.");
        }
        Skill skill = new Skill();
        skill.addBackend(list);
        return skill;
    }
}
