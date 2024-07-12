package pattern;

public class FactoryDemo {

	public static void main(String[] args) {
		Dialog winDialog = DialogFactory.getDialog("Windows");
		Dialog htmlDialog = DialogFactory.getDialog("HTML");
		winDialog.renderWindow();
		htmlDialog.renderWindow();
		winDialog.okButton.onClick();
		htmlDialog.okButton.onClick();
	}

}

class DialogFactory {
	public static Dialog getDialog(String dialogType) {
		switch (dialogType) {
			case "Windows":
				return new WindowsDialog();
			case "HTML":
				return new HtmlDialog();
			default:
				return null;
		}
	}
}


interface Button {
	void render();
	void onClick();
}

class HtmlButton implements Button {

	@Override
	public void render() {
		System.out.println("<button>Test Button</button>");
		onClick();
	}

	@Override
	public void onClick() {
		System.out.println("The html button was clicked");		
	}
}

class WindowsButton implements Button {
	
	@Override
	public void render() {
		System.out.println("<btn>Test Button</btn>");
		onClick();		
	}

	@Override
	public void onClick() {
		System.out.println("The windows button was clicked");			
	}
	
}

abstract class Dialog {
	public Button okButton;
	
	public void renderWindow() {
		Button okButton = createButton();
	}
	// Factory method stub
	public abstract Button createButton();
}

class HtmlDialog extends Dialog {

	@Override
	public Button createButton() {
		okButton = new HtmlButton();
		return okButton;
	}
}

class WindowsDialog extends Dialog {

	@Override
	public Button createButton() {
		okButton = new WindowsButton();
		return okButton;
	}
}















