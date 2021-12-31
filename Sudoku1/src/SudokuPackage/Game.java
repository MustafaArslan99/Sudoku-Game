package SudokuPackage;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		Menu();
	}
	
	static Algorithm s=new Algorithm();
	
	//Diziyi Ekrana Yazdýrma Baþlangýç
	public static void EkranaYaz(int [][]dizi)
	{
		System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
		for (int i = 0; i < 9; i++) 
		{
			if (i==3 || i==6) 
				System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
			for (int j = 0; j < 9 ; j++) 
			{
				if (j==3 || j==6) 
					System.out.print("|");			
				System.out.print("      " + dizi[i][j] + "      ");
			}
			System.out.print("\n\n");
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
	}
	//Diziyi Ekrana Yazdýrma Bitiþ
	
	
	//Oyunun Ana Menüsü Baþlangýç
	public static void Menu()//Menu
	{
		System.out.println("\t\tSudokuya Hoþgeldiniz\n\n");
		System.out.println("1-Oyuna Baþla");
		System.out.println("2-Kurallarý Öðren");
		System.out.println("3-Çýkýþ\n\n");
		System.out.println("Menüde Seçim Yapabilmek için Numaralarý Giriniz..");
		Secim();
		
	}
	//Oyunun Ana Menüsü Bitiþ
	
	
	//Yapýlan Seçime Göre Yönlendirme Baþlangýç
	public static void Secim()
	{
		try //Kullanýcý hatalý giriþ yapabilir diye try-catch blocklarý kullanýldý
		{
			Scanner scanner =new Scanner(System.in);
			int secim=scanner.nextInt();
			switch (secim) 
			{
				case 1: //Eðer 1 giriþi yapýldýysa
				{
					ZorlukSecimi();//Zorluk Seç
					break;
				}
				case 2: //Eðer 2 giriþi yapýldýysa
				{
					Kurallar();//Kurallarý Göster
					break;
				}
				case 3: //Eðer 3 giriþi yapýldýysa
				{
					System.exit(0);//Çýkýþ
					break;
				}
				default: //Eðer istenilen giriþ yapýlmadýysa
				{
					System.out.println("Hatalý Seçim Yapýldý.");
					Menu();//Menüye Geri Dön
					break;
				}
			}
		}
		catch (Exception e) //Eðer hatalý giriþ yapýldýysa 
		{
			System.out.println("Lütfen Numara Giriniz.."); //Ekrana hatasýný belirt
			try
		    {
		        Thread.sleep(1000); // 1 saniye ekranda beklet
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			Menu(); // menüye geri yönlendir
		}
		
	}
	//Yapýlan Seçime Göre Yönlendirme Baþlangýç
	
	
	//Zorluk Seçimi Baþlangýç
	public static void ZorlukSecimi()
	{
		try //hatalý giriþ yapýlabilir o yüzden try-catch blocklarý kullanýlmalý
		{
			System.out.println("\n\nOynayacaðýnýz Zorluðu Seçiniz..\n" + "1-Kolay\n" + "2-Orta\n" + "3-Zor\n" + "4-Menüye Dön");
			
			Scanner scanner=new Scanner(System.in);
			int secim=scanner.nextInt();
			
			int ipucu=10;//Kullanýcý eðer takýlýrsa yada çözüm sýkýntýya girerse ipucu isteyebilir max ipucu sayýsý 10'dur.
			
			switch (secim) 
			{
				case 1: //Eðer zorluk seçiminden 1 gelirse kolay zorluk seçilmiþ demektir.
				{
					//Oyunu kolay modda oluþturup ekrana yazdýrýyoruz
					s.Zorluk="Kolay";
					s.Getir();
					EkranaYaz(s.dizi);
					
					OyunFonskiyonlari(ipucu); //Ýpucu miktarý ile birlikte oyunun fonksiyonlarýnýn bulunduðu methodu çaðýrýyoruz
					break;
				}
				case 2: //Eðer zorluk seçiminden 2 gelirse orta zorluk seçilmiþ demektir.
				{
					//Oyunu orta modda oluþturup ekrana yazdýrýyoruz
					s.Zorluk="Orta";
					s.Getir();
					EkranaYaz(s.dizi);
					
					OyunFonskiyonlari(ipucu); //Ýpucu miktarý ile birlikte oyunun fonksiyonlarýnýn bulunduðu methodu çaðýrýyoruz
					break;
				}
				case 3: //Eðer zorluk seçiminden 3 gelirse zor zorluk seçilmiþ demektir.
				{
					//Oyunu zor modda oluþturup ekrana yazdýrýyoruz
					s.Zorluk="Zor";
					s.Getir();
					EkranaYaz(s.dizi);
					
					OyunFonskiyonlari(ipucu); //Ýpucu miktarý ile birlikte oyunun fonksiyonlarýnýn bulunduðu methodu çaðýrýyoruz
					break;
				}
				case 4: //Eðer zorluk seçiminden 4 gelirse Menüye dönülmek istenmektedir.
				{
					Menu(); //Menü methodunu çaðýrýyoruz
					break;
				}
				default: //Eðer istenilenden farklý bir giriþ yapýlýrsa menüye döndürüyoruz
				{
					System.out.println("Yapýlan Seçim Hatalý Menüye Dönülüyor..");
					Menu();
				}
			}
		} catch (Exception e) //Eðer hata varsa numara girilmemiþ demektir.
		{
			System.out.println("Lütfen Numara Giriniz ..."); //hatasýný söylüyoruz
			try
		    {
		        Thread.sleep(1000); // 1 saniye ekraný bekletiyoruz ki kullanýcý görebilsin
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			ZorlukSecimi();//Zorluk seçimi methodunu tekrar çaðýrýyoruz
		}
		
	}
	//Zorluk Seçimi Bitiþ
	
	
	//Sudokunun Kurallarý Baþlangýç
	public static void Kurallar()
	{
		try //Hatalý giriþ yapýlabilir o yüzden try-catch blocklarý kullanýlmalý
		{
			Scanner scanner = new Scanner(System.in);
			
			// Kurallarý ekrana yazdýrýyoruz
			System.out.println("\n\n1- Her satýrda tüm rakamlar bulunmalý ve bu rakamlar sadece birer defa yer almalýdýr.\n"
					+ "2- Her sütunda tüm rakamlar bulunmalý ve bu rakamlar sadece birer defa yer almalýdýr.\n"
					+ "3- Her bölgede tüm rakamlar bulunmalý ve bu rakamlar sadece birer defa yer almalýdýr.\n"
					+ "4- Sayý giriþi yapýlýrken satýr ve sütun numarasýný girmelisiniz.\n"
					+ "5- Satýr ve sütun numaralarý 1 ile baþlar.");
			
			System.out.println("Geri Dönmek için Lütfen 1'e Basýnýz"); // Kullanýcý Menüye dönmek isteyebilir seçenek sunuyoruz
			int geridon=scanner.nextInt();
			
			if (geridon==1) // Kullanýcý menüye dönmek istiyorsa 
				Menu();//Menü methodunu çaðýrýyoruz
			else //Eðer 1'den farklý bir giriþ yaparsa oyundan çýkartýyoruz
			{
				System.out.println("Hatalý Giriþ Yaptýnýz Oyundan Çýkýlýyor.");
				System.exit(1);
			}
		} catch (Exception e) //Hata varsa numara giriþi yapýlmamýþ demektir
		{
			System.out.println("Lütfen Numara Giriniz..");//hatasýný ekrana basýyoruz
			try
		    {
		        Thread.sleep(1000);//görmesi için 1 saniye bekliyoruz
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			Kurallar();//Kurallar methodunu tekrar çaðýrýyoruz
		}
		
	}
	//Sudokunun Kurallarý Bitiþ
	
	
	//Oyundaki Fonksiyonlar Baþlangýç
	public static void OyunFonskiyonlari(int ipucusayisi)
	{		
		//burada ilk olarak oyun tamamlanmýþ mý kontrolu yapýlýyor
		//ikinci kontrol ise oyun tamamlanmýþ ama hatalý sayýlar giriþi yapýlmýþ ise çalýþýyor
		//eðer yukarýdaki þartlardan biri geçerli deðil ise hala oyun oynanmaktadýr demektir.
		
		
		if (KontrolEt()==1)//Eðer hatasýz oyun bittiyse
		{
			System.out.println("Tebrikler Sudokuyu Tamamladýnýz.." + "\n\nMenuye Dönüyorsunuz"); //ekrana tebrikler mesajý yazdýrýlýyor
			 try
			    {
			        Thread.sleep(2000); // kullanýcýnýn görmesi için 2 saniye bekletiliyor.
			    }
			    catch(InterruptedException ex)
			    {
			        Thread.currentThread().interrupt();
			    }
			 
			for (int i = 0; i < 50; i++) //ekran temizleniyor
				System.out.println("\n\n");
			
			Menu();//menüye geri dönülüyor.
		}
		else if(KontrolEt()==2)//Eðer hepsi dolmuþsa ve hata varsa
		{
			//kullanýcýya yapýlan hatanýn nerede olduðu gösteriliyor.
			System.out.println("Hatalý Giriþ Yapmýþsýnýz");
			System.out.println("Hatanýzýn Bullunduðu Alanlar;");			
			for (int i = 0; i < 9; i++) 
				for (int j = 0; j < 9; j++) 
					if (s.dizi[i][j]!=s.Dizi[i][j]) 
					{
						System.out.println("Satýr : " + (i+1) + " Sutun : " + (j+1) + " Deðeri : " + s.dizi[i][j]);
						try
					    {
					        Thread.sleep(2000);//Her hatanýn arasýnda 2 saniye bekleme yapýyoruz
					    }
					    catch(InterruptedException ex)
					    {
					        Thread.currentThread().interrupt();
					    }		
					}				
			
			
			//kullanýcý hatalý doldurmuþþa oyunu kaybettiniz mesajý veriyoruz ve menüye geri döndürüyoruz
			System.out.println("Oyunu Kaybettiniz. Menüye Dönüyorsunuz..");
			try
		    {
		        Thread.sleep(2000); // 2 saniye mesajý görme süresi veriyoruz.
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }			
			
			for (int i = 0; i < 50; i++) //ekraný temizliyoruz
				System.out.println("\n\n");
			
			Menu();//möenüye döndürüyoruz
		}
		else //Eðer yukarýda þartlarý saðlamýmyorsa oyun hala devam ediyor demektir.
		{		
			try //kullanýcý hatalý giriþ yapabilir try-catch komutlarý kullanýlmalý
			{
				//Kullanýcýnýn yapabileceði hamleleri ekrana yazdýrýyoruz ve seçim yapmasý istiyoruz
				System.out.println("Seçenekleriniz\n\n" + "1-Rakam Giriþi Yap\n" + "2-Ýpucu iste Hakkýnýz : " + ipucusayisi + "\n");
				Scanner scanner=new Scanner(System.in);
				int secim=scanner.nextInt();
				
				switch (secim) 
				{
					case 1: //Eðer seçim 1 ise kullanýcý sayý giriþi yapmak istiyor demektir.
					{
						RakamGiris(ipucusayisi); //Rakam giriþi yapabilmesi için gerekli iþlemlerin yapýldýðý methoda gönderiyoruz
						OyunFonskiyonlari(ipucusayisi);//Rakam giriþi yapýldýktan sonra tekrar seçenek sunmak için methodu tekrar çaðýrýyoruz			
						break;
					}
					case 2: //Eðer seçim 2 ise kullanýcý ipucu istiyor demektir.
					{
						//burada bir kontrol yapmamýz gerekli
						if (ipucusayisi<=0) //eðer ipucu sayýsý 1'den küçük ise bütün ipucu hakkýný bitirmiþ demektir.
						{
							//ipucu hakkýnýn olmadýðýný ekrana yazdýrýyoruz
							System.out.println("Ýpucu Hakkýnýz Kalmamýþtýr..");
							EkranaYaz(s.dizi);//Ekrana oyunu bastýrýp seçeneklerini tekrar gösteriyoruz
							OyunFonskiyonlari(ipucusayisi);
						}
						else //eðer ipucu hakký bitmemiþ ise
						{
							//ipucu vermek için gerekli iþlemlerim yapýldýðý methodu çaðýrýyoruz
							IpucuIste();
							ipucusayisi--;//ipucu sayýsýný azaltýyoruz
							OyunFonskiyonlari(ipucusayisi);//seçeneklerini tekrar gösteriyoruz
						}						
						break;
					}
					default: // Eðer istenilen sayý giriþi yapýlmadýysa hata mesajý veriyoruz
					{
						System.out.println("Yapýlan Seçim Hatalý Þeçeneklere Dönülüyor..");
						EkranaYaz(s.dizi); //Ekrana oyunu bastýrýp seçeneklerini tekrar gösteriyoruz
						OyunFonskiyonlari(ipucusayisi);
					}
				}		
			} catch (Exception e) //hata var ise kullanýcý sayý dýþýnda bir deðer giriþi yapmaya çalýþmýþ demektir.
			{
				//hatasýný ekrana yazdýrýyoruz
				System.out.println("Lütfen Numara Giriþi Yapýnýz..");
				try
			    {
			        Thread.sleep(1000);//1 saniye ekranda bekletiyoruz
			    }
			    catch(InterruptedException ex)
			    {
			        Thread.currentThread().interrupt();
			    }
				EkranaYaz(s.dizi); //ekrana oyunu bastýrýp seçeneklerini tekrar gösteriyoruz
				OyunFonskiyonlari(ipucusayisi);
			}
			
		}
	}
	//Oyundaki Fonksiyonlar Baþlangýç
	
	
	
	//Sudokuya rakam giriþi yapma baþlangýç
	public static void RakamGiris(int ipucusayisi)
	{
		try //kullanýcý hatalý bir giriþ yapabilir o yüzden try-catch blocklarý kullanýyoruz
		{
			//kullanýcýdan satýr,sütun ve sayý giriþi istiyoruz
			Scanner scanner=new Scanner(System.in);
			System.out.println("Rakamýn Deðiþtirileceði Satýrý Giriniz..");
			int i=scanner.nextInt();
			System.out.println("Rakamýn Deðiþtirileceði Sütunu Giriniz..");
			int j=scanner.nextInt();
			System.out.println("Rakamý Giriniz..");
			int deger=scanner.nextInt();
			
			//eðer girilen satýr ve sütün bilgisi oyun sýnýrlarý dýþýnda ise  
			if(j<=0||i<=0 || j>=10 || i>=10)
			{
				//ekrana hatasýný bastýrýyoruz
				System.out.println("Sýnýr dýþý giriþ yapýldý tekrar deneyiniz..");
				try
			    {
			        Thread.sleep(1000);//1 saniye bekletiyoruz
			    }
			    catch(InterruptedException ex)
			    {
			        Thread.currentThread().interrupt();
			    }
				EkranaYaz(s.dizi); //ekrana oyunu bastýrýp seçeneklerini tekrar gösteriyoruz
				OyunFonskiyonlari(ipucusayisi);
			}
			//eðer hatasýz giriþ yapýldýysa girilen sayýyý girilen koordinatlara ekliyoruz
			s.dizi[i-1][j-1]=deger;
			EkranaYaz(s.dizi); //Oyunu ekrana yazdýrýyoruz
		} catch (Exception e) //hata varsa kullanýcý sayý dýþýnda bir deðer girmiþ demektir.
		{			
			//hatasýný ekrana yazýyoruz
			System.out.println("Lütfen Numara Giriniz..");
			try
		    {
		        Thread.sleep(1000);//görebilmesi için 1 saniye bekletiyoruz
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			EkranaYaz(s.dizi);//ekrana oyunu bastýrýp seçeneklerini tekrar gösteriyoruz
			OyunFonskiyonlari(ipucusayisi);
		}
		
	}
	//Sudokuya rakam giriþi yapma bitiþ
	
	
	//Ýpucu Ýsteme Baþlangýç
	public static void IpucuIste()
	{
		//burada rastgele þekilde dizinin satýr ve sütun bilgisini çekiyoruz
		//rastgele gelen satýr ve sütün verileri içindeki sayý 0 ise yani kullanýcý o satýra ve sütuna giriþ yapmamýþsa içindeki veriyi oyun dizisine yazdýrýyoruz  
		int sonuc=0;
		do //burada döngü en az 1 kere dönücek eðer ilk döndüðünde koþulu saðlar ise döngüden çýkýlacak 
		{			 
			int i=s.RandomSayiUret(9,0),j=s.RandomSayiUret(9,0); // 0 ile 9 arasýndan satýr ve sütun numarasý çekiyoruz 
			if (s.dizi[i][j]==0) //eðer gellen satýr ve sütunün içindeki sayý 0 ise
			{
				s.dizi[i][j]=s.Dizi[i][j];//kullanýcýnýn oynadýðý diziye aktarýyoruz
				sonuc=1; // eðer istenilen koþul doðru ise sonuc 1'e eþitlenecek
			}
		} while (sonuc==0); //sonuç 0 olduðu sürece dönecek
		EkranaYaz(s.dizi);	//ekrana oyunu bastýrýp seçeneklerini tekrar gösteriyoruz
		KontrolEt();
	}
	//Ýpucu Ýsteme Bitiþ
	
	//Oyun Tamamlandýmý Kontrol Baþlangýç
	public static int KontrolEt() 
	{
		int sonuc=1;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) 
				if (s.dizi[i][j]!=s.Dizi[i][j]) //Eðer dizinin içeriði doðru dizinin içeriðinden farklý ise hata var demektir.
					sonuc=0;
		
		if(BosKontrol()==0 && sonuc==0) sonuc=2; //eðer dizide boþ býrakýlan satýr ve sütun yoksa ve içeriði doðruysa sonucu 2 yapýyoruz
		return sonuc; // sonucu döndürüyoruz
	}
	//Oyun Tamamlandýmý Kontrol Baþlangýç
	
	
	//Oyunda Boþ Satýr Ve Sütun Kalmýþ mý Kontrolu Baþlangýç
	public static int BosKontrol()
	{
		int sifirsayisi=0; //baþlangýçta sayacý 0'lýyoruz
		for (int i = 0; i < 9; i++) 
			for (int j = 0; j < 9; j++) 
				if (s.dizi[i][j]==0) //eðer dizide 0'a eþit sayý var ise hala doldurulmasý gereken satýr ve sütunlar var demektir.				
					sifirsayisi=1;//sayacý 1 arttýrýyoruz
		
		return sifirsayisi;//geriye sayacý döndürüyoruz
	}
	//Oyunda Boþ Satýr Ve Sütun Kalmýþ mý Kontrolu Bitiþ
}
