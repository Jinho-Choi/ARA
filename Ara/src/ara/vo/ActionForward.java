package ara.vo;

// ��û�� ���� �����Ͻ� ������ �ϼ��� ��
// ������ �� �������� ������ ������ Ŭ����
public class ActionForward {
	private String url; // �������� url�� ����� ����
	private boolean redirect; // �����̿�Ʈ ���� ����ġ ���� �����ϴ� ����
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
