

package model;
public class Vulnerable extends User{
    public Vulnerable(String name, String firstname, String mail, String password) {
        super(name, firstname, mail, password);
        this.type=EnumUser.Vulnerable;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.type.equals(((Vulnerable) obj).type);
    }

}