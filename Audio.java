package ex2019_0508;


public class Audio extends Product{
	public double outPut;
	public String tunu;
	
	@Override
	public String toString() {
		return number+"  "+name+"  "+company+"   "+day+"  "+numOfStock+"  "+
	price+"  ¿¥ÇÃÃâ·Â:"+getOutput()+"w  "+getTunu();
	}
	
	public double getOutput() {
		return outPut;
	}
	public void setOutPut(double outPut) {
		this.outPut = outPut;
	}
	public String getTunu() {
		return tunu;
	}
	public String setTunu(String tunu) {
		return this.tunu = tunu;
	}
}
