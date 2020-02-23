package Assignment1.defination;

import Assignment1.ADT.LinkedListADT;

import java.util.ArrayList;

public class DefinationList<Person> implements LinkedListADT<Person> {
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> firstName = new ArrayList<>();
    private Node<Person> head = null;
    private int size = 0;

    public Node<Person> getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    private void addFirst(Person details) {
        head = new Node<Person>(head, details);
        size++;

    }
    private void addAfter(Node node, Person details) {
        Node<Person> temp = node;
        if (node != null) {
            temp.next = new Node(node.next, details);
            size++;
        }
    }
    private void add(int index, Person details) {
        if (index == 0) {
            addFirst(details);
        }
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("the index is invalid");
        } else {
            Node node = getNode(index - 1);
            addAfter(node.next, details);

        }
    }
    public boolean add(Person details) {
        add(size, details);
        return true;
    }
    private Person removeFirst() {
        Person temporary = null;
        Node<Person> node = head;
        if (head != null) {
            head = head.getNext();
        }
        if (node != null) {
            size--;
            temporary = node.getData();
        }
        return temporary;
    }
    private Person removeAfter(Node<Person> node) {
        Person temporary = null;
        Node<Person> response = node.getNext();
        if (response != null) {
            node.next = response.getNext();
            size--;
            temporary = response.getData();
        }
        if (temporary == null) {
            node = null;
            size--;
        }
        return temporary;
    }
    public ArrayList<String> getName() {
        return name;
    }

    public void setName(String FirstName, String lastname) {
        firstName.add(FirstName + lastname);
    }

    public ArrayList<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        name.add(FirstName);
    }
    public Node<Person> getHead() {
        return head;
    }

    public void setHead(Node<Person> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public boolean delete(int index) {
        boolean response = false;
        if (index - 1 < 0 || (index - 1) > getSize()) {
            throw new IndexOutOfBoundsException(Integer.toString(index - 1));
        } else if (index - 1 == 0) {
            removeFirst();
            name.remove(index - 1);
            response = true;
        } else {
            Node<Person> previousNode = getNode(index - 1);
            removeAfter(previousNode);
            name.remove(index - 1);
            response = true;
        }
        return response;
    }
    int count = 0;
    public void search(String person) {

        for (int i = 0; i < firstName.size(); i++) {
            if (person.compareTo( firstName.get(i).toString()) == 0) {
                count++;
            }
        }
        if (count != 0) {
            System.out.println(count + " match found!");
            for (int i = 0; i < firstName.size(); i++) {
                if (person.compareTo(firstName.get(i).toString()) == 0) {
                    Node<Person> personNode = getNode(i);
                    System.out.println(personNode.getData().toString());
                }
            }
        } else {
            System.out.println("NO MATCH FOUND!");
        }
    }
    public void viewAllDetails() {
        if (size != 0) {
            System.out.println("---Here are your all contacts---");
            for (int i = 0; i < size; i++) {

                Person data = this.getNode(i).getData();
                System.out.print(data);
            }
        } else {
            System.out.println("NO RESULTS FOUND!");
        }
    }

    private static class Node<Person>{
        private Node next = null;
        private Person data = null;

        public Node(Node next, Person data) {
            this.next = next;
            this.data = data;
        }
        public Node(Person data){
            this.data = data;
            this.next = null;
        }

        public Person getData() {
            return data;
        }

        public void setData(Person data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
