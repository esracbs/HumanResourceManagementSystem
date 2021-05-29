package kodlamaio.HumanResourceManagementSystem.core.utilities.results;

public class DataResult<T> extends Result{

	private T data;
	public DataResult(T data ,boolean success, String message) {
		super(success, message);//super bilgisi base sınıfın constructorlarını çalıştırıyor
		this.data=data;
	}
	public DataResult(T data ,boolean success) {
		super(success);//super bilgisi base sınıfın constructorlarını çalıştırıyor
		this.data=data;
	}
	public T getData() {
		return this.data;
	}
	

}
