package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private String contactFirstName;
    private String contactLastName;
    private String salutation;
    private String contactAccountName;
    private String description;
    private String phone;
    private String contactOwner;

    public String getFullName() {
        return getContactFirstName() + " " + getContactLastName();
    }
    public String getNameWithSalutation() {
        return getSalutation() + " " + getFullName();
    }
}
