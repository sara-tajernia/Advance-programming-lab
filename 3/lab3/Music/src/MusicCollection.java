import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection {
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection() {
        files = new ArrayList<Music>();
    }

    /**
     * Add a file to the collection.
     *
     * @param toAdd The file to be added.
     */
    public void addFile(Music toAdd) {
        files.add(toAdd);
    }

    /**
     * Return the number of files in the collection.
     *
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return files.size();
    }

    /**
     * List a file from the collection.
     *
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        files.get(index);
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles() {
        Iterator<Music> it = files.iterator();;
        Music music;
        while (it.hasNext()) {
            music = it.next();
            System.out.println("Name: " +music.getName() +"     Singer:" +music.getSinger() +"      year:" +music.getYear());
        }
        System.out.println();
    }

    /**
     * Remove a file from the collection.
     *
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        files.remove(index);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     *
     * @param index The index of the file to be played.
     */

    private MusicPlayer music = new MusicPlayer();

    public void startPlaying(int index) {
        Music test = files.get(index);
        music.startPlaying(test);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        music.stop();
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     *
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        // The return value.
        // Set according to whether the index is valid or not.
        if (files.size() < index)
            return false;
        else
            return true;
    }

    public void search(String name){
        Iterator<Music> it = files.iterator();
        Music music;
        while (it.hasNext()){
            music = it.next();
            if(music.getName() == name)
                System.out.println("Name: " +music.getName() +"     Singer:" +music.getSinger() +"      year:" +music.getYear());
        }
    }


}