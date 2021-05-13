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
public class Kitap {
    String kitap_adi, kitap_yazari, yayinevi, bolum, raf, isbn;
    int basim_yili, sayfa_sayisi, kitap_adet;
    double fiyat;
    private static ArrayList<Kitap> kitaplar = new ArrayList();
    
    public Kitap()
    {
    
    }
    
    
    public Kitap(String kitap_adi, String kitap_yazari, int basim_yili, String yayinevi, String bolum, String raf, int sayfa_sayisi, double fiyat, int kitap_adet, String isbn) {
        this.kitap_adi = kitap_adi;
        this.kitap_yazari = kitap_yazari;
        this.basim_yili = basim_yili;
        this.yayinevi = yayinevi;
        this.bolum = bolum;
        this.raf = raf;
        this.sayfa_sayisi = sayfa_sayisi;
        this.fiyat = fiyat;
        this.kitap_adet = kitap_adet;
        this.isbn = isbn;
        kitaplar.add(this);
    }
    
    public boolean kitapAra(String kitap_adi) // Kitap adina gore arama.
    {
        int counter = 0;
        for (int i = 0; i < kitaplar.size(); i++) {
            if(kitaplar.get(i).kitap_adi.toLowerCase().equals(kitap_adi.toLowerCase()))
            {
                kitap_bilgi_goster(kitaplar.get(i));
                System.out.println("******************************");
                counter++;
            }
            
        }
        if(counter == 0)
        {
            System.out.println("Aradığınız kitap bulunamadı.");
            return false;
        }
        return true;
    }
    
    public boolean kitapAra(int basim_yili) // Basim yilina gore arama.
    {
        int counter = 0;
        for (int i = 0; i < kitaplar.size(); i++) {
            if(kitaplar.get(i).basim_yili == basim_yili)
            {
                kitap_bilgi_goster(kitaplar.get(i));
                System.out.println("******************************");
                counter++;
            }
            
        }
        if(counter == 0)
        {
            System.out.println("Girdiğiniz yılda basılmış kitap bulunamadı.");
            return false;
        }
        return true;
    }
    
    public boolean yazar_kitap_ara(String yazar_adi) // Yazar adina gore arama.
    {
        int counter = 0;
        for (int i = 0; i < kitaplar.size(); i++) {
            if(kitaplar.get(i).kitap_yazari.toLowerCase().equals(yazar_adi.toLowerCase()))
            {
                kitap_bilgi_goster(kitaplar.get(i));
                System.out.println("******************************");
                counter++;
            }
            
        }
        if(counter == 0)
        {
            System.out.println("Aradığınız yazar bulunamadı.");
            return false;
        }
        return true;
    }
    
    public boolean isbn_kitap_ara(String isbn)
    {
        int counter = 0;
        for (int i = 0; i < kitaplar.size(); i++) {
            if(kitaplar.get(i).isbn.equals(isbn))
            {
                kitap_bilgi_goster(kitaplar.get(i));
                System.out.println("******************************");
                counter++;
            }
        }
        if(counter == 0)
        {
            System.out.println("Girdiğiniz ISBN'e sahip bir kitap bulunamadı.");
            return false;
        }
        return true;
    }
    
    public boolean yayinevi_kitap_ara(String yayinevi)
    {
        int counter = 0;
        for (int i = 0; i < kitaplar.size(); i++) {
            if(kitaplar.get(i).yayinevi.toLowerCase().equals(yayinevi.toLowerCase()))
            {
                kitap_bilgi_goster(kitaplar.get(i));
                System.out.println("******************************");
                counter++;
            }
        }
        if(counter == 0)
        {
            System.out.println("Aradığınız yayınevi bulunamadı.");
            return false;
        }
        return true;
    }
    
    public void tum_kitaplari_goster()
    {
        for (int i = 0; i < kitaplar.size(); i++) {
            kitap_bilgi_goster(kitaplar.get(i));
        }
    }
    
    public void kitap_bilgi_goster(Kitap k)
    {
        int id = getKitapID(k);
        if(id != -1){
            System.out.println("ID: " + id);
            System.out.println("Kitap Adı: " + kitaplar.get(id).kitap_adi);
            System.out.println("Kitap Yazarı: " + kitaplar.get(id).kitap_yazari);
            System.out.println("Basım Yılı: " + kitaplar.get(id).basim_yili);
            System.out.println("Yayınevi: " + kitaplar.get(id).yayinevi);
            System.out.println("Bulunduğu Bölüm: " + kitaplar.get(id).bolum);
            System.out.println("Bulunduğu Raf: " + kitaplar.get(id).raf);
            System.out.println("Sayfa Sayısı: " + kitaplar.get(id).sayfa_sayisi);
            System.out.println("Kitap Adet: " + kitaplar.get(id).kitap_adet);
            System.out.println("ISBN: " + kitaplar.get(id).isbn);
        }
        
        else
        {
            System.out.println("Aradığınız kitap bulunamadı.");
        }
    }
    
    public void kitap_ekle(Kitap k)
    {
        k.kitap_adet++;
    }
    
    public int getKitapID(Kitap k)
    {
        for (int i = 0; i < kitaplar.size(); i++) {
            if(kitaplar.get(i).equals(k))
            {
                return i;
            }
        }
        return -1;
    }
    
    public void kitap_cikar(Kitap k)
    {
        k.kitap_adet--;
        if(k.kitap_adet == 1)
        {
            kitap_sil(k);
        }
    }
    
    public void kitap_sil(Kitap k)
    {
        k.kitap_adet = 0;
        int id = getKitapID(k);
        kitaplar.remove(id);
    }

    
    public static ArrayList<Kitap> getKitaplar() {
        return kitaplar;
    }

    
    public static void setKitaplar(ArrayList<Kitap> aKitaplar) {
        kitaplar = aKitaplar;
    }
    
    
    
}
