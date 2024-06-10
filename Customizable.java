
package stichit;

public interface Customizable {
     void customizeDesign(String designDetails);
}

class Customization implements Customizable {
    private String designDetails;

    @Override
    public void customizeDesign(String designDetails) {
        if (designDetails == null || designDetails.isEmpty()) {
            throw new IllegalArgumentException("Design details cannot be null or empty");
        }
        this.designDetails = designDetails;
    }

    public String getDesignDetails() {
        return designDetails;
    }
}

    
    
