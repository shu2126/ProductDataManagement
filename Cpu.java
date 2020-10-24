package ex2019_0508;

public class Cpu extends Product{
	public double size;
	public double speed;
	
	@Override
	public String toString() {
		return number+"  "+name+"  "+company+"   "+day+"  "+numOfStock+"  "+
	price+"  해상도:"+getSize()+"  크기:"+getSpeed()+"G ";
	}
	

	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
