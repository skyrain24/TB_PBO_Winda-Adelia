import java.util.Scanner;

public class MenuPlaylist extends Playlist {
    private Scanner input;
    private Scanner menu;


    public void menuProgram(){
        int pilihan= 0;
        int inputdata= 0;


    while(inputdata ==0){

        System.out.println("\nMenu Playlist");
        System.out.println("1. Tambah Lagu");
        System.out.println("2. Putar Lagu");
        System.out.print("\nMasukkan Pilihan : ");

        menu = new Scanner (System.in);



        try {
            pilihan = menu.nextInt();
            inputdata = 1;
        } catch (Exception e) {
            System.out.println("Inputkan angka !");
        }
        
    }
    

    System.out.println("");
    pilihan(pilihan);
    }


    public void pilihan(int menu){
        switch(menu){
            case 1 :
            tambah();
            break;

            case 2 :
            play();
            break;
           
        }
        lanjut();
    }

    public void lanjut(){
        System.out.println("\nApakah Anda ingin melanjutkan [0(lanjut)/1(berhenti)]? ");
        input = new Scanner (System.in);
        int pilihan1 = input.nextInt();
        if(pilihan1 == 0){
            menuProgram();
        }
    }
}