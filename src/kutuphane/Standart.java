/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane;


import java.util.ArrayList;

/**
 *
 * @author mobyr
 */
public class Standart extends Kullanici{
    
    private static ArrayList<Standart> standartlar = new ArrayList<Standart>();
    private ArrayList<Kitap> odunc_kitaplar = new ArrayList<Kitap>();
    public Standart()
    {
        
    } // {{}, {}, {}}
    public Standart(String ad, String soyad, String tc, String sifre, String mail, String telefon) {
        super(ad, soyad, tc, sifre, mail, telefon);
        standartlar.add(this);
        
    }

    public void oduncAl(int id)
    {
        Kitap k = new Kitap();
        odunc_kitaplar.add(Kitap.getKitaplar().get(id));
        k.kitap_cikar(Kitap.getKitaplar().get(id));
    }
    
    public void geriVer(int id)
    {
        Kitap k = new Kitap();
        odunc_kitaplar.remove(Kitap.getKitaplar().get(id));
        k.kitap_ekle(Kitap.getKitaplar().get(id)); // kitabın sayısını 1 arttır.
    }
    
    
    public static ArrayList<Standart> getStandartlar() {
        return standartlar;
    }


    public ArrayList<Kitap> getOdunc_kitaplar() {
        return odunc_kitaplar;
    }
    
    
    
    
    
}
