/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane;
import java.util.Scanner;

/**
 *
 * @author mobyr
 */
public class Main {
    public static void main(String[] args) {
        
        Standart s1 = new Standart("Muhammet Onur", "Bayraktar", "12121212121", "1234", "mobyrktr@gmail.com", "+901211211212");
        Standart s2 = new Standart("Bahadır", "Şahin", "12345678910", "1234", "example@mail.com", "+905555555555");
        Personel p1 = new Personel("Kazım", "Yıldız", "99999999999", "9999", "kazim.yildiz@marmara.edu.tr", "+909999999999", 9999, 4);
        Personel p2 = new Personel("Abdulsamet", "Aktaş", "99999999998", "9998", "abdulsamet.aktas@marmara.edu.tr", "+909999999998", 9999, 1);
        Kitap k1 = new Kitap("Seker Portakali", "Jose Mauro de Vasconcelos", 2000, "Can Cocuk", "Ş", "4", 200, 18.90, 3, "9788972785002");
        Kitap k2 = new Kitap("Romeo ve Juliet", "William Shakespeare", 2010, "Is Bankasi Kultur Yayinlari", "R", "6", 133, 7.80, 0, "9781306982351");
        Kitap k3 = new Kitap("Beyaz Dis", "Jack London", 2011, "Iletisim Yayincilik", "B", "12", 236, 15.75, 4, "9789750721922");
        Kitap k4 = new Kitap("Kucuk Prens", "Antoine de Saint-Exupery", 2018, "Turkuvaz Kitap", "K", "9", 112, 6.30, 1, "9786054993888");
        Kitap k5 = new Kitap("Hamlet", "William Shakespeare", 2008, "Is Bankasi Kultur Yayinlari", "H", "8", 188, 7.80, 6, "9780743477123");
        Scanner input = new Scanner(System.in);
        Standart s = new Standart();
        Personel p = new Personel();
        Kitap k = new Kitap();
        while(true)
        {
            System.out.println("1) Kullanıcı Girişi");
            System.out.println("2) Yönetici Girişi");
            System.out.println("3) Çıkış\n");
            System.out.print("Seçiminiz: ");
            String secim = input.nextLine();
            System.out.println("");
            if(secim.equals("1"))
            {
                System.out.print("TC Kimlik Numarası: ");
                String tc = input.nextLine();
                System.out.print("Şifre: ");
                String sifre = input.nextLine();
                boolean girdiMi = false;
                for (int i = 0; i < Standart.getStandartlar().size(); i++) {
                    if(Standart.getStandartlar().get(i).getTc().equals(tc) && Standart.getStandartlar().get(i).getSifre().equals(sifre))
                    {
                        girdiMi = true;
                        System.out.println("\nHoşgeldin " + Standart.getStandartlar().get(i).getAd() + "\n");
                        s = Standart.getStandartlar().get(i);
                        while(true)
                        {
                            System.out.println("******************************");
                            System.out.println("1) Kitap Ödünç Al");
                            System.out.println("2) Kitap Geri Ver");
                            System.out.println("3) Ödünç Alınmış Kitapları Göster");
                            System.out.println("4) Hesap Ayarları");
                            System.out.println("5) Çıkış");
                            System.out.println("******************************\n");
                            System.out.print("Seçiminiz: ");
                            secim = input.nextLine();
                            System.out.println("");
                            if(secim.equals("1"))
                            {
                                while(true){
                                System.out.println("Kitap Arama Menüsü\n");
                                System.out.println("1) Kitap Adı ile Arama");
                                System.out.println("2) Yazar Adı ile Arama");
                                System.out.println("3) Yayınevi ile Arama");
                                System.out.println("4) ISBN ile Arama");
                                System.out.println("5) Basım Yılı ile Arama");
                                System.out.println("6) Önceki Menü\n");
                                System.out.print("Seçiminiz: ");
                                secim = input.nextLine();
                                System.out.println("");
                                if(secim.equals("1"))
                                {
                                    System.out.print("Kitabın adını giriniz: ");
                                    String ad = input.nextLine();
                                    System.out.println("");
                                    System.out.println("******************************");
                                    if(!k.kitapAra(ad))
                                    {
                                        continue;
                                    }
                                    System.out.println("");
                                    System.out.print("Ödünç almak istediğiniz kitabın ID'sini giriniz: ");
                                    int id = input.nextInt();
                                    input.nextLine();
                                    System.out.println("******************************\n");
                                    if(Kitap.getKitaplar().get(id).kitap_adet != 0)
                                    {
                                        s.oduncAl(id);
                                        System.out.println("Kitabınızı " + Kitap.getKitaplar().get(id).bolum + " bölümündeki " + Kitap.getKitaplar().get(id).raf + " numaralı raftan alabilirsiniz.");
                                    }
                                    else
                                    {
                                        System.out.println("Kitapların hepsi kullanımdadır.");
                                    }
                                    
                                }
                                
                                else if(secim.equals("2"))
                                {
                                    System.out.print("Yazarın adını giriniz: ");
                                    String ad = input.nextLine();
                                    System.out.println("");
                                    System.out.println("******************************");
                                    if(!k.yazar_kitap_ara(ad))
                                    {
                                        continue;
                                    }
                                    System.out.println("");
                                    System.out.print("Ödünç almak istediğiniz kitabın ID'sini giriniz: ");
                                    int id = input.nextInt();
                                    input.nextLine();
                                    if(Kitap.getKitaplar().get(id).kitap_adet != 0)
                                    {
                                        s.oduncAl(id);
                                        System.out.println("Kitabınızı " + Kitap.getKitaplar().get(id).bolum + " bölümündeki " + Kitap.getKitaplar().get(id).raf + " numaralı raftan alabilirsiniz.");
                                    }
                                    else
                                    {
                                        System.out.println("Kitapların hepsi kullanımdadır.");
                                    }
                                }
                                
                                else if(secim.equals("3"))
                                {
                                    System.out.print("Yayınevini giriniz: ");
                                    String ad = input.nextLine();
                                    System.out.println("");
                                    System.out.println("******************************");
                                    if(!k.yayinevi_kitap_ara(ad))
                                    {
                                        continue;
                                    }
                                    System.out.println("");
                                    System.out.print("Ödünç almak istediğiniz kitabın ID'sini giriniz: ");
                                    int id = input.nextInt();
                                    input.nextLine();
                                    if(Kitap.getKitaplar().get(id).kitap_adet != 0)
                                    {
                                        s.oduncAl(id);
                                        System.out.println("Kitabınızı " + Kitap.getKitaplar().get(id).bolum + " bölümündeki " + Kitap.getKitaplar().get(id).raf + " numaralı raftan alabilirsiniz.");
                                    }
                                    else
                                    {
                                        System.out.println("Kitapların hepsi kullanımdadır.");
                                    }
                                }
                                
                                else if(secim.equals("4"))
                                {
                                    System.out.print("ISBN giriniz: ");
                                    String isbn = input.nextLine();
                                    System.out.println("");
                                    System.out.println("******************************");
                                    if(!k.isbn_kitap_ara(isbn))
                                    {
                                        continue;
                                    }
                                    System.out.println("");
                                    System.out.print("Ödünç almak istediğiniz kitabın ID'sini giriniz: ");
                                    int id = input.nextInt();
                                    input.nextLine();
                                    if(Kitap.getKitaplar().get(id).kitap_adet != 0)
                                    {
                                        s.oduncAl(id);
                                        System.out.println("Kitabınızı " + Kitap.getKitaplar().get(id).bolum + " bölümündeki " + Kitap.getKitaplar().get(id).raf + " numaralı raftan alabilirsiniz.");
                                    }
                                    else
                                    {
                                        System.out.println("Kitapların hepsi kullanımdadır.");
                                    }
                                }
                                
                                else if(secim.equals("5"))
                                {
                                    System.out.print("Basım yılı giriniz: ");
                                    int yil = input.nextInt();
                                    input.nextLine();
                                    System.out.println("");
                                    System.out.println("******************************");
                                    if(!k.kitapAra(yil))
                                    {
                                        continue;
                                    }
                                    System.out.println("");
                                    System.out.print("Ödünç almak istediğiniz kitabın ID'sini giriniz: ");
                                    int id = input.nextInt();
                                    input.nextLine();
                                    if(Kitap.getKitaplar().get(id).kitap_adet != 0)
                                    {
                                        s.oduncAl(id);
                                        System.out.println("Kitabınızı " + Kitap.getKitaplar().get(id).bolum + " bölümündeki " + Kitap.getKitaplar().get(id).raf + " numaralı raftan alabilirsiniz.");
                                    }
                                    else
                                    {
                                        System.out.println("Kitapların hepsi kullanımdadır.");
                                    }
                                }
                                
                                else if(secim.equals("6"))
                                {
                                    break;
                                }
                            }
                            
                        }
                            else if(secim.equals("2"))
                            {
                                System.out.println("Ödünç aldığınız kitaplar: ");
                                System.out.println("\n");
                                for (Kitap odunc_kitap : s.getOdunc_kitaplar()) {
                                    odunc_kitap.kitap_bilgi_goster(odunc_kitap);
                                    System.out.println("******************************");
                                }
                                System.out.print("İade etmek istediğiniz kitabın ID'sini giriniz: ");
                                int id = input.nextInt();
                                input.nextLine();
                                s.geriVer(id);
                                System.out.println("******************************");
                                System.out.println("Kalan kitaplar: ");
                                for (Kitap odunc_kitap : s.getOdunc_kitaplar()) {
                                    odunc_kitap.kitap_bilgi_goster(odunc_kitap);
                                }
                            }
                            
                            else if(secim.equals("3"))
                            {
                                System.out.println("Ödünç aldığınız kitaplar: ");
                                for (Kitap odunc_kitap : s.getOdunc_kitaplar()) {
                                    System.out.println("******************************");
                                    odunc_kitap.kitap_bilgi_goster(odunc_kitap);
                                    System.out.println("******************************");
                                    System.out.println("");
                                }
                            }
                            
                            else if(secim.equals("4"))
                            {
                                System.out.println("1) Şifreyi Değiştir");
                                System.out.println("2) Telefon Numarasını Güncelle");
                                System.out.println("3) E-Mail Güncelle");
                                System.out.println("4) Hesap Bilgilerini Gör\n");
                                System.out.print("Seçiminiz: ");
                                secim = input.nextLine();
                                if(secim.equals("1"))
                                {
                                    System.out.print("Yeni şifre: ");
                                    String yeni = input.nextLine();
                                    s.setSifre(yeni);
                                }
                                
                                else if(secim.equals("2"))
                                {
                                    System.out.print("Yeni telefon numarası: ");
                                    String yeni = input.nextLine();
                                    s.setTelefon(yeni);
                                }
                                
                                else if(secim.equals("3"))
                                {
                                    System.out.print("Yeni mail adresi: ");
                                    String yeni = input.nextLine();
                                    s.setMail(yeni);
                                }
                                
                                else if(secim.equals("4"))
                                {
                                    System.out.println("\n******************************");
                                    s.bilgileriGoster();
                                    System.out.println("******************************\n");
                                }
                                
                                
                            }
                            else if(secim.equals("5"))
                            {
                                break;
                            }
                        }
                    }
                    
                }
                if(!girdiMi)
                {
                    System.out.println("\nHatalı Giriş.");
                    System.out.println("\n");
                }
            }
            
            else if(secim.equals("2"))
            {
                System.out.print("TC Kimlik Numarası: ");
                String tc = input.nextLine();
                System.out.print("Şifre: ");
                String sifre = input.nextLine();
                boolean girdiMi = false;
                for (Personel personel: Personel.getPersoneller()) {
                    if(personel.getTc().equals(tc) && personel.getSifre().equals(sifre))
                    {
                        girdiMi = true;
                        System.out.println("\nHoşgeldin " + personel.getAd() + "\n");
                        p = personel;
                        while(true){
                        System.out.println("******************************\n");
                        System.out.println("1) Kendi Bilgilerini Gör");
                        System.out.println("2) Kullanıcı Bilgilerini Gör");
                        System.out.println("3) Tüm Kullanıcıları Gör");
                        System.out.println("4) Kullanıcı Sil");
                        System.out.println("5) Hesap Ayarları");
                        System.out.println("6) Çıkış\n");
                        System.out.print("Seçiminiz: ");
                        secim = input.nextLine();
                        if(secim.equals("1"))
                        {
                            p.bilgileriGoster();
                        }
                        
                        else if(secim.equals("2"))
                        {
                            System.out.print("Kullanıcının TC kimlik numarasını giriniz: ");
                            String k_tc = input.nextLine();
                            p.bilgileriGoster(k_tc);
                        }
                        
                        else if(secim.equals("3"))
                        {
                            p.kullanicilari_goster();
                        }
                        
                        else if(secim.equals("4"))
                        {
                            System.out.print("Silmek istediğiniz kullanıcının TC kimlik numarasını giriniz: ");
                            String k_tc = input.nextLine();
                            p.kullanici_sil(k_tc);
                        }
                        
                        else if(secim.equals("5"))
                        {
                            System.out.println("1) Şifreyi Değiştir");
                                System.out.println("2) Telefon Numarasını Güncelle");
                                System.out.println("3) E-Mail Güncelle\n");
                                System.out.print("Seçiminiz: ");
                                secim = input.nextLine();
                                if(secim.equals("1"))
                                {
                                    System.out.print("Yeni şifre: ");
                                    String yeni = input.nextLine();
                                    p.setSifre(yeni);
                                }
                                
                                else if(secim.equals("2"))
                                {
                                    System.out.print("Yeni telefon numarası: ");
                                    String yeni = input.nextLine();
                                    p.setTelefon(yeni);
                                }
                                
                                else if(secim.equals("3"))
                                {
                                    System.out.print("Yeni mail adresi: ");
                                    String yeni = input.nextLine();
                                    p.setMail(yeni);
                                }
                        }
                        
                        else if(secim.equals("6"))
                        {
                            break;
                        }
                    }
                    }
                }
                if(!girdiMi)
                {
                    System.out.println("\nHatalı Giriş.");
                    System.out.println("\n");
                }
            }
            
            else if(secim.equals("3"))
            {
                System.out.println("Programdan Çıkılıyor...");
                System.out.println("İyi Günler.");
                break;
            }
        }
    }
}
