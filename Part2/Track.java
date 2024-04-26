public class Track {
    // Instance variables
    private String name;
    private int trackLength;
    private String surface;
    private int lanes;

    // Constructor
    public Track(String name, int trackLength, String surface, int lanes) {
        this.name = name;
        this.trackLength = trackLength;
        this.surface = surface;
        this.lanes = lanes;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public String getSurface() {
        return surface;
    }

    public int getLanes() {
        return lanes;
    }

    // Mutator methods

    public void setName(String name) {
        this.name = name;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setLanes(int lanes) {
        this.lanes = lanes;
    }

}
