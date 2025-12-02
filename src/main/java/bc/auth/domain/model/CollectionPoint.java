package bc.auth.domain.model;

public class CollectionPoint {

    private Long id;
    private String name;
    private String address;
    private String schedule;
    private Double latitude;
    private Double longitude;
    private boolean active;

    public CollectionPoint() {
    }

    public CollectionPoint(Long id, String name, String address,
                           String schedule, Double latitude,
                           Double longitude, boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.schedule = schedule;
        this.latitude = latitude;
        this.longitude = longitude;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
