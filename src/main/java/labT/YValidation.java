package labT;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("YValidator")
public class YValidation implements Validator {
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println(component.getClientId() + ": " + value);
        String valueStr = value.toString();
        Double y = new Double(valueStr);
        if (y < -3.0 || y > 3.0) {
            FacesMessage msg = new FacesMessage("Something wrong with Y =( ", "Y must be between -3 to 3");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}