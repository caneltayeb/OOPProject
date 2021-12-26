package oopProje;

import java.util.Arrays;
import java.util.Scanner;

public class Hesap {
	//Değişkenler
	int bakiye;
	int[] gecmis = {};
	String kullaniciAd;
	String kullaniciID;
	
	//constructor
	Hesap(String cname, String cid) {
		kullaniciAd = cname;
		kullaniciID = cid;
	}
	
	//Para yatırma fonksiyonu
	void paraYatir(int tutar) {
		if (tutar != 0) {
			bakiye = bakiye + tutar;
			gecmis = Arrays.copyOf(gecmis, gecmis.length + 1);
			gecmis[gecmis.length-1] = tutar;
		}
	}
	
	//Para çekme fonksiyonu
	void paraCek(int tutar) {
		if (bakiye < tutar) {
			System.out.println("Yetersiz bakiye.");
		}
		else {
			bakiye = bakiye - tutar;
			gecmis = Arrays.copyOf(gecmis, gecmis.length + 1);
			gecmis[gecmis.length-1] = -tutar;
		}
	}
	
	//Önceki işlem fonksiyonu
	void getGecmisIslem() {
		for (int i=0; i<gecmis.length; i++) {
			
			if (gecmis[i] > 0) System.out.println("Para yatirma: " + gecmis[i] + "TL");
			else if (gecmis[i] < 0) System.out.println("Para çekme: " + gecmis[i] + "TL");
		}
	}
	
	//Yıla ve bakiyeye göre faiz hesabı fonksiyonu
	void faizHesapla(int yillar) {
		double faizMiktari = .0225;
		double newbakiye = (bakiye * faizMiktari * yillar) + bakiye;
		System.out.println("Şuanki artış" + (100 * faizMiktari) + "%");
		System.out.println(yillar + " Yıl sonraki bakiye: " + newbakiye);
	}
	
	//Menü fonksiyonu
	void menuGoster() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hosgeldin " + kullaniciAd);
		System.out.println("Kullanıcı ID: " + kullaniciID);
		System.out.println();
		System.out.println("Yapılacak İslem: ");
		System.out.println();
		System.out.println("A. Bakiye ögrenme");
		System.out.println("B. Para yatirma");
		System.out.println("C. Para cekme");
		System.out.println("D. Islem gecmisi");
		System.out.println("E. Faiz hesaplama");
		System.out.println("F. Çikis");
		
		do {
			System.out.println();
			System.out.println("Islem: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			//Bakiye öğrenme
			case 'A':
				System.out.println("====================================");
				System.out.println("bakiye: " + bakiye);
				System.out.println("====================================");
				System.out.println();
				break;
			//Para yatırma
			case 'B':
				System.out.println("Yatırılacak tutar: ");
				int tutar = scanner.nextInt();
				paraYatir(tutar);
				System.out.println();
				break;
			//Para çekme
			case 'C':
				System.out.println("Çekilecek tutar: ");
				int tutar2 = scanner.nextInt();
				paraCek(tutar2);
				System.out.println();
				break;
			//Son işlem öğrenme
			case 'D':
				System.out.println("====================================");
				getGecmisIslem();
				System.out.println("====================================");
				System.out.println();
				break;
			//Faiz hesabı
			case 'E':
				System.out.println("Kaç yıl: ");
				int yillar = scanner.nextInt();
				faizHesapla(yillar);
				break;
			//Çıkış
			case 'F':
				System.out.println("====================================");
				break;
			//Geçersiz işlem
			default:
				System.out.println("Geçersiz işlem.");
				break;
			}
		} while(option != 'F');
		System.out.println("Görüşmek üzere");
	}
	
}