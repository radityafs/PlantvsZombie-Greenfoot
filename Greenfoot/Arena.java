import greenfoot.*; 

public class Arena extends World
{
    // inisiasi musicArena , musik background yang akan dijalankan ketika berada di world arena.
    private GreenfootSound musicArena = new GreenfootSound("background.wav");

    // inisiasi koordinat / lokasi x dan y tempat plant ditanam / ditempatkan
    private int[] Koordinatbaris = { 78, 184, 306, 418, 523 };
    private int[] Koordinatkolom = { 326, 413, 500, 588, 679, 765, 857, 943, 1042 };

    // inisiasi class Counter / atau kelas yang berfungsi untuk menghitung jumlah matahari dan skor game
    private Counter counter_sun = new Counter();
    private Counter counter_score = new Counter();

    /**
     * Constructor class Arena
     * fungsi dibawah akan dijalankan ketika Class di inisiasi
     */
    public Arena()
    {    
        super(1111, 602, 1);

        // menyiapkan segala sesuatu yang dibutuhkan dalam game
        prepareGame();

        // menjalankan background music arena secara berulang
        musicArena.playLoop();
    }

    /**
     * Pada fungsi / method prepare game akan dipanggil lagi method
     * prepareSidebar : untuk menyiapkan segala sesuatu yang ada disidebar
     * prepareLawnmower : untuk menyiapkan lawnmower / atau mesin pemotong rumput disamping sidebar
     * prepareShovel : untuk menyiapkan shovel / sekop untuk menghapus plant / tanaman
     */
    private void prepareGame()
    {
        prepareSidebar();
        prepareLawnmowers();
        prepareShovel();
    }

    /**
     *  Menyiapkan Item Game yang berada di sidebar
     *  1. biji tanaman / item game Walnut, PeaShoot, SunFlower, dan BeetRoot
     *  2. Counter atau penghitung skor dan jumlah sun / coin matahari yang dimiliki
     *  3. Menginisiasi nilai coin matahari pertama kali sebanyak 400 sun 
     */
    private void prepareSidebar(){
        addObject(new ItemWalnut(49, 140)   , 49, 140);
        addObject(new ItemPeaShoot(49, 236) , 49, 236);
        addObject(new ItemSunFlower(49, 332), 49, 332);
        addObject(new ItemBeetRoot(49, 428) , 49, 428);

        addObject(counter_score, 49, 78);
        addObject(counter_sun, 49, 567);
        counter_sun.setValue(400);
    }

    /**
     * Menyiapkan lawnMower / pemotong rumput ketempat atau
     * posisi yang sudah ditetapkan dalam variabel rows dan columns
     */
    private void prepareLawnmowers()
    {
        int[] baris = {77, 183, 309, 422, 522};
        int[] kolom = {242, 240, 226, 219, 214};

        for(int i = 0; i<5; i++)
        {
            addObject(new LownMower(), kolom[i] , baris[i]);
        }
    }

    /**
     * Menyiapkan Shovel / cangkul untuk menghapus tanaman yang ingin dihapus
     */
    private void prepareShovel(){
        addObject(new Shovel(1035, 40), 1035, 40); 
    }

    /**
     * Fungsi getPositionItem dibuat untuk mendapatkan
     * jarak terdekat yang memungkinkan tanaman untuk ditanam
     * fungsi ini memerlukan 2 parameter (x dan y)
     * dan akan mengembalikan koordinat yang memungkinkan dalam bentuk array
     */

    public int[] getPositionItem(int x, int y){
        int[] result = new int[2];

        // garis kolom / sebagai pembatas dalam menentukan kolom
        int[] columnGrid = {280, 364, 449, 543, 632, 721, 812, 897, 985, 1089};

        for(int column = 0; column < 9; column ++)
        {
            if(x > columnGrid[column] && x < columnGrid[column + 1])
            {
                result[0] = Koordinatkolom[column];
                break;
            }else{
                if(column==8){
                    result[0] = -1;
                }
            }
        }

        //garis baris / sebagai pembatas dalam menentukan baris
        int[] rowGrid = {0, 137, 246, 357, 462, 569};

        for(int row = 0; row < 5; row ++)
        {
            if(y > rowGrid[row] && y < rowGrid[row + 1])
            {
                result[1] = Koordinatbaris[row];
                break;
            }else{
                if(row==4){
                    result[1] = -1;
                }
            }
        }

        return result;
    }

