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
public class Personel extends Kullanici{
    private int maas;
    private int calismaSure;
    private static ArrayList<Personel> personeller = new ArrayList<Personel>();
    
    public Personel()
    {
        
    }
    
    public Personel(String ad, String soyad, String tc, String sifre, String mail, String telefon, int maas, int calismaSure) {
        super(ad, soyad, tc, sifre, mail, telefon);
        this.maas = maas;
        this.calismaSure = calismaSure;
        personeller.add(this);
    }
    
    @Override
    public void bilgileriGoster()
    {
        super.bilgileriGoster();
        System.out.println("Maaş: " + maas + " Türk Lirası");
        System.out.println("Çalışma Süresi: " + calismaSure + " yıl");
    }
    
    public void bilgileriGoster(String tc)
    {
        boolean varMi = false;
        for (Standart kullanici: Standart.getStandartlar()) {
                if(kullanici.getTc().equals(tc))
                {
                    varMi = true;
                    System.out.println("******************************");
                    System.out.println("Adı: " + kullanici.getAd());
                    System.out.println("Soyadı: " + kullanici.getSoyad());
                    System.out.println("TC Kimlik: " + kullanici.getTc());
                    System.out.println("E-Mail: " + kullanici.getMail());
                    System.out.println("Telefon: " + kullanici.getTelefon());
                    break;
                }
        }
        if(!varMi)
        {
            System.out.println("Kullanıcı Bulunamadı.");
        }
    }
    
    public void kullanicilari_goster()
    {
        for (Standart kullanici: Standart.getStandartlar()) {
            System.out.println("******************************");
            kullanici.bilgileriGoster();
            System.out.println("******************************");
        }
    }
    
    public void kullanici_sil(String tc)
    {
        for (int i = 0; i < Standart.getStandartlar().size(); i++) {
            if(Standart.getStandartlar().get(i).getTc().equals(tc))
            {
                Standart.getStandartlar().remove(i);
            }
        }
    }


    public static ArrayList<Personel> getPersoneller() {
        return personeller;
    }
    
    
    
}
