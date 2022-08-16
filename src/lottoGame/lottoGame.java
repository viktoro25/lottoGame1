package lottoGame;

import java.util.Random;
import java.util.Scanner;
public class lottoGame {

	public static void main(String[] args) {
		String [] chyslaVidKorystyvacha = OtrymatyVvedennyaVidKorystyvacha(); 

		int iKilkistSpivpadin = 0;
		int iKilkistRozigrashiv=0;

		while(iKilkistSpivpadin!=6)
		{
			iKilkistRozigrashiv++;
			//krok 2 �������� �������
			int [] tseyRozigrash = ProvestyRozigrash();
			//krok 3 ��������� ����� �� ����������� �� ��������� � ��������� ������
			iKilkistSpivpadin = PerevirytyRezyltat(chyslaVidKorystyvacha, tseyRozigrash);

			if(iKilkistSpivpadin>4)
			{
				// krok 4 ������� ���������

				String vsiChyslaRozigrashu = KonvertyvatyMasyvTekst(tseyRozigrash);

				System.out.println("� "+iKilkistRozigrashiv+" �������� ������� (" + vsiChyslaRozigrashu +") :" + iKilkistSpivpadin);
			}
		}
	}


	public static String[] OtrymatyVvedennyaVidKorystyvacha()
	{
		//krok 1 �������� �������� �� �����������	
		System.out.println("������ 6 ����� �� (1 �� 54): ");
		Scanner scan = new Scanner(System.in);
		String chysla = scan.nextLine();
		scan.close();
		String[] strMasyvVvedenyhChysel = chysla.split(",");	

		return strMasyvVvedenyhChysel;

	}

	public static int[] ProvestyRozigrash()
	{
		int [] tseyRozigrash = new int[6];
		Random r = new Random();
		int iChysloRozigrashy = 0;
		while (iChysloRozigrashy!=6)
		{
			boolean chysloVzeIsnye = false;
			int tseChyslo = r.nextInt(54)+1;
			for(int isnyyucheJuslo: tseyRozigrash)
			{
				if(isnyyucheJuslo==tseChyslo)
				{
					chysloVzeIsnye = true;
					break;
				}
			}
			if (chysloVzeIsnye!=true)
			{
				tseyRozigrash[iChysloRozigrashy++] = tseChyslo;
			}

		}
		return tseyRozigrash;
	}

	public static int PerevirytyRezyltat(String[] strMasyvVvedenyhChysel,int[] tseyRozigrash)
	{
		int iKilkistSpivpadin =0;
		for(int k=0; k<strMasyvVvedenyhChysel.length;k++ )
		{
			int chyslo = Integer.parseInt(strMasyvVvedenyhChysel[k]);
			for (int tsevygrashneChyslo: tseyRozigrash)
			{
				if (chyslo == tsevygrashneChyslo)
				{
					iKilkistSpivpadin++;
				}
			}
		}
		return iKilkistSpivpadin;
	}

	public static String KonvertyvatyMasyvTekst(int[] chysla)
	{
		String vsiChyslaRozigrashu = "";
		for (int Chyslo: chysla )
		{
			vsiChyslaRozigrashu = vsiChyslaRozigrashu+ Chyslo + " ";
		}
		return vsiChyslaRozigrashu;
	}  
}