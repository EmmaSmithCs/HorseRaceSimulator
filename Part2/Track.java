public class Track {
    // Instance variables
    private String name;
    private int trackLength;
    private String surface;

    // Constructor
    public Track(String name, int trackLength, String surface) {
        this.name = name;
        this.trackLength = trackLength;
        this.surface = surface;
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

}
