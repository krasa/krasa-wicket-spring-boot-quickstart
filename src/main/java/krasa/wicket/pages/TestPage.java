package krasa.wicket.pages;

import org.apache.wicket.markup.html.WebPage;

public class TestPage extends WebPage {

	public TestPage() {
		UploadForm progressUploadForm = new UploadForm("progressUpload");
		queue(progressUploadForm);
	}

}
