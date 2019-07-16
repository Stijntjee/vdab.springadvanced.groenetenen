package be.vdab.groenetenen.constraints;

import be.vdab.groenetenen.forms.VanTotPostcodeForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VanPostcodeFormVanKleinerDanOfGelijkAanTotValidator implements ConstraintValidator<VanPostcodeFormVanKleinerDanOfGelijkAanTot, VanTotPostcodeForm> {

   public void initialize(VanPostcodeFormVanKleinerDanOfGelijkAanTot constraint) {
   }

   @Override
   public boolean isValid(VanTotPostcodeForm form, ConstraintValidatorContext context) {
     if (form.getVan() == null || form.getTot() == null)
     {
        return true;
     }
      return form.getVan() <= form.getTot();
   }


}
