package bean;

public class MedicineBean 
{
	private int medicineId;
	private String medicine_Name,available_qty,price,expiry_date,symptoms,medicine_image;
	

	public String getMedicine_image() {
		return medicine_image;
	}

	public void setMedicine_image(String medicine_image) {
		this.medicine_image = medicine_image;
	}

	public String getsymptoms() {
		return symptoms;
	}

	public void setsymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public MedicineBean()
	{
		
	}
	
	public MedicineBean(int medicineId,String medicine_Name, String available_qty, String price, String expiry_date,String symptoms) 
	{
		this.medicineId = medicineId;
		this.medicine_Name = medicine_Name;
		this.available_qty = available_qty;
		this.price = price;
		this.expiry_date = expiry_date;
		this.symptoms = symptoms;
	}
	
	public MedicineBean(int medicineId,String medicine_Name, String available_qty, String price, String expiry_date) 
	{
		this.medicineId = medicineId;
		this.medicine_Name = medicine_Name;
		this.available_qty = available_qty;
		this.price = price;
		this.expiry_date = expiry_date;
	}
	
	
	public MedicineBean(String medicine_Name,int medicineId, String symptoms, String price, String expiry_date) 
	{
		this.medicineId = medicineId;
		this.medicine_Name = medicine_Name;
		this.symptoms = symptoms;
		this.price = price;
		this.expiry_date = expiry_date;
	}
	
	
	public MedicineBean(int medicineId,String medicine_Name, String available_qty, String price, String expiry_date,String symptoms,String medicine_image) 
	{
		this.medicineId = medicineId;
		this.medicine_Name = medicine_Name;
		this.available_qty = available_qty;
		this.price = price;
		this.expiry_date = expiry_date;
		this.symptoms = symptoms;
		this.medicine_image = medicine_image;
	}
	public MedicineBean(String medicine_Name,String symptoms,String price,String expiry_date)
	{
		this.medicine_Name = medicine_Name;
		this.symptoms = symptoms;
		this.price = price;
		this.expiry_date = expiry_date;
		
	}


	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicine_Name() {
		return medicine_Name;
	}
	public void setMedicine_Name(String medicine_Name) {
		this.medicine_Name = medicine_Name;
	}
	public String getAvailable_qty() {
		return available_qty;
	}
	public void setAvailable_qty(String available_qty) {
		this.available_qty = available_qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	
}
