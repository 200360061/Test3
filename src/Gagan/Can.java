package Gagan;

/**
 * Question 9 - ensure your name and student number is in every .java file (2
 * marks)
 */
/**
 *@author Gagandeep kaur(200360061)
 */
public class Can {

    /**
     * Question 2 - Create a class called called "Can". It should include
     * instance variables that store a String with the product name and volume
     * in ml (use whole numbers for this). Your method should include all get
     * and set methods with some form of validation. (1 mark for the
     * constructor, 2 for the get/set methods)
     */
    private String brandName;
    private int ml;
    public Can(String brandName, int ml) {
        setMl(ml);
        setBrandName(brandName);
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if (brandName.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be Empty");
        }
        this.brandName = brandName;
    }
    
    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        if (ml == 0) {
            throw new IllegalArgumentException("Volume of Product Cannot be a 0");
        } else {
            this.ml = ml;
        }
    }

}
