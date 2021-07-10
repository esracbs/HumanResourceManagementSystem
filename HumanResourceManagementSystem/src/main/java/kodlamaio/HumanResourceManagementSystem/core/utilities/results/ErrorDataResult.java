package kodlamaio.HumanResourceManagementSystem.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{

	public ErrorDataResult(T data, String Message) {
		super(data, false,Message);
	}
	public ErrorDataResult(T data) {
		super(data, false);
	}
	public ErrorDataResult( String Message) {
		super(null, false,Message);
	}
	public ErrorDataResult() {
		super(null, false);
	}

}
