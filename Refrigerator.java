package ex2019_0508;

public class Refrigerator extends Product{

	public double size;
	public String type;
	
	@Override
	public String toString() {
		return number+"  "+name+"  "+company+"   "+day+"  "+numOfStock+"  "+
	price+"  �뷮:"+getSize()+"L  Ÿ��:"+getType();
	}

	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
}
