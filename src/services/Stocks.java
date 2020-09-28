package services;

import java.io.IOException;
import java.time.LocalDateTime;


public class Stocks {
	String symbol;
	String series;
	float open;
	float high;
	float close;
	float last;
	float prevClose;
	long total_Qty;
	double total_Value;
	LocalDateTime timestamp;
	String ISIN;
	public Stocks(String symbol, String series, float open, float high, float close, float last, float prevClose,
		long total_Qty, double total_Value, LocalDateTime timestamp, String iSIN) {
		super();
		this.symbol = symbol;
		this.series = series;
		this.open = open;
		this.high = high;
		this.close = close;
		this.last = last;
		this.prevClose = prevClose;
		this.total_Qty = total_Qty;
		this.total_Value = total_Value;
		this.timestamp = timestamp;
		ISIN = iSIN;
	}
	public Stocks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getLast() {
		return last;
	}
	public void setLast(float last) {
		this.last = last;
	}
	public float getPrevClose() {
		return prevClose;
	}
	public void setPrevClose(float prevClose) {
		this.prevClose = prevClose;
	}
	public long getTotal_Qty() {
		return total_Qty;
	}
	public void setTotal_Qty(long total_Qty) {
		this.total_Qty = total_Qty;
	}
	public double getTotal_Value() {
		return total_Value;
	}
	public void setTotal_Value(double total_Value) {
		this.total_Value = total_Value;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getISIN() {
		return ISIN;
	}
	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}
	
	public void display() throws IOException {
		ReadExcelFileDemo demo=new ReadExcelFileDemo();
		demo.display();
	}
	
	public void displayCharacterWise(char a) throws IOException{
		ReadExcelFileDemo demo=new ReadExcelFileDemo();
		demo.displayCharacterWise(a);
	}
	
	public void displayHighestPrevValue() throws IOException{
		ReadExcelFileDemo demo=new ReadExcelFileDemo();
		demo.displayHighestPrevValue();
	}
	
	public void displayHighestQtyValue() throws IOException{
		ReadExcelFileDemo demo=new ReadExcelFileDemo();
		demo.displayHighestQtyValue();
	}
	
}
