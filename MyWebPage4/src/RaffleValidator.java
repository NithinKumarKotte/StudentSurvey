import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//Nithin Kumar Kotte G01035945
/* Following class is used to validate raffle numbers. where raffle must contain atleast 10 numbers and each of them must be less than 100*/

@FacesValidator("RaffleValidator")
public class RaffleValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub

		String raffle = arg2.toString();

		if (raffle.isEmpty()) {
			FacesMessage msg = new FacesMessage("Name is improper.", "Insert raffle.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
		int count = raffle.length() - raffle.replace(",", "").length();
		int lastascii = (int) raffle.charAt(raffle.length() - 1);

		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(raffle);
		while (m.find()) {
			int n = Integer.parseInt(m.group());

			if (n > 100) {
				FacesMessage msg = new FacesMessage("", "Please enter raffle values to be less than 100 ");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);

			}
		}

		if ((lastascii >= 48 && lastascii <= 57)) {
			for (int i = 0; i < raffle.length(); i++) {
				int ascii = (int) raffle.charAt(i);
				if (!((ascii >= 48) && (ascii <= 57) || ascii == 44)) {

					FacesMessage msg = new FacesMessage("", "Wrong raffle numbers. Insert only numbers separated by ,");
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
					throw new ValidatorException(msg);

				}

			}
		} else {

			FacesMessage msg = new FacesMessage("", "Raffle series must end with numbers");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

		if (count < 9) {
			FacesMessage msg = new FacesMessage("",
					"Please provide minimum 10 raffle numbers ranging between 0 to 100 ");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
