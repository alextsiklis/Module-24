import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class University {
    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public static class CompareByName implements Comparator<University> {
        @Override
        public int compare(University a, University b) {
            return StringUtils.compare(a.getFullName(), b.getFullName());
        }
    };

    public static class CompareById implements Comparator<University> {
        @Override
        public int compare(University a, University b) {
            return StringUtils.compare(a.getId(), b.getId());
        }
    };

    public static class CompareByYear implements Comparator<University> {
        @Override
        public int compare(University a, University b) {
            return Integer.compare(a.getYearOfFoundation(), b.getYearOfFoundation());
        }
    };

    @Override
    public String toString() {
        return "University [ID=" + id +
                ", fullName=" + fullName +
                ", shortName=" + shortName +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile + "]";
    }
}
