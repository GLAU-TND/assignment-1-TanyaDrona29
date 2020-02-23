package Assignment1.ADT;

public interface LinkedListADT<Person> {
    boolean add(Person details);
    boolean delete(int index);
    void search(String person);
    void viewAllDetails();
}
