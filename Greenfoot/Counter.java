import greenfoot.*;

public class Counter extends Actor
{
    //deklarasi variabel colorTransparent yang diisi dengan class Color 0000 (putih transparant)
    private Color Colortransparent = new Color(0,0,0,0);
    
    //deklarasi variabel background yang akan menjadi gambar background dari Counter
    private GreenfootImage background;
    
    
    //deklarasi value dan target sebagai nilai yang akan dijadikan patokan dan tampilan
    private int value;
    private int target;
    
    //deklarasai prefix, digunakan sebagai prefix atau nilai awalan dalam menampilkan skor
    private String prefix;
    
    /**
     * Berikut ini adalah contoh penerapan Overloading pada constructor
     * dimana ada 2 method yang namanya sama tapi memiliki parameter berbeda
     */

    // tidak menerima parameter
    public Counter()
    {
        // Jika tidak ada parameter yang diberikan ketika inisiasi class
        // maka akan membuat class kembali dengan parameter string kosong ""
        this("");
    }

    // menerima parameter prefix
    public Counter(String prefix)
    {
        // mengganti nilai property background dengan gambar yang sudah diinisiasikan ke class
        this.background = getImage();

        //mengganti nilai target dan value yang akan dijadikan patokan dalam menampilkan Counter
        this.value = 0;
        this.target = 0;
        
        //mengganti nilai prefix
        this.prefix = prefix;
        
        //memanggil method updateImage untuk mengganti value yang ada digambar
        updateImage();
    }

    /**
     *   Method act akan diselalu dijalankan sesudah class diinisiasi
     *   disini saya memanfaatkan method act untuk :
     *   1. Meng Update nilai value
     *   2. Memanggil method UpdateImage
     *   
     *   Kenapa tidak langsung diset valuenya ?
     *   agar terlihat animasi pengurangan atau penambahan nilainya.. :D
     */
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }

    }

    /**
     * Method add untuk menambahkan nilai target sesuai parameter score
     */
    public void add(int score)
    {
        target += score;
    }

    /**
     * Method Accessor atau Getter
     * untuk mengakses nilai target
     */
    
    public int getValue()
    {
        return target;
    }

    /**
     * Method Mutator atau Setter
     * untuk mengubah nilai target dan value
     * kemudian dilakukan updateImage
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        
        updateImage();
    }

    /**
     * Method UpdateImage
     * digunakan untuk menambahan nilai score ditengah background
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, Colortransparent);

        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }

        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
            (image.getHeight()-text.getHeight())/2);

        setImage(image);
    }
}

