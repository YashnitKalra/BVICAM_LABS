/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delhi_University;

/**
 *
 * @author yashnit
 */
public class UGCourse {
    private int math, physics, chemistry, english, computerScience;

    public UGCourse(int math, int physics, int chemistry, int english, int computerScience) {
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.english = english;
        this.computerScience = computerScience;
    }
    
    public boolean checkMath(){
        return math>=60;
    }
    
    public boolean checkChemistry(){
        return chemistry>=50;
    }
    
    public boolean checkPhysics(){
        return physics>=50;
    }
    
    public boolean checkEligibility(){
        return (checkMath() && checkChemistry() && checkPhysics() && (math+physics+chemistry>=160 || math+physics>=120));
    }
    
    public boolean checkHonorsEligibility(){
        return (checkEligibility() && (math+physics+chemistry+english+computerScience)>225);
    }
}
