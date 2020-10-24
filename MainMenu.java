package ex2019_0508;


import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MainMenu {
	Scanner scan = new Scanner(System.in);
	ArrayList<Product> productList = new ArrayList<Product>();
	double scanNum=0;
	String scanData="";
	int count=0;
	
	Comparator<Product> sortDay = new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			if (p1.getDay() < p2.getDay())
				return -1;
			else if (p1.getDay() > p2.getDay())	return 1;
			else return 0;
		}
	};
	
	Comparator<Product> sortPrice1 = new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			if (p1.getPrice() < p2.getPrice())
				return -1;
			else if (p1.getPrice() > p2.getPrice())	return 1;
			else return 0;
		}
	};
	
	Comparator<Product> sortPrice2 = new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			if (p1.getPrice() < p2.getPrice())
				return 1;
			else if (p1.getPrice() > p2.getPrice())	return -1;
			else return 0;
		}
	};

	Comparator<Product> sortName1 = new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			return p1.getName().compareTo(p2.getName());
		}
	};
	
	Comparator<Product> sortName2 = new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			return p2.getName().compareTo(p1.getName());
		}
	};

	public double scanNumber(int num) {
		while (true) {
			try {
				if(num==1) {
					scanNum = scan.nextDouble();
					return scanNum;
				}
				else {
					scanNum = scan.nextInt();
					return (int)scanNum;
				}
			} catch (InputMismatchException e) {
				scan = new Scanner(System.in);
				System.out.println("다시입력해주세요.");
			}
		}
	}
	
	public void playMenu() {
		int num=0;
		while (true) {
			System.out.println("============================================");
			System.out.println("1.제품 데이터 입력\n2.제품리스트 보기");
			System.out.println("3.제품 재고 수량 조정\n4.모든 제품 가격 일괄 조정");
			System.out.println("5.가격 범위로 검색\n6.종료");
			System.out.println("============================================");
			num=(int)scanNumber(2);
			if (num == 6)break;
			else if(num>0 && num<6)playMiniMenu(num);
			else System.out.println("다시입력해주세요.");
		}
	}
	public void playMiniMenu(int num) {
		if (num == 1)
			inputData();
		else if (num == 2)
			showList();
    	else if (num == 3)
			changeNumOfStock();
		else if (num == 4)
			changeAllPrice();
		else
			searchPrice();
	}

	public void inputData() {

		System.out.println("제품 데이터를 입력해주세요.");
		while(count<10) {
			System.out.print("c:CPU, r:냉장고, a:오디오, x:종료 --> ");
			scanData = scan.next();
			if (scanData.equals("c") || scanData.equals("r") || scanData.equals("a")) {
				inputData2(count, scanData);
				count++;
			} 
			else if (scanData.equals("x"))break;
			else System.out.println("다시 입력해주세요");
		}
	}

	public void inputData2(int count, String data) {
		Product p = null;
		if(data.equals("c"))p = new Cpu();
		else if(data.equals("r"))p = new Refrigerator();
		else p = new Audio();
		
		p.setNumber(count+1);
		
		System.out.print("제품명을 입력해주세요 : ");
		p.setName(scan.next());
		System.out.print("제품 브랜드명을 입력해주세요 : ");
		p.setCompany(scan.next());
		System.out.print("입고 날짜를 입력해주세요 : ");
		p.setDay((int)scanNumber(2));
		System.out.print("재고수량을 입력해주세요 : ");
		p.setNumOfStock((int)scanNumber(2));
		System.out.print("제품가격을 입력해주세요 : ");
		p.setPrice((int)scanNumber(2));
		
		if (scanData.equals("c"))inputCpu(p);
		else if (scanData.equals("r")) inputRefrigerator(p);
		else inputAudio(p);
		productList.add(p);
	}
	
	public void inputCpu(Product p) {
		System.out.print("제품의 속도를 입력해주세요 : ");
		((Cpu)p).setSpeed(scanNumber(1));
		System.out.print("제품의 핀수(인치)를 입력해주세요 :");
		((Cpu)p).setSize(scanNumber(1));
	}
	public void inputAudio(Product p) {
		System.out.print("제품의 앰프출력을 입력해주세요 : ");
		((Audio)p).setOutPut(scanNumber(1));
		System.out.print("제품의 튜너 지원여부를 입력해주세요(y:yes, n:no) :");
		while (true) {
			scanData = scan.next();
			if (scanData.equals("y") || scanData.equals("n")) {
				if (scanData.equals("y"))((Audio) p).setTunu("튜너지원O");
				else ((Audio) p).setTunu("튜너지원X");
				break;
			} else
				System.out.println("다시입력해주세요");
		}
	}
	public void inputRefrigerator(Product p) {
		System.out.print("제품의 용량을 입력해주세요 : ");
		((Refrigerator) p).setSize(scanNumber(1));
		System.out.print("제품의 타입을 입력해주세요 :");
		((Refrigerator) p).setType(scan.next());
	}

	public void showList() {
		int choose = 0;
		
		System.out.println("============================================");
		System.out.println("1.날짜순보기(기본)\n2.제품명순 보기\n3.제품명역순 보기");
		System.out.println("4.가격순 보기\n5.가격역순 보기\n선택");
		System.out.println("============================================");
		while(true) {
		    choose = (int)scanNumber(2);
			if(choose<1||choose>5)System.out.println("다시입력해주세요.");
			else break;
		}
		if(choose==1) Collections.sort(productList,sortDay);
		else if(choose==2)Collections.sort(productList,sortName1);
		else if(choose==3)Collections.sort(productList,sortName2);
		else if(choose==4)Collections.sort(productList,sortPrice1);
		else Collections.sort(productList,sortPrice2);
		
		System.out.println("번호  제품명  브랜드   입고날짜   재고  가격  세부사항");
		System.out.println("-------------------------------------");
		for(int i=0;i<productList.size();i++) {
			System.out.println(productList.get(i));
		}
	}

	public void changeNumOfStock() {
		int num=0,num2=0;
		System.out.print("재고를 조정할 번호를 입력해주세요 : ");
		while (true) {
			num = (int)scanNumber(2);
			
			if(num>0 && num<=productList.size()) {
				for(Product p : productList) {
					if(num==p.getNumber())System.out.println("현재 재고는 " + p.getNumOfStock() + "입니다.");
				}
				System.out.print("수정할 재고 수량을 입력해주세요 : ");
				num2 = (int)scanNumber(2);
				
				for(Product p : productList) {
					if(num==p.getNumber())p.setNumOfStock((num2));
				}
				break;
			}
			else if (productList.size() == 0)	break;
			else System.out.print("다시 입력해 주세요 : ");
		}
	}

	public void changeAllPrice() {
		int price = 0,num=0;
		while (true) {
			System.out.println("1.제품가격 일괄 올림\n2.제품가격 일괄 내림\n3.취소");
			price = (int)scanNumber(2);
			
			if (price == 1 || price == 2 || price == 3)
			 {
				if (price == 3)	break;
				else {
					if (price == 1)	System.out.println("일괄 올릴 제품 가격은? ");
					else System.out.println("일괄 내릴 제품 가격은? ");
					num=(int)scanNumber(2);
					for (Product p : productList)
					 {
						if (price == 1)	p.setPrice(p.getPrice() + num);
						else {
							p.setPrice(p.getPrice() - num);
							if (p.getPrice() < 0) p.setPrice(0);
						}
					}
					break;
				}
			} 
			else System.out.println("다시입력해주세요.");
		}
	}

	public void searchPrice() {
		int start=0, end=0;
		System.out.print("최소 가격 입력 : ");
		start = (int)scanNumber(2);
		System.out.print("최대 가격 입력 : ");
		end = (int)scanNumber(2);
		
		Collections.sort(productList,sortPrice1);
		for (Product p:productList) {
			if (start <= p.getPrice() && end >= p.getPrice())
				System.out.println(p);
		}
	}
	
	public static void main(String[] args) {
		MainMenu play = new MainMenu();
		play.playMenu();
		System.out.println("프로그램을 종료합니다.");
	}

}