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
				System.out.println("�ٽ��Է����ּ���.");
			}
		}
	}
	
	public void playMenu() {
		int num=0;
		while (true) {
			System.out.println("============================================");
			System.out.println("1.��ǰ ������ �Է�\n2.��ǰ����Ʈ ����");
			System.out.println("3.��ǰ ��� ���� ����\n4.��� ��ǰ ���� �ϰ� ����");
			System.out.println("5.���� ������ �˻�\n6.����");
			System.out.println("============================================");
			num=(int)scanNumber(2);
			if (num == 6)break;
			else if(num>0 && num<6)playMiniMenu(num);
			else System.out.println("�ٽ��Է����ּ���.");
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

		System.out.println("��ǰ �����͸� �Է����ּ���.");
		while(count<10) {
			System.out.print("c:CPU, r:�����, a:�����, x:���� --> ");
			scanData = scan.next();
			if (scanData.equals("c") || scanData.equals("r") || scanData.equals("a")) {
				inputData2(count, scanData);
				count++;
			} 
			else if (scanData.equals("x"))break;
			else System.out.println("�ٽ� �Է����ּ���");
		}
	}

	public void inputData2(int count, String data) {
		Product p = null;
		if(data.equals("c"))p = new Cpu();
		else if(data.equals("r"))p = new Refrigerator();
		else p = new Audio();
		
		p.setNumber(count+1);
		
		System.out.print("��ǰ���� �Է����ּ��� : ");
		p.setName(scan.next());
		System.out.print("��ǰ �귣����� �Է����ּ��� : ");
		p.setCompany(scan.next());
		System.out.print("�԰� ��¥�� �Է����ּ��� : ");
		p.setDay((int)scanNumber(2));
		System.out.print("�������� �Է����ּ��� : ");
		p.setNumOfStock((int)scanNumber(2));
		System.out.print("��ǰ������ �Է����ּ��� : ");
		p.setPrice((int)scanNumber(2));
		
		if (scanData.equals("c"))inputCpu(p);
		else if (scanData.equals("r")) inputRefrigerator(p);
		else inputAudio(p);
		productList.add(p);
	}
	
	public void inputCpu(Product p) {
		System.out.print("��ǰ�� �ӵ��� �Է����ּ��� : ");
		((Cpu)p).setSpeed(scanNumber(1));
		System.out.print("��ǰ�� �ɼ�(��ġ)�� �Է����ּ��� :");
		((Cpu)p).setSize(scanNumber(1));
	}
	public void inputAudio(Product p) {
		System.out.print("��ǰ�� ��������� �Է����ּ��� : ");
		((Audio)p).setOutPut(scanNumber(1));
		System.out.print("��ǰ�� Ʃ�� �������θ� �Է����ּ���(y:yes, n:no) :");
		while (true) {
			scanData = scan.next();
			if (scanData.equals("y") || scanData.equals("n")) {
				if (scanData.equals("y"))((Audio) p).setTunu("Ʃ������O");
				else ((Audio) p).setTunu("Ʃ������X");
				break;
			} else
				System.out.println("�ٽ��Է����ּ���");
		}
	}
	public void inputRefrigerator(Product p) {
		System.out.print("��ǰ�� �뷮�� �Է����ּ��� : ");
		((Refrigerator) p).setSize(scanNumber(1));
		System.out.print("��ǰ�� Ÿ���� �Է����ּ��� :");
		((Refrigerator) p).setType(scan.next());
	}

	public void showList() {
		int choose = 0;
		
		System.out.println("============================================");
		System.out.println("1.��¥������(�⺻)\n2.��ǰ��� ����\n3.��ǰ���� ����");
		System.out.println("4.���ݼ� ����\n5.���ݿ��� ����\n����");
		System.out.println("============================================");
		while(true) {
		    choose = (int)scanNumber(2);
			if(choose<1||choose>5)System.out.println("�ٽ��Է����ּ���.");
			else break;
		}
		if(choose==1) Collections.sort(productList,sortDay);
		else if(choose==2)Collections.sort(productList,sortName1);
		else if(choose==3)Collections.sort(productList,sortName2);
		else if(choose==4)Collections.sort(productList,sortPrice1);
		else Collections.sort(productList,sortPrice2);
		
		System.out.println("��ȣ  ��ǰ��  �귣��   �԰�¥   ���  ����  ���λ���");
		System.out.println("-------------------------------------");
		for(int i=0;i<productList.size();i++) {
			System.out.println(productList.get(i));
		}
	}

	public void changeNumOfStock() {
		int num=0,num2=0;
		System.out.print("��� ������ ��ȣ�� �Է����ּ��� : ");
		while (true) {
			num = (int)scanNumber(2);
			
			if(num>0 && num<=productList.size()) {
				for(Product p : productList) {
					if(num==p.getNumber())System.out.println("���� ���� " + p.getNumOfStock() + "�Դϴ�.");
				}
				System.out.print("������ ��� ������ �Է����ּ��� : ");
				num2 = (int)scanNumber(2);
				
				for(Product p : productList) {
					if(num==p.getNumber())p.setNumOfStock((num2));
				}
				break;
			}
			else if (productList.size() == 0)	break;
			else System.out.print("�ٽ� �Է��� �ּ��� : ");
		}
	}

	public void changeAllPrice() {
		int price = 0,num=0;
		while (true) {
			System.out.println("1.��ǰ���� �ϰ� �ø�\n2.��ǰ���� �ϰ� ����\n3.���");
			price = (int)scanNumber(2);
			
			if (price == 1 || price == 2 || price == 3)
			 {
				if (price == 3)	break;
				else {
					if (price == 1)	System.out.println("�ϰ� �ø� ��ǰ ������? ");
					else System.out.println("�ϰ� ���� ��ǰ ������? ");
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
			else System.out.println("�ٽ��Է����ּ���.");
		}
	}

	public void searchPrice() {
		int start=0, end=0;
		System.out.print("�ּ� ���� �Է� : ");
		start = (int)scanNumber(2);
		System.out.print("�ִ� ���� �Է� : ");
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
		System.out.println("���α׷��� �����մϴ�.");
	}

}