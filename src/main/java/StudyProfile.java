import com.fasterxml.jackson.annotation.JsonProperty;

public enum StudyProfile {
    MEDICINE ("Medicine"),
    PHYSICS ("Physics"),
    MATHEMATICS ("Mathematics"),
    IT ("IT"),
    LAW ("Law"),
    SPORT ("Sport"),
    LINGUISTICS ("Linguistics");

    @JsonProperty("study-profile")
    private String title;

    StudyProfile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
