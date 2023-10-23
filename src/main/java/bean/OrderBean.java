package bean;

public class OrderBean 
{
	private int orderId,userId,medicineId;
	private String medicineName,quantity,amount,totalAmount;
	private String symptoms,date;
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public OrderBean(int userId,int medicineId,String medicineName,String quantity,String amount,String totalAmount,String date)
	{
		this.userId = userId;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.date = date;
	}
	
	
	public OrderBean()
	{
		
	}
	
	public OrderBean(int medicineId,String medicineName,String quantity,String amount,String totalAmount,String date)
	{
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.date = date;
	}
	
	public OrderBean(String symptoms)
	{
		this.symptoms = symptoms;
	}
	
	public OrderBean(String medicineName,String quantity,String amount,String totalAmount,String symptoms)
	{
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.symptoms = symptoms;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
