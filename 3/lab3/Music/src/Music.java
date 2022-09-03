public class Music {

    /**
     * the class to hold a details of each song includes name,
     * name of singer and date of the song
     */
    private String name;
    private String singer;
    private int year;

    public Music(String name_song, String singer_song, int year_song){
        name = name_song;
        singer = singer_song;
        year = year_song;
    }
    public void setName(String Name){
        this.name = Name;
    }
    public String getName(){
        return name;
    }
    public void setSinger(String singer){
        this.singer = singer;
    }
    public String getSinger(){
        return singer;
    }
    public void setYear(int Year){
        this.year = Year;
    }
    public int getYear(){
        return year;
    }


}
