package bean;

public class CartBean 
{
	public String getQTYxMedicineAMount() {
		return QTYxMedicineAMount;
	}


	public void setQTYxMedicineAMount(String qTYxMedicineAMount) {
		QTYxMedicineAMount = qTYxMedicineAMount;
	}


	public String getExpiry_date() {
		return expiry_date;
	}


	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}


	public String getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	private int cartId,medicineId,userId;
	private String medicineName,quantity,amount,totalCartAmount,QTYxMedicineAMount,expiry_date,symptoms;
	
	public CartBean(int userId,int medicineId,String medicineName,String quantity,String amount,String expiry_date,String symptoms,String totalCartAmount)
	{
		this.userId = userId;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.amount = amount;
		this.expiry_date = expiry_date;
		this.symptoms = symptoms;
		this.totalCartAmount = totalCartAmount;
	}
	
	
	public CartBean()
	{
		
	}
	public CartBean(int userId,String quantity,String amount,String QTYxMedicineAMount,String totalCartAmount)
	{
		this.userId = userId;
		this.quantity = quantity;
		this.amount = amount;
		this.QTYxMedicineAMount = QTYxMedicineAMount;
		this.totalCartAmount = totalCartAmount;
	}
	
	
	
	
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public String getTotalCartAmount() {
//		int amnt = Integer.parseInt(amount);
//		int qty = Integer.parseInt(quantity);
//		amnt = qty*amnt;
//		String totalAmount = Integer.toString(amnt);
//		return totalAmount;
		return totalCartAmount;
	}
	public void setTotalCartAmount(String TotalCartAmount) {
		int amnt = Integer.parseInt(amount);
		int qty = Integer.parseInt(quantity);
		amnt = qty*amnt;
		System.out.println("Amount in setTotalCartAmount() - "+amnt);
		TotalCartAmount = Integer.toString(amnt);
		System.out.println("TotalCartAmount in setTotalCartAmount() - "+TotalCartAmount);
		this.totalCartAmount = TotalCartAmount;
		
	}
	
}
