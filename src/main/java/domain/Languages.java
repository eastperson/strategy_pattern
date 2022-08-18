package domain;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    private List<LanguageType> languageList = new ArrayList();

    public void acquire(LanguageType language) {
        this.languageList.add(language);
    }

    public List<LanguageType> getLanguageList() {
        return languageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Languages languages)) return false;

        return languageList.equals(languages.languageList);
    }

    @Override
    public int hashCode() {
        return languageList.hashCode();
    }
}
