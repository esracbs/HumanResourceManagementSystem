package kodlamaio.HumanResourceManagementSystem.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String Message) {
		super(data, true,Message);
	}
	public SuccessDataResult(T data) {
		super(data, true);
	}
	public SuccessDataResult( String Message) {
		super(null, true,Message);
	}
	public SuccessDataResult() {
		super(null, true);
	}

}
