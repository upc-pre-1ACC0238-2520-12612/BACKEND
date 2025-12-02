package bc.auth.application.dto;

public class SustainableActionDto {

    private Long id;
    private String title;
    private String description;
    private String category;
    private Integer pointsPerUnit;
    private String unit;
    private boolean active;

    public SustainableActionDto() {
    }

    public SustainableActionDto(Long id, String title, String description,
                                String category, Integer pointsPerUnit,
                                String unit, boolean active) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.pointsPerUnit = pointsPerUnit;
        this.unit = unit;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPointsPerUnit() {
        return pointsPerUnit;
    }

    public void setPointsPerUnit(Integer pointsPerUnit) {
        this.pointsPerUnit = pointsPerUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
