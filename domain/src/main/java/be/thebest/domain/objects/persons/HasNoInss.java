package be.thebest.domain.objects.persons;

public class HasNoInss implements INSSable {

    @Override
    public String getInss() {
        return null;
    }

    @Override
    public void setInns(String inns) {

    }
}
