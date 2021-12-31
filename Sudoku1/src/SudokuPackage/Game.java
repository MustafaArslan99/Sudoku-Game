package SudokuPackage;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		Menu();
	}
	
	static Algorithm s=new Algorithm();
	
	//Diziyi Ekrana Yazd�rma Ba�lang��
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
	//Diziyi Ekrana Yazd�rma Biti�
	
	
	//Oyunun Ana Men�s� Ba�lang��
	public static void Menu()//Menu
	{
		System.out.println("\t\tSudokuya Ho�geldiniz\n\n");
		System.out.println("1-Oyuna Ba�la");
		System.out.println("2-Kurallar� ��ren");
		System.out.println("3-��k��\n\n");
		System.out.println("Men�de Se�im Yapabilmek i�in Numaralar� Giriniz..");
		Secim();
		
	}
	//Oyunun Ana Men�s� Biti�
	
	
	//Yap�lan Se�ime G�re Y�nlendirme Ba�lang��
	public static void Secim()
	{
		try //Kullan�c� hatal� giri� yapabilir diye try-catch blocklar� kullan�ld�
		{
			Scanner scanner =new Scanner(System.in);
			int secim=scanner.nextInt();
			switch (secim) 
			{
				case 1: //E�er 1 giri�i yap�ld�ysa
				{
					ZorlukSecimi();//Zorluk Se�
					break;
				}
				case 2: //E�er 2 giri�i yap�ld�ysa
				{
					Kurallar();//Kurallar� G�ster
					break;
				}
				case 3: //E�er 3 giri�i yap�ld�ysa
				{
					System.exit(0);//��k��
					break;
				}
				default: //E�er istenilen giri� yap�lmad�ysa
				{
					System.out.println("Hatal� Se�im Yap�ld�.");
					Menu();//Men�ye Geri D�n
					break;
				}
			}
		}
		catch (Exception e) //E�er hatal� giri� yap�ld�ysa 
		{
			System.out.println("L�tfen Numara Giriniz.."); //Ekrana hatas�n� belirt
			try
		    {
		        Thread.sleep(1000); // 1 saniye ekranda beklet
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			Menu(); // men�ye geri y�nlendir
		}
		
	}
	//Yap�lan Se�ime G�re Y�nlendirme Ba�lang��
	
	
	//Zorluk Se�imi Ba�lang��
	public static void ZorlukSecimi()
	{
		try //hatal� giri� yap�labilir o y�zden try-catch blocklar� kullan�lmal�
		{
			System.out.println("\n\nOynayaca��n�z Zorlu�u Se�iniz..\n" + "1-Kolay\n" + "2-Orta\n" + "3-Zor\n" + "4-Men�ye D�n");
			
			Scanner scanner=new Scanner(System.in);
			int secim=scanner.nextInt();
			
			int ipucu=10;//Kullan�c� e�er tak�l�rsa yada ��z�m s�k�nt�ya girerse ipucu isteyebilir max ipucu say�s� 10'dur.
			
			switch (secim) 
			{
				case 1: //E�er zorluk se�iminden 1 gelirse kolay zorluk se�ilmi� demektir.
				{
					//Oyunu kolay modda olu�turup ekrana yazd�r�yoruz
					s.Zorluk="Kolay";
					s.Getir();
					EkranaYaz(s.dizi);
					
					OyunFonskiyonlari(ipucu); //�pucu miktar� ile birlikte oyunun fonksiyonlar�n�n bulundu�u methodu �a��r�yoruz
					break;
				}
				case 2: //E�er zorluk se�iminden 2 gelirse orta zorluk se�ilmi� demektir.
				{
					//Oyunu orta modda olu�turup ekrana yazd�r�yoruz
					s.Zorluk="Orta";
					s.Getir();
					EkranaYaz(s.dizi);
					
					OyunFonskiyonlari(ipucu); //�pucu miktar� ile birlikte oyunun fonksiyonlar�n�n bulundu�u methodu �a��r�yoruz
					break;
				}
				case 3: //E�er zorluk se�iminden 3 gelirse zor zorluk se�ilmi� demektir.
				{
					//Oyunu zor modda olu�turup ekrana yazd�r�yoruz
					s.Zorluk="Zor";
					s.Getir();
					EkranaYaz(s.dizi);
					
					OyunFonskiyonlari(ipucu); //�pucu miktar� ile birlikte oyunun fonksiyonlar�n�n bulundu�u methodu �a��r�yoruz
					break;
				}
				case 4: //E�er zorluk se�iminden 4 gelirse Men�ye d�n�lmek istenmektedir.
				{
					Menu(); //Men� methodunu �a��r�yoruz
					break;
				}
				default: //E�er istenilenden farkl� bir giri� yap�l�rsa men�ye d�nd�r�yoruz
				{
					System.out.println("Yap�lan Se�im Hatal� Men�ye D�n�l�yor..");
					Menu();
				}
			}
		} catch (Exception e) //E�er hata varsa numara girilmemi� demektir.
		{
			System.out.println("L�tfen Numara Giriniz ..."); //hatas�n� s�yl�yoruz
			try
		    {
		        Thread.sleep(1000); // 1 saniye ekran� bekletiyoruz ki kullan�c� g�rebilsin
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			ZorlukSecimi();//Zorluk se�imi methodunu tekrar �a��r�yoruz
		}
		
	}
	//Zorluk Se�imi Biti�
	
	
	//Sudokunun Kurallar� Ba�lang��
	public static void Kurallar()
	{
		try //Hatal� giri� yap�labilir o y�zden try-catch blocklar� kullan�lmal�
		{
			Scanner scanner = new Scanner(System.in);
			
			// Kurallar� ekrana yazd�r�yoruz
			System.out.println("\n\n1- Her sat�rda t�m rakamlar bulunmal� ve bu rakamlar sadece birer defa yer almal�d�r.\n"
					+ "2- Her s�tunda t�m rakamlar bulunmal� ve bu rakamlar sadece birer defa yer almal�d�r.\n"
					+ "3- Her b�lgede t�m rakamlar bulunmal� ve bu rakamlar sadece birer defa yer almal�d�r.\n"
					+ "4- Say� giri�i yap�l�rken sat�r ve s�tun numaras�n� girmelisiniz.\n"
					+ "5- Sat�r ve s�tun numaralar� 1 ile ba�lar.");
			
			System.out.println("Geri D�nmek i�in L�tfen 1'e Bas�n�z"); // Kullan�c� Men�ye d�nmek isteyebilir se�enek sunuyoruz
			int geridon=scanner.nextInt();
			
			if (geridon==1) // Kullan�c� men�ye d�nmek istiyorsa 
				Menu();//Men� methodunu �a��r�yoruz
			else //E�er 1'den farkl� bir giri� yaparsa oyundan ��kart�yoruz
			{
				System.out.println("Hatal� Giri� Yapt�n�z Oyundan ��k�l�yor.");
				System.exit(1);
			}
		} catch (Exception e) //Hata varsa numara giri�i yap�lmam�� demektir
		{
			System.out.println("L�tfen Numara Giriniz..");//hatas�n� ekrana bas�yoruz
			try
		    {
		        Thread.sleep(1000);//g�rmesi i�in 1 saniye bekliyoruz
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			Kurallar();//Kurallar methodunu tekrar �a��r�yoruz
		}
		
	}
	//Sudokunun Kurallar� Biti�
	
	
	//Oyundaki Fonksiyonlar Ba�lang��
	public static void OyunFonskiyonlari(int ipucusayisi)
	{		
		//burada ilk olarak oyun tamamlanm�� m� kontrolu yap�l�yor
		//ikinci kontrol ise oyun tamamlanm�� ama hatal� say�lar giri�i yap�lm�� ise �al���yor
		//e�er yukar�daki �artlardan biri ge�erli de�il ise hala oyun oynanmaktad�r demektir.
		
		
		if (KontrolEt()==1)//E�er hatas�z oyun bittiyse
		{
			System.out.println("Tebrikler Sudokuyu Tamamlad�n�z.." + "\n\nMenuye D�n�yorsunuz"); //ekrana tebrikler mesaj� yazd�r�l�yor
			 try
			    {
			        Thread.sleep(2000); // kullan�c�n�n g�rmesi i�in 2 saniye bekletiliyor.
			    }
			    catch(InterruptedException ex)
			    {
			        Thread.currentThread().interrupt();
			    }
			 
			for (int i = 0; i < 50; i++) //ekran temizleniyor
				System.out.println("\n\n");
			
			Menu();//men�ye geri d�n�l�yor.
		}
		else if(KontrolEt()==2)//E�er hepsi dolmu�sa ve hata varsa
		{
			//kullan�c�ya yap�lan hatan�n nerede oldu�u g�steriliyor.
			System.out.println("Hatal� Giri� Yapm��s�n�z");
			System.out.println("Hatan�z�n Bullundu�u Alanlar;");			
			for (int i = 0; i < 9; i++) 
				for (int j = 0; j < 9; j++) 
					if (s.dizi[i][j]!=s.Dizi[i][j]) 
					{
						System.out.println("Sat�r : " + (i+1) + " Sutun : " + (j+1) + " De�eri : " + s.dizi[i][j]);
						try
					    {
					        Thread.sleep(2000);//Her hatan�n aras�nda 2 saniye bekleme yap�yoruz
					    }
					    catch(InterruptedException ex)
					    {
					        Thread.currentThread().interrupt();
					    }		
					}				
			
			
			//kullan�c� hatal� doldurmu��a oyunu kaybettiniz mesaj� veriyoruz ve men�ye geri d�nd�r�yoruz
			System.out.println("Oyunu Kaybettiniz. Men�ye D�n�yorsunuz..");
			try
		    {
		        Thread.sleep(2000); // 2 saniye mesaj� g�rme s�resi veriyoruz.
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }			
			
			for (int i = 0; i < 50; i++) //ekran� temizliyoruz
				System.out.println("\n\n");
			
			Menu();//m�en�ye d�nd�r�yoruz
		}
		else //E�er yukar�da �artlar� sa�lam�myorsa oyun hala devam ediyor demektir.
		{		
			try //kullan�c� hatal� giri� yapabilir try-catch komutlar� kullan�lmal�
			{
				//Kullan�c�n�n yapabilece�i hamleleri ekrana yazd�r�yoruz ve se�im yapmas� istiyoruz
				System.out.println("Se�enekleriniz\n\n" + "1-Rakam Giri�i Yap\n" + "2-�pucu iste Hakk�n�z : " + ipucusayisi + "\n");
				Scanner scanner=new Scanner(System.in);
				int secim=scanner.nextInt();
				
				switch (secim) 
				{
					case 1: //E�er se�im 1 ise kullan�c� say� giri�i yapmak istiyor demektir.
					{
						RakamGiris(ipucusayisi); //Rakam giri�i yapabilmesi i�in gerekli i�lemlerin yap�ld��� methoda g�nderiyoruz
						OyunFonskiyonlari(ipucusayisi);//Rakam giri�i yap�ld�ktan sonra tekrar se�enek sunmak i�in methodu tekrar �a��r�yoruz			
						break;
					}
					case 2: //E�er se�im 2 ise kullan�c� ipucu istiyor demektir.
					{
						//burada bir kontrol yapmam�z gerekli
						if (ipucusayisi<=0) //e�er ipucu say�s� 1'den k���k ise b�t�n ipucu hakk�n� bitirmi� demektir.
						{
							//ipucu hakk�n�n olmad���n� ekrana yazd�r�yoruz
							System.out.println("�pucu Hakk�n�z Kalmam��t�r..");
							EkranaYaz(s.dizi);//Ekrana oyunu bast�r�p se�eneklerini tekrar g�steriyoruz
							OyunFonskiyonlari(ipucusayisi);
						}
						else //e�er ipucu hakk� bitmemi� ise
						{
							//ipucu vermek i�in gerekli i�lemlerim yap�ld��� methodu �a��r�yoruz
							IpucuIste();
							ipucusayisi--;//ipucu say�s�n� azalt�yoruz
							OyunFonskiyonlari(ipucusayisi);//se�eneklerini tekrar g�steriyoruz
						}						
						break;
					}
					default: // E�er istenilen say� giri�i yap�lmad�ysa hata mesaj� veriyoruz
					{
						System.out.println("Yap�lan Se�im Hatal� �e�eneklere D�n�l�yor..");
						EkranaYaz(s.dizi); //Ekrana oyunu bast�r�p se�eneklerini tekrar g�steriyoruz
						OyunFonskiyonlari(ipucusayisi);
					}
				}		
			} catch (Exception e) //hata var ise kullan�c� say� d���nda bir de�er giri�i yapmaya �al��m�� demektir.
			{
				//hatas�n� ekrana yazd�r�yoruz
				System.out.println("L�tfen Numara Giri�i Yap�n�z..");
				try
			    {
			        Thread.sleep(1000);//1 saniye ekranda bekletiyoruz
			    }
			    catch(InterruptedException ex)
			    {
			        Thread.currentThread().interrupt();
			    }
				EkranaYaz(s.dizi); //ekrana oyunu bast�r�p se�eneklerini tekrar g�steriyoruz
				OyunFonskiyonlari(ipucusayisi);
			}
			
		}
	}
	//Oyundaki Fonksiyonlar Ba�lang��
	
	
	
	//Sudokuya rakam giri�i yapma ba�lang��
	public static void RakamGiris(int ipucusayisi)
	{
		try //kullan�c� hatal� bir giri� yapabilir o y�zden try-catch blocklar� kullan�yoruz
		{
			//kullan�c�dan sat�r,s�tun ve say� giri�i istiyoruz
			Scanner scanner=new Scanner(System.in);
			System.out.println("Rakam�n De�i�tirilece�i Sat�r� Giriniz..");
			int i=scanner.nextInt();
			System.out.println("Rakam�n De�i�tirilece�i S�tunu Giriniz..");
			int j=scanner.nextInt();
			System.out.println("Rakam� Giriniz..");
			int deger=scanner.nextInt();
			
			//e�er girilen sat�r ve s�t�n bilgisi oyun s�n�rlar� d���nda ise  
			if(j<=0||i<=0 || j>=10 || i>=10)
			{
				//ekrana hatas�n� bast�r�yoruz
				System.out.println("S�n�r d��� giri� yap�ld� tekrar deneyiniz..");
				try
			    {
			        Thread.sleep(1000);//1 saniye bekletiyoruz
			    }
			    catch(InterruptedException ex)
			    {
			        Thread.currentThread().interrupt();
			    }
				EkranaYaz(s.dizi); //ekrana oyunu bast�r�p se�eneklerini tekrar g�steriyoruz
				OyunFonskiyonlari(ipucusayisi);
			}
			//e�er hatas�z giri� yap�ld�ysa girilen say�y� girilen koordinatlara ekliyoruz
			s.dizi[i-1][j-1]=deger;
			EkranaYaz(s.dizi); //Oyunu ekrana yazd�r�yoruz
		} catch (Exception e) //hata varsa kullan�c� say� d���nda bir de�er girmi� demektir.
		{			
			//hatas�n� ekrana yaz�yoruz
			System.out.println("L�tfen Numara Giriniz..");
			try
		    {
		        Thread.sleep(1000);//g�rebilmesi i�in 1 saniye bekletiyoruz
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			EkranaYaz(s.dizi);//ekrana oyunu bast�r�p se�eneklerini tekrar g�steriyoruz
			OyunFonskiyonlari(ipucusayisi);
		}
		
	}
	//Sudokuya rakam giri�i yapma biti�
	
	
	//�pucu �steme Ba�lang��
	public static void IpucuIste()
	{
		//burada rastgele �ekilde dizinin sat�r ve s�tun bilgisini �ekiyoruz
		//rastgele gelen sat�r ve s�t�n verileri i�indeki say� 0 ise yani kullan�c� o sat�ra ve s�tuna giri� yapmam��sa i�indeki veriyi oyun dizisine yazd�r�yoruz  
		int sonuc=0;
		do //burada d�ng� en az 1 kere d�n�cek e�er ilk d�nd���nde ko�ulu sa�lar ise d�ng�den ��k�lacak 
		{			 
			int i=s.RandomSayiUret(9,0),j=s.RandomSayiUret(9,0); // 0 ile 9 aras�ndan sat�r ve s�tun numaras� �ekiyoruz 
			if (s.dizi[i][j]==0) //e�er gellen sat�r ve s�tun�n i�indeki say� 0 ise
			{
				s.dizi[i][j]=s.Dizi[i][j];//kullan�c�n�n oynad��� diziye aktar�yoruz
				sonuc=1; // e�er istenilen ko�ul do�ru ise sonuc 1'e e�itlenecek
			}
		} while (sonuc==0); //sonu� 0 oldu�u s�rece d�necek
		EkranaYaz(s.dizi);	//ekrana oyunu bast�r�p se�eneklerini tekrar g�steriyoruz
		KontrolEt();
	}
	//�pucu �steme Biti�
	
	//Oyun Tamamland�m� Kontrol Ba�lang��
	public static int KontrolEt() 
	{
		int sonuc=1;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) 
				if (s.dizi[i][j]!=s.Dizi[i][j]) //E�er dizinin i�eri�i do�ru dizinin i�eri�inden farkl� ise hata var demektir.
					sonuc=0;
		
		if(BosKontrol()==0 && sonuc==0) sonuc=2; //e�er dizide bo� b�rak�lan sat�r ve s�tun yoksa ve i�eri�i do�ruysa sonucu 2 yap�yoruz
		return sonuc; // sonucu d�nd�r�yoruz
	}
	//Oyun Tamamland�m� Kontrol Ba�lang��
	
	
	//Oyunda Bo� Sat�r Ve S�tun Kalm�� m� Kontrolu Ba�lang��
	public static int BosKontrol()
	{
		int sifirsayisi=0; //ba�lang��ta sayac� 0'l�yoruz
		for (int i = 0; i < 9; i++) 
			for (int j = 0; j < 9; j++) 
				if (s.dizi[i][j]==0) //e�er dizide 0'a e�it say� var ise hala doldurulmas� gereken sat�r ve s�tunlar var demektir.				
					sifirsayisi=1;//sayac� 1 artt�r�yoruz
		
		return sifirsayisi;//geriye sayac� d�nd�r�yoruz
	}
	//Oyunda Bo� Sat�r Ve S�tun Kalm�� m� Kontrolu Biti�
}
