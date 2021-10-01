package marks;

import javax.ejb.Stateless;

@Stateless
public class MarkBean implements MarkBeanLocal {

    @Override
    public float getPercentage(float m1, float m2, float m3) {
        return (m1 + m2 + m3)/3;
    }

    @Override
    public String getDivision(float percentage) {
        if(percentage > 80)
            return "I";
        if(percentage > 65)
            return "II";
        return "III";
    }     
}
