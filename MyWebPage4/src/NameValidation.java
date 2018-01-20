
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//Nithin Kumar Kotte G01035945
/* Following class is used to validate firrstname and lastname. Where each of these must contain only 15 alphabets*/

@FacesValidator("NameValidation")
public class NameValidation implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub

		String nameval = value.toString();
		if (nameval.isEmpty()) {
			FacesMessage msg = new FacesMessage("Name is improper.", "Insert name.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
		if (nameval.length() < 15) {
			for (int i = 0; i < nameval.length(); i++) {
				int ascii = (int) nameval.charAt(i);
				if (!(ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122)) {

					FacesMessage msg = new FacesMessage("Name is improper.",
							"Please enter valid name having only alphabets containing 15 characters");
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
					throw new ValidatorException(msg);

				}
			}
		} else {
			FacesMessage msg = new FacesMessage("Name is improper.",
					"Please enter valid name having only alphabets containing 15 characters");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}

}
