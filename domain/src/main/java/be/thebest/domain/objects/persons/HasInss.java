package be.thebest.domain.objects.persons;

public class HasInss implements INSSable {

    private String inss;

    @Override
    public String getInss() {
        return inss;
    }

    @Override
    public void setInns(String inns) {
        this.inss = inns;
    }
}
