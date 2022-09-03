public class Test {

    public static void main(String[] args) {

        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        MusicCollection favorite = new MusicCollection();

        Music music1 = new Music("Intro","Sadegh", 1395);
        Music music2 = new Music("Sarkoob","Yas", 1398);
        Music music3 = new Music("Bidari","Assar", 1394);
        Music music4 = new Music("Barron","Shajarian", 1395);
        Music music5 = new Music("Iran","Chaartaar", 1398);


        rock.addFile(music1);                                       //add musics to different playlist
        rock.addFile(music2);
        pop.addFile(music3);
        pop.addFile(music4);
        pop.addFile(music5);

        System.out.println(pop.getNumberOfFiles());                 //number of files
        pop.listAllFiles();                                         //print songs information
        rock.removeFile(0);                                   //remove the first music
        pop.startPlaying(2);                                  //play a song
        pop.stopPlaying();                                          //stop a song

        favorite.addFile(music4);                                   //add musics to my favorite
        favorite.addFile(music1);
        favorite.removeFile(0);                               //remove from favorite
        favorite.listAllFiles();

        pop.search("Iran");



    }
}
