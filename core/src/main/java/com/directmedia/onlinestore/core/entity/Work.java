package com.directmedia.onlinestore.core.entity;

public class Work {

    private long id;
    private String title;
    private String genre;
    private int release;
    private String summary;
    private Artist mainArtist;

    public long randLong(long min, long max) {
        return (new java.util.Random().nextLong() % (max - min)) + min;
    }
    
    /**
     * Default Constructor
     */
    public Work() {
        super();
    }

    /**
     * @param title
     */
    public Work(String title) {
        super();
        this.id = randLong(10000, 100000);
        this.title = title;
    }
    
    /**
     * @param id
     * @param title
     */
    public Work(long id, String title) {
        super();
        this.id = id;
        this.title = title;
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the release
     */
    public int getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(int release) {
        this.release = release;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the mainArtist
     */
    public Artist getMainArtist() {
        return mainArtist;
    }

    /**
     * @param mainArtist the mainArtist to set
     */
    public void setMainArtist(Artist mainArtist) {
        this.mainArtist = mainArtist;
    }

}