    /**
     * Method addZombie digunakan untuk menambahkan zombie
     * kedalam Arena
     */
    public void addZombie(Zombie zombie, int row)
    {
        addObject(zombie, Koordinatkolom[8] + 70, Koordinatbaris[row]);        
    }

    /**
     * Fungsi random untuk menentukan zombie jenis apa yang dikeluarkan
     * atau dimunculkan kedalam arena
     */
    public void randomZombie(int row)
    {
        if(Greenfoot.getRandomNumber(2) == 0)
        {
            addZombie(new NormalZombie(), row);
        }
        else
        {
            addZombie(new FootballZombie(), row);
        }
    }

    /**
     * Method createWave ini berfungsi untuk memunculkan gelombang zombie
     * atau 1baris zombie pada periode tertentu
     */
    public void createWave()
    {
        for(int i = 0; i < 5; i += 1)
        {
            randomZombie(i);
        }
    }

    /**
     * Method untuk menjatuhkan Sun / Matahari 
     * pada lokasi kolom secara random
     */
    public void produceSunFromSky()
    {
        Sun sun = new Sun();
        addObject(sun, Koordinatkolom[Greenfoot.getRandomNumber(8)], 0);
        sun.letTheSunFall();
    }

    /**
     * Method ini digunakan untuk mengembalikan atau memberikan value
     * berupa class Counter yang digunakan untuk menghitung jumlah sun / matahari
     * berikut merupakan penerapan PBO -> Encapsulation
     */
    public Counter getSunCounter()
    {
        return this.counter_sun;
    }

    /**
     * Method ini digunakan untuk mengembalikan atau memberikan value
     * berupa class Counter yang digunakan untuk menghitung jumlah score game / permainan
     * berikut merupakan penerapan PBO -> Encapsulation
     */
    public Counter getScoreCounter()
    {
        return this.counter_score;
    }

    private long lastAdded = System.currentTimeMillis();
    private int timeUnit = 1; // 1 time unit = 10 seconds
    private int numberOfWaves = 0;
    private int waveNumber = 0;

    /**
     *   Method act akan diselalu dijalankan sesudah class diinisiasi
     *   disini saya memanfaatkan method act untuk memunculkan 
     *   zombie dan gelombang zombie setiap periode tertentu
     */
    public void act()
    {      
        long curTime  = System.currentTimeMillis();

        // setiap 10 detik akan memanggil zombie 
        // dan menghasilkan matahari dari langit
        // serta menambahkan timeUnit += 1

        if (curTime >= lastAdded + 10000)
        {
            // Menjatuhkan Matahari dari langit / atas
            produceSunFromSky();

            // Memunculkan Zombie
            randomZombie(Greenfoot.getRandomNumber(5));

            this.timeUnit += 1;
            this.lastAdded = curTime;
        }

        // Gelombang zombie akan ditambahkan setiap 30Detik
        // namun 30 Detik pertama akan dilewatkan karena masih terlalu awal

        if(this.timeUnit % 3 == 0 && this.timeUnit != 3) //1menit / 60s / 6time unit
        {
            
            // menambahkan baris gelombang zombie pertama
            if(curTime <= lastAdded + 25){
                // Menambahkan pesan dan suara Zombie Are Cooming menggunakan class ZombiesAreComing
                addObject(new ZombiesAreComing(), 639, 273);
                
                createWave();

                // jumlah gelombang
                // pertama = 6 time unit , 6-3/3 = 1
                // kedua = 9 time unit , 9-3 /3 = 2
                // dst
                
                this.numberOfWaves = (timeUnit - 3) / 3;
                this.waveNumber = 1;
            }

            //Menambahkan baris berikutnya jika gelombang lebih dari 1, agar tidak bertabrakan
            if((curTime > lastAdded + waveNumber * 1000) && (curTime < lastAdded + numberOfWaves * 1000))
            {
                this.waveNumber+=1;

                createWave();
            }
        }

    }

    /**
     * Method untuk menghentikan music
     * fungsi ini digunakan ketika sudah berganti halaman.
     */
    public void stopBackgroundMusic()
    {
        musicArena.stop();
    }
}
