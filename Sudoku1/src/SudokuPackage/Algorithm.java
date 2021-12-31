package SudokuPackage;

public class Algorithm {


		public int [][]Dizi=new int[9][9]; //Doðru Dizi
		public int [][]dizi=new int[9][9]; //Kullanýcýnýn Dolduracaðý Dizi
		public String Zorluk; //Zorluk Bilgisi
		
		
		//Rastgele sayý üretimi için kullanýlan fonksiyon
		public int RandomSayiUret(int number,int baslangicdeger)
		{
			return (int)((Math.random()*number)+baslangicdeger);
		}	
		
		//Doldurulmuþ sudokularý kullanýcýdan gizliyoruz ve girilen zorluk bilgisine göre kullanýcýnýn dolduracaðý sudokuyu dolduruyoruz.
		private void SudokuGizle()
		{
			int sayac=0;
			DoldurulacakDizi();
			if (Zorluk.equals("Kolay")) 
			{
				while (sayac<39) 
				{
					int i=RandomSayiUret(9,0),j=RandomSayiUret(9,0);
					if(dizi[i][j]==0)
					{
						dizi[i][j]=Dizi[i][j];
						sayac++;
					}			
				}
			}
			else if (Zorluk.equals("Orta")) 
			{
				while (sayac<34) 
				{
					int i=RandomSayiUret(9,0),j=RandomSayiUret(9,0);
					if(dizi[i][j]==0)
					{
						dizi[i][j]=Dizi[i][j];
						sayac++;
					}			
				}
			}
			else if (Zorluk.equals("Zor")) 
			{
				while (sayac<29) 
				{
					int i=RandomSayiUret(9,0),j=RandomSayiUret(9,0);
					if(dizi[i][j]==0)
					{
						dizi[i][j]=Dizi[i][j];
						sayac++;
					}			
				}
			}
			else System.out.println("Seçtiðiniz Zorluk Bulunamadý");		
		}
		
		//Rastgele olarak yazýlmýþ olan sudokularý getiriyor.
		public void Getir()
		{
			int number=RandomSayiUret(8,1);
			switch (number) 
			{
				case 1: 
				{
					Sudoku1();
					break;
				}
				case 2:
				{
					Sudoku2();
					break;
				}
				case 3:
				{
					Sudoku3();
					break;
				}
				case 4:
				{
					Sudoku4();
					break;
				}
				case 5:
				{
					Sudoku5();
					break;
				}
				case 6:
				{
					Sudoku6();
					break;
				}
				case 7:
				{
					Sudoku7();
					break;
				}
				case 8:
				{
					Sudoku8();
					break;
				}
			}
		}
		
		//Kullanýcýnýn dolduracaðý diziyi ayarlýyoruz
		private void DoldurulacakDizi()
		{
			for (int i = 0; i < 9; i++) 
				for (int j = 0; j < 9; j++) 
					dizi[i][j]=0;			
		}
		
