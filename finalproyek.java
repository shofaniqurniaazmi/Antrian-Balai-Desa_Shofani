import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class finalproyek {
    private String[] queue;
    private int front;
    private int rear;
    private int maxSize;

    private int nomorAntrian = 1;

    private Map<Integer, Nota> notaTable;

    public finalproyek(int maxSize) {
        this.maxSize = maxSize;
        queue = new String[maxSize];
        front = 0;
        rear = -1;
        notaTable = new HashMap<>();
    }

    public void ambilAntrian(String nama, String keperluan) {
        String nota = "Nomor Antrian: " + nomorAntrian + "\nNama: " + nama + "\nKeperluan: " + keperluan;
        System.out.println("Antrian nomor " + nomorAntrian + " - Nama: " + nama);
        tambah(nota);

        Nota notaObjek = new Nota(nomorAntrian, nama, keperluan);
        notaTable.put(nomorAntrian, notaObjek);

        nomorAntrian++;
    }

    public boolean isFull()
    {return rear == maxSize - 1;}


    public boolean isEmpty() {
        return front > rear;
    }


    public void tambah(String data) {
        if (isFull()) {
            System.out.println("Antrian sedang full!!");
        } else {
            queue[++rear] = data;
            System.out.println("Objek " + data + " ditambahkan ke dalam antrian, sabar tunggu ya!");
        }
    }


    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian sedang kosong!");
            return null;
        } else {
            String data = queue[front++];
            System.out.println("Objek " + data + " dikeluarkan dari antrian, sampai jumpa!");
            return data;
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Antrian sedang kosong!");
        } else {
            System.out.println("Isi antrian:");
            for (int i = front + 1; i <= rear; i++) {
                System.out.println(queue[i]);
            }
            System.out.println("+----------------------+");
            System.out.println("|     NOTA ANTRIAN     |");
            System.out.println("+----------------------+");
            System.out.println("|                      |");
            System.out.println("| " + queue[front] + " |");
            System.out.println("|                      |");
            System.out.println("+----------------------+");
        }
    }

    public void tampilkanLaporanTabel() {
        System.out.println("+------------------------------------+");
        System.out.println("+       DATA SELURUH ANTRIAN         +");
        System.out.println("+------------------------------------+");
        System.out.println("+------------------------------------+");
        System.out.println("| No.  |   Nama   |  Keperluan       |");
        System.out.println("+------------------------------------+");

        for (Map.Entry<Integer, Nota> entry : notaTable.entrySet()) {
            int nomorAntrian = entry.getKey();
            Nota nota = entry.getValue();
            System.out.printf("| %-4d | %-8s | %-18s |%n", nomorAntrian, nota.getNama(), nota.getKebutuhan());
        }

        System.out.println("+------------------------------------+");
    }


    public void panggilAntrianRecursive() {
        if (isEmpty()) {
            System.out.println("Antrian sedang kosong!");
        } else {
            System.out.println("Antrian yang dipanggil:");
            System.out.println(queue[front]);
        }
    }

    private void panggilAntrianRecursive(int index) {
        if (index > rear) {
            System.out.println("Tidak ada antrian lain yang dipanggil.");
        } else {
            System.out.println("Antrian yang dipanggil:");
            System.out.println(queue[index]);
            panggilAntrianRecursive(index + 1);
        }
    }


    private static class Nota {
        private int nomorAntrian;
        private String nama;
        private String kebutuhan;

        public Nota(int nomorAntrian, String nama, String kebutuhan) {
            this.nomorAntrian = nomorAntrian;
            this.nama = nama;
            this.kebutuhan = kebutuhan;
        }

        public String getNama() {
            return nama;
        }

        public String getKebutuhan() {
            return kebutuhan;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan kapasitas dalam antrian Di Balai Desa Gitik  : ");
        int maxSize = scanner.nextInt();
        AntrianProgram queueExample = new AntrianProgram(maxSize);
        int choice = 0;
        while (choice != 6) {
            System.out.println();
            System.out.println("=====================");
            System.out.println("[Selamat Datang Di Balai Desa Gitik]");
            System.out.println("=====================");

            System.out.println("Silahkan Anda Pilih : ");
            System.out.println("1. Ambil nomor ke dalam antrian");
            System.out.println("2. Panggil antrian ");
            System.out.println("3. Keluarkan nomor dari antrian ");
            System.out.println("4. Ambil nota antrian ");
            System.out.println("5. Tampilkan data seluruh antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan keperluan: ");
                    String kebutuhan = scanner.nextLine();
                    queueExample.ambilAntrian(nama, kebutuhan);
                    break;
                case 2:
                    queueExample.panggilAntrianRecursive();
                    break;
                case 3:
                    queueExample.dequeue();
                    break;
                case 4:
                    queueExample.displayQueue();
                    break;
                case 5:
                    queueExample.tampilkanLaporanTabel();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan pelayanan kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba pilihan lain.");
                    break;
            }
        }
    }
}





