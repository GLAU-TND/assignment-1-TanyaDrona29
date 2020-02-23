package Assignment1.PersonDetails;

public class Person {
    private static String firstName = "";
    private static String lastName = "";
    private static String emailAddress = "";
    private static String[] numberList ;
    public Person(String firstName,String lastName, String emailAddress,String[] numberList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.numberList = numberList;
    }

    public static String[] getNumberList() {
        return numberList;
    }

    public static void setNumberList(String[] numberList) {
        Person.numberList = numberList;
    }

    public static String getEmailAddress() {
        return emailAddress;
    }

    public static void setEmailAddress(String emailAddress) {
        Person.emailAddress = emailAddress;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Person.lastName = lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Person.firstName = firstName;
    }
    public String toString() {
        final StringBuffer sb = new StringBuffer("-------- * -------- * -------- * --------\n");
        sb.append("First Name: ").append(firstName).append('\n');
        sb.append("Last Name: ").append(lastName).append('\n');
        sb.append("Contact List: ").append(numberList);

        for (int i = 0; i < numberList.length; i++) {
            sb.append((numberList[i] != null && i != numberList.length ? numberList[i] : ""));

        }
        sb.append("\nemail='").append(emailAddress).append('\n');
        sb.append("-------- * -------- * -------- * --------");
        return sb.toString();
    }

}
