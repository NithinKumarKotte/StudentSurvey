import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//Nithin Kumar Kotte G01035945
/* Following class is used to validate street address. Where each of these must contain only alphabets, numbers and alpha numeric characters*/

@FacesValidator("AddressValidation")
public class AddressValidation implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		// TODO Auto-generated method stub

		String addrval = value.toString();

		if (addrval.isEmpty()) {
			FacesMessage msg = new FacesMessage("Name is improper.", "Insert address.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

		for (int i = 0; i < addrval.length(); i++) {
			int ascii = (int) addrval.charAt(i);
			if (!(ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122 || ascii >= 48 && ascii <= 57 || ascii == 32
					|| ascii == 44 || ascii == 45)) {

				FacesMessage msg = new FacesMessage("Address is improper.",
						"Address is improper. Use ony alphabets, numbers, alphanumerics like (<space>,/,-)");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);

			}
		}

	}

}
