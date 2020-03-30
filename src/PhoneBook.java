import java.util.Arrays;

public class PhoneBook {
    private int capacity = 10;
    private int size = 0;
    private Person repository[] = new Person[capacity];

    public void addPerson(String firstName, String lastName, String phoneNumber){
        if (size >= capacity) return;
        repository[size] = new Person(firstName, lastName, phoneNumber);
        size++;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public void sortMethod(int method){
        Person[] toSort = new Person[this.size];
        System.arraycopy(this.repository, 0, toSort, 0, this.size);
        if (method == 1) Arrays.sort(toSort, Person.firstNameComparator);
        if (method == 2) Arrays.sort(toSort, Person.lastNameComparator);
        if (method == 3) Arrays.sort(toSort, Person.ageComparator);
        if (method == 4) Arrays.sort(toSort);
        System.arraycopy(toSort, 0, this.repository, 0, this.size);
    }

    public void printRepository(){
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.repository[i].toString());
        }
    }
}
