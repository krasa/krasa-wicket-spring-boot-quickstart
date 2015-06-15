package krasa.wicket.pages;

import java.util.List;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.lang.Bytes;
import org.slf4j.*;

/**
 * @author Vojtech Krasa
 */
public class UploadForm extends Form<Void> {

	private static final Logger log = LoggerFactory.getLogger(UploadForm.class);

	FileUploadField fileUploadField;

	public UploadForm(String id) {
		super(id);
		setMultiPart(true);
		add(fileUploadField = new FileUploadField("fileInput"));
		setMaxSize(Bytes.kilobytes(25000));
        add(new FeedbackPanel("feedback"));
    }

	@Override
	protected void onSubmit() {
		List<FileUpload> uploads = fileUploadField.getFileUploads();
		if (uploads.isEmpty()) {
			error("No file uploaded");
		}
		for (FileUpload upload : uploads) {
			try {
				info("uploaded: " + upload.getClientFileName());
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
	}

}
