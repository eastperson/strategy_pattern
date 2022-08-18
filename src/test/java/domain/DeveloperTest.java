package domain;

import domain.curriculum.BackendCurriculumStrategy;
import domain.curriculum.FrontendCurriculumStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DeveloperTest {

    @Test
    @DisplayName("개발자는 최소 하나 이상의 언어를 할 줄 안다.")
    void developer_create_language() {
        Developer developer = new Developer(LanguageType.JAVA);
        assertThat(developer).isEqualTo(new Developer(LanguageType.JAVA));
    }

    @Test
    @DisplayName("자바 개발자가 백엔드 커리큘럼을 배우면 백엔드 개발자가 된다.")
    void developer_learn_framework() {
        Developer developer = new Developer(List.of(LanguageType.JAVA, LanguageType.GO));
        developer.learn(new BackendCurriculumStrategy());
        assertThat(developer.isBackendDeveloper()).isTrue();
    }

    @Test
    @DisplayName("JS 개발자가 프론트엔드 커리큘럼을 배우면 프론트엔드 개발자가 된다.")
    void front_developer_learn_framework() {
        Developer developer = new Developer(LanguageType.JAVASCRIPT);
        developer.learn(new FrontendCurriculumStrategy());
        assertThat(developer.isFrontendDeveloper()).isTrue();
    }

    @Test
    @DisplayName("함수형 프로그래밍 -> 인자로 매개변수로 JSP 만 배워!")
    void functional_interface() {
        Developer developer = new Developer(LanguageType.JAVASCRIPT);
        developer.learn((languageType -> {
            List<FrontendFramework> list =FrontendFramework.JavaFrontendFrameworks();
            Skill skill = new Skill();
            skill.addFrontend(list);
            return skill;
        }));
        assertThat(developer.isFrontendDeveloper()).isTrue();
    }

    @Test
    @DisplayName("GO 개발자가 프론트 커리큘럼을 배우면 프론트엔드 개발자가 되지못한다.")
    void go_front_developer_learn_framework() {
        Developer developer = new Developer(LanguageType.GO);
        assertThatThrownBy(() -> developer.learn(new FrontendCurriculumStrategy())).isInstanceOf(IllegalArgumentException.class);
    }
}
