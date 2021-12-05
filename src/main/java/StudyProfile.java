public enum StudyProfile {
    MEDICINE ("Medicine"),
    PHYSICS ("Physics"),
    MATHEMATICS ("Mathematics"),
    IT ("IT"),
    LAW ("Law"),
    SPORT ("Sport"),
    LINGUISTICS ("Linguistics");

    private String title;

    StudyProfile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
