import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Collection (Antrian)
public class Playlist {

	String x;
	Queue<String> playlist = new LinkedList<>();
	Scanner input = new Scanner(System.in);

    public void tambah(){
		System.out.println("Masukkan lagu");
		x = input.next();
		((LinkedList<String>) playlist).push(x);
	}

	public void play(){
		System.out.println("Lagu " + playlist.peek() + " diputar");
		playlist.poll();
	}
}