		//Kullanýcýnýn görmediði sudokular doldurulup kullanýcýdan gizleniyor.
		private void Sudoku1()
		{
			Dizi[0][0]=2;Dizi[0][1]=5;Dizi[0][2]=9;Dizi[0][3]=3;Dizi[0][4]=1;Dizi[0][5]=4;Dizi[0][6]=7;Dizi[0][7]=6;Dizi[0][8]=8;//1.Satýr
			Dizi[1][0]=8;Dizi[1][1]=7;Dizi[1][2]=1;Dizi[1][3]=6;Dizi[1][4]=2;Dizi[1][5]=9;Dizi[1][6]=4;Dizi[1][7]=5;Dizi[1][8]=3;//2.Satýr
			Dizi[2][0]=6;Dizi[2][1]=4;Dizi[2][2]=3;Dizi[2][3]=5;Dizi[2][4]=8;Dizi[2][5]=7;Dizi[2][6]=1;Dizi[2][7]=9;Dizi[2][8]=2;//3.Satýr
			Dizi[3][0]=9;Dizi[3][1]=6;Dizi[3][2]=7;Dizi[3][3]=8;Dizi[3][4]=3;Dizi[3][5]=5;Dizi[3][6]=2;Dizi[3][7]=1;Dizi[3][8]=4;//4.Satýr
			Dizi[4][0]=4;Dizi[4][1]=1;Dizi[4][2]=8;Dizi[4][3]=9;Dizi[4][4]=7;Dizi[4][5]=2;Dizi[4][6]=5;Dizi[4][7]=3;Dizi[4][8]=6;//5.Satýr
			Dizi[5][0]=3;Dizi[5][1]=2;Dizi[5][2]=5;Dizi[5][3]=4;Dizi[5][4]=6;Dizi[5][5]=1;Dizi[5][6]=9;Dizi[5][7]=8;Dizi[5][8]=7;//6.Satýr
			Dizi[6][0]=7;Dizi[6][1]=9;Dizi[6][2]=6;Dizi[6][3]=2;Dizi[6][4]=5;Dizi[6][5]=3;Dizi[6][6]=8;Dizi[6][7]=4;Dizi[6][8]=1;//7.Satýr
			Dizi[7][0]=1;Dizi[7][1]=8;Dizi[7][2]=4;Dizi[7][3]=7;Dizi[7][4]=9;Dizi[7][5]=6;Dizi[7][6]=3;Dizi[7][7]=2;Dizi[7][8]=5;//8.Satýr
			Dizi[8][0]=5;Dizi[8][1]=3;Dizi[8][2]=2;Dizi[8][3]=1;Dizi[8][4]=4;Dizi[8][5]=8;Dizi[8][6]=6;Dizi[8][7]=7;Dizi[8][8]=9;//9.Satýr
			SudokuGizle();
		}
		private void Sudoku2()
		{
			Dizi[0][0]=3;Dizi[0][1]=1;Dizi[0][2]=5;Dizi[0][3]=4;Dizi[0][4]=8;Dizi[0][5]=2;Dizi[0][6]=9;Dizi[0][7]=6;Dizi[0][8]=7;//1.Satýr
			Dizi[1][0]=4;Dizi[1][1]=9;Dizi[1][2]=2;Dizi[1][3]=7;Dizi[1][4]=6;Dizi[1][5]=5;Dizi[1][6]=1;Dizi[1][7]=3;Dizi[1][8]=8;//2.Satýr
			Dizi[2][0]=6;Dizi[2][1]=7;Dizi[2][2]=8;Dizi[2][3]=1;Dizi[2][4]=9;Dizi[2][5]=3;Dizi[2][6]=2;Dizi[2][7]=4;Dizi[2][8]=5;//3.Satýr
			Dizi[3][0]=7;Dizi[3][1]=2;Dizi[3][2]=3;Dizi[3][3]=9;Dizi[3][4]=1;Dizi[3][5]=6;Dizi[3][6]=5;Dizi[3][7]=8;Dizi[3][8]=4;//4.Satýr
			Dizi[4][0]=9;Dizi[4][1]=6;Dizi[4][2]=4;Dizi[4][3]=2;Dizi[4][4]=5;Dizi[4][5]=8;Dizi[4][6]=7;Dizi[4][7]=1;Dizi[4][8]=3;//5.Satýr
			Dizi[5][0]=5;Dizi[5][1]=8;Dizi[5][2]=1;Dizi[5][3]=3;Dizi[5][4]=7;Dizi[5][5]=4;Dizi[5][6]=6;Dizi[5][7]=9;Dizi[5][8]=2;//6.Satýr
			Dizi[6][0]=8;Dizi[6][1]=5;Dizi[6][2]=7;Dizi[6][3]=6;Dizi[6][4]=3;Dizi[6][5]=1;Dizi[6][6]=4;Dizi[6][7]=2;Dizi[6][8]=9;//7.Satýr
			Dizi[7][0]=2;Dizi[7][1]=3;Dizi[7][2]=6;Dizi[7][3]=5;Dizi[7][4]=4;Dizi[7][5]=9;Dizi[7][6]=8;Dizi[7][7]=7;Dizi[7][8]=1;//8.Satýr
			Dizi[8][0]=1;Dizi[8][1]=4;Dizi[8][2]=9;Dizi[8][3]=8;Dizi[8][4]=2;Dizi[8][5]=7;Dizi[8][6]=3;Dizi[8][7]=5;Dizi[8][8]=6;//9.Satýr
			SudokuGizle();
		}
		private void Sudoku3()
		{
			Dizi[0][0]=4;Dizi[0][1]=3;Dizi[0][2]=9;Dizi[0][3]=2;Dizi[0][4]=6;Dizi[0][5]=8;Dizi[0][6]=7;Dizi[0][7]=1;Dizi[0][8]=5;//1.Satýr
			Dizi[1][0]=6;Dizi[1][1]=7;Dizi[1][2]=8;Dizi[1][3]=4;Dizi[1][4]=5;Dizi[1][5]=1;Dizi[1][6]=2;Dizi[1][7]=3;Dizi[1][8]=9;//2.Satýr
			Dizi[2][0]=1;Dizi[2][1]=5;Dizi[2][2]=2;Dizi[2][3]=9;Dizi[2][4]=3;Dizi[2][5]=7;Dizi[2][6]=8;Dizi[2][7]=4;Dizi[2][8]=6;//3.Satýr
			Dizi[3][0]=7;Dizi[3][1]=9;Dizi[3][2]=4;Dizi[3][3]=3;Dizi[3][4]=1;Dizi[3][5]=2;Dizi[3][6]=6;Dizi[3][7]=5;Dizi[3][8]=8;//4.Satýr
			Dizi[4][0]=8;Dizi[4][1]=1;Dizi[4][2]=5;Dizi[4][3]=6;Dizi[4][4]=4;Dizi[4][5]=9;Dizi[4][6]=3;Dizi[4][7]=7;Dizi[4][8]=2;//5.Satýr
			Dizi[5][0]=3;Dizi[5][1]=2;Dizi[5][2]=6;Dizi[5][3]=8;Dizi[5][4]=7;Dizi[5][5]=5;Dizi[5][6]=1;Dizi[5][7]=9;Dizi[5][8]=4;//6.Satýr
			Dizi[6][0]=5;Dizi[6][1]=8;Dizi[6][2]=3;Dizi[6][3]=7;Dizi[6][4]=9;Dizi[6][5]=6;Dizi[6][6]=4;Dizi[6][7]=2;Dizi[6][8]=1;//7.Satýr
			Dizi[7][0]=2;Dizi[7][1]=4;Dizi[7][2]=1;Dizi[7][3]=5;Dizi[7][4]=8;Dizi[7][5]=3;Dizi[7][6]=9;Dizi[7][7]=6;Dizi[7][8]=7;//8.Satýr
			Dizi[8][0]=9;Dizi[8][1]=6;Dizi[8][2]=7;Dizi[8][3]=1;Dizi[8][4]=2;Dizi[8][5]=4;Dizi[8][6]=5;Dizi[8][7]=8;Dizi[8][8]=3;//9.Satýr
			SudokuGizle();
		}
		private void Sudoku4()
		{
			Dizi[0][0]=2;Dizi[0][1]=1;Dizi[0][2]=5;Dizi[0][3]=3;Dizi[0][4]=7;Dizi[0][5]=9;Dizi[0][6]=8;Dizi[0][7]=6;Dizi[0][8]=4;//1.Satýr
			Dizi[1][0]=9;Dizi[1][1]=8;Dizi[1][2]=6;Dizi[1][3]=1;Dizi[1][4]=2;Dizi[1][5]=4;Dizi[1][6]=3;Dizi[1][7]=5;Dizi[1][8]=7;//2.Satýr
			Dizi[2][0]=7;Dizi[2][1]=3;Dizi[2][2]=4;Dizi[2][3]=8;Dizi[2][4]=5;Dizi[2][5]=6;Dizi[2][6]=2;Dizi[2][7]=1;Dizi[2][8]=9;//3.Satýr
			Dizi[3][0]=4;Dizi[3][1]=5;Dizi[3][2]=2;Dizi[3][3]=7;Dizi[3][4]=8;Dizi[3][5]=1;Dizi[3][6]=6;Dizi[3][7]=9;Dizi[3][8]=3;//4.Satýr
			Dizi[4][0]=8;Dizi[4][1]=6;Dizi[4][2]=9;Dizi[4][3]=5;Dizi[4][4]=4;Dizi[4][5]=3;Dizi[4][6]=1;Dizi[4][7]=7;Dizi[4][8]=2;//5.Satýr
			Dizi[5][0]=3;Dizi[5][1]=7;Dizi[5][2]=1;Dizi[5][3]=6;Dizi[5][4]=9;Dizi[5][5]=2;Dizi[5][6]=4;Dizi[5][7]=8;Dizi[5][8]=5;//6.Satýr
			Dizi[6][0]=5;Dizi[6][1]=2;Dizi[6][2]=7;Dizi[6][3]=4;Dizi[6][4]=1;Dizi[6][5]=8;Dizi[6][6]=9;Dizi[6][7]=3;Dizi[6][8]=6;//7.Satýr
			Dizi[7][0]=6;Dizi[7][1]=4;Dizi[7][2]=8;Dizi[7][3]=9;Dizi[7][4]=3;Dizi[7][5]=7;Dizi[7][6]=5;Dizi[7][7]=2;Dizi[7][8]=1;//8.Satýr
			Dizi[8][0]=1;Dizi[8][1]=9;Dizi[8][2]=3;Dizi[8][3]=2;Dizi[8][4]=6;Dizi[8][5]=5;Dizi[8][6]=7;Dizi[8][7]=4;Dizi[8][8]=8;//9.Satýr
			SudokuGizle();
		}
		private void Sudoku5()
		{
			Dizi[0][0]=8;Dizi[0][1]=7;Dizi[0][2]=6;Dizi[0][3]=4;Dizi[0][4]=9;Dizi[0][5]=3;Dizi[0][6]=2;Dizi[0][7]=5;Dizi[0][8]=1;//1.Satýr
			Dizi[1][0]=3;Dizi[1][1]=4;Dizi[1][2]=5;Dizi[1][3]=7;Dizi[1][4]=1;Dizi[1][5]=2;Dizi[1][6]=9;Dizi[1][7]=6;Dizi[1][8]=8;//2.Satýr
			Dizi[2][0]=2;Dizi[2][1]=9;Dizi[2][2]=1;Dizi[2][3]=5;Dizi[2][4]=6;Dizi[2][5]=8;Dizi[2][6]=4;Dizi[2][7]=7;Dizi[2][8]=3;//3.Satýr
			Dizi[3][0]=9;Dizi[3][1]=8;Dizi[3][2]=2;Dizi[3][3]=1;Dizi[3][4]=3;Dizi[3][5]=5;Dizi[3][6]=7;Dizi[3][7]=4;Dizi[3][8]=6;//4.Satýr
			Dizi[4][0]=7;Dizi[4][1]=5;Dizi[4][2]=4;Dizi[4][3]=8;Dizi[4][4]=2;Dizi[4][5]=6;Dizi[4][6]=3;Dizi[4][7]=1;Dizi[4][8]=9;//5.Satýr
			Dizi[5][0]=1;Dizi[5][1]=6;Dizi[5][2]=3;Dizi[5][3]=9;Dizi[5][4]=4;Dizi[5][5]=7;Dizi[5][6]=8;Dizi[5][7]=2;Dizi[5][8]=5;//6.Satýr
			Dizi[6][0]=4;Dizi[6][1]=1;Dizi[6][2]=7;Dizi[6][3]=3;Dizi[6][4]=5;Dizi[6][5]=9;Dizi[6][6]=6;Dizi[6][7]=8;Dizi[6][8]=2;//7.Satýr
			Dizi[7][0]=6;Dizi[7][1]=3;Dizi[7][2]=8;Dizi[7][3]=2;Dizi[7][4]=7;Dizi[7][5]=1;Dizi[7][6]=5;Dizi[7][7]=9;Dizi[7][8]=4;//8.Satýr
			Dizi[8][0]=5;Dizi[8][1]=2;Dizi[8][2]=9;Dizi[8][3]=6;Dizi[8][4]=8;Dizi[8][5]=4;Dizi[8][6]=1;Dizi[8][7]=3;Dizi[8][8]=7;//9.Satýr
			SudokuGizle();
		}
		private void Sudoku6()
		{
			Dizi[0][0]=1;Dizi[0][1]=6;Dizi[0][2]=5;Dizi[0][3]=8;Dizi[0][4]=4;Dizi[0][5]=7;Dizi[0][6]=9;Dizi[0][7]=2;Dizi[0][8]=3;//1.Satýr
			Dizi[1][0]=7;Dizi[1][1]=8;Dizi[1][2]=9;Dizi[1][3]=3;Dizi[1][4]=1;Dizi[1][5]=2;Dizi[1][6]=5;Dizi[1][7]=4;Dizi[1][8]=6;//2.Satýr
			Dizi[2][0]=4;Dizi[2][1]=3;Dizi[2][2]=2;Dizi[2][3]=5;Dizi[2][4]=9;Dizi[2][5]=6;Dizi[2][6]=1;Dizi[2][7]=7;Dizi[2][8]=8;//3.Satýr
			Dizi[3][0]=2;Dizi[3][1]=9;Dizi[3][2]=7;Dizi[3][3]=4;Dizi[3][4]=6;Dizi[3][5]=3;Dizi[3][6]=8;Dizi[3][7]=5;Dizi[3][8]=1;//4.Satýr
			Dizi[4][0]=5;Dizi[4][1]=1;Dizi[4][2]=8;Dizi[4][3]=7;Dizi[4][4]=2;Dizi[4][5]=9;Dizi[4][6]=3;Dizi[4][7]=6;Dizi[4][8]=4;//5.Satýr
			Dizi[5][0]=3;Dizi[5][1]=4;Dizi[5][2]=6;Dizi[5][3]=1;Dizi[5][4]=5;Dizi[5][5]=8;Dizi[5][6]=2;Dizi[5][7]=9;Dizi[5][8]=7;//6.Satýr
			Dizi[6][0]=9;Dizi[6][1]=7;Dizi[6][2]=3;Dizi[6][3]=2;Dizi[6][4]=8;Dizi[6][5]=4;Dizi[6][6]=6;Dizi[6][7]=1;Dizi[6][8]=5;//7.Satýr
			Dizi[7][0]=8;Dizi[7][1]=2;Dizi[7][2]=1;Dizi[7][3]=6;Dizi[7][4]=7;Dizi[7][5]=5;Dizi[7][6]=4;Dizi[7][7]=3;Dizi[7][8]=9;//8.Satýr
			Dizi[8][0]=6;Dizi[8][1]=5;Dizi[8][2]=4;Dizi[8][3]=9;Dizi[8][4]=3;Dizi[8][5]=1;Dizi[8][6]=7;Dizi[8][7]=8;Dizi[8][8]=2;//9.Satýr
			SudokuGizle();
		}
		private void Sudoku7()
		{
			Dizi[0][0]=8;Dizi[0][1]=3;Dizi[0][2]=5;Dizi[0][3]=9;Dizi[0][4]=2;Dizi[0][5]=1;Dizi[0][6]=4;Dizi[0][7]=6;Dizi[0][8]=7;//1.Satýr
			Dizi[1][0]=1;Dizi[1][1]=9;Dizi[1][2]=7;Dizi[1][3]=4;Dizi[1][4]=6;Dizi[1][5]=5;Dizi[1][6]=2;Dizi[1][7]=3;Dizi[1][8]=8;//2.Satýr
			Dizi[2][0]=4;Dizi[2][1]=6;Dizi[2][2]=2;Dizi[2][3]=3;Dizi[2][4]=7;Dizi[2][5]=8;Dizi[2][6]=1;Dizi[2][7]=5;Dizi[2][8]=9;//3.Satýr
			Dizi[3][0]=3;Dizi[3][1]=2;Dizi[3][2]=8;Dizi[3][3]=5;Dizi[3][4]=9;Dizi[3][5]=4;Dizi[3][6]=6;Dizi[3][7]=7;Dizi[3][8]=1;//4.Satýr
			Dizi[4][0]=7;Dizi[4][1]=5;Dizi[4][2]=4;Dizi[4][3]=6;Dizi[4][4]=1;Dizi[4][5]=3;Dizi[4][6]=9;Dizi[4][7]=8;Dizi[4][8]=2;//5.Satýr
			Dizi[5][0]=9;Dizi[5][1]=1;Dizi[5][2]=6;Dizi[5][3]=7;Dizi[5][4]=8;Dizi[5][5]=2;Dizi[5][6]=5;Dizi[5][7]=4;Dizi[5][8]=3;//6.Satýr
			Dizi[6][0]=2;Dizi[6][1]=4;Dizi[6][2]=9;Dizi[6][3]=8;Dizi[6][4]=5;Dizi[6][5]=7;Dizi[6][6]=3;Dizi[6][7]=1;Dizi[6][8]=6;//7.Satýr
			Dizi[7][0]=5;Dizi[7][1]=8;Dizi[7][2]=1;Dizi[7][3]=2;Dizi[7][4]=3;Dizi[7][5]=6;Dizi[7][6]=7;Dizi[7][7]=9;Dizi[7][8]=4;//8.Satýr
			Dizi[8][0]=6;Dizi[8][1]=7;Dizi[8][2]=3;Dizi[8][3]=1;Dizi[8][4]=4;Dizi[8][5]=9;Dizi[8][6]=8;Dizi[8][7]=2;Dizi[8][8]=5;//9.Satýr
			SudokuGizle();
		}
		private void Sudoku8()
		{
			Dizi[0][0]=1;Dizi[0][1]=8;Dizi[0][2]=2;Dizi[0][3]=7;Dizi[0][4]=9;Dizi[0][5]=5;Dizi[0][6]=4;Dizi[0][7]=3;Dizi[0][8]=6;//1.Satýr
			Dizi[1][0]=4;Dizi[1][1]=7;Dizi[1][2]=3;Dizi[1][3]=6;Dizi[1][4]=8;Dizi[1][5]=1;Dizi[1][6]=2;Dizi[1][7]=9;Dizi[1][8]=5;//2.Satýr
			Dizi[2][0]=5;Dizi[2][1]=9;Dizi[2][2]=6;Dizi[2][3]=2;Dizi[2][4]=3;Dizi[2][5]=4;Dizi[2][6]=7;Dizi[2][7]=8;Dizi[2][8]=1;//3.Satýr
			Dizi[3][0]=8;Dizi[3][1]=5;Dizi[3][2]=1;Dizi[3][3]=4;Dizi[3][4]=2;Dizi[3][5]=9;Dizi[3][6]=3;Dizi[3][7]=6;Dizi[3][8]=7;//4.Satýr
			Dizi[4][0]=7;Dizi[4][1]=6;Dizi[4][2]=4;Dizi[4][3]=1;Dizi[4][4]=5;Dizi[4][5]=3;Dizi[4][6]=8;Dizi[4][7]=2;Dizi[4][8]=9;//5.Satýr
			Dizi[5][0]=2;Dizi[5][1]=3;Dizi[5][2]=9;Dizi[5][3]=8;Dizi[5][4]=7;Dizi[5][5]=6;Dizi[5][6]=1;Dizi[5][7]=5;Dizi[5][8]=4;//6.Satýr
			Dizi[6][0]=6;Dizi[6][1]=2;Dizi[6][2]=5;Dizi[6][3]=3;Dizi[6][4]=1;Dizi[6][5]=7;Dizi[6][6]=9;Dizi[6][7]=4;Dizi[6][8]=8;//7.Satýr
			Dizi[7][0]=9;Dizi[7][1]=1;Dizi[7][2]=8;Dizi[7][3]=5;Dizi[7][4]=4;Dizi[7][5]=2;Dizi[7][6]=6;Dizi[7][7]=7;Dizi[7][8]=3;//8.Satýr
			Dizi[8][0]=3;Dizi[8][1]=4;Dizi[8][2]=7;Dizi[8][3]=9;Dizi[8][4]=6;Dizi[8][5]=8;Dizi[8][6]=5;Dizi[8][7]=1;Dizi[8][8]=2;//9.Satýr
			SudokuGizle();
		}

	}


