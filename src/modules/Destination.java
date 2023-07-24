package modules;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Destination {
    private String name;
    private  String description;
    private Set<Activity> activities;

    private TravelPackage travelPackage;

    public Destination(String name, String description,TravelPackage travelPackage) {
        this.name = name;
        this.description = description;
        this.activities = new HashSet<>();
        this.travelPackage=travelPackage;
        this.travelPackage.add_destination(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean add_activity(Activity activity){
        if(activity.isIs_associated()){
            System.out.println("this activity is already associated with ");
            return false;
        }
        this.activities.add(activity);
        activity.setIs_associated(true);
        return true;
    }

    public void remove_activity(Activity activity){
        this.activities.remove(activity);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", activities=" + activities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(travelPackage, that.travelPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), travelPackage);
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }
}
