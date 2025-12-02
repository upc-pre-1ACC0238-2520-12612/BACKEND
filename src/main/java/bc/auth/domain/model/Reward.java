package bc.auth.domain.model;

public class Reward {

    private Long id;
    private String title;
    private String description;
    private Integer requiredPoints;
    private boolean active;

    public Reward() {
    }

    public Reward(Long id, String title, String description,
                  Integer requiredPoints, boolean active) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requiredPoints = requiredPoints;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRequiredPoints() {
        return requiredPoints;
    }

    public void setRequiredPoints(Integer requiredPoints) {
        this.requiredPoints = requiredPoints;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
