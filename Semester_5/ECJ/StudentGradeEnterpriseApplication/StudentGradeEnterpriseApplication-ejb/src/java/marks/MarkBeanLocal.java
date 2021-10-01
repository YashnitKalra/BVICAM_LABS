/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marks;

import javax.ejb.Local;

/**
 *
 * @author yashnit
 */
@Local
public interface MarkBeanLocal {

    float getPercentage(float m1, float m2, float m3);

    String getDivision(float percentage);
    
}
