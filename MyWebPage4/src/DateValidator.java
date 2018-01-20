import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.calendar.Calendar;

@FacesValidator("DateValidation")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
	
		//UIInput otherInput = (UIInput) context.getViewRoot().findComponent("dateInput");
		
		
	//	UIInput surveydateobj = (UIInput) component.getAttributes().; //toString();   //getAttributes(). 	 	get("dateInput");
		//System.out.println(surveydateobj.getSubmittedValue());
		//System.out.println(surveydateobj);
		//String surveydate = surveydateobj.getSubmittedValue().toString();
		
		
		//System.out.println("survey date :" + surveydate);
		/*Date surveydate = (Date) otherValue;

		Date semdate = (Date) value;
		System.out.println("sem date :" + semdate);

		if (semdate.compareTo(surveydate) > 0) {
			FacesMessage msg = new FacesMessage("Name is improper.",
					"Semester date must not be less than survey date ");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		// SimpleDateFormat spf = new SimpleDateFormat("MM/dd/yyyy");
*/
	}

}
