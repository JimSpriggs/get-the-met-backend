package uk.spon.getthemet.entity;

public final class MetrolinkStationBuilder {
    private String name;

    private MetrolinkStationBuilder() {
    }

    public static MetrolinkStationBuilder aMetrolinkStation() {
        return new MetrolinkStationBuilder();
    }

    public MetrolinkStationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MetrolinkStation build() {
        return new MetrolinkStation(name);
    }
}
