package labT;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("RValidator")
public class RValidation implements Validator {
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println(component.getClientId() + ": " + value);
        String valueStr = value.toString();
        Double r = new Double(valueStr);
        if (r < 1.0 || r > 4.0) {
            FacesMessage msg = new FacesMessage("Something wrong with R =(", "R must be between 1 to 4");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}