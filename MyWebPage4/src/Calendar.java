
public class Calendar extends org.primefaces.component.calendar.Calendar {

	public Calendar() {
		super();
		this.addValidator(new DateValidator());
	}
}