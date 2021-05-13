/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane;


/**
 *
 * @author mobyr
 */
public class Kullanici {
    private String ad, soyad, tc, sifre, mail, telefon;

    public Kullanici()
    {
        
    }
    
    public Kullanici(String ad, String soyad, String tc, String sifre, String mail, String telefon) {
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.sifre = sifre;
        this.mail = mail;
        this.telefon = telefon;
    }
    
    public void bilgileriGoster()
    {
        System.out.println("Adı: " + ad);
        System.out.println("Soyadı: " + soyad);
        System.out.println("TC Kimlik: " + tc);
        System.out.println("E-Mail: " + mail);
        System.out.println("Telefon: " + telefon);
    }
    
    

    
    public String getAd() {
        return ad;
    }

    
    public String getSoyad() {
        return soyad;
    }

    
    public String getTc() {
        return tc;
    }
    
    public String getSifre(){
        return sifre;
    }
    
    public void setSifre(String sifre){
        this.sifre = sifre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
    public String getTelefon() {
        return telefon;
    }

    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
}
